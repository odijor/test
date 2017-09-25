/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author sige
 */


abstract class Player{
    abstract public int open(ArrayList<Integer> x);//処理を実装
    abstract public boolean checkSum(Integer sum);//処理を実装
    abstract public ArrayList setCard(int x,ArrayList<Integer> sl);//処理を実装
    ArrayList <Integer> myCard =new ArrayList<>();//共通要素
    
}

class Dealer extends Player{
    //Cardsの初期化
    public ArrayList stCard(){
        ArrayList<Integer> Cards;
        Cards = new ArrayList<>(Arrays.asList
                (1,1,1,1,2,2,2,2,3,3,3,3,4,4,4,4,5,5,5,5,6,6,6,6,7,7,7,7,
                        8,8,8,8,9,9,9,9,10,10,10,10,10,10,10,10,10,10,10,10));
        int deck=Cards.size();
        System.out.println("デッキ枚数:"+deck);
        return Cards;
    }
    
    //乱数
    public int deal(ArrayList cl){
        Random rnd=new Random();
        int deck=cl.size();
        int ran=rnd.nextInt(deck);
        return ran;
    }
    
    //山札消費処理
    public ArrayList Delete(int x,ArrayList Cards){
        Cards.remove(x);
        int deck=Cards.size();
        System.out.println("デッキ枚数:"+deck);
        return Cards;
    }
    
    //手札処理
    public ArrayList setCard(int x,ArrayList<Integer> cl){
        int y=cl.get(x);
        myCard.add(y);
        System.out.println("ディーラーは"+y+"を引いた");
        return myCard;
    }

    //手札管理
    public int open(ArrayList<Integer> MyCard){
        Integer sum=0;
        for(int i=0;i<myCard.size();i++){
            sum +=MyCard.get(i);
        }
        System.out.println("ディーラー合計:"+sum);
         return sum;
    }
    
    //追加有無
    public boolean checkSum(Integer sum){
        if(sum<17){
            System.out.println("ディーラーがヒット");
            return true;
        }else{
            System.out.println("ディーラーがスタンド");
            return false;}
    }
    
    
}

class User extends Player{
    //手札処理
    public ArrayList setCard(int x,ArrayList<Integer> cl){
        int y=cl.get(x);
        myCard.add(y);
        System.out.println("プレイヤーは"+y+"を引いた");
        return myCard;
    }

    //手札管理
    public int open(ArrayList<Integer> MyCard){
        Integer sum=0;
        for(int i=0;i<myCard.size();i++){
            sum +=MyCard.get(i);
        }
        System.out.println("プレイヤー合計:"+sum);
         return sum;
    }
    
    //追加有無
    public boolean checkSum(Integer sum){
        if(sum<17){
            System.out.println("プレイヤーがヒット");
            return true;
        }else{
            System.out.println("プレイヤーがスタンド");
            return false;
        }
    }
}

public class blackjack1 {
    public static void main(String[]args){
        //初期設定
        ArrayList<Integer> Cards=new ArrayList<>();
        int ran;
        Dealer d1=new Dealer();
        User U1=new User();
        Cards=d1.stCard();
        int dsum=0;
        int usum=0;
        boolean ds = true;
        boolean us = true;
        boolean bust= false;
        
        //ディーラ―の初期手札
        ran=d1.deal(Cards);
        d1.myCard=d1.setCard(ran, Cards);
        Cards=d1.Delete(ran, Cards);
        ran=d1.deal(Cards);
        d1.myCard=d1.setCard(ran, Cards);
        Cards=d1.Delete(ran, Cards);
        dsum=d1.open(d1.myCard);
        ds=d1.checkSum(dsum);
        
        //ユーザーの初期手札
        ran=d1.deal(Cards);
        U1.myCard=U1.setCard(ran, Cards);
        Cards=d1.Delete(ran, Cards);
        ran=d1.deal(Cards);
        U1.myCard=U1.setCard(ran, Cards);
        Cards=d1.Delete(ran, Cards);
        usum=U1.open(U1.myCard);
        us=d1.checkSum(usum);
        
        while(us == true||ds == true){
            //ユーザーのヒット
            if(us == true){
                ran=d1.deal(Cards);
                U1.myCard=U1.setCard(ran, Cards);
                d1.Delete(ran, Cards);
                usum=U1.open(U1.myCard);
                us=U1.checkSum(usum);
                if(usum>21){
                    bust=true;
                    break;
                    }
                
            }
            //ディーラーのヒット
            if(ds == true){
                ran=d1.deal(Cards);
                d1.myCard=d1.setCard(ran, Cards);
                d1.Delete(ran, Cards);
                dsum=d1.open(d1.myCard);
                ds=d1.checkSum(dsum);
            }   
        }
        //勝敗判定
        if(bust==true){
            System.out.println("プレイヤーがバースト");
            System.out.println("ディーラーの勝ち");
        }else{
            System.out.println("ディーラーの合計:"+dsum);
            System.out.println("プレイヤーの合計:"+usum);
        if(dsum>22){
            System.out.println("プレイヤーの勝ち");
        }else if(dsum>usum){
            System.out.println("ディーラーの勝ち");
        }else if(usum>dsum){
            System.out.println("プレイヤーの勝ち");
        }else if(usum==dsum){
            System.out.println("引き分け");
        }
        else System.out.println("エラー");
        }
    }
}
