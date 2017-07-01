<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
    
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
        .custom{
            margin-top: 50px;
        }
        
        #submitBtn{
            margin-top: 10px;
            margin-bottom: 20px;
        }
            
        #username, #password{
            width: 40%;
        }
        
        h3{
            font-family: "Lucida Sans Unicode", "Lucida Grande", sans-serif;
        }
        
        .new-acc-reg{
            margin-top: 40px;
            margin-bottom: 40px;
        }
        
        #new-acc-reg-p{
            font-size: 20px;
        }
        
    </style> 
    
</head>
<body>
    <div id="main" class="container">
        <ul class="nav nav-tabs">
          <li><h1>Library Login Page</h1></li>
        </ul>
    </div>
    
    <div id="main" class="container">

        
        <div class="custom">
            <h3>Login credentials</h3>
            <form name="login" action="/library/login" method="POST">
                <div class="form-group">
                    <label for ="username">Username</label>
                    <input id="username" name="username" class="form-control" type="text"/>
                </div>
                <div class="form-group">
                    <label for ="password">Password</label>
                    <input id="password" name="password" class="form-control" type="password" />
                </div>
                <input id="submitBtn" name="submit" type="submit" value="Login" />
    
            </form>

        </div>

        <div class="new-acc-reg">
            <p id="new-acc-reg-p">No account ? No problem</p>
            
                 <button type="button" class="btn btn-primary" onclick="location = '/library/createAccount'">Create Account</button>
            
            <!--          
<button type="button" onclick="location = '/library/createAccount'">Create Account</button>		-->
        </div>

     
    </div>   
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"
			integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
			crossorigin="anonymous"></script>
    
</body>
</html>