<%-- 
    Document   : index
    Created on : Jan 2, 2017, 5:18:18 PM
    Author     : Emil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Info</title>
        <link type="text/css" rel="stylesheet" href="style.css"/>
        <style>
            body {
                background: url(images/bg.jpg);
            }
        </style>   
    </head>
    <body>

        <div class="user-info">
            <form action="servlet/Login">
                Name:<input type="text" name="name"/><br/>
                Password:<input type="password" name="pass"/><br/>
                <input type="submit" value="login"/>
            </form>

            
        </div>    
    </body>
</html>
