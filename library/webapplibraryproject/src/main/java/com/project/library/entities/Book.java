package com.project.library.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "BOOKS")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BOOK_ID", unique = true)
	private Long bookId;
	
	@Column(name = "NAME", nullable = false)
	private String name;
	
	@Column(name = "ISBN" , nullable = false)
	private String isbn;
	
	@Column(name = "AUTHOR", nullable = false)
	private String author;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "DATE_RELEASED", nullable = false)
    private Date dateReleased;
	
	@Column(name = "PUBLISHED_BY", nullable = false)
	private String publishedBy;
	
	@OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<BooksLent> booksLentByUser;

	public List<BooksLent> getBooksLentByUser() {
		return booksLentByUser;
	}

	public void setBooksLentByUser(List<BooksLent> booksLentByUser) {
		this.booksLentByUser = booksLentByUser;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getdateReleased() {
		return dateReleased;
	}

	public void setdateReleased(Date dateReleased) {
		this.dateReleased = dateReleased;
	}

	public String getPublishedBy() {
		return publishedBy;
	}

	public void setPublishedBy(String publishedBy) {
		this.publishedBy = publishedBy;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", name=" + name + ", isbn=" + isbn + ", author=" + author + ", dateReleased="
				+ dateReleased + ", publishedBy=" + publishedBy + ", booksLentByUser=" + booksLentByUser + "]";
	}
	
}
