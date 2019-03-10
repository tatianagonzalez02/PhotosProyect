app.controller("ctrlProjectsViewer", function ($scope, $http) {

    $scope.company = null;
    $scope.chosenProject = null;
    $scope.photosToShow = [];
    $scope.photographer = null;
    $scope.newPhoto = {};

    $scope.getData = function () {
        $http.get("./webresources/CompanyService/" + localStorage.getItem("viewCompany"), {})
                .then(function (response) {
                    $scope.company = response.data;
                    $scope.projects = $scope.company.listProyects;
                }, function () {
                    alert("Error al obtener compañias");
                });
    };

    $scope.verListFotografias = function (idProject) {
        $scope.projects = $scope.company.listProyects;
        $scope.photosToShow = [];
        for (var i = 0; i < $scope.projects.length; i++) {
            if ($scope.projects[i].id === idProject) {
                $scope.photos = $scope.projects[i].listPhotos;
                for (var i = 0; i < $scope.photos.length; i++) {
                    if ($scope.photos[i].enumStatus === "AVAILABLE") {
                        $scope.photosToShow.push($scope.photos[i]);
                    } else {
                        $scope.photosToShow.push({path: "https://cloud.netlifyusercontent.com/assets/344dbf88-fdf9-42bb-adb4-46f01eedd629/43b892a2-9859-4905-be03-384c222c1f17/excerpt-lazy-load.png"});
                    }
                }
                break;
            }
        }
        $('#modal1').modal().open();
    };

    //abre el modal para subir fotografias
    $scope.subirFotografias = function (idProject) {
        $scope.chosenProject = idProject;
        $('#modalSubirF').modal().open();
    };

    $scope.sendPhoto = function () {
        const input = document.getElementById('inputFileServer');
        $http.post("./webresources/ProyectService/sendPhoto", input.files[0])
                .then(function (response) {
                    $scope.newPhoto.path = response.data;
                    $scope.updateProyect();
                    alert("Hemos recibido tu fotografía y la estamos procesando para que sea publicada.");
                }, function () {
                    alert("Error al cargar la imagen");
                });
    };

    $scope.updateProyect = function () {
        $scope.projects = $scope.company.listProyects;
        for (var i = 0; i < $scope.projects.length; i++) {
            if ($scope.projects[i].id === $scope.chosenProject) {
                $scope.project = $scope.projects[i];
                break;
            }
        }
        $scope.newPhoto.date = new Date();
        $scope.newPhoto.photographer = $scope.photographer;
        $scope.project.listPhotos.push($scope.newPhoto);
        $http.put("./webresources/ProyectService/update", $scope.project)
                .then(function () {
                }, function () {
                    alert("Error al actualizar proyecto");
                });
    };

    $scope.getData();
});