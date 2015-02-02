public class Problem45 {
   public static void main(String[] args){
      Problem45 p = new Problem45();
      long time = System.currentTimeMillis();
      p.run();
      System.out.println("Time: " + (System.currentTimeMillis()-time));
      System.out.println();
      time = System.currentTimeMillis();
      p.alt();
      System.out.println("Time: " + (System.currentTimeMillis()-time));
   }
   
   
   //16ms
   public void run() {
      long t = 286;
      long p = 165;
      long h = 143;  
     
      while(triangle(t) != pentagon(p) || pentagon(p) != hexagon(h)) {
         if(triangle(t) >= pentagon(p)){
            p++;
         }
         else if(triangle(t) >= hexagon(h)){
            h++;
         }
         else{
            t++;
         }   
      }
      System.out.println("Triangle #" + t + ": " + triangle(t));
   }
   
   //Faster, but doesn't find which triangular number is the solution
   //7ms
   public void alt() {
      long p = 166;
      long h = 144;
      
      while(p*(3*p-1)/2 != h*(2*h-1)){
         if(p*(3*p-1)/2 > h*(2*h-1))
            h++;
         else
            p++;
      }
      System.out.println(h*(2*h-1));
   }
   
   public long triangle(long n) {
      return n*(n+1)/2;
   }
   public long pentagon(long n) {
      return n*(3*n-1)/2;
   }
   public long hexagon(long n) {
      return n*(2*n-1);
   }
}