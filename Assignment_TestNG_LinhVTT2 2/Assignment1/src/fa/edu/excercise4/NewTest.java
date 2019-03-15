package fa.edu.excercise4;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NewTest {
	@DataProvider(name = "showInfor")
	public static Object[][] ShowInfor() {
		return new Object[][] {{"red", "#f00"}, {"green", "#0f0"}, {"blue", "#00f"},{"cyan", "#0ff"}, {"magenta", "#f0f"}, {"yellow", "#ff0"}, {"black", "#000"}};
	}
  @Test(dataProvider = "showInfor")
  public void Test(String color, String value) {
	  System.out.println(color + "\t" + value);
  }
}
