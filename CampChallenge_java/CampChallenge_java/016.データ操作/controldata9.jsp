<%-- 
    Document   : controldata9
    Created on : 2017/09/28, 14:15:50
    Author     : sige
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession hs=request.getSession();
    String n=(String)hs.getAttribute("name2");
    String s=(String)hs.getAttribute("sex2");
    String h=(String)hs.getAttribute("hobby2");
    String c1="";
    String c2="";
    
    if(s.equals("male")){
        c1="checked=\"checked\"";
    }
    if(s.equals("female")){
        c2="checked=\"checked\"";
    }
   
    %>
    

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="http://localhost:8080/SanpleA/controldata9.jsp" method="get"><label>
                名前:<input type="text" name="name" value= "<% out.print(n); %>" ></label><input type="submit" value="送信"></form>
            <br>
            <form action="http://localhost:8080/SanpleA/controldata9.jsp" method="post"><label>
                性別:<input type="radio" name="sex" value="male" <%out.print(c1);%> > 男性
                <input type="radio" name="sex" value="female" <%out.print(c2);%> > 女性 </label><input type="submit" value="送信"></form>
            <br>
            <form action="http://localhost:8080/SanpleA/controldata9.jsp" method="post"><label>
                    趣味:<textarea name="hobby" cols="30" rows="3"  ><% out.print(h); %></textarea></label><input type="submit" value="送信"></form>
            
            <a href="http://www.htmq.com/html/indexm.shtml" target="_blank">サンプルはこちら</a>
        
    </body>
</html>

<%
    
    
    
    if(request.getParameter("name") !=null){
    n=request.getParameter("name");}
    if(request.getParameter("sex")!=null){
    s=request.getParameter("sex");}
    if(request.getParameter("hobby")!=null){
    h=request.getParameter("hobby");}
    
    out.println(n);
    out.println(s);
    out.println(h);
    
    hs.setAttribute("name2", n);
    hs.setAttribute("sex2", s);
    hs.setAttribute("hobby2", h);

%>