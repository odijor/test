<%-- 
    Document   : java8_1
    Created on : 2017/09/12, 14:13:40
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
        long total =1;
        for(int i = 1 ; i <= 20 ; i++){
            total *= 8;
        }
        out.print(total);
        %>
    </body>
</html>
