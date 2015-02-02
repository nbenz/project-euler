public class Problem15 {
    public static void main(String[] args) {
      Problem15 p = new Problem15();
      long time = System.currentTimeMillis();
      p.run();
      System.out.println("Time: " + (System.currentTimeMillis()-time));    
    }
    public void run(){
      int size = 20;
      long paths = 1;
       
      for(int i=0; i<size; i++) {   //Paths is just a combination...
          paths *= (2*size)-i;
          paths /= i+1;
      }
      System.out.println(paths);
    }
}