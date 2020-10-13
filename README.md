# Java-project
GitHub Connect API Project
Purpose
This project is to design an automated Framework which will connect to the end point source API bundles in the GitHub Gateway Repository. So from the Java program needs to connect to the endpoint GitHub API’s repository without using Rest Assured in Java.  The client GitHub API Bundles supports (querying based on a series of keywords and qualifiers) , Ordering and Sorting. The program interface has to test the different scenarios of test conditions based on the API Bundles output.
•	User will run the Test cases in Junit5 framework/ Jenkins.
•	Within Eclipse, internally Junit tests are connected to Maven Project through which Java programs are fired. The Java program connects to the GitHub API via HTTP.
•	Test results are captured via Surefire report plugin and are stored in test run repository.
•	The API response is captured and test cases are executed to validate the test scenario.

•	Junit5 - Through this framework Test1.java program all test cases are executed, which is a plugin of JDK 14 integrated in Maven project in Eclipse IDE.
•	Eclipse
1.	Main Class – JSONGenericTestSetup.java: All test data needed for the Test cases are built and individual Test cases are called.(handy enough for a tester to play with test data)
2.	Main Methods class – JSONGenericTestSetupMethods.java:  This class contains logic to call GitHub API’s and validate the test scenarios.
3.	Structure or POZO classes – JSONObjectRootClass.java consists of 2 sublevel objects JSONObjectRootLelve1Class and JSONObjectRootLelve2Class.
4.	These classes are used to represent the structure of the GitHub API result.
