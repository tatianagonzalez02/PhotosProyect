app.controller("ctrlProjectsViewer", function ($scope, $http) {

    $scope.company = null;
    
    $scope.getData = function (){
        $http.get("./webresources/CompanyService/" + localStorage.getItem("viewCompany"),{})
            .then(function(response) {
                $scope.company = response.data;
        }, function(){
            alert("Error al obtener compañias");
        });
    };
    
    $scope.verListFotografias= function (idProyect){
        console.log(idProyect);//Voy aqui...
         $('#modal1').modal().open();
    };
    
    //abre el modal para subir fotografias
    $scope.subirFotografias= function (){
         $('#modalSubirF').modal().open();
    };
    
    $scope.sendPhoto = function (){
        const input = document.getElementById('inputFileServer');
        if (input.files && input.files[0]) {
            console.log("File seleccionado: ", input.files[0]);
        }
        $http.post("./webresources/ProyectService/sendPhoto", input.files[0])
    }
    
    $scope.getData();
});