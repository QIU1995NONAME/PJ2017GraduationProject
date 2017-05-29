'use strict';

// index_app_mgr-hardware
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
	// /////////////////////////////////////////
	ws_register('get_counts', function(result) {
		$scope.counts = result.data;
		$scope.$apply();
	});
	// /////////////////////////////////////////
	ws_register('get_gateways_allowed', function(result) {
		$scope.gateways = result.data;
		$scope.gallowed = true;
		$scope.gdenied = false;
		$scope.$apply();
	});
	$scope.btnallowedgateways = function() {
		ws_send({
			command : 'get_gateways_allowed'
		});
	};
	// /////////////////////////////////////////
	ws_register('get_gateways_denied', function(result) {
		$scope.gateways = result.data;
		$scope.gallowed = false;
		$scope.gdenied = true;
		$scope.$apply();
	});
	$scope.btndeniedgateways = function() {
		ws_send({
			command : 'get_gateways_denied'
		});
	};
	// /////////////////////////////////////////
	ws_register('get_gateways_unchecked', function(result) {
		$scope.gateways = result.data;
		$scope.gallowed = false;
		$scope.gdenied = false;
		$scope.$apply();
	});
	$scope.btnuncheckedgateways = function() {
		ws_send({
			command : 'get_gateways_unchecked'
		});
	};
	// /////////////////////////////////////////
	ws_register('get_stations_allowed', function(result) {
		$scope.stations = result.data;
		$scope.sallowed = true;
		$scope.sdenied = false;
		$scope.$apply();
	});
	$scope.btnallowedstations = function() {
		ws_send({
			command : 'get_stations_allowed'
		});
	};
	// /////////////////////////////////////////
	ws_register('get_stations_denied', function(result) {
		$scope.stations = result.data;
		$scope.sallowed = false;
		$scope.sdenied = true;
		$scope.$apply();
	});
	$scope.btndeniedstations = function() {
		ws_send({
			command : 'get_stations_denied'
		});
	};
	// /////////////////////////////////////////
	ws_register('get_stations_unchecked', function(result) {
		$scope.stations = result.data;
		$scope.sallowed = false;
		$scope.sdenied = false;
		$scope.$apply();
	});
	$scope.btnuncheckedstations = function() {
		ws_send({
			command : 'get_stations_unchecked'
		});
	};
	// /////////////////////////////////////////
	$scope.btndomodifygateway = function(index) {
		console.log($scope.gateways[index]);
	};
	// /////////////////////////////////////////
	ws_register('allow_gateway', function(result) {
		ws_send({
			command : 'get_counts'
		});
	});
	$scope.btndoallowgateway = function(index) {
		ws_send({
			command : 'allow_gateway',
			data : $scope.gateways[index].ID
		});
		$scope.gateways.splice(index, 1);
		$scope.$apply();
	};
	// /////////////////////////////////////////
	ws_register('deny_gateway', function(result) {
		ws_send({
			command : 'get_counts'
		});
	});
	$scope.btndodenygateway = function(index) {
		ws_send({
			command : 'deny_gateway',
			data : $scope.gateways[index].ID
		});
		$scope.gateways.splice(index, 1);
		$scope.$apply();
	};
	// /////////////////////////////////////////
	$scope.btndomodifystation = function(index) {
		console.log($scope.stations[index]);
	};
	// /////////////////////////////////////////
	ws_register('allow_station', function(result) {
		ws_send({
			command : 'get_counts'
		});
	});
	$scope.btndoallowstation = function(index) {
		ws_send({
			command : 'allow_station',
			data : $scope.stations[index].ID
		});
		$scope.stations.splice(index, 1);
		$scope.$apply();
	};
	// /////////////////////////////////////////
	ws_register('deny_station', function(result) {
		ws_send({
			command : 'get_counts'
		});
	});
	$scope.btndodenystation = function(index) {
		ws_send({
			command : 'deny_station',
			data : $scope.stations[index].ID
		});
		$scope.stations.splice(index, 1);
		$scope.$apply();
	};
	// /////////////////////////////////////////
	ws_send({
		command : 'get_counts'
	});
} ]);
