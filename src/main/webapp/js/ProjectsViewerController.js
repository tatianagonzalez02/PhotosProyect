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
    
    $scope.verListFotografias= function (){
         $('#modal1').modal().open();
    };
    
    //abre el modal para subir fotografias
    $scope.subirFotografias= function (){
         $('#modalSubirF').modal().open();
    };
    
    $scope.getData();
});