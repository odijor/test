/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test1;

import java.text.ParseException;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;

/**
 *
 * @author sige
 */
public class Date1 {
    public static void main(String[]args) throws ParseException{
        SimpleDateFormat sdf =
                new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Calendar d1=Calendar.getInstance();
        d1.set(2016,00,01,00,00,00);
        System.out.println(d1);
        
        Date d2=new Date();
        System.out.println(sdf.format(d2));
        
        Calendar d3=Calendar.getInstance();
        d3.set(2016,10,04,10,00,00);
        System.out.println(d3);
        Date d32=d3.getTime();
        System.out.println(sdf.format(d32));
        
        Date d4=null;
        Date d5=null;
        
        
        d4=sdf.parse("2015年12月31日 23:59:59");
        d5=sdf.parse("2015年01月01日 00:00:00");
        
        long d42=d4.getTime();
        long d52=d5.getTime();
        long x=d42-d52;
        System.out.print("差は"+x+"ミリ秒です");
    }
}
