<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>

<html>  
<head>
	<title>Home</title>
	
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
        i {
            margin-right: 5px;
        }
        h3{
            font-family: "Lucida Sans Unicode", "Lucida Grande", sans-serif;
        }
    </style>
    
</head>
<body>
    
    <div id="main" class="container">
        <h2><i class="glyphicon glyphicon-book"></i>Library</h2>
        <ul class="nav nav-tabs">
            
            <li role="presentation" class="active"><a href="/library">Home</a></li>
            <li role="presentation"><a href="/library/booksRegistry">Books</a></li>
            <li role="presentation"><a href="/library/booksLentByMe">Books lent by <b>ME</b></a></li>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <li role="presentation"><a href="/library/userRegistry">User Registry</a></li>
            </sec:authorize>    
            <li role="presentation" style="float:right"><a href="/library/logout">Logout</a></li>
        </ul>
    </div>
    
    <div id="main" class="container">
        <div class="jumbotron">
        <h2>Hello, ${username} !</h2>
            <div>
               <p>
                       Welcome to the library! Here you can search &amp; lend your favourite books for a certain time.
               </p>
            </div>
        </div>
        
        <div>
            <p>
                <h3>&#8226; News</h3>
            <p>     Lorem ipsum dolor sit amet, vide nominati ei usu, in pri quem ipsum principes, semper nostrud vituperata eam cu. Ut sit accusata invenire indoctum, no petentium imperdiet interpretaris est, adhuc semper      disputando an vis. No vel idque dolorem. Nam ut tale consequuntur. Ne choro doctus theophrastus cum, brute mediocritatem ad pri. Ad nobis omittam invidunt ius, cu vix ignota meliore, dicam expetendis ne est. An homero qualisque conceptam ius. Ferri facer mea cu, denique partiendo in quo. Albucius scriptorem eum ut, ea aliquam persequeris vel. Congue evertitur scriptorem ei usu. Usu etiam complectitur id, no his congue diceret interesset, mel natum persequeris ei. Est at fastidii accumsan, quot rebum deseruisse cum in, facer fabulas quo ex. Ne mea duis malis dolor. Ad quo dictas ponderum. Pro et eius labore nominati, laoreet facilisi cotidieque ad mei. Ius vide quidam denique ad, has ex doming epicuri deserunt. Vero essent nam cu, te mel ferri labitur. Officiis tacimates ei duo, has euismod utroque reformidans ut. Feugait epicurei at ius, unum scripserit et cum. Te quod persius eripuit quo, ne vel probo labitur suscipit. Atqui tollit nec ex, ipsum repudiandae per ne.
                </p>
            <p style="margin-bottom: 50px;">
                Pro stet augue ornatus et. Et pro impedit volumus constituam. Timeam commodo numquam et his. Graeci phaedrum theophrastus ne duo, no mea impetus complectitur, vis ad hinc dicunt virtute. Qui choro eripuit an, summo nulla iisque ea vis, sed velit senserit consulatu ne. Ius erant docendi deterruisset te.
                Intellegat appellantur ut qui, alii deleniti voluptua et duo. Voluptatum honestatis ius ex, vis partem invidunt reprimique et. Te falli cotidieque has, vis veri interesset ex. Usu tibique nominati molestiae ei, eam fastidii philosophia cu, cum possim discere an. Mea veniam consectetuer no, ex possit conclusionemque vis. Eam wisi putent at, meis ancillae postulant eam in. Eum utroque splendide te.
            </p>
            </p>
        </div>
    </div>
    
    
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"
			integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
			crossorigin="anonymous"></script>
</body>
</html>

