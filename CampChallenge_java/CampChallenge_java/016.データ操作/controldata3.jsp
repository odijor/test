<%-- 
    Document   : controldata3
    Created on : 2017/09/27, 11:14:56
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
        <h1>
            <form action="http://localhost:8080/SanpleA/controldata3.jsp" method="get"></form>
            <input name="total">
            <input name="count">
            <input name="type">
            <%
                int x=0;
                double p=0;
                int total=Integer.parseInt(request.getParameter("total"));
                int count=Integer.parseInt(request.getParameter("count"));
                int type=Integer.parseInt(request.getParameter("type"));
                if(count==0)count=1;
                
                x=total/count;
                if(total>=5000){p=total*0.05;}
                if(total>=3000){p=total*0.04;}
                out.println("合計:"+total);
                out.println("個数:"+count);
                out.println("単価:"+x);
                switch(type){
                    case 1:out.println("雑貨");
                    break;
                    case 2:out.println("生鮮食品");
                    break;
                    case 3:out.println("その他");
                    break;
                    default:out.println("エラー");
                    break;
                }
                out.println("今回の取得ポイントは"+p+"ポイントです。");
                %>
        </h1>
    </body>
</html>
