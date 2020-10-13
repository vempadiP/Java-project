//***********************************************************************
// Revision History
// Class      : JSONObjectRootLevel1Class
// Date       : 01/05/2020
// Name       : Padmavathi Vempadi
// Description: The definition of this Java class  is created to hold/represent the level 1 structure Items of an JSON object.
// Parameters : N/A
//***********************************************************************

package demoFnl;



public class JSONObjectRootLevel1Class {
	

	private int id;
	private String name;       
	private String path;	
	private String created_at;
	private int watchers_count;
	private JSONObjectRootLevel2Class repository;
    private String has_wiki;
    private int open_issues;		

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public int getWatchers_count() {
		return watchers_count;
	}
	public void setWatchers_count(int watchers_count) {
		this.watchers_count = watchers_count;
	}
	public JSONObjectRootLevel2Class getRepository() {
		return repository;
	}
	public void setRepository(JSONObjectRootLevel2Class repository) {
		this.repository = repository;
	}
	public String getHas_wiki() {
		return has_wiki;
	}
	public void setHas_wiki(String has_wiki) {
		this.has_wiki = has_wiki;
	}
	public int getOpen_issues() {
		return open_issues;
	}
	public void setOpen_issues(int open_issues) {
		this.open_issues = open_issues;
	}

    
	

}
