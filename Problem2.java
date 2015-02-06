import java.util.ArrayList;

public class Problem2 {
   ArrayList<Integer> fib = new ArrayList<Integer>();
   
   public static void main(String[] args){
      Problem2 p = new Problem2();
      long time = System.currentTimeMillis();
      p.run();
      System.out.println("Time: " + (System.currentTimeMillis()-time));
   }
   public void run(){
      loadFib();
      long sum = 0;
      for(int i=1; i<fib.size(); i++){
         if(fib.get(i)%2 == 0)
            sum += fib.get(i);
      }
      System.out.println(sum);
   }
   public void loadFib(){
      int n = 4000000;
      int a = 1;
      int b = 1;
      int temp;
      
      fib.add(1);
      fib.add(1);
      while((a+b)<n){
         fib.add(a+b);
         temp = a;
         a = b;
         b = b + temp;
      }
   }
}