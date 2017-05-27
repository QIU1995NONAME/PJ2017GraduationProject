'use strict';

// index_app_help
angular.module('QPControl.help', [ 'ngRoute' ]).config([//
'$routeProvider', function($routeProvider) {
	$routeProvider.when('/help', {
		templateUrl : 'views/help.xml',
		controller : 'help'
	});
} ]).controller('help', [ function() {
} ]);
