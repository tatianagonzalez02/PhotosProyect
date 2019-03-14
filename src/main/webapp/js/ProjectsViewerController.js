app.controller("ctrlProjectsViewer", function ($scope, $http) {

    $scope.pages = [];
    $scope.photos = [];
    $scope.newPhoto = {};
    $scope.company = null;
    $scope.pageNumber = 1;
    $scope.photosToShow = [];
    $scope.photographer = null;
    $scope.chosenProject = null;

    $scope.addPhoto = function () {
        $scope.projects = $scope.company.listProyects;
        for (var i = 0; i < $scope.projects.length; i++) {
            if ($scope.projects[i].id === $scope.chosenProject) {
                $scope.project = $scope.projects[i];
                break;
            }
        }
        $scope.newPhoto.date = new Date();
        $scope.newPhoto.photographer = $scope.photographer;
        $http.post("./webresources/PhotoService/" + $scope.project.id, $scope.newPhoto)
                .then(function () {
                }, function () {
                    alert("Error al actualizar proyecto");
                });
    };

    $scope.getData = function () {
        $http.get("./webresources/CompanyService/" + localStorage.getItem("viewCompany"), {})
                .then(function (response) {
                    $scope.company = response.data;
                }, function () {
                    alert("Error al obtener compañias");
                });
    };

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
                    }
                    $scope.createPages();
                    $scope.setPage($scope.pageNumber);
                }, function () {
                    alert("Error al obtener fotografias");
                });
        $('#modal1').modal().open();
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
                    $scope.addPhoto();
                    alert("Hemos recibido tu fotografía y la estamos procesando para que sea publicada.");
                }, function () {
                    alert("Error al cargar la imagen");
                });
    };

    $scope.getPhotographer = function (emailP) {
        $http.get("./webresources/PhotographerService/" + emailP, {})
                .then(function (response) {
                    if (response.data !== '') {
                        $scope.photographer = response.data;
                    }
                }, function () {
                    alert("Error al obtener el fotógrafo");
                });
        $('#modal1').modal().open();
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

    $scope.getData();
});