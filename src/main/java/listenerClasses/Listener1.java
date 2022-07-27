package listenerClasses;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener1 implements ITestListener {

	
	public void onTestStart(ITestResult result) {
	  
		System.out.println(result.getName()+ "is Started");
	  }
	
	
	public void onTestSuccess(ITestResult result) {

		System.out.println(result.getName()+ "is Success");
	  }
	
	public void onTestFailure(ITestResult result) {
	    
		System.out.println(result.getName()+ "is Failed");
	  }
	
	public void onTestSkipped(ITestResult result) {
	    
		System.out.println(result.getName()+ "is skipped");
	  }
}
