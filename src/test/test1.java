package demoFnl;

//***********************************************************************
//Revision History
//Class      : Test1
//Date       : 01/05/2020
//Name       : Padmavathi Vempadi
//Description: This is the main framework JUnit class which will call all the 5 test cases.
//           Any new test cases can be added easily below
//Parameters : N/A
//***********************************************************************


import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.IOException;
import org.junit.jupiter.api.Test;
//import demoFnl.JSONGenericTestSetup;



/*import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FirstTest {

 @Test
 public void testTrue() {
     System.out.println("Executing testTrue()");
     assertTrue(true);     
  }
}
*/
class Test1 {


	@Test
	void TestCase1() throws IOException {
		
		int Test = 1;
		JSONGenericTestSetup t = new JSONGenericTestSetup();
		int output = t.ExecuteTest1(Test);
		assertEquals(1, output);
	}
	

	@Test
	void TestCase2() throws IOException {
		
		int Test = 2;
		JSONGenericTestSetup t = new JSONGenericTestSetup();
		int output = t.ExecuteTest2(Test);
		assertEquals(1, output);
	}	

	
	
	@Test
	void TestCase3() throws IOException {
		
		int Test = 3;
		JSONGenericTestSetup t = new JSONGenericTestSetup();
		int output = t.ExecuteTest3(Test);
		assertEquals(1, output);
	}		



	@Test
	void TestCase4() throws IOException {
		
		int Test = 4;
		JSONGenericTestSetup t = new JSONGenericTestSetup();
		int output = t.ExecuteTest4(Test);
		assertEquals(1, output);
	}		

	@Test
	void TestCase5() throws IOException {
		
		int Test = 5;
		JSONGenericTestSetup t = new JSONGenericTestSetup();
		int output = t.ExecuteTest5(Test);
		assertEquals(1, output);
	}	
	
	
}
