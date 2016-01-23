<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>1st Grade Math</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel = "stylesheet" href = "main.css">
        <script src = "https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src = "http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    </head>
    <body>
        <script>
            function setCookie(cname, cvalue, exdays) {
                var d = new Date();
                d.setTime(d.getTime() + (exdays*24*60*60*1000));
                var expires = "expires="+d.toUTCString();
                document.cookie = cname + "=" + cvalue + "; " + expires;
            }
            function delCookie(cname) {
                document.cookie = cname + "=0; expires=0";
            }
            function getCookie(cname) {
                var name = cname + "=";
                var ca = document.cookie.split(';');
                for(var i=0; i<ca.length; i++) {
                    var c = ca[i];
                    while (c.charAt(0)===' ') c = c.substring(1);
                    if (c.indexOf(name) === 0) return c.substring(name.length,c.length);
                }
                return "";
            }
            function toGrade(grade){
                setCookie("Grade",grade,1);
                document.location.href = 'Home.jsp';
                document.location.href = 'math.jsp';
            }
            function toLesson(grade, lesson){
                
            }
            function addButton (name, bgCol, bdCol, lesson) {
                var element = document.createElement("input");
                element.setAttribute("type", "button");
                element.setAttribute("value", name);
                element.onclick = function (){
                    document.location.href = "UserController?action=lesson&lesson="+lesson.toString();
                };
                element.style.backgroundColor = bgCol;
                element.style.borderColor = bdCol;
                element.style.borderWidth = "4px";
                element.style.borderStyle = "solid";
                document.getElementById("kek").appendChild(element);
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
                <h1>Sniper Team Dango Math</h1>
                <p id ="p2">Grade Math</p>
                <script>
                    var grade=0;
                    grade = getCookie("Grade");
                    var name="You sneaky...";
                    if(grade==="1"){
                        name="First Grade";
                    }else if(grade==="2"){
                        name="Second Grade";
                    }else if(grade==="3"){
                        name="Third Grade";
                    }else if(grade==="4"){
                        name="Fourth Grade";
                    }else if(grade==="5"){
                        name="Fifth Grade";
                    }
                    document.getElementById("p2").innerHTML=name;
                </script>
            </div>
        </div>
        <div class = "content">
            <div class = "text-center">
                <div class = "row">
                    <div class = "col-md-12">
                        <p></p>
                        <input type = "button" style = "background-color:#FFDAB9; border: 4px solid #E7C6A5" onclick = "document.location.href = 'Home.jsp'" value = "Home"/>
                        <input type = "button" style = "background-color:#FF0000; border: 4px solid #E00000" onclick = "toGrade(1)" value = "1st Grade"/>
                        <input type = "button" style = "background-color:#FF7400; border: 4px solid #E06600" onclick = "toGrade(2)" value = "2nd Grade"/>
                        <input type = "button" style = "background-color:#FFAA00; border: 4px solid #E09600" onclick = "toGrade(3)" value = "3rd Grade"/>
                        <input type = "button" style = "background-color:#00DD00; border: 4px solid #00B300" onclick = "toGrade(4)" value = "4th Grade"/>
                        <input type = "button" style = "background-color:#00BCBC; border: 4px solid #008787" onclick = "toGrade(5)" value = "5th Grade"/>
                        <input type = "button" style = "background-color:#FFDAB9; border: 4px solid #E7C6A5" onclick = "document.location.href = 'Profile.jsp'" value = "Profile"/>
                        <p></p>
                    </div>
                </div>
            </div>
        </div>
        <div class = "content">
            <div class = "text-center">
                <div class = "row">
                    <div style = "background-color: gray;">
                        <div class = "hoon" id = "kek">
                            <p style = "background-color: gray;"></p>
                            <script>
                                var grade = getCookie("Grade");
                                if (grade === "1")
                                {
                                    addButton("Number Patterns", "#FF5D36", "FF3A0B", 1.1);
                                    addButton("Addition", "FF5236", "FF1D0B", 1.2);
                                    addButton("Subtraction", "FF4536", "FF1D0B", 1.3);
                                    addButton("Geometry", "FF3636", "FF0B0B", 1.4);
                                    addButton("Measurement", "FC3644", "FB0B1D", 1.5);
                                }
                                else if (grade === "2")
                                {
                                    addButton("3 Digit Addition", "#FF8C36", "FF730B", 2.1);
                                    addButton("2 Digit Subtraction", "FF9136", "FF7A0B", 2.2);
                                    addButton("Number Patterns", "FF9736", "FF800B", 2.3);
                                    addButton("Patterns", "FF9C36", "FF860B", 2.4);
                                    addButton("Probability", "FFA036", "FF8C0B", 2.5);
                                }
                                else if (grade === "3")
                                {
                                    addButton("Multiplication", "#FF8C36", "FF730B", 3.1);
                                    addButton("Division", "FF9136", "FF7A0B", 3.2);
                                    addButton("Fractions", "FF9736", "FF800B", 3.3);
                                    addButton("Logical Reasoning", "FF9C36", "FF860B", 3.4);
                                    addButton("Money", "FFA036", "FF8C0B", 3.5);
                                    addButton("Geometry", "red", "red", 3.6);
                                }
                                else if (grade === "4")
                                {
                                    addButton("Equations", "#FF8C36", "FF730B", 4.1);
                                    addButton("Adding Fractions", "FF9146", "FF7A0B", 4.2);
                                    addButton("Subtracting Fractions", "FF9746", "FF800B", 4.3);
                                    addButton("What's my Rule?", "FF9C46", "FF860B", 4.4);
                                    addButton("Decimals", "FFA046", "FF8C0B", 4.5);
                                    addButton("Geometry", "red", "red", 4.6);
                                }
                                else if (grade === "5")
                                {
                                    addButton("Equations", "#FF8C36", "FF730B", 5.1);
                                    addButton("Adding Fractions", "FF9146", "FF7A0B", 5.2);
                                    addButton("Subtracting Fractions", "FF9746", "FF800B", 5.3);
                                    addButton("What's my Rule?", "FF9C46", "FF860B", 5.4);
                                    addButton("Decimals", "FFA046", "FF8C0B", 5.5);
                                    addButton("Geometry", "red", "red", 5.6);
                                    addButton("Divide Decimals", "red", "red", 5.7);
                                }
                                //delCookie("Grade");
                            </script>
                            <p></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
