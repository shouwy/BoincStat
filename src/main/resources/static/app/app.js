/**
 * Created by Inspiron on 24/06/2015.
 */
angular.module("boincapp", [])
    .controller("homeCtrl", function($scope, $http){
        $scope.projects = [];
        $scope.projectKey = null;
        $scope.page=0;
        $scope.nbElement=10;
        $scope.loadPageProject = function() {
            $http.get("http://localhost:8080/project/list/"+$scope.page+"/"+$scope.nbElement)
                .success(function (data) {
                    $scope.projects = data;
                });
        };
        $scope.loadPageProject();
    });