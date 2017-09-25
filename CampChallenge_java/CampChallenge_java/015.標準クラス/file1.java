/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test1;

import java.io.*;

/**
 *
 * @author sige
 */
public class file1 {
    public static void main(String[]args) throws IOException{
        File fp=new File("C:\\Users\\sige\\Desktop\\geek job関連\\ファイル操作.txt");
        FileWriter fw=new FileWriter(fp);
        fw.write("新井です。");
        fw.write("好きなものはメロンです。");
        fw.close();
        
        FileReader fr=new FileReader (fp);
        BufferedReader br=new BufferedReader(fr);
        System.out.print(br.readLine());
        fr.close();
        
    }    
}
