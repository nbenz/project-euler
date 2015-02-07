import java.util.HashSet;

//Runs in ~105ms

public class Problem47{
   public static void main(String[] args){
      Problem47 p = new Problem47();
      long time = System.currentTimeMillis();
      p.run();
      System.out.println("Time: " + (System.currentTimeMillis()-time));
   }
   public void run(){
      boolean found = false;
      int i=33508;
      while(!found){
         found = true;
         for(int j=i; j<i+4; j++){
            if(distinctPrimeFactors(j) != 4){
               found = false;
               i += ((j+1)-i);
               break;
            }
         }
      }
      System.out.println("Result: " + i); 
   }
   
   public int distinctPrimeFactors(int n){
      HashSet<Integer> pFactors = new HashSet<Integer>();
      for(int i=2; i<=(n/i); i++){
         while(n%i == 0){
            pFactors.add(i);
            n /= i;
         }
      }    
      if(n>1){
         pFactors.add(n);
      }
      return pFactors.size();
   }
}  