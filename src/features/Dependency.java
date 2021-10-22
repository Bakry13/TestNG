package features;

import org.testng.annotations.Test;

public class Dependency {
	@Test(dependsOnMethods={"C"}, priority=2)
	public void A(){
		System.out.println("Test Case A");
	}
	@Test(dependsOnMethods={"C"}, priority=1)
	public void B(){
		System.out.println("Test Case B");
	}
	@Test(priority=2)
	public void C(){
		System.out.println("Test Case C");
	}
	@Test(priority=1)
	public void D(){
		System.out.println("Test Case D");
	}
	@Test
	public void E(){
		System.out.println("Test Case E");
	}
}
