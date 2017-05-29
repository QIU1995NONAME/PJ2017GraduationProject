'use strict';
var wsclienturi = "ws://localhost:8080/qmh-gproject-control-web/ws/main.ws";
var wsclient0 = null;
var ws_registers = [];
var ws_callbacks = [];
function ws_send(data) {
	console.log(JSON.stringify(data));
	return wsclient0.send(JSON.stringify(data));
}
function ws_register(command, callback) {
	ws_callbacks.push({
		command : command,
		callback : callback
	});
}
function new_wsclient() {
	var ws_result = new WebSocket(wsclienturi);
	ws_result.onopen = function(event) {
		ws_onOpen(event)
	};
	ws_result.onmessage = function(event) {
		ws_onMessage(event)
	};
	ws_result.onclose = function(event) {
		ws_onClose(event)
	};
	ws_result.onerror = function(event) {
		ws_onError(event)
	};
	return ws_result;
}
function ws_onOpen(event) {
	console.log(event);
	new $.zui.Messager('打开WebSocket成功！', {
		type : 'success'
	}).show();
}
function ws_onMessage(event) {
	console.log(event);
	var result = JSON.parse(event.data);
	angular.forEach(ws_callbacks, function(value) {
		if (value.command == result.command) {
			value.callback(result);
		}
	});
}
function ws_onClose(event) {
	console.log(event);
	new $.zui.Messager('WebSocket已经关闭！', {
		type : 'warning'
	}).show();
}
function ws_onError(event) {
	console.log(event);
}
wsclient0 = new_wsclient();
