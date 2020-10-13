//***********************************************************************
// Revision History
// Class       : JSONGenericTestSetup
// Date        : 01/05/2020
// Name        : Padmavathi Vempadi
// Description : This class is used to prepare Test data for every test 
//               Using test data we call generic test methods.
//               As of now we have defined 5 methods each calling Generic function
// Parameters  : N/A
//***********************************************************************
	

package demoFnl;

import java.io.IOException;


public class  JSONGenericTestSetup {
	
	//***********************************************************************
	// Function    : ExecuteTest1
	// Description : Test scope is to search for a specific text in the JSON object tag 'name'
    //	             If found then return 1(TRUE) else 0(FALSE)
	// Parameters  : 
    //	              a. SearchValue1 -- the text to be searched in the JSON tag 'name' 
	//***********************************************************************	  
	
		public static void main(String [] args) throws IOException {
			
			JSONGenericTestSetup ts = new JSONGenericTestSetup();
		try {
			int TestNumber1 = 1;
			int TestNumber2 = 2;
			int TestNumber3 = 3;
			int TestNumber4 = 4;
			int TestNumber5 = 5;
			
			ts.ExecuteTest1(TestNumber1);
			
			ts.ExecuteTest2(TestNumber2);
			ts.ExecuteTest3(TestNumber3);
			ts.ExecuteTest4(TestNumber4);
			ts.ExecuteTest5(TestNumber5);
			
		} catch (IOException e) {
            e.printStackTrace();
        } 
			
		}
	
	 public  int ExecuteTest1(int p_TestNumber) throws IOException {

		  String MethodName      = "ExecuteTest1";
		  String TestDescription = "Test scope is to search for a specific text in the JSON object tag 'name'. If found then return 1(TRUE) else 0(FALSE) ";
		  String GetURL          = "https://api.github.com/search/code?q=addClass+in:file+language:js+repo:jquery/jquery";
		  String SearchValue1     = "jquery-1.9.1.js"; 
		  int result             = 0;
		  boolean debug          = false;
		  if (debug) { System.out.println(MethodName + "==>" + " Value of Result before the test ==> " + result); }
		  result = JSONGenericTestSetupMethods.GenericGetJSONObjectdata(GetURL, SearchValue1, p_TestNumber ,TestDescription, debug);
		  if (debug) { System.out.println("Value of Result After ==> " + result); }
		  if (debug) { System.out.println(MethodName + "==>" + "Value of Result Alter the test==> " + result); }
		  if (result == 1 ) { System.out.println("\nTestNumber " + p_TestNumber  + " **************SUCCESS and COMPLETED**************\n"); } else { System.out.println("**************TestNumber " + p_TestNumber + " FAILED and COMPLETED**************"); }
		  return result;
	 } 	
	

	 //***********************************************************************
	 // Function    : ExecuteTest2
	 // Description : Test scope is to check if all the dates in the JASON result set is 
	 //               greater than the date specified in the test parameter.
	 //	             If found then return 1(TRUE) else 0(FALSE)
	 // Parameters  : 
	 //	              a. Searchalue2 -- date to compare with the result set. 
	 //***********************************************************************		 
	 public  int ExecuteTest2(int p_TestNumber) throws IOException {

		  String MethodName      = "ExecuteTest2";
		  String TestDescription2 = "Test scope is to check if all the dates in the JASON result set is greater than the date specified in the test parameter, if greater then return 1(TRUE)  else 0 (FALSE)";
		  String GetURL2          = "https://api.github.com/search/repositories?q=tetris+created:%3E=2019-04-01+language:assembly&sort=stars&order=desc";
		  String SearchValue2    = "2019-04-11T00:00:00Z"; 
		  int result2             = 0;
		  boolean debug          = false;
		  if (debug) { System.out.println(MethodName + "==>" + " Value of Result before the test ==> " + result2); }
		  result2 = JSONGenericTestSetupMethods.GenericGetJSONObjectdata(GetURL2, SearchValue2, p_TestNumber,TestDescription2, debug);
		  if (debug) { System.out.println("Value of Result After ==> " + result2); }
		  if (debug) { System.out.println(MethodName + "==>" + "Value of Result Alter the test==> " + result2); }
		  if (result2 == 1 ) { System.out.println("\n**************TestNumber " + p_TestNumber + " **************SUCCESS and COMPLETED\n"); } else { System.out.println("**************TestNumber " + p_TestNumber + " FAILED and COMPLETED**************"); }
		  return result2;
	 }
	 
