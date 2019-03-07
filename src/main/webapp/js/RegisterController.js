app.controller("ctrlRegister", function($scope, $http) {
   
    $scope.company = null;
    $scope.auxPassword = null;
    $scope.listPhotos = [{photographer: null, requestValue: 0, path: "http://proyectofse.mx/wp-content/uploads/2016/04/prodetes_checklist-759x500.jpg"}];
    $scope.users = ['Fabio', 'Leonardo', 'Thomas', 'Gabriele', 'Fabrizio', 'John', 'Luis', 'Kate', 'Max','maria', 'buu'];
    $scope.proyects = [
        {name: "ProyectoName1", description: "ProyectoDescription", valuePay: 12000, listPhotos: $scope.listPhotos, Company: null},
        {name: "ProyectoName2", description: "ProyectoDescription", valuePay: 12000, listPhotos: $scope.listPhotos, Company: null},
        {name: "ProyectoName3", description: "ProyectoDescription", valuePay: 12000, listPhotos: $scope.listPhotos, Company: null}
    ];
   
    $scope.registerCompany = function(){
        if ($scope.company !== null){
            if ($scope.company.password !== $scope.auxPassword){
                alert("No coincide la contraseña");
                return;
            }
            $scope.company.listProyects = $scope.proyects;
            for (var i = 0; i < $scope.company.listProyects.length; i++) {
                $scope.company.listProyects.company = $scope.company;
            }
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