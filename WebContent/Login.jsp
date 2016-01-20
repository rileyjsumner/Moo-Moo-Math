<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
        <link type="text/css" href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
        <link rel = "stylesheet" href = "main.css">
        <script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
        <script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
        <title>Log in</title>
    </head>
    <body>
        <div class = "nav">
            <div class = "jumbotron">
                <div class = "text-center">
                    <h1>Sniper Team Dango Math</h1>
                    <p>First Grade Math</p>
                </div>
            </div>
            <div class = "content">
                <div class = "text-center">
                    <div class = "row">
                        <div class = "col-md-12">
                            <p></p>
                            <input type = "button" style = "background-color:#FFDAB9; border: 4px solid #E7C6A5" onclick = "document.location.href = 'Home.jsp'" value = "Home"/>
                            <input type = "button" style = "background-color:#FF0000; border: 4px solid #E00000" onclick = "document.location.href = 'firstgrade.html'" value = "1st Grade"/>
                            <input type = "button" style = "background-color:#FF7400; border: 4px solid #E06600" onclick = "document.location.href = 'secondgrade.html'" value = "2nd Grade"/>
                            <input type = "button" style = "background-color:#FFAA00; border: 4px solid #E09600" onclick = "document.location.href = 'thirdgrade.html'" value = "3rd Grade"/>
                            <input type = "button" style = "background-color:#00DD00; border: 4px solid #00B300" onclick = "document.location.href = 'fourthgrade.html'" value = "4th Grade"/>
                            <input type = "button" style = "background-color:#00BCBC; border: 4px solid #008787" onclick = "document.location.href = 'fifthgrade.html'" value = "5th Grade"/>
                            <input type = "button" style = "background-color:#FFDAB9; border: 4px solid #E7C6A5" onclick = "document.location.href = 'Profile.jsp'" value = "Profile"/>
                            <p></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <form style="font-family:Verdana, sans-serif" method=post action="j_security_check">
        <table>
                <tr>
                        <td colspan="2">Login</td>
                </tr>
                <tr>
                        <td colspan="2">Name</td>
                        <td><p>     </p></td>
                        <td><input type="text" name="j_username" /></td>
                </tr>
                <tr>
                        <td colspan="2">Password</td>
                        <td><p>     </p></td>
                        <td><input type="password" name="j_password" ></td>
                </tr>
                <tr>
                        <td colspan="2"><input type="submit" value="Go" />
                            <td><p> </p></td>
                        <input type="reset" value="Reset"></td>
                </tr>
        </table>
        </form>
        <!--<form method="POST" action="UserController?action=LoginForm" name="UserController">
            User name : <input
                type="text" name="User name"
                value="${Username}" /> <br /> 
            Password : <input
                type="text" name="password"
                value="${Password}" /> <br />
            <input type="submit" value="Submit" />
        </form>
        <h1> </h1>
        <button type="button" onclick="document.location.href = 'CreateAccount.jsp';">Create Account</button> -->
    </body>
</html>