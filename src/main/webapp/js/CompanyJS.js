var app = angular.module("app", []);

app.controller("ctrlCompany", function($scope, $http) {
   
    $scope.registerCompany = function(){
        alert("Ya lo tomo");
    };
});