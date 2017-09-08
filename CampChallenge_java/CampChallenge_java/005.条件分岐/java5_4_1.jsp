<%-- 
    Document   : java5_4_1
    Created on : 2017/09/08, 17:39:56
    Author     : sige
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            int a = 3;
            switch(a) {
                case 1:out.print("one");
                break;
                case 2:out.print("two");
                break;
                default:out.print("想定外"); 
                break;    
            }
            %>
            
    </body>
</html>