	//***********************************************************************
	// Function    : ExecuteTest3
	// Description : Test scope is to check if all the entries in the JSON results 
	//               in descending order.If found then return 1(TRUE) else 0(FALSE)
	// Parameters  : N/A
	//	               
	//***********************************************************************	 
	 public  int ExecuteTest3(int p_TestNumber) throws IOException {

		  String MethodName      = "ExecuteTest3";
		  
		  String TestDescription3 = "Test scope is to check if all the entries in the JSON results in descending order.If found then return 1(TRUE) else 0(FALSE)";
		  String GetURL3          = "https://api.github.com/search/repositories?q=tetris+language:assembly&sort=stars&order=desc";
		  String SearchValue3     = ""; // N/A
		  int result3             = 0;
		  boolean debug           = false;
		  if (debug) { System.out.println(MethodName + "==>" + " Value of Result before the test ==> " + result3); }
		  result3 = JSONGenericTestSetupMethods.GenericGetJSONObjectdata(GetURL3, SearchValue3, p_TestNumber,TestDescription3, debug);
		  if (debug) { System.out.println("Value of Result After ==> " + result3); }
		  if (debug) { System.out.println(MethodName + "==>" + "Value of Result Alter the test==> " + result3); }
		  if (result3 == 1 ) { System.out.println("\n**************TestNumber " + p_TestNumber + " SUCCESS and COMPLETED**************\n"); } else { System.out.println("**************TestNumber " + p_TestNumber + " FAILED and COMPLETED**************"); }

		  return result3;
	 }	 
	 
	 //***********************************************************************
	 // Function    : ExecuteTest4
	 // Description : Test scope is to check if for any user the 'has_wiki' is set 
	 //               to 'false'. if set to false then return 1(TRUE) else 0(FALSE)
	 // Parameters  : 
	 //	              SearchValue4   - -- the text to be searched in the JSON tag 'has_wiki' 
	 //***********************************************************************	 
	 public  int ExecuteTest4(int p_TestNumber) throws IOException {

		  String MethodName      = "ExecuteTest4";
		  
		  String TestDescription4 = "Test scope is to check if for any user the 'has_wiki' is set to 'false'. if set to false then return 1(TRUE) else 0(FALSE) ";
		  String GetURL4          = "https://api.github.com/search/repositories?q=te+created:%3E=2019-05-01+language:assembly&sort=stars&order=desc";
		  String SearchValue4     = "false"; 
		  int result4             = 0;
		  boolean debug           = false;
		  if (debug) { System.out.println(MethodName + "==>" + " Value of Result before the test ==> " + result4); }
		  result4 = JSONGenericTestSetupMethods.GenericGetJSONObjectdata(GetURL4, SearchValue4, p_TestNumber,TestDescription4, debug);
		  if (debug) { System.out.println("Value of Result After ==> " + result4); }
		  if (debug) { System.out.println(MethodName + "==>" + "Value of Result Alter the test==> " + result4); }
		  if (result4 == 1 ) { System.out.println("\n**************TestNumber " + p_TestNumber + " SUCCESS and COMPLETED **************\n"); } else { System.out.println("**************TestNumber " + p_TestNumber + " FAILED and COMPLETED**************"); }

		  return result4;
	 }	 	 
	 

	 
	 //***********************************************************************
	 // Function    : ExecuteTest5
	 // Description : Test scope is to  Search and list users who has 
	 //               open_issues >= SearchValue ,if found then return 1(TRUE) else 0(FALSE)
	 // Parameters  : 
	 //	              SearchValue5   - search value to be capped for users who has open issues.
	 //***********************************************************************	 
	 public  int ExecuteTest5(int p_TestNumber) throws IOException {

		  String MethodName      = "ExecuteTest5";
		  
		  String TestDescription5 = "Test scope is to  Search and list users who has open_issues >= SearchValue ,if found then return 1(TRUE) else 0(FALSE)";
		  String GetURL5          = "https://api.github.com/search/repositories?q=tetris+created:%3E=2019-05-01+language:Python&sort=open_issues";
		  String SearchValue5     = "5"; 
		  int result5             = 0;
		  boolean debug           = false;
		  if (debug) { System.out.println(MethodName + "==>" + " Value of Result before the test ==> " + result5); }
		  result5 = JSONGenericTestSetupMethods.GenericGetJSONObjectdata(GetURL5, SearchValue5, p_TestNumber,TestDescription5, debug);
		  if (debug) { System.out.println("Value of Result After ==> " + result5); }
		  if (debug) { System.out.println(MethodName + "==>" + "Value of Result Alter the test==> " + result5); }
		  if (result5 == 1 ) { System.out.println("\n **************TestNumber " + p_TestNumber + " SUCCESS and COMPLETED **************\n "); } else { System.out.println(" **************TestNumber " + p_TestNumber + " FAILED and COMPLETED **************"); }

		  return result5;
	 }	 	 
	 
	 
	 

}
