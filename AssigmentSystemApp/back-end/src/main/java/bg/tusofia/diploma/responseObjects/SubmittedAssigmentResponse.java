package bg.tusofia.diploma.responseObjects;

public class SubmittedAssigmentResponse {
	
	private Integer id;
	private String name;
	private String category;
	private String student_first_name;
	private String student_last_name;
	private String date_submitted;
	
	public SubmittedAssigmentResponse(){
		
	}

	public SubmittedAssigmentResponse(Integer id, String name, String category, String student_first_name,
			String student_last_name, String date_submitted) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.student_first_name = student_first_name;
		this.student_last_name = student_last_name;
		this.date_submitted = date_submitted;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getStudent_first_name() {
		return student_first_name;
	}

	public void setStudent_first_name(String student_first_name) {
		this.student_first_name = student_first_name;
	}

	public String getStudent_last_name() {
		return student_last_name;
	}

	public void setStudent_last_name(String student_last_name) {
		this.student_last_name = student_last_name;
	}

	public String getDate_submitted() {
		return date_submitted;
	}

	public void setDate_submitted(String date_submitted) {
		this.date_submitted = date_submitted;
	}
	
	
	
}
