/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test1;

/**
 *
 * @author sige
 */
public class String1 {
    public static void main(String[]args){
        String name ="佐藤太郎";
        System.out.println(name);
        int count=name.length();
        int b=name.getBytes().length;
        System.out.println("文字数は"+count+"字");
        System.out.println("容量は"+b+"byte");
        
        String Email ="sanple1@gmail.com";
        System.out.println(Email);
        int domain = Email.indexOf("@");
        System.out.println(Email.substring(domain));
        
        String x ="「きょUはぴIえIちぴIのくみこみかんすUのがくしゅUをしてIます」";
        System.out.println(x);
        x=x.replace("U", "う");
        x=x.replace("I", "い");
        System.out.println(x);
    }
}
