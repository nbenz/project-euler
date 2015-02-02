public class Problem36{
   public static void main(String[] args){
      Problem36 p = new Problem36();
      long time = System.currentTimeMillis();
      p.run();
      System.out.println("Time: " + (System.currentTimeMillis()-time));
   }
   public void run(){
      int n = 1000000;
      int sum = 0;

      for(int i=1; i<n; i++){
         if(palindrome(Integer.toString(i))&&palindrome(Integer.toBinaryString(i)))
            sum += i;               
      }
      System.out.println(sum);
   }
   public boolean palindrome(String n){
      int b = n.length()-1;
      
      for(int i=0; i<=b/2; i++){

         if(n.charAt(i) != n.charAt(b-i))
            return false;
      }
      return true;
   }
}