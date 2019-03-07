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
    
    $scope.viewCompanyProyects = function(idCompany){
        localStorage.setItem("viewCompany", idCompany);
        window.location.replace("#listProyects");
    };
    
    $scope.getCompanies();
    
////    abre el modal donde muestra las fotografias
//    $scope.verListFotografias= function (){
//         $('#modal1').modal().open();
//    };
//    
//    //abre el modal para subir fotografias
//    $scope.subirFotografias= function (){
//         $('#modalSubirF').modal().open();
//    };
});