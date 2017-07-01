<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Books lent by user</title>
    
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
            <li role="presentation" ><a href="/library/booksRegistry">Books</a></li>
            <li role="presentation" ><a href="/library/booksLentByMe">Books lent by <b>ME</b></a></li>
            <!--            <sec:authorize access="hasRole('ROLE_ADMIN')">-->
            <li role="presentation" class="active"><a href="/library/userRegistry">User Registry</a></li>
            <!--            </sec:authorize>    -->
            <li role="presentation" style="float:right"><a href="/library/logout">Logout</a></li>
        </ul>
    </div>
    <div id="main" class="container">
        <h3>Books lent by user</h3>

        <c:if test="${not empty lentInfo}">
            <c:forEach var="lentInfo" items="${lentInfo}">
                <div class="panel panel-default">
                  <div class="panel-heading">
                    <h3 class="panel-title">Info about ${lentInfo.book.name}</h3>
                  </div>
                  <div class="panel-body">
                    <label><b>Book Name : </b></label> ${lentInfo.book.name} <br>
                    <label><b>Author : </b></label> ${lentInfo.book.author} <br>
                    <label><b>Date released : </b></label> ${lentInfo.book.dateReleased} <br>
                    <label><b>Published by : </b></label> ${lentInfo.book.publishedBy} <br>	<br>

                    <label><b>Lent from :</b></label> ${lentInfo.lentFrom}<br>
                    <label><b>Lent until :</b></label> ${lentInfo.lentUntil}<br> <br>
                    <form:form method="POST" action="/library/booksLentByUser/${lentInfo.user.userId}/returned/${lentInfo.book.bookId}" modelAttribute="lentInfo">
                        <button type=submit class="btn btn-primary" id="btn1" name="Book Returned" value="Book Returned"> Book Returned </button>
                    </form:form>
                    </div>                    
                </div>
            </c:forEach>
        <br>
        </c:if>
    </div>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"
			integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
			crossorigin="anonymous"></script>
</body>
</html>