'use strict';

// index_app_view-data
angular.module('QPControl.view-data', [ 'ngRoute' ]).config([//
'$routeProvider', function($routeProvider) {
	$routeProvider.when('/view-data', {
		templateUrl : 'views/view-data.xml',
		controller : 'view-data'
	});
} ]).controller('view-data', [ '$scope', '$interval',//
function($scope, $interval) {
	var chart0 = echarts.init(document.getElementById('chart0'));
	var chart_title = "";
	$scope.selectstation = function() {
		console.log($scope.current_station);
		ws_send({
			command : 'get_station_variables',
			data : $scope.current_station.ID
		});
	};
	$interval(function() {
		if ($scope.auto_refresh) {
			if ($scope.current_variable != null) {
				ws_send({
					command : 'get_variable_history',
					data : $scope.current_variable.ID
				});
			}
		}
	}, 1000);

	$scope.selectvariable = function() {
		$scope.auto_refresh = false;
		chart_title = 'VAR:' + $scope.current_variable.owner;
		chart_title += ':' + $scope.current_variable.num;
		chart0.setOption({
			title : {
				text : chart_title,
			},
			tooltip : {},
			legend : {
				data : [ 'DATA' ]
			},
			xAxis : {
				type : 'category',
				boundaryGap : false,
				data : [],
			},
			yAxis : {
				boundaryGap : [ 0, '50%' ],
				type : 'value',
			},
			series : [ {
				name : 'DATA',
				type : 'line',
				smooth : true,
				symbol : 'none',
				stack : 'a',
				areaStyle : {
					normal : {}
				},
				data : [],
			} ]
		});

		chart0.showLoading();
		ws_send({
			command : 'get_variable_history',
			data : $scope.current_variable.ID
		});
	};
	ws_register('get_stations_allowed', function(result) {
		$scope.stations = result.data;
		$scope.$apply();
	});
	ws_register('get_variable_history', function(result) {
		var chart_data = result.data.slice();
		chart_data.reverse();
		var x_data = [];
		var y_data = [];
		for (var i = 0; i < chart_data.length; i++) {
			x_data.push(new Date(chart_data[i].timestamp));
			y_data.push(chart_data[i].data);
		}
		chart0.setOption({
			title : {
				text : chart_title + "(" + chart_data.length + " Records)",
			},
			xAxis : {
				data : x_data,
			},
			legend : {
				data : [ 'DATA' ]
			},
			yAxis : {
				boundaryGap : [ 0, '50%' ],
				type : 'value',
			},
			series : [ {
				name : 'DATA',
				type : 'line',
				smooth : true,
				symbol : 'none',
				stack : 'a',
				areaStyle : {
					normal : {}
				},
				data : y_data,
			} ]
		});
		chart0.hideLoading();

	});
	ws_register('get_station_variables', function(result) {
		$scope.variables = result.data;
		$scope.$apply();
	});
	ws_send({
		command : 'get_stations_allowed'
	});
}//
]);
