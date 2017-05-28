package com.github.qiu1995.noname.gproject.control.web.websocket;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.github.qiu1995.noname.gproject.control.core.dao.GatewayDao;
import com.github.qiu1995.noname.gproject.control.core.dao.StationDao;
import com.github.qiu1995.noname.gproject.control.core.dao.impl.GatewayDaoImpl;
import com.github.qiu1995.noname.gproject.control.core.dao.impl.StationDaoImpl;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@ServerEndpoint("/ws/main.ws")
public class WSMain {
	@OnOpen
	public void onOpen(Session session) {

	}

	@OnMessage
	public String onMessage(Session session, String message) {
		System.out.println(message);
		JsonObject request = (JsonObject) new JsonParser().parse(message);
		String command = request.get("command").getAsString();
		JsonObject result = new JsonObject();
		result.addProperty("command", command);
		if (command == null || command.length() == 0) {
			result.addProperty("errno", 10001);
			result.addProperty("errinfo", "command 不可以为空！");
		} else if (command.equalsIgnoreCase("get_counts")) {
			GatewayDao gatewayDao = new GatewayDaoImpl();
			StationDao stationDao = new StationDaoImpl();
			int count_gateways_all = gatewayDao.getAllGateways().size();
			int count_gateways_allowed = gatewayDao.getAllowedGateways().size();
			int count_gateways_denied = gatewayDao.getDeniedGateways().size();
			int count_gateways_unchecked = gatewayDao.getUncheckedGateways().size();
			int count_stations_all = stationDao.getAllStations().size();
			int count_stations_allowed = stationDao.getAllowedStations().size();
			int count_stations_denied = stationDao.getDeniedStations().size();
			int count_stations_unchecked = stationDao.getUncheckedGateway().size();
			result.addProperty("errno", 0);
			result.addProperty("errinfo", "正常");
			JsonObject counts = new JsonObject();
			counts.addProperty("gateways", count_gateways_all);
			counts.addProperty("stations", count_stations_all);
			counts.addProperty("allowed_gateways", count_gateways_allowed);
			counts.addProperty("denied_gateways", count_gateways_denied);
			counts.addProperty("unchecked_gateways", count_gateways_unchecked);
			counts.addProperty("allowed_stations", count_stations_allowed);
			counts.addProperty("denied_stations", count_stations_denied);
			counts.addProperty("unchecked_stations", count_stations_unchecked);
			result.add("counts", counts);
		} else if (command.equalsIgnoreCase("get_gateways_allowed")) {
		} else if (command.equalsIgnoreCase("get_gateways_denied")) {
		} else if (command.equalsIgnoreCase("get_gateways_unchecked")) {
		} else if (command.equalsIgnoreCase("get_stations_allowed")) {
		} else if (command.equalsIgnoreCase("get_stations_denied")) {
		} else if (command.equalsIgnoreCase("get_stations_unchecked")) {
		} else if (command.equalsIgnoreCase("allow_gateway")) {
		} else if (command.equalsIgnoreCase("deny_gateway")) {
		} else if (command.equalsIgnoreCase("allow_station")) {
		} else if (command.equalsIgnoreCase("deny_station")) {
		} else if (command.equalsIgnoreCase("get_gateways_online")) {
		} else if (command.equalsIgnoreCase("get_stations_online")) {
		} else if (command.equalsIgnoreCase("modify_gateway")) {
		} else if (command.equalsIgnoreCase("modify_station")) {
		} else if (command.equalsIgnoreCase("get_station_variables")) {
		} else if (command.equalsIgnoreCase("get_variable_history")) {
		} else if (command.equalsIgnoreCase("get_variable_current")) {
		} else if (command.equalsIgnoreCase("set_variable_data")) {
		} else {
			result.addProperty("errno", 99999);
			result.addProperty("errinfo", "暂不支持command" + command);
		}
		// json.add(property, value);

		System.out.println(new Gson().toJson(result));
		return new Gson().toJson(result);
	}

	@OnError
	public void onError(Throwable throwable, Session session) {
	}

	@OnClose
	public void onClose(Session session) {
	}
}
