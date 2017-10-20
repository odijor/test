package jums;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author hayashi-s
 */
public class SearchResult extends HttpServlet {

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
        
        try{
            HttpSession session = request.getSession();
            request.setCharacterEncoding("UTF-8");//リクエストパラメータの文字コードをUTF-8に変更
            //アクセスルートチェック
            String accesschk = request.getParameter("ac");
            if(accesschk ==null || (Integer)session.getAttribute("ac")!=Integer.parseInt(accesschk)){
                throw new Exception("不正なアクセスです");
            }
        
            //フォームからの入力を取得して、JavaBeansに格納
            UserDataBeans udb = new UserDataBeans();
            
            //検索から遷移した場合
            if((UserDataDTO)session.getAttribute("resultData") == null){
                udb.setName(request.getParameter("name"));
                udb.setYear(request.getParameter("year"));
                udb.setType(request.getParameter("type"));
            

                //DTOオブジェクトにマッピング。DB専用のパラメータに変換
                UserDataDTO searchData = new UserDataDTO();
                udb.UD2DTOMapping(searchData);

                ArrayList<UserDataDTO> resultList = UserDataDAO .getInstance().search(searchData);
                session.setAttribute("resultList", resultList);
            
            }else{
                //検索以外から遷移した場合
                ArrayList<UserDataDTO> resultList = (ArrayList<UserDataDTO>)session.getAttribute("resultList");
                UserDataDTO updatedData = (UserDataDTO)session.getAttribute("resultData");
                int ID =Integer.parseInt(request.getParameter("id"));
                int updatePosition=checkID(resultList,ID);
                resultList.set (updatePosition,updatedData);
                session.setAttribute("resultList", resultList);
            }
           
           
            session.setAttribute("ac", (int) (Math.random() * 1000));
            request.getRequestDispatcher("/searchresult.jsp").forward(request, response);  
        }catch(Exception e){
            //何らかの理由で失敗したらエラーページにエラー文を渡して表示。想定は不正なアクセスとDBエラー
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
        
        
    }
    
    //ID確認を行う。arraylist上のresultListのIDが一致するデータの位置を返す
    public int checkID(ArrayList<UserDataDTO> resultList,int ID){
        for(int i=0;i<resultList.size();i++){
            if(resultList.get(i).getUserID() == ID){
                return i;
            }
        }
        return -1;
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
