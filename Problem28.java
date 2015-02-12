//Runs in ~0ms. This literally took less than 1 minute to write.
public class Problem28 {
   public static void main(String[] args){
      Problem28 p = new Problem28();
      long time = System.currentTimeMillis();
      p.run(1001);
      System.out.println("Time: " + (System.currentTimeMillis()-time));
   }
   //n should be odd
   public void run(int n){
      int sum = 1;
      int pos = 1; //Position on the number line... not a great name.
      for(int i=3; i<=n; i+=2){ //i is what layer of the spiral you are in
         for(int j=0; j<4; j++){ //once for each corner
            pos += (i-1);
            sum += pos;
         }
      }
      System.out.println("Sum: " + sum);
   }
}