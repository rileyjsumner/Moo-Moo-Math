<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="Post" action='UserController' name="CreateAccount">
        User name : <input
            type="text" name="User name"
            value="${NewUser.Username}" /> <br /> 
        Password : <input
            type="text" name="Password"
            value="${NewUser.Password}" /> <br />
        Verify Password : <input
            type="text" name="Verify Password"
            value="${NewUser.PasswordV}" /> <br />
        <input type="submit" value="Submit" />
    </form>
</body>
</html>