//Runs in ~0ms
public class Problem26 {
   public static void main(String[] args){
      Problem26 p = new Problem26();
      long time = System.currentTimeMillis();
      p.run(1000);
      System.out.println("Time: " + (System.currentTimeMillis()-time));
   }
   
   /*
      Calculate the sequence r0 = 1 % n
                             r1 = r0*10 % n
                             r2 = r1*10 % n
                             ...
      which checks the remainder at each decimal position. Store the
      result remainderFound. Once you get back to something you've seen
      you have found the repeating cycle.  
   */
   public void run(int n){
      int length = 0;
      int d = 0;
      for(int i=n; i>length; i--){
         int[] remainderFound = new int[i];
         int position = 0;
         int numerator = 1;
         
         while(remainderFound[numerator] == 0 && numerator != 0){
            remainderFound[numerator] = position;
            numerator *= 10;
            numerator %= i;
            position++;
         }
         if(position - remainderFound[numerator] > length) {
            length = position - remainderFound[numerator];
            d = position;
         }   
      }
      System.out.println("Result: 1/"+d+"\n"+"Length: "+length);
   }
}