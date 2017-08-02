package bg.tusofia.diploma.requestObjects;

public class NewAssigmentRequest {
	
	private String assigmentTitle;
	private String assigmentTopic;
	private String assigmentDescr;
	
	public NewAssigmentRequest(){
		
	}
	
	public NewAssigmentRequest(String assigmentTitle, String assigmentTopic, String assigmentDescr) {
		this.assigmentTitle = assigmentTitle;
		this.assigmentTopic = assigmentTopic;
		this.assigmentDescr = assigmentDescr;
	}

	public String getAssigmentTitle() {
		return assigmentTitle;
	}
	public void setAssigmentTitle(String assigmentTitle) {
		this.assigmentTitle = assigmentTitle;
	}
	public String getAssigmentTopic() {
		return assigmentTopic;
	}
	public void setAssigmentTopic(String assigmentTopic) {
		this.assigmentTopic = assigmentTopic;
	}
	public String getAssigmentDescr() {
		return assigmentDescr;
	}
	public void setAssigmentDescr(String assigmentDescr) {
		this.assigmentDescr = assigmentDescr;
	}
	
	

}
