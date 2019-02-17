var app = angular.module("app", []);

app.controller("ctrlCompany", function($scope, $http) {
   
   $scope.company = null;
   
    $scope.registerCompany = function(){
        if ($scope.company !== null){
            $http.post("./webresources/CompanyService/", $scope.company)
            .then(function(response) {
                    if (response.data) {
                        alert("Tu cuenta a sido creada!");
                    }else{
                        alert("Ya existe esta cuenta.");
                    }
            }, function(){
                alert("Error al registrar compañia");
            });
        }else{
            alert("Debes ingresar los datos...");
        }
    };
});