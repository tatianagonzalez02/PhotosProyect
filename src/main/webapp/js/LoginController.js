app.controller("ctrlLogin", function ($scope, $http) {

    $scope.company = null;
    
    $scope.login = function () {
        $http.post("./webresources/CompanyService/login", $scope.company)
                .then(function (response) {
                    if (response.data.idError !== undefined) {
                        alert("Datos erróneos");
                    } else {
                        $scope.company = response.data;
                        localStorage.setItem("usuario", $scope.company.nameCompany);
                        localStorage.setItem("company", $scope.company.idCompany);
                        window.location.replace("index.html");
                    }
                }, function (error) {
                    console.log(error);
                    alert("Error al iniciar sesion");
                });
    };

    $scope.existLogin = function () {
        if (localStorage.getItem("usuario")) {
            window.location.replace("proyectos.html");
        } else {
            window.location.replace("login.html");
        }
    };
});