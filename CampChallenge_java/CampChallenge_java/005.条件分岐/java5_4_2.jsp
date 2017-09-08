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
            char a = 'B';
            switch(a) {
                case 'あ':out.print("日本語");
                break;
                case 'A':out.print("英語");
                break;
            }
            %>
            
    </body>
</html>
