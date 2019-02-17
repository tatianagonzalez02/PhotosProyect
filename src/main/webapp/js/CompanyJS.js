var app = angular.module("app", []);

app.controller("ctrlCompany", function($scope, $http) {
   
   $scope.company = {};
   
    $scope.registerCompany = function(){
        $http.post("./webresources/CompanyService/", $scope.company)
            .then(function() {
                alert("Ya estuvo");
            }, function(){
                alert("Error al registrar compañia");
            });
    };
});