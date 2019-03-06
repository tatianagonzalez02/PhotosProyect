var app = angular.module("app", ['ngRoute']);

app.config(['$routeProvider', function ($routeProvider) {

        $routeProvider.when('/', {templateUrl: "partials/about.html"});
        $routeProvider.when('/companies', {templateUrl: "partials/companies.html", controller: "ctrlCompanies"});
        $routeProvider.when('/login', {templateUrl: "partials/login.html", controller: "ctrlLogin"});
        $routeProvider.when('/proyects', {templateUrl: "partials/proyects.html", controller: "ctrlProyects"});
        $routeProvider.when('/listProyects', {templateUrl: "partials/listProyects.html", controller: "ctrlCompanies"});
        $routeProvider.when('/register', {templateUrl: "partials/register.html", controller: "ctrlRegister"});
        $routeProvider.otherwise({redirectTo: '/'});

    }]);

var module = angular.module("app.controllers", []);