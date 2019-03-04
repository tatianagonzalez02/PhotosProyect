app.controller("ctrlIndex", function ($scope, $http) {

    $scope.options = null;

    $scope.company = localStorage.getItem("usuario");

    $scope.showUser = function () {
        if ($scope.company !== null) {
            $scope.options = [
                {text: "Close", path: "", close:true},
                {text: $scope.company, path: "#proyects", close:false},
                {text: "Empresas", path: "#companies", close:false},
                {text: "Home", path: "#about", close:false}];
        }else{
            $scope.options = [
            {text: "Iniciar sesion", path: "#login", close:false},
            {text: "Registrarse", path: "#register", close:false},
            {text: "Empresas", path: "#companies", close:false},
            {text: "Home", path: "#about", close:false}];
        }
    };

    $scope.logout = function () {
        if (confirm('¿Deseas cerrar sesión?')) {
            localStorage.removeItem("usuario");
            window.location.replace("index.html");
        }
    };

    $scope.showUser();
});