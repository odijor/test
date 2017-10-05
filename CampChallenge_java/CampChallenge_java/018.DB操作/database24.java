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
@WebServlet(name = "database24", urlPatterns = {"/database24"})
public class database24 extends HttpServlet {

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
            
            String sql;
            String data;
            String id,name,cost,stock;
            
            try{
            //jdbcドライバーのロード
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            //mysqlに接続
            db_con=DriverManager.getConnection
            ("jdbc:mysql://localhost:3306/Challenge_db","odijor","j2rtfdy3");
            out.println("接続成功しました。");
                
                //一覧機能
                
                    sql = "select * from item;";
                    db_st=db_con.prepareStatement(sql);
                    db_data = db_st.executeQuery();
                    
                    while(db_data.next()){
                    id = db_data.getString("itemID");
                    name = db_data.getString("itemname");
                    cost = db_data.getString("cost");
                    stock = db_data.getString("stock");
                    
                
                         data = ("検索結果 -> ID" + id + " name:" + name + " cost:" + cost 
                         + " stock:" + stock );
                        out.print(data+"<br>");
                }
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
                out.println("mysqlのクローズに失敗しました。");
            }
        }
            
            
        }
    }}

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
