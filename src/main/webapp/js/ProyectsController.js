app.controller("ctrlProyects", function ($scope, $http) {

    $scope.company = null;
    $scope.projects = null;
    $scope.photosToShow = null;
    
    $scope.getCompany = function (){
        $http.get("./webresources/CompanyService/" + localStorage.getItem("company"),{})
            .then(function(response) {
                $scope.company = response.data;
                $scope.projects = $scope.company.listProyects;
        }, function(){
            alert("Error al obtener compañias");
        });
    };
    
    //    abre el modal donde muestra las fotografias
    $scope.verListFotografias= function (idProject){
        for (var i = 0; i < $scope.projects.length; i++) {
            if ($scope.projects[i].id === idProject) {
                $scope.photosToShow = $scope.projects[i].listPhotos;
                break;
            }
        }
         $('#modal2').modal().open();
    };
    
    $scope.getCompany();
});