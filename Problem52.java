import java.util.Arrays;

public class Problem52 {
   public static void main(String[] args){
      Problem52 p = new Problem52();
      long time = System.currentTimeMillis();
      p.run();
      System.out.println();
      System.out.println("Time: "+(System.currentTimeMillis()-time));
   }
   
   public void run(){
      boolean found = false;
      int power = 0;
      int x=0;
      int max;
      
      while(!found){
         power++;
         x = (int)Math.pow(10,(power-1));
         max = (int)Math.pow(10,power)/6;
         while(x<max && !found){
            x++; //This is ok because 10^n will never work.
            found =  sameDigits(x,2*x) &&
                     sameDigits(2*x,3*x) &&
                     sameDigits(3*x,4*x) &&
                     sameDigits(4*x,5*x) &&
                     sameDigits(5*x,6*x);
         }
      }
      System.out.println(" x = "+x+"\n2x = "+2*x+"\n3x = "+3*x+"\n4x = "+4*x+"\n5x = "+5*x+"\n6x = "+6*x);
   }
   
   public boolean sameDigits(int n, int m) {
      char[] nDigits = String.valueOf(n).toCharArray();
      char[] mDigits = String.valueOf(m).toCharArray();
      
      Arrays.sort(nDigits);
      Arrays.sort(mDigits);
      
      return Arrays.equals(nDigits,mDigits);  
   }
}