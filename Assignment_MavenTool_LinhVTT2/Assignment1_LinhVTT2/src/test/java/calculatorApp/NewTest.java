package calculatorApp;

import org.testng.Assert;
import org.testng.annotations.Test;

public class NewTest {
  @Test
  public void TestAddition() {
	  Assert.assertEquals(CalculatorApp.addition(4, 2), 6, "method addition is fail!");
  }
  
  @Test
  public void TestSubtraction() {
	  Assert.assertEquals(CalculatorApp.subtraction(4, 2), 2, "Method subtraction is fail!");
  }
  
  @Test
  public void TestSmultiplication() {
	  Assert.assertEquals(CalculatorApp.smultiplication(2, 4), 8, "Method smultiplication is fail!" );
  }
  
  @Test
  public void TestDivision() {
	  Assert.assertEquals(CalculatorApp.division(4, 2), (float)2.0, "Method Division is fail!");
  }
}
