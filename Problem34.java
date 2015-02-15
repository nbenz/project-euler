//Runs in 0ms
public class Problem34 {
   public static void main(String[] args){
      Problem34 p = new Problem34();
      long time = System.currentTimeMillis();
      p.run();
      System.out.println("Time: " + (System.currentTimeMillis()-time));
   }
   public void run(){
      int[] factorial = new int[10];
      factorial[0] = 1;
      for(int a=1; a<10; a++) //DP for generating factorials 0-9
         factorial[a] = a*factorial[a-1];
         
      int n = 99999; 
      int total = 0;
      for(int i=3; i<n; i++){
         int temp = i;
         int check = 0;
         while(temp > 0 ) { //This should be pretty self explanatory
            check += factorial[temp%10];
            temp = temp/10;
         }   
         if(check == i)
            total += check;
      }
      System.out.println("Sum: " + total);
   }
}