

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Testing3 {
	SoftAssert softAssert=new SoftAssert();
	
	@Test (priority=1,groups="Sanity")
	public void homeTest(){
		System.out.println("I am in home Test");
		System.out.println("before Sssertion");
		Assert.assertTrue(4>3,"Verify element");//if this is false then it will not execute next line it will fail here
		System.out.println("afetr assertions");
		
	}
	@Test (priority=2,dependsOnMethods={"homeTest"},groups={"Smoke","Sanity"})
	public void mainTest(){
		System.out.println("I am in main Test");
		System.out.println("before Sssertion");
		softAssert.assertTrue(2>3,"Verify element");//this is softassert in which if it is fail here,but it will execute next line
		System.out.println("afetr assertions");
		softAssert.assertAll();//similar to error collector
	
}
	
	@Test (priority=3,dependsOnMethods={"mainTest"},groups="nikul")
	public void endTest(){
		System.out.println("I am in end Test");
		System.out.println("before Sssertion");
		Assert.assertTrue(2>3,"Verify element");
		System.out.println("afetr assertions");
		softAssert.assertEquals("abc", "abc1");
		System.out.println("afetr assertions");
		softAssert.assertAll();
		
	}
}
