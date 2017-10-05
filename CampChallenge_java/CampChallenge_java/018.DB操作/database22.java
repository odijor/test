/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author sige
 */
@WebServlet(name = "database22", urlPatterns = {"/database22"})
public class database22 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            Connection db_con=null;
            PreparedStatement db_st=null;
            ResultSet db_data = null;
            final String mainsystem ="/WEB-INF/database23.jsp";
            
            try{
            //jdbcドライバーのロード
             Class.forName("com.mysql.jdbc.Driver").newInstance();
            //mysqlに接続
            db_con=DriverManager.getConnection
            ("jdbc:mysql://localhost:3306/Challenge_db","odijor","j2rtfdy3");
            out.println("接続成功しました。");
            
            String sql,name,pass;
            request.setCharacterEncoding("UTF-8");
            name=request.getParameter("name");
            pass=request.getParameter("pass");
            
            if(name != null){
                sql = "select * from manager where name = ? and pass = ? ;";
            db_st=db_con.prepareStatement(sql);
            db_st.setString(1, name);
            db_st.setString(2, pass);
            db_data = db_st.executeQuery();
            }
            while(db_data.next()){
                out.println("ログイン成功");
                db_data.close();
                db_st.close();
                db_con.close();
                RequestDispatcher lg = request.getRequestDispatcher(mainsystem);
                lg.forward(request, response);
            }
            out.println("お名前とパスワードをお確かめください。");
            
            db_data.close();
            db_st.close();
            db_con.close();
        }catch(SQLException e_sql){
            out.println("接続時にエラーが発生しました:" + e_sql.toString());
        }catch(Exception e){
            out.println(e.getMessage());
        }finally{
        if(db_con != null){
            try{
                db_con.close();
                out.print("mysqlをクローズしました。");
            }catch(SQLException e){
                out.println(e.getMessage());
            }
        }
        
        
}      
            
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
