package features;

import org.testng.annotations.Test;

public class DisableEnable {
	
	@Test
	public void A(){
		System.out.println("Test Case A");
	}
	@Test(enabled = false)
	public void B(){
		System.out.println("Test Case B");
	}
	@Test
	public void C(){
		System.out.println("Test Case C");
	}

}
