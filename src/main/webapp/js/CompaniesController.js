app.controller("ctrlCompanies", function ($scope, $http) {

    $scope.companies = null;
    
    $scope.getCompanies = function (){
        $http.get("./webresources/CompanyService/companies",{})
            .then(function(response) {
                $scope.companies = response.data;
        }, function(){
            alert("Error al obtener compañias");
        });
    };
    
    $scope.showProyects = function(idCompany){
        localStorage.setItem("viewCompany", idCompany);
    };
    
    $scope.getCompanies();
    
//    abre el modal donde muestra las fotografias
    $scope.verListFotografias= function (){
         $('#modal1').modal().open();

    }
});