<%-- 
    Document   : java6_4_1
    Created on : 2017/09/11, 16:18:16
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
            String [] data1 = {"10","100","soeda","hayasi","-20","118","end"};
            data1[2] = "33";
            for(int i=0;i<7;i++){
                out.println(data1[i]);
            }
            %>
    </body>
</html>
