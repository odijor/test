/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.sample;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.HashMap;
/**
 *
 * @author sige
 */
@WebServlet(name = "method7", urlPatterns = {"/method7"})
public class method7 extends HttpServlet {
    HashMap<String,String> makedata(int id,PrintWriter pw){
        HashMap<String,String>data=new HashMap<>();
        switch(id){
            case 1:
                data.put("id","1");
                data.put("名前","sanple1");
                data.put("生年月日", "1/1");
                data.put("住所", "東京都");
                pw.println("<br>");
                break;
            case 2:
                data.put("id","2");
                data.put("名前","sanple2");
                data.put("生年月日", "2/1");
                data.put("住所", null);
                pw.println("<br>");
                break;
            case 3:
                data.put("id","3");
                data.put("名前","sanple3");
                data.put("生年月日", "3/1");
                data.put("住所", "神奈川県");
                pw.println("<br>");
                break;
                
        }
        return data;    
    }

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
            HashMap<String,String>data=new HashMap<>();
            for(int i=1;i<4;i++){
            data=makedata(i,out);
            if(data.containsValue(null)){
                out.println("<br>");
                continue;
            }
            out.println(data.get("名前"));
            out.println(data.get("生年月日"));
            out.println(data.get("住所"));
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
