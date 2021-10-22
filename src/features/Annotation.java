package features;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Annotation {
	@Test
	public void firstTest(){
		System.out.println("first Test Case");
	}
	@Test
	public void secondTest(){
		System.out.println("second Test Case");
	}
	@BeforeMethod
	public void BeforeEveryMethod(){
		System.out.println("Executed before every method");
	}
	@AfterMethod
	public void AfterEveryMethod(){
		System.out.println("Executed after every method");
	}
}