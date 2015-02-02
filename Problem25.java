//Easy...

import java.math.BigInteger;

public class Problem25 {
   public static void main(String[] args){
      Problem25 p = new Problem25();
      int n = 10000000;
      
      long time = System.currentTimeMillis();
      System.out.println(p.fibOfLength(n));
      System.out.println("Time: " + (System.currentTimeMillis()-time));
      
      /*time = System.currentTimeMillis();
      System.out.println(p.bruteFibOfLength(n));
      System.out.println("Time: " + (System.currentTimeMillis()-time));*/
   }
   //Math
   public int fibOfLength(int n) {
      double phi = 1.6180339887498948482045868343656381177203091798057628621354486227052604628189;
      
      return (int) Math.ceil(((n-1)+(Math.log10(5))/2)/Math.log10(phi));
   }
   
   //Brute force
   public int bruteFibOfLength(int n){
      int count = 2;
      
      BigInteger a1 = new BigInteger("1");
      BigInteger a2 = new BigInteger("1");
      BigInteger a3 = new BigInteger("0");
      
      while(a3.toString().length() < n){
         a3 = a2.add(a1);
         a1 = a2;
         a2 = a3; 
         count++;
      }
      return count;  
   }
}