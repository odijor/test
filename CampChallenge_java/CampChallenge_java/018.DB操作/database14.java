/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package database1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;
/**
 *
 * @author sige
 */
@WebServlet(name = "database14", urlPatterns = {"/database14"})
public class database14 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    
        
    /*時間に余裕があればメソッド化に挑戦
    public String Select(String sql){
        try{
        Connection db_con=null;
        PreparedStatement db_st=null;
        ResultSet db_data = null;
        int id,age;
        String name,tel,data;
        SimpleDateFormat sdf =
                new SimpleDateFormat("yyyy-MM-dd");
        Date d1=new Date();
        ResultSet rs = null;
        
        db_st=db_con.prepareStatement("select * from profiles where name like ? ;");
        db_st.setString(1, "%茂%");
        db_data = db_st.executeQuery();
        while(rs.next()){
            id = rs.getInt("profilesID");
            name = rs.getString("name");
                tel = rs.getString("tel");
                age = rs.getInt("age");
                d1 = rs.getDate("birthday");
                String bir = sdf.format(d1);
                
                data = ("取得結果 -> " + id + ":" + name + ":" + tel 
                + ":" + age + ":" + bir);
                
        }
        return data;
        }catch(Exception e){
                System.out.println(e.getMessage());
                }
    }
    */

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            Connection db_con=null;
        PreparedStatement db_st=null;
        ResultSet db_data = null;
        int id,age,IinsertID,IinsertA;
        String sql,name,tel,data,select,insertID,insertN,insertT,insertA,insertB,update,searchN,searchB,deleteID,updateID,searchA;
        SimpleDateFormat sdf =
                new SimpleDateFormat("yyyy-MM-dd");
        Date d1=new Date();
        //deleteID = "-1";
        //updateID = "-1";
        //searchA = "-1";
        
        
        request.setCharacterEncoding("UTF-8");
        select=request.getParameter("select");
        insertID = request.getParameter("insertID");
        insertN = request.getParameter("insertN");
        insertA = request.getParameter("insertA");
        insertT = request.getParameter("insertT");
        insertB = request.getParameter("insertB");
        deleteID = request.getParameter("deleteID");
        update = request.getParameter("update");
        updateID =request.getParameter("updateID");
        searchN = request.getParameter("searchN");
        searchB = request.getParameter("searchB");
        searchA = request.getParameter("searchA");
        
        try{
        //jdbcドライバーのロード
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        //mysqlに接続
        db_con=DriverManager.getConnection
        ("jdbc:mysql://localhost:3306/Challenge_db","odijor","j2rtfdy3");
        out.println("接続成功しました。");
        
        //情報検索
        if(select != null){
            sql = "select * from profiles where name like ? ;";
            db_st=db_con.prepareStatement(sql);
            db_st.setString(1, "%" + select + "%");
            db_data = db_st.executeQuery();
            while(db_data.next()){
                id = db_data.getInt("profilesID");
                name = db_data.getString("name");
                    tel = db_data.getString("tel");
                    age = db_data.getInt("age");
                    d1 = db_data.getDate("birthday");
                    String bir = sdf.format(d1);
                
                    data = ("取得結果 -> ID" + id + " name:" + name + " tel:" + tel 
                     + " age:" + age + " birthday:" + bir + "\r\n");
                    out.print(data);
                }
            if(db_data == null){
                out.println("該当件数0です。");
            }
            }
        
        //情報追加
        if(insertID != null){
            try{
            IinsertID = Integer.parseInt(insertID);
            IinsertA = Integer.parseInt(insertA);
            }catch (NumberFormatException e){
            IinsertID = -1;
            IinsertA = -1;
            }
            
            sql = "insert into profiles (profilesID,name,tel,age,birthday) "
                    + "values ("+ IinsertID +",\'"+ insertN +"\',\'"+ insertT +"\',"+ IinsertA +",\'"+insertB+"\');";
            db_st=db_con.prepareStatement(sql);
            db_st.executeUpdate();
            out.println("追加しました");
        }
        //情報削除
        if(deleteID != null){
            sql = "delete from profiles where profilesID = ?";
            db_st=db_con.prepareStatement(sql);
            db_st.setString(1, deleteID);
            db_st.executeUpdate();
            out.print("削除しました");
        }
        //情報更新(名前)
        if(updateID != null){
            sql = "update profiles set " + update + " where profilesID = ?;";
            db_st=db_con.prepareStatement(sql);
            db_st.setString(1, updateID);
            db_st.executeUpdate();
            out.print("更新しました");
        }
        //複合検索
        if(searchN != null || searchB != null || searchA != null){
            if(searchN == null) searchN = "";
            if(searchB == null) searchB = "";
            if(searchA == null) searchA = "";
            sql = "select * from profiles where name like ? or birthday = ? or age = ?;";
            db_st=db_con.prepareStatement(sql);
            db_st.setString(1, "%" + searchN + "%");
            db_st.setString(2, searchB);
            db_st.setString(3, searchA);
            db_data = db_st.executeQuery();
            while(db_data.next()){
                id = db_data.getInt("profilesID");
                name = db_data.getString("name");
                    tel = db_data.getString("tel");
                    age = db_data.getInt("age");
                    d1 = db_data.getDate("birthday");
                    String bir = sdf.format(d1);
                
                     data = ("取得結果 -> ID" + id + " name:" + name + " tel:" + tel 
                     + " age:" + age + " birthday:" + bir + "\r\n");
                    out.print(data);
                }
            
        }
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
                out.println("mysqlのクローズに失敗しました。");
            }
        }
        
        
}      
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet database14</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>終了</h1>");
            out.println("</body>");
            out.println("</html>");
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
