package com.yk.redpackage;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		
		int index = 8;
		double money = 1000;
		Float[] fs = new Float[index];
		
		for (int j = 0; j < 10; j++) {
			RedPackage redPackage=new RedPackage(money, index);
			for (int i = 0; i < index; i++) {
				fs[i] = redPackage.startRobrRedPackage().floatValue();
				System.out.println(fs[i]);
			}
			redPackage = null;
			if(RedPackage.baseTypeArraySumKeepTwo(fs).doubleValue() != money) {
				System.out.println("error");
			}
			System.out.println("-------------------------------");
		}
		
	}
	
	

}
