'use strict';

// index_app_view-data
angular.module('QPControl.view-data', [ 'ngRoute' ]).config([//
'$routeProvider', function($routeProvider) {
	$routeProvider.when('/view-data', {
		templateUrl : 'views/view-data.xml',
		controller : 'view-data'
	});
} ]).controller('view-data', [ function() {
} ]);
