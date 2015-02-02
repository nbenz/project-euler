public class Problem20 {
   public static void main(String[] args){
      //100! has 100/5 + 100/25 trailing 0s
      long n = 1;
      
      for(int i=2; i<101; i++){
         n *= i;
            
      }
   
   }
   /* Fix this later
   public int reducedFact(int n) {
      int result = 1;
      
      for(int i=n; i>1; i++){
         
      }
   }*/
}