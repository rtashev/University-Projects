<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lend details</title>

	<style>
		ul {
    		list-style-type: none;
    		margin: 0;
    		padding: 0;
    		overflow: hidden;
    		background-color: #333;
		}

		li {
    		float: left;
		}

	li a {
    		display: block;
    		color: white;
    		text-align: center;
   			padding: 14px 16px;
    		text-decoration: none;
		}
		
	li a:hover {
			color : black;
	}

	li a:hover {
    	background-color: white;
	}
	</style>
</head>
<body>

<ul>
	<li><font color="white" size="6px" ><b>Library</b></font></li>
	<li><a href="/library">Home</a></li>
	<li><a href="/library/booksRegistry">Books</a></li>
	<li><a href="/library/booksLentByMe">Books lent by me</a></li>
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<li><a href="/library/userRegistry">User Registry</a></li>
		</sec:authorize>
	<li style="float:right"><a class="active" href="/library/logout">Logout</a></li>
</ul>
	<h2>Book lend details</h2>
	
	<div>
		<fieldset>
		<legend><b>Book Details</b></legend>
			<form:form method="POST" action="/library/lendBookDetails/${bookId}/saveLend">
				<label><b>Book Name : </b></label> ${book.name} <br>
				<label><b>Book ISBN : </b></label> ${book.isbn} <br>			
				<label><b>Author : </b></label> ${book.author} <br>				
				<label><b>Date released : </b></label> ${book.dateReleased} <br>
				<label><b>Published by : </b></label> ${book.publishedBy} <br>
				<br>
				<label><b>Lend from : </b></label> ${currentDate}
				<label style="margin: 10px"><b>for :</b></label>
				 <select name="lendDays" id="lendDays">
					 <option value="10">10</option>
					 <option value="15">15</option>
					 <option value="25">25</option>
					 <option value="40">40</option>
				</select>
				<label style="margin: 10px"><b>Days</b></label>
				<br>
				<input type="submit" name="Lend" value="Lend">
			</form:form> 
		</fieldset>
	</div>
</body>
</html>