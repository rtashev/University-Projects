package bg.tusofia.diploma.entities;

import java.sql.Blob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "assigments")
public class Assigment {
	
	private Integer assigmentId;
	private String name;
	private String category;
	private String description;
	private Boolean isAssigned;
	private Boolean isSubmitted;
	private Date dateSubmitted;
	@Column(name="pdf")
	@Lob
	private Blob pdf;
	@OneToOne
	private User user;
	
	public Assigment(){
		
	}
	
	public Assigment(Integer assigmentId, String name, String category, String description, Boolean isAssigned,
			Boolean isSubmitted, Date dateSubmitted, Blob pdf) {
		this.assigmentId = assigmentId;
		this.name = name;
		this.category = category;
		this.description = description;
		this.isAssigned = isAssigned;
		this.isSubmitted = isSubmitted;
		this.dateSubmitted = dateSubmitted;
		this.pdf = pdf;
	}
	
	public Integer getAssigmentId() {
		return assigmentId;
	}
	
	public void setAssigmentId(Integer assigmentId) {
		this.assigmentId = assigmentId;
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
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Boolean getIsAssigned() {
		return isAssigned;
	}
	
	public void setIsAssigned(Boolean isAssigned) {
		this.isAssigned = isAssigned;
	}
	
	public Boolean getIsSubmitted() {
		return isSubmitted;
	}
	public void setIsSubmitted(Boolean isSubmitted) {
		this.isSubmitted = isSubmitted;
	}
	
	public Date getDateSubmitted() {
		return dateSubmitted;
	}
	
	public void setDateSubmitted(Date dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}
	
	public Blob getPdf() {
		return pdf;
	}
	
	public void setPdf(Blob pdf) {
		this.pdf = pdf;
	}

}
