var app = angular.module("app", []);

app.controller("ctrlIndex", function($scope, $http) {
   
    $scope.login = function(){
        alert("Iniciando sesion...");
//        if ($scope.company !== null){
//            $http.post("./webresources/CompanyService/", $scope.company)
//            .then(function(response) {
//                    if (response.data) {
//                        alert("Tu cuenta a sido creada!");
//                    }else{
//                        alert("Ya existe esta cuenta.");
//                    }
//            }, function(){
//                alert("Error al registrar compañia");
//            });
//        }else{
//            alert("Debes ingresar los datos...");
//        }
    };
});