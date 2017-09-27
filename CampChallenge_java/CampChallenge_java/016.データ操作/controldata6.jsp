<%-- 
    Document   : controldata6
    Created on : 2017/09/27, 17:01:51
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
        <form action="http://localhost:8080/SanpleA/controldata6.jsp" method="get"></form>
    <input name="x">
    <%
    boolean f=false;
    int x=Integer.parseInt(request.getParameter("x"));
    int a=x;
    int z;
    String y="";
    while(f==false){
        z=x%2;
        if(z==0){
            x=x/2;
            y=y+"2.";
            continue;
        }
        z=x%3;
        if(z==0){
            x=x/3;
            y=y+"3.";
            continue;
        }
        z=x%5;
        if(z==0){
            x=x/5;
            y=y+"5.";
            continue;
        }
        z=x%7;
        if(z==0){
            x=x/7;
            y=y+"7.";
            continue;
        }
        if(x==1){
            out.print("元の値:"+a+"因数:"+y);
            break;
        }
        else{
            out.print("元の値:"+a+"因数"+y+"余り:"+x);
            break;
        }
    }
    %>
</html>
