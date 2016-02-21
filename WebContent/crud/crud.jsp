<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:if test="${empty general}">
    <c:redirect url="/User?action=crud"/>
</c:if>
<html>
    <head>
        <title>CRUD</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel = "stylesheet" href = "main.css">
        <script src = "https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src = "http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    </head>
    <body>
        <script>
            function rgbToHex(r, g, b) {
                if(r < 0 || r > 255) alert("r is out of bounds; "+r);
                if(g < 0 || g > 255) alert("g is out of bounds; "+g);
                if(b < 0 || b > 255) alert("b is out of bounds; "+b);
                return "#" + ((1 << 24) + (r << 16) + (g << 8) + b).toString(16).slice(1,7);
            }
            function addButton (name, bgCol, bdCol, lesson, parent,redir) {
                var element = document.createElement("input");
                element.setAttribute("type", "button");
                element.setAttribute("value", name);
                element.onclick = function (){
                    document.location.href = redir;
                };
                element.style.backgroundColor = bgCol;
                element.style.borderColor = bdCol;
                element.style.borderWidth = "4px";
                element.style.borderStyle = "solid";
                document.getElementById(parent).appendChild(element);
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
            <div class = "text-right">
                <div class = "col-xs-pull-1">
                    <div class = "dropdown">
                        <button class = "btn btn-default dropdown-toggle" type = "button" data-toggle = "dropdown" style = "background-color:#81C6C9; border: 4px solid #489194"> Options
                        <span class = "caret"></span></button>
                        <ul class = "dropdown-menu pull-right">
                            <li><a href = "Profile.jsp">Profile</a></li>
                            <li><a href = "User?action=logout">Log Out</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class = "text-center">
                <h1>Moo-Moo Math</h1>
            </div>
        </div>
        <div class = "content">
            <div class = "text-center">
                <div id = "GradeButtonContainer" class = "col-md-12">
                    <p></p>
                    <input type = "button" style = "background-color:#81C6C9; border: 4px solid #489194" onclick = "document.location.href = 'Home.jsp'" value = "Home"/>
                    <script>
                        var grades = ["lessons","progress","questions","users"];
                        var gradeNames = ["Lessons","Progress","Questions","Users"];
                        var element;
                        for(i=0;i<4;i++){
                            element = document.createElement("input");
                            element.setAttribute("type", "button");
                            element.setAttribute("value", "View "+gradeNames[i]);
                            element.setAttribute('onclick', "document.location.href='User?action=crud&crudaction="+grades[i]+"'");
                            element.style.backgroundColor = hslToRgb(i*.1,.8,.6);
                            element.style.borderColor = hslToRgb(i*.1,.8,.4);
                            element.style.borderWidth = "4px";
                            element.style.borderStyle = "solid";
                            document.getElementById("GradeButtonContainer").appendChild(element);
                            if(i !== 3){
                                element = document.createElement("div");
                                element.setAttribute("class","divider");
                                document.getElementById("GradeButtonContainer").appendChild(element);
                            }
                        }
                    </script>
                    <input type = "button" style = "background-color:#81C6C9; border: 4px solid #489194" onclick = "document.location.href = 'Profile.jsp'" value = "Profile"/>
                    <p></p>
                </div>
            </div>
            <div class = "jumbotron">
                <div class ="text-center">
                    <p>Welcome to the C.R.U.D.</p>
                    <p>Select an option from above to edit data</p>
                </div>
            </div>
        </div>
        
    </body>
</html>
