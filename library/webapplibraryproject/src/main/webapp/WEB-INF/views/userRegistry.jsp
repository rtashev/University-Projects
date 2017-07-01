<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
<title>User Registry</title>
    
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
        <h3>User Registry</h3>
        <div>
            <fieldset>
            <legend><b>Search user</b></legend>

                <form method="POST" action="/library/finduser">                    
                    <div class="input-group">
                        <span class="input-group-addon" id="sizing-addon2"><i class="glyphicon glyphicon-search"></i></span>
                        <input type="text" id="userSearchBar" name="userSearchBar" style="width:700px" class="form-control" placeholder="Username" aria-describedby="sizing-addon2">
                        <input name="submit" type="submit" style="margin-left:15px;" class="btn btn-primary" value="Search" />
                    </div>                    
                </form>

            </fieldset>
            
        <div class="panel panel-default">
        <div class="panel-heading" style="font-size:20px; text-align: center;">Search Results</div>
                <c:if test="${not empty user}">
                    <table class="table">
                        <thead>
                            <tr>                                
                                <td><b>name</b></td>
                                <td><b>enabled</b></td>
                                <td><b>role</b></td>
                            </tr>
                        </thead>
                            <tbody>
                            <c:forEach var="user" items="${user}">
                                <tr>                                    
                                    <td>${user.name}</td>                                    
                                    <td>${user.enabled}</td>
                                    <td>${user.role}</td>

                                    <td>
                                        <form:form method="POST" action="/library/changeUserRole/${user.userId}" modelAttibute="user">
                                            <button type=submit class="btn btn-info" id="btn1" name="Change user role" value="Change user role"><i class="glyphicon glyphicon-refresh"></i> Change user role</button> 
                                        </form:form> 
                                    </td>
                                    <td>
                                        <form:form method="POST" action="/library/changeUserStatus/${user.userId}" modelAttibute="user">
                                            <button type=submit class="btn btn-danger" id="btn1" name="Activate/Deactive user" value="Activate/Deactive user"><i class="glyphicon glyphicon-ban-circle"></i> Activate/Deactivate user</button>
                                        </form:form> 
                                    </td>
                                    <td><a href="/library/booksLentByUser/${user.userId}" class="btn btn-primary"><i class="glyphicon glyphicon-user"></i>Books lent by ${user.name}</a></td>
                                </tr>		            		
                            </c:forEach>
                        </tbody>
                    </table>
                </c:if>
            </div>
        </div>
    </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"
			integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
			crossorigin="anonymous"></script>
    
</body>
</html>