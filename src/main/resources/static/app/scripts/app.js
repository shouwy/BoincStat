'use strict';
/**
 * Created by Inspiron on 24/06/2015.
 */
angular.module('boincApp', ['ngRoute', 'ui.router'])
    .config(function ($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise("/");

        $stateProvider
            .state('app', {
                abstract : true,
                views : {
                    'header' : {
                        templateUrl : 'views/header.html',
                        controller : 'headerCtrl'
                    },
                    '' : {
                        template : '<div id="page-wrapper" class="container" scripts notification>'+
                            '<div class="row"><div ng-include="\'views/side-bar.html\'" ng-controller="sidebarCtrl" ></div>'+
                            '<div ui-view=""  autoscroll="false"></div>'+
                            '</div></div>'
                    }
                }
            })
            .state('app.home', {
                url : '/',
                views : {
                    '' : {
                        templateUrl : 'views/home.html',
                        controller : 'homeCtrl'
                    }
                }
            })
            .state('app.project', {
                url : '/project',
                views : {
                    '': {
                        templateUrl: 'views/project.html',
                        controller: 'projectCtrl'
                    }
                }
            })
            .state('app.computer', {
                url : '/computer',
                views : {
                    '': {
                        templateUrl: 'views/computer.html',
                        controller: 'computerCtrl'
                    }
                }
            })
            .state('app.user', {
                url : '/user',
                views : {
                    '': {
                        templateUrl: 'views/user.html',
                        controller: 'userCtrl'
                    }
                }
            });
    })
    .constant('APP', {
        baseUrl : 'http://localhost:8080/'
    });