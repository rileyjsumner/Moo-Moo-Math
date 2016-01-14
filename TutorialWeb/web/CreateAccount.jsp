<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link type="text/css"
    href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
<title>Create Account</title>
</head>
<body>
<script>
function validateForm(){
	var x = document.forms["SignIn"];
    if (x["First Name"].value == null || x["First Name"].value == "") {
        alert("First name must be filled out");
        return false;
    }
    if (x["Last Name"].value == null || x["Last Name"].value == "") {
    	alert("Last name must be filled out");
        return false;
    }
    if (x["User Name"].value == null || x["User Name"].value == "") {
    	alert("User name must be filled out");
        return false;
    }
    if (x["Password"].value == null || x["Password"].value == "") {
    	alert("Password must be filled out");
        return false;
    }
    if (x["Verify Password"].value == null || x["Verify Password"].value == "") {
    	alert("Password verification must be filled out");
        return false;
    }
    if (x["Verify Password"].value != x["Password"].value) {
    	alert("Passwords do not match");
        return false;
    }
    return true;
}
</script>
<form id = "SignIn" onsubmit="return validateForm()" method="POST" action='UserController?action=CreateAccount' name="SignIn">
		First name<font color="red">*</font> <input
            type="text" name="First Name"
            value="${NewUser.Username}" /> <br /> 
        Last name<font color="red">*</font> <input
            type="text" name="Last Name"
            value="${NewUser.Username}" /> <br /> 
        User name<font color="red">*</font> <input
            type="text" name="User Name"
            value="${NewUser.Username}" /> <br /> 
        Password<font color="red">*</font> <input
            type="text" name="Password"
            value="${NewUser.Password}" /> <br />
        Verify Password<font color="red">*</font> <input
            type="text" name="Verify Password"
            value="${NewUser.PasswordV}" /> <br />
            <p><font color="red">*</font> Required Fields</p>
            <input type="submit" value="Create Account"/>
            </form>
</body>
</html>