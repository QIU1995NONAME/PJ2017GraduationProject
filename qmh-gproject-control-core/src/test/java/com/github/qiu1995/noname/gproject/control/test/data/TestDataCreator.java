package com.github.qiu1995.noname.gproject.control.test.data;

import java.util.Map;

import org.hibernate.LobHelper;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.github.qiu1995.noname.gproject.control.core.QPCCore;
import com.github.qiu1995.noname.gproject.control.core.dao.StationDao;
import com.github.qiu1995.noname.gproject.control.core.dao.impl.StationDaoImpl;
import com.github.qiu1995.noname.gproject.control.core.entity.Station;
import com.github.qiu1995.noname.gproject.control.core.entity.VarData;
import com.github.qiu1995.noname.gproject.control.core.entity.Variable;
import com.github.qiu1995.noname.gproject.control.core.helper.NumberHelper;
import com.google.common.collect.Maps;

public class TestDataCreator {
	private static final int STATION_ID = 8010000;

	public static void main(String[] args) throws Exception {
		QPCCore.getInstance().enable();
		Session session = QPCCore.getInstance().getSession();
		LobHelper lob = session.getLobHelper();
		StationDao station_dao = new StationDaoImpl(session);
		Station station = station_dao.getStationByID(STATION_ID);
		Map<Integer, Variable> vars = Maps.newHashMap();
		for (Variable var : station.getVars()) {
			vars.put(var.getNum(), var);
		}
		/**
		 * 定义测试环境
		 * <ol>
		 * <li>液位高度(mm)</li>
		 * <li>液位温度(T)</li>
		 * <li>流入速度期望值(ml/50ms)</li>
		 * <li>流出速度期望值(ml/50ms)</li>
		 * <li>流入速度干扰量(ml/50ms)</li>
		 * <li>流出速度干扰量(ml/50ms)</li>
		 * <li>流入开关</li>
		 * <li>流出开关</li>
		 * <li>液位报警</li>
		 * <li>温度报警</li>
		 * </ol>
		 */
		long[] value = new long[10];
		value[0] = 0;
		value[1] = 300;

		double V = 0;// m3
		double S = 0.001;// m2
		for (int i = 0; i < 288000; i++) {
			Thread.sleep(45);
			long timenow = System.currentTimeMillis();
			// 一些发生的事情
			if (i % 6000 == 0) {
				value[2] = 2030;
				value[3] = 1300;
				value[4] = 80;
				value[5] = 80;
				value[6] = 1;
				value[7] = 0;
				value[8] = 0;
				value[9] = 0;
			}
			if (i % 6000 == 1000) {
				value[6] = 1;
				value[7] = 1;
			}
			if (i % 6000 == 1500) {
				value[6] = 0;
				value[7] = 1;
			}
			if (i % 6000 == 2400) {
				value[6] = 1;
				value[7] = 1;
				value[4] = 1000;
				value[5] = 1000;
			}
			if (i % 6000 == 3600) {
				value[2] = 1000;
				value[3] = 1000;
			}
			if (i % 6000 == 4200) {
				value[2] = 2300;
				value[3] = 1530;
				value[4] = 160;
				value[5] = 160;
			}
			if (i % 6000 == 4800) {
				value[2] = 2109;
				value[3] = 3210;
				value[6] = 1;
				value[7] = 0;
			}
			// 进行变量模拟
			value[0] = (long) (V / S * 1000);
			if (value[6] != 0) {
				V += (value[2] + 2 * value[4] * (Math.random() - 0.5)) / 1000000000.;
			}
			if (value[7] != 0) {
				V -= (value[3] + 2 * value[5] * (Math.random() - 0.5)) / 1000000000.;
			}
			if (V < 0) {
				V = 0;
			}
			if (value[0] > 3000) {
				value[6] = 0;
				value[7] = 1;
				value[8] = 1;
			} else {
				value[8] = 0;
			}
			// 保存变量
			Transaction tx = session.beginTransaction();
			// System.out.printf("%d\t%.2f\t", i, i / 20.);
			for (int j = 0; j < 10; j++) {
				// System.out.print(value[j]);
				// System.out.print('\t');
				VarData vardata = new VarData();
				vardata.setTimestamp(timenow);
				vardata.setVar(vars.get(j));
				vardata.setData(lob.createBlob(NumberHelper.long2bytes(value[j])));
				session.save(vardata);
			}
			// System.out.println();
			tx.commit();
		}
	}
}
