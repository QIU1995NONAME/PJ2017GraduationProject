'use strict';

// index_app_mgr-data
angular.module('QPControl.mgr-data', [ 'ngRoute' ]).config([//
'$routeProvider', function($routeProvider) {
	$routeProvider.when('/mgr-data', {
		templateUrl : 'views/mgr-data.xml',
		controller : 'mgr-data'
	});
} ]).controller('mgr-data', [ '$scope', function($scope) {
	$scope.selectstation = function() {
		console.log($scope.current_station);
		ws_send({
			command : 'get_station_variables',
			data : $scope.current_station.ID
		});
	}
	ws_register('get_stations_allowed', function(result) {
		$scope.stations = result.data;
		$scope.$apply();
	});
	ws_register('get_station_variables', function(result) {
		$scope.variables = result.data;
		$scope.$apply();
	});
	ws_send({
		command : 'get_stations_allowed'
	});
} ]);
