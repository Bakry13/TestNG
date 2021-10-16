package features;

import org.testng.annotations.Test;

public class Grouping {
	@Test(groups={"Retest"}, priority=4)
	public void TC1(){
		System.out.println("Test Case 1");
	}
	@Test(groups={"Regression"}, priority=3)
	public void TC2(){
		System.out.println("Test Case 2");
	}
	@Test(groups={"Retest"}, priority=2)
	public void TC3(){
		System.out.println("Test Case 3");
	}
	@Test(groups={"Regression"}, priority=1)
	public void TC4(){
		System.out.println("Test Case 4");
	}

}
