package com.yk.redpackage;

import java.math.BigDecimal;
import java.util.Random;

public class RedPackage {

	private BigDecimal totalMoney;
	private int totalMan;

	public RedPackage(double totalMoney,int totalMan) {
		// TODO Auto-generated constructor stub
		this.totalMan=totalMan;
		this.totalMoney=new BigDecimal(totalMoney);
	}
	/**
	 * 开始抢红包
	 * 
	 * @return
	 */
	public synchronized BigDecimal startRobrRedPackage() {
		if (this.totalMan == 1) {
			return totalMoney;
		}
		BigDecimal avg = totalMoney.divide(new BigDecimal(totalMan), 6);
		BigDecimal currentMoney = getRandomBigDecimal(new BigDecimal(0.01),
				avg.multiply(new BigDecimal(2)).setScale(2, BigDecimal.ROUND_HALF_DOWN));
		totalMoney = totalMoney.subtract(currentMoney);
		totalMan--;
		return currentMoney;

	}

	/**
	 * 红包算法
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static BigDecimal getRandomBigDecimal(BigDecimal a, BigDecimal b) {
		if (b.subtract(a).doubleValue() <= 0 || a.intValue() < 0)
			throw new RuntimeException("start value no allow low end value");
		return new BigDecimal(new Random().nextDouble()).multiply(b).add(a).setScale(2, BigDecimal.ROUND_HALF_UP);

	}
	
	
	/**
	 * 基本数据类型的数据和计算
	 * @param t
	 * @param mc
	 * @param scale
	 * @return
	 */
	public static <T> BigDecimal baseTypeArraySum(T[] t,int scale) {
		BigDecimal count=new BigDecimal(0);
		if (t.length <= 0) {
			return count;
		}
		for (T t2 : t) {
			count=count.add(new BigDecimal((char[]) t2));
		}
		return count.setScale(scale, BigDecimal.ROUND_HALF_DOWN);
		
	}
	
	/**
	 * 基本数据类型的数据和计算
	 * @param t
	 * @param mc
	 * @param scale
	 * @return
	 */
	public static <T extends Number> BigDecimal baseTypeArraySumKeepTwo(T[] t) {
		BigDecimal count=new BigDecimal(0);
		if (t.length <= 0) {
			return count;
		}
		for (T t2 : t) {
			count=count.add(new BigDecimal(t2.doubleValue()));
		}
		return count.setScale(2, BigDecimal.ROUND_HALF_DOWN);
		
	}
	
	
}
