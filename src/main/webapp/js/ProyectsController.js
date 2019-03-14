app.controller("ctrlProyects", function ($scope, $http) {

    $scope.pages = [];
    $scope.photos = [];
    $scope.company = null;
    $scope.pageNumber = 1;
    $scope.projects = null;
    $scope.photosToShow = [];

    $scope.getCompany = function () {
        $http.get("./webresources/CompanyService/" + localStorage.getItem("company"), {})
                .then(function (response) {
                    $scope.company = response.data;
                }, function () {
                    alert("Error al obtener compañias");
                });
    };

    //    abre el modal donde muestra las fotografias
    $scope.verListFotografias = function (idProject) {
        $scope.photos = [];
        $scope.pages = [];
        $scope.page = [];
        $http.get("./webresources/PhotoService/" + idProject, {})
                .then(function (response) {
                    $scope.photos = response.data;
                    for (var i = 0; i < $scope.photos.length; i++) {
                        if ($scope.photos[i].enumStatus !== "AVAILABLE") {
                            $scope.photos[i].path = "imgindex/loading.png";
                        }
                        $scope.date = $scope.photos[i].date;
                        $scope.photos[i].date = new Date($scope.date.substring(0, $scope.date.length - 5));
                    }
                    $scope.createPages();
                    $scope.setPage($scope.pageNumber);
                }, function () {
                    alert("Error al obtener fotografias");
                });
    };
    
    $scope.createPages = function () {
        $scope.page = [];
        $scope.pages = [];
        for (var i = 0, j = 1; i < $scope.photos.length; i++, j++) {
            $scope.page.push($scope.photos[i]);
            if (j === 10) {
                $scope.pages.push($scope.page);
                $scope.page = [];
                j = 0;
            }
        }
        if ($scope.page.length > 0) {
            $scope.pages.push($scope.page);
        }
    };
    
    $scope.setPage = function (page) {
        $scope.pageNumber = page;
        $scope.photosToShow = $scope.pages[page - 1];
    };

    $scope.setBackPage = function () {
        if ($scope.pageNumber > 1) {
            $scope.pageNumber--;
        }
        $scope.setPage($scope.pageNumber);
    };

    $scope.setNextPage = function () {
        if ($scope.pageNumber < $scope.pages.length) {
            $scope.pageNumber++;
        }
        $scope.setPage($scope.pageNumber);
    };
    
    document.addEventListener('DOMContentLoaded', function () {
        var elems = document.querySelectorAll('.modal');
        var instances = M.Modal.init(elems, options);
    });

    $(document).ready(function () {
        $('.modal').modal();
    });

    $scope.getCompany();
});