app.controller("ctrlProjectsViewer", function ($scope, $http) {

    $scope.company = null;
    $scope.chosenProject = null;
    $scope.photosToShow = null;
    
    $scope.getData = function (){
        $http.get("./webresources/CompanyService/" + localStorage.getItem("viewCompany"),{})
            .then(function(response) {
                $scope.company = response.data;
                $scope.projects = $scope.company.listProyects;
        }, function(){
            alert("Error al obtener compañias");
        });
    };
    
    $scope.verListFotografias= function (idProject){
        for (var i = 0; i < $scope.projects.length; i++) {
            if ($scope.projects[i].id === idProject) {
                $scope.photosToShow = $scope.projects[i].listPhotos;
                break;
            }
        }
         $('#modal1').modal().open();
    };
    
    //abre el modal para subir fotografias
    $scope.subirFotografias= function (idProject){
        $scope.chosenProject = idProject;
        $('#modalSubirF').modal().open();
    };
    
    $scope.sendPhoto = function (){
        const input = document.getElementById('inputFileServer');
        if (input.files && input.files[0]) {
            console.log("File seleccionado: ", input.files[0]);
        }
        $http.post("./webresources/ProyectService/sendPhoto", input.files[0])
    };
    
    $scope.getData();
});