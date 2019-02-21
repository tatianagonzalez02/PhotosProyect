var app = angular.module("app", []);

app.controller("ctrlCompany", function($scope, $http) {
   
    $scope.company = null;
    $scope.auxPassword = null;
    $scope.proyects = [
        {name: "ProyectoName", description: "ProyectoDescription", valuePay: 12000, listPhotos: null},
        {name: "ProyectoName", description: "ProyectoDescription", valuePay: 12000, listPhotos: null}
    ];
   
    $scope.registerCompany = function(){
        if ($scope.company !== null){
            if ($scope.company.password !== $scope.auxPassword){
                alert("No coincide la contraseña");
                return;
            }
            $scope.company.listProyects = $scope.proyects;
            $http.post("./webresources/CompanyService/register", $scope.company)
            .then(function(response) {
                    if (response.data) {
                        alert("Tu cuenta ha sido creada!");
                    }else{
                        alert("Ya existe esta cuenta.");
                    }
            }, function(){
                alert("Error al registrar compañia");
            });
        }else{
            alert("Debes ingresar los datos.");
        }
    };
    
    $scope.exitSesion = function (){
        localStorage.removeItem("usuario");
    };
});