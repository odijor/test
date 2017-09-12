<%-- 
    Document   : java8_4
    Created on : 2017/09/12, 14:44:25
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
            int x=1000;
            while(x>=100){
                x /=2;
                out.println(x);
            }
            %>
    </body>
</html>
