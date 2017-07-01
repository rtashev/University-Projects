<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Book Registry</title>

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
            <li role="presentation"><a href="/library/booksLentByMe">Books lent by <b>ME</b></a></li>
<!--            <sec:authorize access="hasRole('ROLE_ADMIN')">-->
                <li role="presentation"><a href="/library/userRegistry">User Registry</a></li>
<!--            </sec:authorize>    -->
            <li role="presentation" style="float:right"><a href="/library/logout">Logout</a></li>
        </ul>
    </div>

    <div id="main" class="container">
	<h3>Books Registry</h3>
	
	<div>
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<p><button type="button" style="margin-bottom: 15px;" class="btn btn-primary" onclick="location = '/library/addBook'">Add a new Book</button><p>
		</sec:authorize>
	</div>
	
	<div>
		<fieldset>
	    <legend><b>Search</b></legend>
		
			<form method="POST" action="/library/bookSearch">
				<label><b>Search by :</b></label>
				<input style="margin: 15px" type="radio" name="searchBookBy" value="name" checked>Name
			  	<input style="margin: 15px" type="radio" name="searchBookBy" value="isbn">ISBN
	  			<input style="margin: 15px" type="radio" name="searchBookBy" value="author">Author
	  			<br>
				<div class="input-group">
                    <span class="input-group-addon" id="sizing-addon2"><i class="glyphicon glyphicon-search"></i></span>
                    <input type="text" id="bookSearchBar" name="bookSearchBar" style="width:700px" class="form-control" placeholder="Search" aria-describedby="sizing-addon2">
                    <input name="submit" type="submit" style="margin-left:15px;" class="btn btn-primary" value="Search" />
                </div>                
			</form>
	
		</fieldset>
	</div>
	<p>
	<div class="panel panel-default">
        <div class="panel-heading" style="font-size:20px; text-align: center;">Search Results</div>
		<c:if test="${not empty book}">
			<table class="table">
				<thead>
					<tr>						
						<td><b>Name</b></td>
						<td><b>ISBN</b></td>
						<td><b>Author</b></td>
						<td><b>Date Released</b></td>
						<td><b>Published By</b></td>
					</tr>
				</thead>
		        <tbody>
		            <c:forEach var="book" items="${book}">
		            	<tr>			                
			                <td>${book.name}</td>
			                <td>${book.isbn}</td>
			                <td>${book.author}</td>
			                <td>${book.dateReleased}</td>
			                <td>${book.publishedBy}</td>
			                <sec:authorize access="hasRole('ROLE_ADMIN')">
                                <td><a href="/library/editBook/${book.bookId}" class="btn btn-warning"><i class="glyphicon glyphicon-edit"></i>Edit</a></td>
<!--			               		<td><a href="<c:url value="/editBook/${book.bookId}"/>">Edit </a></td>    -->
                                <td>
                                    <form:form method="POST" action="/library/deleteBook/${book.bookId}" modelAttibute="book">
                                        <button type=submit class="btn btn-danger" id="btn1" name="Delete" value=" Delete "><i class="glyphicon glyphicon-trash"></i> Delete</button>
                                    </form:form> 
                                </td>
<!--			               	    <%-- <td><a href="<c:url value="/deleteBook/${book.bookId}"/> ">Delete</a></td>  --%>-->
			               	</sec:authorize>
			               	<td>
                                <form:form action="/library/lendBookDetails/${book.bookId}">
                                    <button type=submit class="btn btn-success" id="btn2" name="lend" value=" Lend Book "><i class="glyphicon glyphicon-ok-circle"></i> Lend Book</button>
                                </form:form>
                            </td>
		            	</tr>		            		
			        </c:forEach>
		        </tbody>
			</table>
		</c:if>
	</div>
    </div>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"
			integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
			crossorigin="anonymous"></script>

</body>
</html>