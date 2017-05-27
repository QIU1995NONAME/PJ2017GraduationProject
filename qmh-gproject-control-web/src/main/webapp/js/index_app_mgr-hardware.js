'use strict';

//index_app_mgr-hardware
angular.module('QPControl.mgr-hardware', [ 'ngRoute' ]).config([//
'$routeProvider', function($routeProvider) {
	$routeProvider.when('/mgr-hardware', {
		templateUrl : 'views/mgr-hardware.xml',
		controller : 'mgr-hardware'
	});
} ]).controller('mgr-hardware', [ '$scope', function($scope) {
	$scope.counts = {
		gateways : 0,
		stations : 0,
		allowed_gateways : 0,
		denied_gateways : 0,
		unchecked_gateways : 0,
		allowed_stations : 0,
		denied_stations : 0,
		unchecked_stations : 0,
	};
	// function hardware_update_counts(var       res_counts){}
	// $scope.counts = res_counts;
	// $scope.$apply();
	// }
} ]);
