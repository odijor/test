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
class Human{
    public int id=0;
    public String name="";
    
    public void setHuman(int i,String n) {
        this.id=i;
        this.name=n;
    }
    void outputHuman( int i,String n){
    System.out.println("ID:"+i);
    System.out.println("name:"+n);
    }
}

public class Test{
    public static void main(String[] args) {
        Delete hito1 = new Delete();
        hito1.setHuman(1,"sanple1");
        hito1.outputHuman(hito1.id,hito1.name);
        hito1.delete1(hito1.id,hito1.name);
        hito1.outputHuman(hito1.id, hito1.name);
        
        
        
    }
    
}

class Delete extends Human{
    public void delete1(int i,String n){
        this.id=0;
        this.name=null;
    }
}

