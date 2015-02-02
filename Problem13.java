import java.util.Scanner;
import java.io.File;
import java.math.BigInteger;

public class Problem13 {
   public static void main(String[] args) {
      Problem13 p = new Problem13();
      long time = System.currentTimeMillis();
      p.run();
      System.out.println("Time: " + (System.currentTimeMillis()-time));
   }
   public void run(){
      File file = new File("p13data.txt");
      Scanner numfile;
      try{
         numfile = new Scanner(file);
      }
      catch(Exception e){
         System.out.println("Add the file idiot.");
         return;
      };
      BigInteger line;
      BigInteger sum = BigInteger.ZERO;
      String result;
      do {
         line = new BigInteger(numfile.nextLine());
         sum = sum.add(line);
         
      }while(numfile.hasNextLine());
      
      result = sum.toString();
      System.out.println(result.substring(0,10));
   }
}