<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            function setCookie(cname, cvalue, exdays) {
                var d = new Date();
                d.setTime(d.getTime() + (exdays*24*60*60*1000));
                var expires = "expires="+d.toUTCString();
                document.cookie = cname + "=" + cvalue + "; " + expires;
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
                document.location.href = 'math.jsp';
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
                            <li><a href = "CreateAccount.jsp">Create Account</a></li>
                            <li><a href = "#">Log Out</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class = "text-center">
                <h1>Sniper Team Dango Math</h1>
            </div>
        </div>
        <div class = "content">
            <div class = "text-center">
                <div class = "row">
                    <div class = "col-md-12">
                        <p></p>
                        <input type = "submit" style = "background-color:#FFDAB9; border: 4px solid #E7C6A5" onclick="location.href='UserController?action=Home'" value = "Home"/>
                        <form name ="frm" action = "UserController" method = "GET">
                            <input type = "submit" style = "background-color:#FFDAB9; border: 4px solid #E7C6A5" name="action" value = "Home"/>
                            <input type = "submit" style = "background-color:#FF0000; border: 4px solid #E00000" value = "1st Grade"/>
                            <input type = "submit" style = "background-color:#FF7400; border: 4px solid #E06600" value = "2nd Grade"/>
                            <input type = "submit" style = "background-color:#FFAA00; border: 4px solid #E09600" value = "3rd Grade"/>
                            <input type = "submit" style = "background-color:#00DD00; border: 4px solid #00B300" value = "4th Grade"/>
                            <input type = "submit" style = "background-color:#00BCBC; border: 4px solid #008787" value = "5th Grade"/>
                            <input type = "submit" style = "background-color:#FFDAB9; border: 4px solid #E7C6A5" value = "Profile"/>
                        </form>
                        <p></p>
                    </div>
                </div> 
            </div>
        </div>
    </body>
</html>
