package club.gsjglob.test;

import java.util.Date;

import org.junit.Test;

import club.gsjglob.domain.GsjUser;
import club.gsjglob.tools.DateUtils;

public class MyTest {
	
	@Test
	public void fun01(){
		GsjUser gsjUser = new GsjUser();
		System.out.println(gsjUser.getUserid());
		
		
	}
	
	double print(byte a , double y){
		
		return (short) (a/y*2);
		
		
		
		
	}
	
	@Test
	public void fun9(){
		byte a = 1;
		double print = print(a, 2.22);
		System.out.println(print);
		
	}

	
	@Test
	public void fun03() {
		String nowDate = DateUtils.getStringDate();
		System.out.println(nowDate);
		
		
		
	}
	
}
