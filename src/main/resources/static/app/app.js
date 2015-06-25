/**
 * Created by Inspiron on 24/06/2015.
 */
var app = angular.module('boincapp', ['ngTable']);
app.controller("homeCtrl", function($scope, $http){

    });
app.controller("projectCtrl", function($scope, ngTableParams, projectService){
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

app.service("projectService", function($http, $filter) {
   function filterData(data, filter){
       return $filter('filter')(data, filter);
   }

    function orderData(data, params){
        return params.sorting() ? $filter('orderBy')(data, params.orderBy()) : filteredData;
    }

    function sliceData(data, params){
        return data.slice((params.page() - 1) * params.count(), params.page() * params.count())
    }

    function transformData(data,filter,params){
        return sliceData( orderData( filterData(data,filter), params ), params);
    }

    var service = {
        cachedData : [],
        getData : function($defer, params, filter) {
            if (service.cachedData.length > 0){
                var filteredData = filterData(service.cachedData, filter);
                var transformedData = sliceData(orderData(filteredData, params), params);
                params.total(filteredData.length);
                $defer.resolve(transformedDataData);
            } else {
                $http.get("http://localhost:8080/project/list/").success(
                    function (resp) {
                        angular.copy(resp, service.cachedData);
                        params.total(resp.length);
                        var filteredData = $filter('filter')(resp, filter);
                        var transformedData = transformData(resp, filter, params);

                        $defer.resolve(transformedData);
                    }
                );
            }
        }
    };
    return service;
});