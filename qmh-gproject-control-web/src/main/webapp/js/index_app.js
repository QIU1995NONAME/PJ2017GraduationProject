'use strict';

// QPControl APP
angular.module('QPControl', [//
'ngRoute',//
'QPControl.main',//
'QPControl.mgr-hardware', //
'QPControl.mgr-data',//
'QPControl.mgr-back',//
'QPControl.view-data',//
'QPControl.help',//
'QPControl.about',//
]).config([ //
'$locationProvider', //
'$routeProvider',//
function($locationProvider, $routeProvider) {
	$locationProvider.hashPrefix('!');
	$routeProvider.otherwise({
		redirectTo : '/main'
	});
} ]);
