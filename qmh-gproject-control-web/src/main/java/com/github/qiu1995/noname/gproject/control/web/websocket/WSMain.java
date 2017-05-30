package com.github.qiu1995.noname.gproject.control.web.websocket;

import java.util.List;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.github.qiu1995.noname.gproject.control.core.dao.GatewayDao;
import com.github.qiu1995.noname.gproject.control.core.dao.StationDao;
import com.github.qiu1995.noname.gproject.control.core.dao.VarDataDao;
import com.github.qiu1995.noname.gproject.control.core.dao.impl.GatewayDaoImpl;
import com.github.qiu1995.noname.gproject.control.core.dao.impl.StationDaoImpl;
import com.github.qiu1995.noname.gproject.control.core.dao.impl.VarDataDaoImpl;
import com.github.qiu1995.noname.gproject.control.core.entity.Gateway;
import com.github.qiu1995.noname.gproject.control.core.entity.Station;
import com.github.qiu1995.noname.gproject.control.core.entity.VarData;
import com.github.qiu1995.noname.gproject.control.core.entity.Variable;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@ServerEndpoint("/ws/main.ws")
public class WSMain {
	protected JsonElement msg_get_counts(JsonElement data) {
		GatewayDao gatewayDao = new GatewayDaoImpl();
		StationDao stationDao = new StationDaoImpl();
		int count_gateways_all = gatewayDao.getAllGatewaysCount();
		int count_gateways_allowed = gatewayDao.getAllowedGatewaysCount();
		int count_gateways_denied = gatewayDao.getDeniedGatewaysCount();
		int count_gateways_unchecked = gatewayDao.getUncheckedGatewaysCount();
		int count_stations_all = stationDao.getAllStationsCount();
		int count_stations_allowed = stationDao.getAllowedStationsCount();
		int count_stations_denied = stationDao.getDeniedStationsCount();
		int count_stations_unchecked = stationDao.getUncheckedStationsCount();
		JsonObject counts = new JsonObject();
		counts.addProperty("gateways", count_gateways_all);
		counts.addProperty("stations", count_stations_all);
		counts.addProperty("allowed_gateways", count_gateways_allowed);
		counts.addProperty("denied_gateways", count_gateways_denied);
		counts.addProperty("unchecked_gateways", count_gateways_unchecked);
		counts.addProperty("allowed_stations", count_stations_allowed);
		counts.addProperty("denied_stations", count_stations_denied);
		counts.addProperty("unchecked_stations", count_stations_unchecked);
		return counts;
	}

	protected JsonElement msg_get_gateways_allowed(JsonElement data) {
		JsonArray result = new JsonArray();
		GatewayDao dao = new GatewayDaoImpl();
		List<Gateway> gateways = dao.getAllowedGateways();
		for (Gateway gateway : gateways) {
			result.add(gateway.toJsonObj());
		}
		return result;
	}

	protected JsonElement msg_get_gateways_denied(JsonElement data) {
		JsonArray result = new JsonArray();
		GatewayDao dao = new GatewayDaoImpl();
		List<Gateway> gateways = dao.getDeniedGateways();
		for (Gateway gateway : gateways) {
			result.add(gateway.toJsonObj());
		}
		return result;
	}

	protected JsonElement msg_get_gateways_unchecked(JsonElement data) {
		JsonArray result = new JsonArray();
		GatewayDao dao = new GatewayDaoImpl();
		List<Gateway> gateways = dao.getUncheckedGateways();
		for (Gateway gateway : gateways) {
			result.add(gateway.toJsonObj());
		}
		return result;
	}

	protected JsonElement msg_get_stations_allowed(JsonElement data) {
		JsonArray result = new JsonArray();
		StationDao dao = new StationDaoImpl();
		List<Station> stations = dao.getAllowedStations();
		for (Station station : stations) {
			result.add(station.toJsonObj());
		}
		return result;
	}

	protected JsonElement msg_get_stations_denied(JsonElement data) {
		JsonArray result = new JsonArray();
		StationDao dao = new StationDaoImpl();
		List<Station> stations = dao.getDeniedStations();
		for (Station station : stations) {
			result.add(station.toJsonObj());
		}
		return result;
	}

	protected JsonElement msg_get_stations_unchecked(JsonElement data) {
		JsonArray result = new JsonArray();
		StationDao dao = new StationDaoImpl();
		List<Station> stations = dao.getUncheckedGateway();
		for (Station station : stations) {
			result.add(station.toJsonObj());
		}
		return result;
	}

	protected JsonElement msg_allow_gateway(JsonElement data) {
		JsonObject result = new JsonObject();
		if (data == null) {
			// TODO
			return result;
		}
		GatewayDao dao = new GatewayDaoImpl();
		Gateway gateway = dao.getGatewayByID(data.getAsInt());
		if (gateway == null) {
			// TODO
			return result;
		}
		gateway.setStatus(127);
		dao.modifyGateway(gateway);
		// TODO
		return result;
	}

	protected JsonElement msg_deny_gateway(JsonElement data) {
		JsonObject result = new JsonObject();
		if (data == null) {
			// TODO
			return result;
		}
		GatewayDao dao = new GatewayDaoImpl();
		Gateway gateway = dao.getGatewayByID(data.getAsInt());
		if (gateway == null) {
			// TODO
			return result;
		}
		gateway.setStatus(-128);
		dao.modifyGateway(gateway);
		// TODO
		return result;
	}

