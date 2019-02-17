var app = angular.module("app", []);

app.controller("ctrlIndex", function($scope, $http) {
   
    $scope.company = null;
    
    $scope.login = function(){
        $http.post("./webresources/CompanyService/login", $scope.company)
            .then(function(response) {
                alert("Hola: " + response.data);
        }, function(){
            alert("Error al iniciar sesion");
        });
    };
});