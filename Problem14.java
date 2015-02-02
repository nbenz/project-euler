public class Problem14 {
    public static void main(String[] args) {
        Problem14 p = new Problem14();
        long time = System.currentTimeMillis();
        p.run();
        System.out.println("Time: " + (System.currentTimeMillis()-time));  
    }
    
    public void run(){
      int longestSeq = 0;
      int longest = 0;
      int temp;
      
      for(int i=999999; i>1; i--) {
          temp = collatzSequence(i);
          if(temp > longestSeq) {
              longest = i;
              longestSeq = temp;
          }
      }
      
      System.out.println(longest);
    }
    
    public int collatzSequence(long n) {
        int count = 1;
        do {
            if(n%2==0) {
                n /= 2;
            }
            else {
                n = 3*n+1;
            }
            count++;
        }while(n > 1);
        
        return count;
    }
}