	protected JsonElement msg_allow_station(JsonElement data) {
		JsonObject result = new JsonObject();
		if (data == null) {
			// TODO
			return result;
		}
		StationDao dao = new StationDaoImpl();
		Station station = dao.getStationByID(data.getAsInt());
		if (station == null) {
			// TODO
			return result;
		}
		station.setStatus(127);
		dao.modifyStation(station);
		// TODO
		return result;
	}

	protected JsonElement msg_deny_station(JsonElement data) {
		JsonObject result = new JsonObject();
		if (data == null) {
			// TODO
			return result;
		}
		StationDao dao = new StationDaoImpl();
		Station station = dao.getStationByID(data.getAsInt());
		if (station == null) {
			// TODO
			return result;
		}
		station.setStatus(-128);
		dao.modifyStation(station);
		// TODO
		return result;
	}

	protected JsonElement msg_get_station_variables(JsonElement data) {
		JsonArray result = new JsonArray();
		if (data == null) {
			// TODO
			return result;
		}
		StationDao dao = new StationDaoImpl();
		Station station = dao.getStationByID(data.getAsInt());
		if (station == null) {
			// TODO
			return result;
		}
		Set<Variable> vars = station.getVars();
		for (Variable var : vars) {
			result.add(var.toJsonObj());
		}
		// TODO
		return result;
	}

	protected JsonElement msg_get_variable_history(JsonElement data) {
		JsonArray result = new JsonArray();
		if (data == null) {
			// TODO
			return result;
		}
		VarDataDao dao = new VarDataDaoImpl();
		List<VarData> li = dao.getVariableHistoryData(data.getAsLong(), 2000);
		for (VarData vd : li) {
			result.add(vd.toJsonObj());
		}
		// TODO
		return result;
	}

	@OnMessage
	public String onMessage(Session session, String message) {
		System.out.println("IN : " + message);
		JsonObject request = (JsonObject) new JsonParser().parse(message);
		String command = request.get("command").getAsString();
		JsonObject result = new JsonObject();
		result.addProperty("command", command);
		try {
			if (command == null || command.length() == 0) {
				result.addProperty("errno", 10001);
				result.addProperty("errinfo", "command 不可以为空！");
			} else if (command.equalsIgnoreCase("get_counts")) {
				result.addProperty("errno", 0);
				result.addProperty("errinfo", "正常");
				result.add("data", msg_get_counts(request.get("data")));
			} else if (command.equalsIgnoreCase("get_gateways_allowed")) {
				result.add("data", msg_get_gateways_allowed(request.get("data")));
			} else if (command.equalsIgnoreCase("get_gateways_denied")) {
				result.add("data", msg_get_gateways_denied(request.get("data")));
			} else if (command.equalsIgnoreCase("get_gateways_unchecked")) {
				result.add("data", msg_get_gateways_unchecked(request.get("data")));
			} else if (command.equalsIgnoreCase("get_stations_allowed")) {
				result.add("data", msg_get_stations_allowed(request.get("data")));
			} else if (command.equalsIgnoreCase("get_stations_denied")) {
				result.add("data", msg_get_stations_denied(request.get("data")));
			} else if (command.equalsIgnoreCase("get_stations_unchecked")) {
				result.add("data", msg_get_stations_unchecked(request.get("data")));
			} else if (command.equalsIgnoreCase("allow_gateway")) {
				result.add("data", msg_allow_gateway(request.get("data")));
			} else if (command.equalsIgnoreCase("deny_gateway")) {
				result.add("data", msg_deny_gateway(request.get("data")));
			} else if (command.equalsIgnoreCase("allow_station")) {
				result.add("data", msg_allow_station(request.get("data")));
			} else if (command.equalsIgnoreCase("deny_station")) {
				result.add("data", msg_deny_station(request.get("data")));
			} else if (command.equalsIgnoreCase("get_gateways_online")) {
			} else if (command.equalsIgnoreCase("get_stations_online")) {
			} else if (command.equalsIgnoreCase("modify_gateway")) {
			} else if (command.equalsIgnoreCase("modify_station")) {
			} else if (command.equalsIgnoreCase("get_station_variables")) {
				result.add("data", msg_get_station_variables(request.get("data")));
			} else if (command.equalsIgnoreCase("get_variable_history")) {
				result.add("data", msg_get_variable_history(request.get("data")));
			} else if (command.equalsIgnoreCase("get_variable_current")) {
			} else if (command.equalsIgnoreCase("set_variable_data")) {
			} else {
				result.addProperty("errno", 99999);
				result.addProperty("errinfo", "暂不支持command" + command);
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.addProperty("errno", 88888);
			result.addProperty("errinfo", command + "内部错误");
		}
		System.out.println("OUT: " + new Gson().toJson(result));
		return new Gson().toJson(result);
	}

	@OnError
	public void onError(Throwable throwable, Session session) {
	}

	@OnClose
	public void onClose(Session session) {
	}

	@OnOpen
	public void onOpen(Session session) {

	}
}
