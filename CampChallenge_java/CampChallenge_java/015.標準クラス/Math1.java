/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test1;
import java.io.*;


import java.util.Date;
import java.text.SimpleDateFormat;


/**
 *
 * @author sige
 */
public class Math1 {
    public static void main(String[]args) throws IOException{
        SimpleDateFormat sdf =
                new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date d1=new Date();
        //ログファイル作成
        File fp=new File("C:\\Users\\sige\\Desktop\\geek job関連\\logfile1.txt");
        FileWriter fw=new FileWriter(fp,true);
        fw.write(sdf.format(d1)+"開始\r\n");
        
        //余弦定理の計算
        fw.write("余弦定理を使い三角形の2辺と間の角度から最後の辺の長さを求めます。\r\n");
        double a,b,c,cosa,x;
        fw.write("double型の変数a,b,c,cosa,xを設定\r\n");
        b=3.0;
        fw.write("bを3に設定\r\n");
        c=2.0;
        fw.write("c=2に設定\r\n");
        cosa=0.5;
        fw.write("cosa=1/2に設定\r\n");
        x=b*b+c*c-2*b*c*cosa;
        fw.write("計算中...\r\n");
        a=Math.sqrt(x);
        fw.write("平方根を取り結果を出します\r\n");
        System.out.print(a);
        fw.write("計算結果:"+a+"\r\n");
        Date d2=new Date();
        fw.write(sdf.format(d2)+"終了\r\n");
        fw.close();
        
        FileReader fr=new FileReader (fp);
        BufferedReader br=new BufferedReader(fr);
        System.out.print(br.readLine());
        fr.close();
        
    }
}
