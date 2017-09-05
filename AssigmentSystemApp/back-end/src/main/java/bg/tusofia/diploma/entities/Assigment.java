package bg.tusofia.diploma.entities;

import java.sql.Blob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "assigments")
public class Assigment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="assigment_id")
	private Integer assigmentId;
	
	@Column(name="name")
	@NotNull
	private String name;
	
	@Column(name="category")
	@NotNull
	private String category;
	
	@Column(name="description")
	@NotNull
	private String description;
	
	@Column(name="is_assigned")
	@NotNull
	private Boolean isAssigned;
	
	@Column(name="is_submitted")
	@NotNull
	private Boolean isSubmitted;
	
	@Column(name="date_submitted")
	@Temporal(TemporalType.DATE)
	private Date dateSubmitted;
	
	@Column(name="pdf")
	@Lob
	private Blob pdf;
	
	@JoinColumn(name = "user_id", unique = true)
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
