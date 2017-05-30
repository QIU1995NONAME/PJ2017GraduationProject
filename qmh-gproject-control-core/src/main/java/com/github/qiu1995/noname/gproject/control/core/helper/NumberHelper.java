package com.github.qiu1995.noname.gproject.control.core.helper;

/**
 * 用来将数据与字节数组进行转换
 * 
 * @author QMH
 */

public class NumberHelper {
	private NumberHelper() {

	}

	public static byte[] short2bytes(short num) {
		byte[] result = new byte[2];
		for (int i = 0; i < 2; i++) {
			result[i] = (byte) num;
			num >>= 8;
		}
		return result;
	}

	public static byte[] int2bytes(int num) {
		byte[] result = new byte[4];
		for (int i = 0; i < 4; i++) {
			result[i] = (byte) num;
			num >>= 8;
		}
		return result;
	}

	public static byte[] long2bytes(long num) {
		byte[] result = new byte[8];
		for (int i = 0; i < 8; i++) {
			result[i] = (byte) num;
			num >>= 8;
		}
		return result;
	}

	public static byte[] float2bytes(float num) {
		int i = Float.floatToIntBits(num);
		return int2bytes(i);
	}

	public static byte[] double2bytes(double num) {
		long l = Double.doubleToLongBits(num);
		return long2bytes(l);
	}

	public static short bytes2short(byte[] b) {
		short result = 0;
		if (b == null || b.length < 2) {
			return 0;
		}
		for (int i = 0; i < 2; i++) {
			result <<= 8;
			result |= (long) (0xFF & b[1 - i]);
		}
		return result;
	}

	public static int bytes2int(byte[] b) {
		int result = 0;
		if (b == null || b.length < 4) {
			return 0;
		}
		for (int i = 0; i < 4; i++) {
			result <<= 8;
			result |= (long) (0xFF & b[3 - i]);
		}
		return result;
	}

	public static long bytes2long(byte[] b) {
		long result = 0;
		if (b == null || b.length < 8) {
			return 0;
		}
		for (int i = 0; i < 8; i++) {
			result <<= 8;
			result |= (long) (0xFF & b[7 - i]);
		}
		return result;
	}

	public static float bytes2float(byte[] b) {
		int i = bytes2int(b);
		return Float.intBitsToFloat(i);
	}

	public static double bytes2double(byte[] b) {
		long l = bytes2long(b);
		return Double.longBitsToDouble(l);
	}
}
