<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <c:if test="${empty buttons}">
    <c:redirect url="User?action=Home"/>
</c:if>
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
            function validate(page){
                var element = document.getElementById(page);
                var x = document.forms["SignIn"];
                if (x[page].value === null || x[page].value === "") {
                    element.className="form-error";
                }
                else{
                    element.className = "";
                }
            }
            function isValid(){
                var x = document.forms["SignIn"];
                if (x["UserName"].value == null || x["UserName"].value == "") {
                    alert("Username must be filled out");
                    return false;
                }
                else if (x["Password"].value == null || x["Password"].value == "") {
                    alert("Password must be filled out");
                    return false;
                }
                else{
                    return true;
                }
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
                    <h2 style="font-size: 280%">You're not logged in yet!</h2>
                    <p style="font-size: 150%">Please Sign in below</p>
                    <form method="POST" onsubmit="return isValid();" action="User?action=Login" name = "SignIn">
                        <p class="form-basic" style="font-size: 100%">Username</p>
                        <input class="" id="UserName" onblur="validate('UserName')" type="text" name="UserName" value="Username" />
                        <p />
                        <p class="form-basic" style="font-size: 100%">Password</p>
                        <input class="" id="Password" onblur="validate('Password')" type="password" name="Password" value="" />
                        <p></p>
                        <input style ="border-color: #31B531;background-color: #028F02;" type="submit" value="Log In"/>
                        <p></p>
                        <p><a href="User?action=createAccount">Create Account</a></p>
                    </form>
                </div>
            </div>
        </div>
        
    </body>
</html>
