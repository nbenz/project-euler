public class Problem4 {
   public static void main(String[] args){
      Problem4 p = new Problem4();
      boolean found = false;
      int palindrome = -1;
      
      long time = System.currentTimeMillis();
    
      for(int i=999; i>100; i--){
         for(int j=i; j>100; j--){
            if(i*j>palindrome && p.isPalindrome(i*j)){
               palindrome = i*j;
            }      
         }
      }
      System.out.println("Palindrome: " + palindrome);
      System.out.println("Time: " + (System.currentTimeMillis()-time));
   }
   
   public boolean isPalindrome(int n){
      String nString = String.valueOf(n);
      String revString = "";
      
      
      while(n > 0){
         revString += String.valueOf(n%10);
         n /= 10;
      }
      return nString.equals(revString);
   }
}