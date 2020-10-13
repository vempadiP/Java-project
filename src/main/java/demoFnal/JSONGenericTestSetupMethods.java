//***********************************************************************
// Revision History
// Class      : JSONGenericTestSetupMethods
// Date       : 01/05/2020
// Name       : Padmavathi Vempadi
// Description: This class has the main logic to call the GitHub API
//              When the Github GET call returns results then the Generic test 
//                validation function is called to validate the test scenarios
// Parameters : N/A
//***********************************************************************



package demoFnl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.ZonedDateTime;
import org.apache.commons.lang3.StringUtils;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


public class JSONGenericTestSetupMethods {

	
	//***********************************************************************
	// Function    : GenericGetJSONObjectdata
	// Description : This is a generic funciton which will connect to the URL passed as a parameter.
	//               if the get URL returns the results then a generic test function is called and tests are valided.
	//	             If the get URL does not return any results then it return 0(FALSE)
	// Parameters  : 
    //	              a. p_GetURL           -- The URL to call
	//                b. p_SearchValue      -- the text to be searched in the JSON tag
	//                c. p_TestNumber       -- The test number to beb called  ex : 1, 2,3,4,5
	//                d. p_TestDescription  -- The description of the test. used to print in the report.
	//                e. p_debug            -- debug flag needed if something breaks
	// Return      : return 1(TRUE)  if Success 
	//                      0(FALSE) if failure	
	//***********************************************************************	
	public static int GenericGetJSONObjectdata(String p_GetURL, String p_SearchValue, int p_TestNumber,String p_TestDescription ,boolean p_debug ) throws IOException {

	String CallingMethod = "GenericGetJSONObjectdata";
	URL urlForGetRequest = new URL(p_GetURL);
	int found1 = 0;

    try {
    	    
    	   // Logic to call the GET API.
			String readLine = null;
		    HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
		    conection.setRequestMethod("GET");
		    int responseCode = conection.getResponseCode();
		    if (responseCode == HttpURLConnection.HTTP_OK) {
		        BufferedReader in = new BufferedReader(new InputStreamReader(conection.getInputStream()));
		        StringBuffer response = new StringBuffer();

		        	while ((readLine = in .readLine()) != null) {
			            response.append(readLine);
			        } in .close();
		    

		        
		        // We are using ObjectMapper Lib to convert/format the JSON object/JSON string into Java Object;
			    ObjectMapper mapper = new ObjectMapper();
			    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			    mapper.setSerializationInclusion(Include.NON_NULL);
                mapper.setSerializationInclusion(Include.NON_EMPTY);
                mapper.setSerializationInclusion(Include.NON_DEFAULT);
                
			    

	        try {
	            
	        	if (p_debug) { System.out.println("GET URL results in JSON format below ==> " + response.toString() + " \n"); }

	            //System.out.println("GET UR: JASON response in hash ==> " + response.toString());
	            JSONObjectRootClass JSONObjectJavaInstance = mapper.readValue(response.toString(), JSONObjectRootClass.class);
	            String prettyStaff1 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(JSONObjectJavaInstance);
	            System.out.println("\nTest " + p_TestNumber + " : URL ==> " + p_GetURL);
	            
	            System.out.println("Test " + p_TestNumber + "==> URL results JSON object below :\n " + prettyStaff1 + "\n");
	            
	            if (p_debug) { System.out.println(CallingMethod + "==> " + "Before GenericTest . Result is ==> " + found1); }
	            found1  = GenericTestScenarios(JSONObjectJavaInstance,p_SearchValue,p_TestNumber,p_TestDescription, p_debug  );
	            if (p_debug) { System.out.println(CallingMethod + "==> " + "After GenericTest . Result is ==> " + found1); }

	        } catch (IOException e) {
	            e.printStackTrace();
	        }  // End of Mapper try catch
		    

      } else {  
 		        System.out.println("The GET URL "
 		        		+ "call didnt return any results so not calling the test suite. Return 0(FALSE)");
      } // End of Http get connection

		    
    } catch (IOException e) {
        e.printStackTrace();
    }
	return found1;

 } // end of GenericGetJSONObjectdata function


	
	//***********************************************************************
	// Function    : GenericTestScenarios
	// Description : This is a generic funciton which will test and validate the test scenario.
	//               This is a generic function where in any new test case scenario can be added within the if else if condition.
	//               For every test executed If found then return 1(TRUE) else 0(FALSE).
	// Parameters  : 
    //	              a. JSONObjectJavaInstance -- JSON Object
	//                b. tp_SearchValue         -- the text to be searched in the JSON tag
	//                c. tp_TestNumber          -- The test number to beb called  ex : 1, 2,3,4,5
	//                d. tp_TestDescription     -- The description of the test. used to print in the report.
	//                e. tp_debug               -- debug flag needed if something breaks
	//Return        : return 1(TRUE)  if Success 
	//                       0(FALSE) if failure
	//***********************************************************************		
	public static <JSONObjectJavaInstance> int GenericTestScenarios(JSONObjectJavaInstance o, String tp_SearchValue, int tp_TestNumber, String tp_TestDescription, boolean tp_debug) throws IOException {	


        //***********************************************************************
        // Declaration of variables
        //***********************************************************************		
		int found = 0;
        int i = 0;
        
    //***********************************************************************
	// Print headers of the test cases . We put it here to skip the For loop
	//***********************************************************************
	System.out.println("\n\n**********************************************************************************");
	if (tp_TestNumber == 1) { 
		System.out.println("*****TestNumber " + tp_TestNumber + " Validation started \n" + "*****Description :" + tp_TestDescription); 
		System.out.println("**********************************************************************************");        	
		System.out.println("JSON Object ID \t JSON obj name    \t\tSearch Key    \t\t ==>      Test Progress \n --------------    --------------              ---------               -------------  " );      
	}
	
	
	
	if (tp_TestNumber == 2) { 
		System.out.println("*****TestNumber " + tp_TestNumber + " Validation started \n" + "*****Description :" + tp_TestDescription); 
		System.out.println("**********************************************************************************"); 
		System.out.println("JSON Object ID \t Search date \t\t\t JSON Date \t\t ==>  Test Progress \n --------------    --------------                  ---------             -------------  " );
	}

	
	
	if (tp_TestNumber == 3) { 
		System.out.println("*****TestNumber " + tp_TestNumber + " Validation started \n" + "*****Description :" + tp_TestDescription); 
		System.out.println("**********************************************************************************"); 
		System.out.println("JSON Object ID \t Search watchers_count \t JSON Watchers_count    ==>  Test Progress \n --------------    --------------          ---------         -------------  " );
	}
      
	
	
	if (tp_TestNumber == 4) { 
		System.out.println("*****TestNumber " + tp_TestNumber + " Validation started \n" + "*****Description :" + tp_TestDescription); 
		System.out.println("**********************************************************************************"); 
		System.out.println("JSON Object ID \t Name \t\t\tSearch Key \t\t Home page  \t ==>  Test Progress \n --------------  --------------        -------------           -----------------     -----------------  " );
	
	}

	
	
	if (tp_TestNumber == 5) { 
		System.out.println("*****TestNumber " + tp_TestNumber + " Validation started \n" + "*****Description :" + tp_TestDescription); 
		System.out.println("**********************************************************************************"); 
		System.out.println("JSON Object ID \t Name \t\t  Search Key \t  Open issues\t\t ==>  Test Progress \n --------------  --------------     ------------       ---------        -------------  " );
	
	}


	//***********************************************************************
	// The logic for each test case starts here.
	// Here we loop in only 28 times(this number can be changed in future if you want to cover more data)
	//   as we don't want to print the results of the whole test results from the Github object.
	// Using a for loop we loop through the results and validate our Git data result with the serach key.
	// If the Key is found then we return 1 else we return 0 to the calling function.
	// 
	//***********************************************************************        
	for (i=0; i < 29 ; i++)	{			

		if (tp_debug) { System.out.println("test parameter key  " + tp_SearchValue);}

	    //***********************************************************************
	    // The Logic to validate for every test scenario is here.
		// In future when a new test scenario has to be implemented then we just have to add 1 more elseif condition here.
		// We use the break statement to break the for loop when test is validated. 
		// Future performance Enhancements : Transform this to a Switch Case statement. Doing this now is causing a issue.
		//***********************************************************************
		
		// Test case 1
		if (tp_TestNumber == 1)   { 
					if   (((JSONObjectRootClass) o).getItems().get(i).getName().equals(tp_SearchValue)) { 
						if (tp_debug) {  System.out.println("print Total count in functions --> Loop("+ i + ")" + "found so breaking the loop"); }
						System.out.println(((JSONObjectRootClass) o).getItems().get(i).getRepository().getId() + "\t\t" +  StringUtils.rightPad(  ((JSONObjectRootClass) o).getItems().get(i).getName() ,25," ") + "==     "+  tp_SearchValue + "\t"+ "  ==>     SAME . BREAK");
						found = 1;
						 break;
				     } else {
						 System.out.println( ((JSONObjectRootClass) o).getItems().get(i).getRepository().getId() + "\t\t" +  StringUtils.rightPad( ((JSONObjectRootClass) o).getItems().get(i).getName(),25," ") + "==     "+  tp_SearchValue + "\t"+ "  ==>     NOT SAME , COUNTINUE");
				    	 found = 0;
				     }
				// Test case 2
	            }  else if ((tp_TestNumber == 2)) {  
	            	if (tp_debug) {  System.out.println("print Total count in functions --> Loop("+ i + ")"); }
	            	  ZonedDateTime zonedDateTime1  = ZonedDateTime.parse(tp_SearchValue);
	    		      ZonedDateTime zonedDateTime2  = ZonedDateTime.parse(((JSONObjectRootClass) o).getItems().get(i).getCreated_at());
		    		  if (zonedDateTime1.compareTo(zonedDateTime2) < 0 ) {
	                    System.out.println(((JSONObjectRootClass) o).getItems().get(i).getId() + "\t"+ zonedDateTime1 + " \t <     "+  zonedDateTime2 + "\t"+ "==> (Search Date <= JSON date) so CONTINUE");
	                      found = 1;
	                  } else {
	                	  System.out.println(((JSONObjectRootClass) o).getItems().get(i).getId() + "\t"+ zonedDateTime1 + " \t <     "+  zonedDateTime2 + "\t"+ "==> (Search Date > JSON date) so BREAK");
	                      found = 0;
	                	  break;
	                  } 

		    	// Test case 3
	            } else if  (tp_TestNumber == 3) { 
	            	    
	            	if ( (((JSONObjectRootClass) o).getItems().get(i).getWatchers_count()) >= ((JSONObjectRootClass) o).getItems().get(i+1).getWatchers_count())  {
	            		System.out.println(((JSONObjectRootClass) o).getItems().get(i).getId() + "\t\t" +  ((JSONObjectRootClass) o).getItems().get(i).getWatchers_count() + "\t\t\t" + ((JSONObjectRootClass) o).getItems().get(i+1).getWatchers_count() + "\t\t"+ "==> Descreasing Order , CONTINUE");
	            		found = 1;
	            	} else {
	            		System.out.println(((JSONObjectRootClass) o).getItems().get(i).getId() + "\t\t" +  ((JSONObjectRootClass) o).getItems().get(i).getWatchers_count() + "\t\t\t" + ((JSONObjectRootClass) o).getItems().get(i+1).getWatchers_count() + "\t\t"+ "==> Descreasing Order , BREAK ");
	            		found = 0;
	            		break;
	            	}
	            // Test case 4
	            } else if  (tp_TestNumber == 4) { 
	            	if (((JSONObjectRootClass) o).getItems().get(i).getHas_wiki() == tp_SearchValue) { 
						if (tp_debug) {  System.out.println("print Total count in functions --> Loop("+ i + ")" + "found so breaking the loop"); }
					    System.out.println(((JSONObjectRootClass) o).getItems().get(i).getId()  + "\t" +  StringUtils.rightPad( (((JSONObjectRootClass) o).getItems().get(i).getName() ),25," ") +   tp_SearchValue + " \t\t\t  " + ((JSONObjectRootClass) o).getItems().get(i).getHas_wiki() +  " \t ==> Set to false, BREAK");
						found = 1;
						break;
				     } else {
						 System.out.println(((JSONObjectRootClass) o).getItems().get(i).getId()  + "\t" +  StringUtils.rightPad(((JSONObjectRootClass) o).getItems().get(i).getName(),25," ") +   tp_SearchValue + " \t\t\t  " + ((JSONObjectRootClass) o).getItems().get(i).getHas_wiki() +  " \t\t ==> Set to true, CONTINUTE");
				    	 found = 0;
						 ;
				     }
	            // Test case 5
	            } else if  (tp_TestNumber == 5 ) {
	            	if (((JSONObjectRootClass) o).getItems().get(i).getOpen_issues() >=  Integer.valueOf(tp_SearchValue)) { 
						if (tp_debug) {  System.out.println("print Total count in functions --> Loop("+ i + ")" + "found so breaking the loop"); }
					    System.out.println(((JSONObjectRootClass) o).getItems().get(i).getId()  + "\t" +  StringUtils.rightPad( (((JSONObjectRootClass) o).getItems().get(i).getName() ),25," ")  + tp_SearchValue + " \t\t  " + ((JSONObjectRootClass) o).getItems().get(i).getOpen_issues() +  " \t\t ==> Open_issues > " + tp_SearchValue + " found , CONTINUE");
						found = 1;
				     } else {
						 System.out.println(((JSONObjectRootClass) o).getItems().get(i).getId()  + "\t" +  StringUtils.rightPad(((JSONObjectRootClass) o).getItems().get(i).getName(),25," ") +   tp_SearchValue + " \t\t  " + ((JSONObjectRootClass) o).getItems().get(i).getOpen_issues() +  " \t\t ==> Open_issues > " + tp_SearchValue + " not found , CONTINUE");
				     }		            	
	            	
	            } // End of If else if

	 }	//End of For loop
	System.out.println("**********************************************************************************");	
	
	return found;
    
	} // End of GenericTest method
} // End of Class


