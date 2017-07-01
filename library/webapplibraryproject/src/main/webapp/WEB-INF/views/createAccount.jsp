<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    
    <title>Create Account</title>
    
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
        }
        #name, #password, #confirmPassword{
            width: 40%;
        }
        
        #btn1{
            margin-bottom: 40px;
            margin-top: 10px;
        }
        
    </style>
    
</head>
    
<body>
    <div id="main" class="container">
        <ul class="nav nav-tabs">
          <li><h1>Create Account</h1></li>
        </ul>
    </div>
    
    <div id="main" class="container">	
    <h3>Account information</h3>
		<form:form method="POST" action="/library/createAccount" modelAttibute="user">
			<div class="form-group">
                  <label for ="name">Username</label>
                <input id="name" name="name" class="form-control" type="text"/>
            </div>
            <div class="form-group">
                <label for ="password">Password</label>
                <input id="password" name="password" class="form-control" type="password" />
            </div>
            <div class="form-group">
                <label for="confirmPassword">Confirm Password</label>
                <input id="confirmPassword" type="password" name="confirmPassword" class="form-control" type="password"/>
            </div>

			<c:if test="${passwordsDontMatch == true}">
				<font color="red">Passwords dont match</font>
				<br>
				<p>	
			</c:if>
 
			
            <input type=submit id="btn1" class="btn btn-primary" name="Submit"/>
		</form:form>
	</div>
    
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"
			integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
			crossorigin="anonymous"></script>
    
</body>
</html>