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
// main
angular.module('QPControl.main', [ 'ngRoute' ]).config([//
'$routeProvider', function($routeProvider) {
	$routeProvider.when('/main', {
		templateUrl : 'views/main.xml',
		controller : 'main'
	});
} ]).controller('main', [ function() {
} ]);
// mgr-hardware
angular.module('QPControl.mgr-hardware', [ 'ngRoute' ]).config([//
'$routeProvider', function($routeProvider) {
	$routeProvider.when('/mgr-hardware', {
		templateUrl : 'views/mgr-hardware.xml',
		controller : 'mgr-hardware'
	});
} ]).controller('mgr-hardware', [ function() {
} ]);
// mgr-data
angular.module('QPControl.mgr-data', [ 'ngRoute' ]).config([//
'$routeProvider', function($routeProvider) {
	$routeProvider.when('/mgr-data', {
		templateUrl : 'views/mgr-data.xml',
		controller : 'mgr-data'
	});
} ]).controller('mgr-data', [ function() {
} ]);
// mgr-back
angular.module('QPControl.mgr-back', [ 'ngRoute' ]).config([//
'$routeProvider', function($routeProvider) {
	$routeProvider.when('/mgr-back', {
		templateUrl : 'views/mgr-back.xml',
		controller : 'mgr-back'
	});
} ]).controller('mgr-back', [ function() {
} ]);
// view-data
angular.module('QPControl.view-data', [ 'ngRoute' ]).config([//
'$routeProvider', function($routeProvider) {
	$routeProvider.when('/view-data', {
		templateUrl : 'views/view-data.xml',
		controller : 'view-data'
	});
} ]).controller('view-data', [ function() {
} ]);
// help
angular.module('QPControl.help', [ 'ngRoute' ]).config([//
'$routeProvider', function($routeProvider) {
	$routeProvider.when('/help', {
		templateUrl : 'views/help.xml',
		controller : 'help'
	});
} ]).controller('help', [ function() {
} ]);
// about
angular.module('QPControl.about', [ 'ngRoute' ]).config([//
'$routeProvider', function($routeProvider) {
	$routeProvider.when('/about', {
		templateUrl : 'views/about.xml',
		controller : 'about'
	});
} ]).controller('about', [ function() {
} ]);