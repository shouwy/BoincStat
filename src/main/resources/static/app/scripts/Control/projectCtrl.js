/**
 * Created by Inspiron on 29/06/2015.
 */
angular.module('boincApp')
    .controller("projectCtrl", function($scope, ngTableParams, projectService){
    $scope.projects = projectService.cachedData;

    $scope.projectTable = new ngTableParams({
            page : 1,
            count : 10
        }, {
            total : 0,
            getData : function($defer, params) {
                projectService.getData($defer, params, $scope.filter);
            }
        }
    );

    $scope.$watch("filter.$", function() {
        $scope.projectTable.reload();
    })
});