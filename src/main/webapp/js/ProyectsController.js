app.controller("ctrlProyects", function ($scope, $http) {

    $scope.company = null;
    $scope.projects = null;
    $scope.photosToShow = [];

    $scope.getCompany = function () {
        $http.get("./webresources/CompanyService/" + localStorage.getItem("company"), {})
                .then(function (response) {
                    $scope.company = response.data;
                    $scope.projects = $scope.company.listProyects;
                    for (var i = 0; i < $scope.projects.length; i++) {
                        $scope.photos = $scope.projects[i].listPhotos;
                        for (var j = 0; j < $scope.photos.length; j++) {
                            $scope.date = $scope.photos[j].date;
                            $scope.photos[j].date = new Date($scope.date.substring(0, $scope.date.length - 5));
                        }
                        $scope.projects[i].listPhotos = $scope.photos;
                    }
                }, function () {
                    alert("Error al obtener compañias");
                });
    };

    //    abre el modal donde muestra las fotografias
    $scope.verListFotografias = function (idProject) {
        for (var i = 0; i < $scope.projects.length; i++) {
            if ($scope.projects[i].id === idProject) {
                $scope.photos = $scope.projects[i].listPhotos;
                for (var i = 0; i < $scope.photos.length; i++) {
                    if ($scope.photos[i].enumStatus !== "AVAILABLE") {
                        $scope.photos[i].path = "https://cloud.netlifyusercontent.com/assets/344dbf88-fdf9-42bb-adb4-46f01eedd629/43b892a2-9859-4905-be03-384c222c1f17/excerpt-lazy-load.png";
                    }
                    $scope.photosToShow.push($scope.photos[i]);
                }
                break;
            }
        }
        $('#modal2').modal().open();
    };

    $scope.getCompany();
});