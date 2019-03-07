app.controller("ctrlProyects", function ($scope, $http) {

    $scope.company = null;
    
    $scope.getCompany = function (){
        $http.get("./webresources/CompanyService/" + localStorage.getItem("company"),{})
            .then(function(response) {
                $scope.company = response.data;
        }, function(){
            alert("Error al obtener compañias");
        });
    };
    
    $scope.getCompany();
    
    //    abre el modal donde muestra las fotografias
    $scope.verListFotografias= function (){
         $('#modal2').modal().open();
    };
    
});