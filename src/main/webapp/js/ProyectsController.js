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
});