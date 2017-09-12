<%-- 
    Document   : java8_2
    Created on : 2017/09/12, 14:30:31
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
            String a ="";
            for(int i =0;i<30;i++){
                a=a+"A";
            }
            out.print(a);
            %>
            
    </body>
</html>
