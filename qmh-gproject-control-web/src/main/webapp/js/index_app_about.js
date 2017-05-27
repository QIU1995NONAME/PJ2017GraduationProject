'use strict';

// index_app_about
angular.module('QPControl.about', [ 'ngRoute' ]).config([//
'$routeProvider', function($routeProvider) {
	$routeProvider.when('/about', {
		templateUrl : 'views/about.xml',
		controller : 'about'
	});
} ]).controller('about', [ function() {
} ]);
