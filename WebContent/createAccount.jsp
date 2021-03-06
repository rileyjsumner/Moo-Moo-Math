<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <c:if test="${empty buttons}">
    <c:redirect url="User?action=createAccount"/>
</c:if>
<html>
    <head>
        <title>Create Account</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel = "stylesheet" href = "main.css">
        <script src = "https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src = "http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    </head>
    <body>
        <script>
            function validate(page){
                var element = document.getElementById(page);
                var x = document.forms["SignIn"];
                if (x[page].value === null || x[page].value === "") {
                    element.className="form-error";
                    document.getElementById(page+"Error").innerHTML="Cannot leave this field empty";
                }
                else{
                    element.className = "";
                    document.getElementById(page+"Error").innerHTML="";
                }
                if(page === "VerifyPassword" || page === "Password"){
                    if(x["Password"].value !== x["VerifyPassword"].value){
                        document.getElementById("VerifyPassword").className="form-error";
                        document.getElementById("VerifyPasswordError").innerHTML="Passwords do not match";
                    }
                    else{
                        document.getElementById("VerifyPassword").className="";
                        document.getElementById("VerifyPasswordError").innerHTML="";
                    }
                }
            }
            function validateForm(){
                var x = document.forms["SignIn"];
                if (x["FirstName"].value === null || x["FirstName"].value === "") {
                    alert("First name must be filled out");
                    return false;
                }
                if (x["LastName"].value === null || x["LastName"].value === "") {
                    alert("Last name must be filled out");
                    return false;
                }
                if (x["UserName"].value === null || x["UserName"].value === "") {
                    alert("User name must be filled out");
                    return false;
                }
                if (x["Password"].value === null || x["Password"].value === "") {
                    alert("Password must be filled out");
                    return false;
                }
                if (x["VerifyPassword"].value === null || x["VerifyPassword"].value === "") {
                    alert("Password verification must be filled out");
                    return false;
                }
                if (x["VerifyPassword"].value !== x["Password"].value) {
                    alert("Passwords do not match");
                    return false;
                }
                return true;
            }
            function rgbToHex(r, g, b) {
                if(r < 0 || r > 255) alert("r is out of bounds; "+r);
                if(g < 0 || g > 255) alert("g is out of bounds; "+g);
                if(b < 0 || b > 255) alert("b is out of bounds; "+b);
                return "#" + ((1 << 24) + (r << 16) + (g << 8) + b).toString(16).slice(1,7);
            }
            function hslToRgb(h, s, l){
                var r, g, b;

                if(s === 0){
                    r = g = b = l; // achromatic
                }else{
                    var hue2rgb = function hue2rgb(p, q, t){
                        if(t < 0) t += 1;
                        if(t > 1) t -= 1;
                        if(t < 1/6) return p + (q - p) * 6 * t;
                        if(t < 1/2) return q;
                        if(t < 2/3) return p + (q - p) * (2/3 - t) * 6;
                        return p;
                    };

                    var q = l < 0.5 ? l * (1 + s) : l + s - l * s;
                    var p = 2 * l - q;
                    r = hue2rgb(p, q, h + 1/3);
                    g = hue2rgb(p, q, h);
                    b = hue2rgb(p, q, h - 1/3);
                }
                
                return rgbToHex(Math.round(r * 255), Math.round(g * 255), Math.round(b * 255));
            }
        </script>
        <div class = "jumbotron">
            <div class = "text-center">
                <h1>Moo-Moo Math</h1>
            </div>
        </div>
        <div class = "content">
            <div class = "text-center">
                <div id = "GradeButtonContainer" class = "col-md-12">
                    <p></p>
                    <input type = "button" style = "background-color:#81C6C9; border: 4px solid #489194" value = "Home"/>
                    <script>
                        var grades = ${buttons.GetGrades()};
                        var element;
                        for(i=1;i<grades;i++){
                            element = document.createElement("input");
                            element.setAttribute("type", "button");
                            element.setAttribute("value", "Grade "+i);
                            element.style.backgroundColor = hslToRgb((i-1)*.1,.6,.6);
                            element.style.borderColor = hslToRgb((i-1)*.1,.6,.4);
                            element.style.borderWidth = "4px";
                            element.style.borderStyle = "solid";
                            document.getElementById("GradeButtonContainer").appendChild(element);
                            if(i != grades-1){
                                element = document.createElement("div");
                                element.setAttribute("class","divider");
                                document.getElementById("GradeButtonContainer").appendChild(element);
                            }
                        }
                    </script>
                    <input type = "button" style = "background-color:#DADADA; border: 4px solid #B7B7B7" value = "Profile"/>
                    <p></p>
                </div>
            </div>
            <div class = "content">
                <div class ="text-center">
                    <h2 style="font-size: 280%">Create Account</h2>
                    <form method="POST" onsubmit="return validateForm()" action="User?action=CreateAccount" name = "SignIn">
                        <p class="form-basic" style="font-size: 100%">First Name</p>
                        <input class="" id="FirstName" onblur="validate('FirstName')" type="text" name="FirstName" value="First name" />
                        <p class ="form-error" id="FirstNameError"> </p>
                        <p class="form-basic" style="font-size: 100%">Last Name</p>
                        <input class="" id="LastName" onblur="validate('LastName')" type="text" name="LastName" value="Last name" />
                        <p class ="form-error" id="LastNameError"></p>
                        <p class="form-basic" style="font-size: 100%">Username</p>
                        <input class="" id="UserName" onblur="validate('UserName')" type="text" name="UserName" value="Username" />
                        <p class ="form-error" id="UserNameError"> </p>
                        <p class="form-basic" style="font-size: 100%">Email</p>
                        <input class="" id="Email" onblur="validate('Email')" type="text" name="Email" value="Email" />
                        <p class ="form-error" id="EmailError"> </p>
                        <p class="form-basic" style="font-size: 100%">Password</p>
                        <input class="" id="Password" onchange="validate('Password')" onblur="validate('Password')" type="password" name="Password" value="" />
                        <p class ="form-error" id="PasswordError"></p>
                        <p class="form-basic" style="font-size: 100%">Verify Password</p>
                        <input class="" id="VerifyPassword" onchange="validate('VerifyPassword')" onblur="validate('VerifyPassword')" type="password" name="VerifyPassword" value="" />
                        <p class ="form-error" id="VerifyPasswordError"></p>
                        <input style ="border-color: #31B531;background-color: #028F02;" type="submit" value="Create Account"/>
                    </form>
                </div>
            </div>
        </div>
        
    </body>
</html>