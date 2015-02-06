public class Problem1 {
   public static void main(String[] args){
      long time = System.currentTimeMillis();
      int sum = 0;
      for(int i=1; i<1000; i++){
         if(i%3==0 || i%5==0)
            sum += i;
      }
      System.out.println("Sum: " + sum);
      System.out.println("Time: " + (System.currentTimeMillis()-time));
   }
}