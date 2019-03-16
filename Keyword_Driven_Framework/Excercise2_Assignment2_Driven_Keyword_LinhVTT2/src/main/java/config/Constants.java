package config;

public class Constants {
	public static final String Path_TestData = System.getProperty("user.dir")
			+ "//src//main//java//dataEngine//DataEngine.xlsx";
	public static final String Path_OR = System.getProperty("user.dir") + "//src//main//java//config//OR.txt";
	public static final String File_TestData = "DataEngine.xlsx";

	public static final int Col_TestCaseID = 0;
	public static final int Col_PageObject = 4;
	public static final int Col_ActionKeyword = 5;
	public static final int Col_RunMode = 2;
	public static final int Col_Result = 3;
	public static final int Col_DataSet = 6;
	public static final int Col_TestStepResult = 7;

	public static final String Sheet_TestSteps = "Test Steps";
	public static final String Sheet_TestCases = "Test Cases";

	public static final String KEYWORD_FAIL = "FAIL";
	public static final String KEYWORD_PASS = "PASS";
}
