'use strict';

// index_app_mgr-data
angular.module('QPControl.mgr-data', [ 'ngRoute' ]).config([//
'$routeProvider', function($routeProvider) {
	$routeProvider.when('/mgr-data', {
		templateUrl : 'views/mgr-data.xml',
		controller : 'mgr-data'
	});
} ]).controller('mgr-data', [ function() {
} ]);
