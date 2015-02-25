import java.util.HashSet;
//Runs in about 1.37s
public class Problem72 {
   public static void main(String[] args){
      Problem72 p = new Problem72();
      long time = System.currentTimeMillis();
      p.run(1000000);
      System.out.println("Time: " + (System.currentTimeMillis()-time));
   }
   public void run(int n){
      long elements = 0;
      for(int i=2; i<=n; i++){
         elements += totient(i);
      }
      System.out.println("Distinct fractions between 1/"+n+" and "+(n-1)+"/"+n+":");
      System.out.println(elements);
   }
   public int totient(int n){ //Euler's totient function
      HashSet<Integer> dpf = new HashSet<Integer>(); //Distinct prime factors
      int phi = n;
      
      for(int i=2; i<=n/i; i++){
         while(n%i==0){
            dpf.add(i);
            n /= i;
         }
      }
      if(n > 1)
         dpf.add(n);
         
      for(int j : dpf){
         phi *= (1-1/(double)j);
      }
      return phi;
   }
}