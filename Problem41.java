public class Problem41{
   long time;
   public static void main(String[] args){
      Problem41 p = new Problem41();
      p.run();
   }
   public void run(){
      time = System.currentTimeMillis();
      String str = "987654321";
      for(int i=0; i<str.length(); i++){
         permute(str);
         str = str.substring(1,str.length());
      }
   }
   public void permute(String str){
      permute("", str);
   }
   public void permute(String prefix, String str){
      int n = str.length();
      if(n==0)
         handle(prefix);
      else{
         for(int i=0; i<n; i++){
            permute(prefix+str.charAt(i), str.substring(0,i)+str.substring(i+1,n));
         }
      }   
   }
   public void handle(String str){
      long n = Long.parseLong(str);
      if(isPrime(n)){
         System.out.println(n);
         System.out.println("Time: " + (System.currentTimeMillis()-time));
         System.exit(0); //Well this is fucking terrible.
      }
   }
   public boolean isPrime(long n){
      if(n<=3)
         return n>1;
      else if (n%2 == 0 || n%3 == 0)
         return false;
      else{
         for(int i=5; i*i<=n; i+= 6){
            if(n%i==0 || n%(i+2)==0)
               return false;
         }
         return true;
      }      
   }
}