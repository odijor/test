/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database1;

import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;
/**
 *
 * @author sige
 */

/*未実装
class select(String sql){
    Statement stm = db_con.createStatement();
    int id,age;
        String name,tel;
        SimpleDateFormat sdf =
                new SimpleDateFormat("yyyy-MM-dd");
        Date d1=new Date();
        String sql=
        
        while(rs.next()){
            id = rs.getInt("profilesID");
            name = rs.getString("name");
                tel = rs.getString("tel");
                age = rs.getInt("age");
                d1 = rs.getDate("birthday");
                String bir = sdf.format(d1);
                ResultSet rs = stm.executeQuery(sql);
                System.out.println("取得結果 -> " + id + ":" + name + ":" + tel 
                + ":" + age + ":" + bir);
                
        }
        
}
*/        
        
        
public class database11 {
    public static void main(String[]args) {
    Connection db_con=null;
    PreparedStatement db_st=null;
    try{
        //jdbcドライバーのロード
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        //mysqlに接続
        db_con=DriverManager.getConnection
        ("jdbc:mysql://localhost:3306/Challenge_db","odijor","j2rtfdy3");
        System.out.println("接続成功しました。");
        
        int id,age;
        String name,tel;
        SimpleDateFormat sdf =
                new SimpleDateFormat("yyyy-MM-dd");
        Date d1=new Date();
        
        //情報追加
        Statement stm = db_con.createStatement();
        String sql=("insert into profiles (profilesID,name,tel,age,birthday) values "
                + "(6,'荒井 茂','0120-123-456',20,'2004-01-01');");
        int result = stm.executeUpdate(sql);
            System.out.println("更新件数は" + result + "です。");
            
        //情報取得
        sql = "select * from profiles";
        ResultSet rs = stm.executeQuery(sql);
        
        
        while(rs.next()){
                id = rs.getInt("profilesID");
                name = rs.getString("name");
                tel = rs.getString("tel");
                age = rs.getInt("age");
                d1 = rs.getDate("birthday");
                String bir = sdf.format(d1);
                
                System.out.println("取得結果 -> " + id + ":" + name + ":" + tel 
                + ":" + age + ":" + bir);
        }
        //情報取得prepareStatement使用
        sql ="select * from profiles where profilesID = ? ;";        
        db_st=db_con.prepareStatement(sql);
        db_st.setInt(1, 1);
        rs = db_st.executeQuery();
        System.out.println("ID:1の情報");
        
        while(rs.next()){
            id = rs.getInt("profilesID");
            name = rs.getString("name");
                tel = rs.getString("tel");
                age = rs.getInt("age");
                d1 = rs.getDate("birthday");
                String bir = sdf.format(d1);
                
                System.out.println("取得結果 -> " + id + ":" + name + ":" + tel 
                + ":" + age + ":" + bir);
        }
        db_st=db_con.prepareStatement("select * from profiles where name like ? ;");
        db_st.setString(1, "%茂%");
        rs = db_st.executeQuery();
        System.out.println("茂を含む検索結果");
        while(rs.next()){
            id = rs.getInt("profilesID");
            name = rs.getString("name");
                tel = rs.getString("tel");
                age = rs.getInt("age");
                d1 = rs.getDate("birthday");
                String bir = sdf.format(d1);
                
                System.out.println("取得結果 -> " + id + ":" + name + ":" + tel 
                + ":" + age + ":" + bir);
        }
        //データ削除
        sql = "delete from profiles where profilesID = ? ;";
        db_st=db_con.prepareStatement(sql);
        db_st.setInt(1, 6);
        result = db_st.executeUpdate();
        System.out.println("更新件数は" + result + "です。");
        sql = "select * from profiles";
        rs = stm.executeQuery(sql);
        
        while(rs.next()){
                id = rs.getInt("profilesID");
                name = rs.getString("name");
                tel = rs.getString("tel");
                age = rs.getInt("age");
                d1 = rs.getDate("birthday");
                String bir = sdf.format(d1);
                
                System.out.println("取得結果 -> " + id + ":" + name + ":" + tel 
                + ":" + age + ":" + bir);
        }
        //データ変更
        sql = "update profiles set name='松岡 修造',age=48 "
                +",birthday='1967-11-06'where profilesID = ? ;";
        db_st=db_con.prepareStatement(sql);
        db_st.setInt(1, 1);
        result = db_st.executeUpdate();
        System.out.println("更新件数は" + result + "です。");
        
        sql = "select * from profiles";
        rs = stm.executeQuery(sql);
        
        while(rs.next()){
                id = rs.getInt("profilesID");
                name = rs.getString("name");
                tel = rs.getString("tel");
                age = rs.getInt("age");
                d1 = rs.getDate("birthday");
                String bir = sdf.format(d1);
                
                System.out.println("取得結果 -> " + id + ":" + name + ":" + tel 
                + ":" + age + ":" + bir);
        }
        
        
        }catch(InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            System.out.println("jdbcドライバのロードに失敗しました。");
        }catch(SQLException e){
            System.out.println("mySQLの接続に失敗しました。");
            System.out.println(e.getMessage());
        }finally{
        if(db_con != null){
            try{
                db_con.close();
                System.out.print("mysqlをクローズしました。");
            }catch(SQLException e){
                System.out.println("mysqlのクローズに失敗しました。");
            }
        }
        
        
}      
    }
}