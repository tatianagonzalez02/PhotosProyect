app.controller("ctrlProyects", function ($scope, $http) {

    $scope.getProyects = function(){
//        $scope.companyID = localStorage.getItem("company");
//        $http.get("./webresources/ProyectService/" + $scope.companyID, {})
//            .then(function(response) {
//                $scope.companies = response.data;
//        }, function(){
//            alert("Error al obtener compañias");
//        });
    };
    
    $scope.getProyects();
    
    //    abre el modal donde muestra las fotografias
    $scope.verListFotografias= function (){
         $('#modal2').modal().open();
    }
    
});