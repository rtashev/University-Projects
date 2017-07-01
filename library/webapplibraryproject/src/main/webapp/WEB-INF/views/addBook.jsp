<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Book</title>
	
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    
    <style>
    html, body {
            height:100%;
        } 
        body {
            background-color: white;
            background-image: url('https://images5.alphacoders.com/389/389872.jpg');
            background-size:  100%;
            background-repeat: no-repeat;
                
        }
        #main{
            background-color: #f2f2f2;
        }
        h3{
            font-family: "Lucida Sans Unicode", "Lucida Grande", sans-serif;
            margin-top: 40px;
            margin-bottom: 20px;
        }
        i {
            margin-right: 5px;
        }        
    </style>
    
</head>
<body>

<div id="main" class="container">
    <h2><i class="glyphicon glyphicon-book"></i>Library</h2>
            <ul class="nav nav-tabs">
            <li role="presentation" ><a href="/library">Home</a></li>
            <li role="presentation" class="active"><a href="/library/booksRegistry">Books</a></li>
            <li role="presentation" ><a href="/library/booksLentByMe">Books lent by <b>ME</b></a></li>
            <!--            <sec:authorize access="hasRole('ROLE_ADMIN')">-->
            <li role="presentation"><a href="/library/userRegistry">User Registry</a></li>
            <!--            </sec:authorize>    -->
            <li role="presentation" style="float:right"><a href="/library/logout">Logout</a></li>
        </ul>
    </div>
    <div id="main" class="container">
	<h3>Add Book</h3>
	
	<p> 
	<fieldset>
    <legend><b>Book information </b></legend>
		<form:form method="POST" action="/library/addBookSave" modelAttibute="book">
			<p>
			<label for ="name">Name</label>
			<input type="text" name="name" />
			<br>
			<p>
			<label for ="isbn">ISBN</label>
			<input type="text" name="isbn"/>
			<br>
			<p>
			<label for ="author">Author</label>
			<input type="text" name="author"/>
			<br>
			<p>
			<label for ="dateReleased">Date released</label>
			<input type="text" name="dateReleased" value = "<fmt:formatDate value ="${book.dateReleased}" pattern="yyyy-MM-dd" />"/>
			<br><font size="2" face="Courier" color="gray">Input format : <b>(YYYY-MM-DD)</b></font> 
			<br>
			<p>
			<label for ="publishedBy">Published by</label>
			<input type="text" name="publishedBy" />
			<br>
			<p>
			<input type=submit class="btn btn-primary" id="btn1" name="Submit"/>
		</form:form>
	</fieldset>
	</div>	
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"
			integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
			crossorigin="anonymous"></script>
</body>
</html>