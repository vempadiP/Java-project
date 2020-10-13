//***********************************************************************
// Revision History
// Class      : JSONObjectRootClass
// Date       : 01/05/2020
// Name       : Padmavathi Vempadi
// Description: The definition of this Java class  is created to hold/represent the structure of an JSON object.
//              We are only doing 3 level deep as of now.
//              Future enhancements : we can define any level depending on the complexity of the JSON object.
// Parameters : N/A
//***********************************************************************

package demoFnl;

import java.util.List;


public class JSONObjectRootClass {

	private int total_count;                       // stores the total count of the JSON API call 
	private boolean incomplete_results;            // describes the API result set
	private List<JSONObjectRootLevel1Class> items; // list to store the structure of the Items
	
	public int getTotal_count() {
		return total_count;
	}

	public void setTotal_count(int total_count) {
		this.total_count = total_count;
	}

	public boolean isIncomplete_results() {
		return incomplete_results;
	}

	public void setIncomplete_results(boolean incomplete_results) {
		this.incomplete_results = incomplete_results;
	}

	public List<JSONObjectRootLevel1Class> getItems() {
		return items;
	}

	public void setItems(List<JSONObjectRootLevel1Class> items) {
		this.items = items;
	}


	
		
	
	
}
