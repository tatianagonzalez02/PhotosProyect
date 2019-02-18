var app = angular.module("app", []);

app.controller("ctrlIndex", function($scope, $http) {
   
    $scope.company = null;
    
    $scope.login = function(){
        $http.post("./webresources/CompanyService/login", $scope.company)
            .then(function(response) {
                console.log(JSON.stringify(response));
                    console.log(response.data);
                    console.log(response.data.idError);
                    if (response.data.idError !== undefined) {
                        alert("Datos erróneos");
                    } else {
                        window.location.replace("registro_1.html");
                        localStorage.setItem("usuario", $scope.company.nameCompany);
                    }
        }, function(error){
            console.log(error);
            alert("Error al iniciar sesion");
        });
    };
    
    $scope.existLogin = function(){
        if (localStorage){
            
        }
    };
});