'use strict';

// index_app_mgr-back
angular.module('QPControl.mgr-back', [ 'ngRoute' ]).config([//
'$routeProvider', function($routeProvider) {
	$routeProvider.when('/mgr-back', {
		templateUrl : 'views/mgr-back.xml',
		controller : 'mgr-back'
	});
} ]).controller('mgr-back', [ function() {
} ]);
