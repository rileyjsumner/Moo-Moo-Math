<%@page import = "Questions.Converter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
    <head>
        <title>Home</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel = "stylesheet" href = "main.css">
        <script src = "https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src = "http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    </head>
    <body>
        <script>
            function toGrade(grade){
                document.location.href = 'UserController?action=viewLessons&grade='+grade;
            }
        </script>
        <div class = "jumbotron">
            <div class = "text-right">
                <div class = "col-xs-pull-1">
                    <div class = "dropdown">
                        <button class = "btn btn-default dropdown-toggle" type = "button" data-toggle = "dropdown" style = "background-color:#FFDAB9; border: 4px solid #E7C6A5"> Options
                        <span class = "caret"></span></button>
                        <ul class = "dropdown-menu pull-right">
                            <li><a href = "Login.jsp">Log In</a></li>
                            <li><a href = "Profile.jsp">Profile</a></li>
                            <li class = "divider"></li>
                            <li><a href = "#">Log Out</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class = "text-center">
                <h1>Oh Dang Studios! Math</h1>
            </div>
        </div>
        <c:choose>
            <c:when test="${not empty buttons}">
                ${buttons.GetData()}
            </c:when>
            <c:otherwise>
                <c:redirect url="UserController?action=Home"/>
            </c:otherwise>
        </c:choose>
        <c:choose>
            <c:when test="${not empty data}">
                ${data.GetData()}
            </c:when>
            <c:otherwise>
                <c:redirect url="UserController?action=Home"/>
            </c:otherwise>
        </c:choose>
    </body>
</html>