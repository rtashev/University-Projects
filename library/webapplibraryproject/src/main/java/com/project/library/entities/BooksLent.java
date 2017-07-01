package com.project.library.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "BOOKS_LENT")
public class BooksLent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LENT_ID", unique = true)
	private Long lentId;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_ID", unique = true, referencedColumnName = "user_id")
	private User user;
	
	@ManyToOne(optional = false,  fetch = FetchType.EAGER)
	@JoinColumn(name = "BOOK_ID", unique = true, referencedColumnName = "book_id")
	private Book book;
	

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "LENT_FROM", nullable = false)
    private Date lentFrom;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "LENT_UNTIL", nullable = false)
    private Date lentUntil;
	
	@Column(name = "BOOK_RETURNED", nullable = false)
	private boolean bookReturned;
	
	public Long getLentId() {
		return lentId;
	}
	
	public void setLentId(Long lentId) {
		this.lentId = lentId;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public Book getBook() {
		return book;
	}
	
	public void setBook(Book book) {
		this.book = book;
	}
	
	public Date getLentFrom() {
		return lentFrom;
	}
	
	public void setLentFrom(Date lentFrom) {
		this.lentFrom = lentFrom;
	}
	
	public Date getLentUntil() {
		return lentUntil;
	}
	
	public void setLentUntil(Date lentUntil) {
		this.lentUntil = lentUntil;
	}
	
	public boolean isBookReturned() {
		return bookReturned;
	}
	
	public void setBookReturned(boolean bookReturned) {
		this.bookReturned = bookReturned;
	}

	@Override
	public String toString() {
		return "BooksLent [lentId=" + lentId + ", user=" + user + ", book=" + book + ", lentFrom=" + lentFrom
				+ ", lentUntil=" + lentUntil + ", bookReturned=" + bookReturned + "]";
	}
	
	
}

