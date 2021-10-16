package features;

import org.testng.annotations.Test;

public class Dependency {
	@Test(dependsOnMethods={"B"}, priority=1)
	public void A(){
		System.out.println("Test Case A");
	}
	@Test(priority=2)
	public void B(){
		System.out.println("Test Case B");
	}
	@Test
	public void C(){
		System.out.println("Test Case C");
	}
}
