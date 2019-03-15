package fa.edu.excercise2;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CheckPassFail {
	@Parameters("mark")
  @Test
  public void Test(int mark) {
		Check check = new Check();
	 Assert.assertEquals(check.CheckPassFail(mark), "PASS");
   }
}
