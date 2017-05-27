'use strict';

// index_app_main
angular.module('QPControl.main', [ 'ngRoute' ]).config([//
'$routeProvider', function($routeProvider) {
	$routeProvider.when('/main', {
		templateUrl : 'views/main.xml',
		controller : 'main'
	});
} ]).controller('main', [ function() {
} ]);
