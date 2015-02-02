public class Problem30 {
   public static void main(String[] args){
      Problem30 p = new Problem30();
      
      int sum = 0;
      int tempSum;
      int temp;
      int n = 2;
      int d;
      
      long time = System.currentTimeMillis();
      
      for(int i=2; i<355000; i++){
         n=i;
         tempSum = 0;
         while(n>0){
            d = n%10;
            n /= 10;
            
            temp = d;
            for(int j=1;j<5;j++){  //Replaces Math.pow. Over 250ms faster!
               temp *= d;   
            }
            tempSum += temp;   
         }
         if(tempSum == i){
            sum += i;
         }   
      }      
      System.out.println("Time: " + (System.currentTimeMillis()-time));
      System.out.println("Sum: " + sum);
      
   }
}