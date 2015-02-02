import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Problem67 {
   int[][] tree;
   int[][] cache;
   
   public static void main(String[] args) {
      Problem67 p = new Problem67();
      File file = new File("p67data.txt");
      System.out.println(p.maxPathSum(file, 100));   
   
   }
   
   /* File contains number tree in format:
      X
      XX
      XXX
      
      Must pass the depth of the tree. I could check for it, but meh.
    */
   public int maxPathSum(File file, int depth) {
      tree = new int[depth][depth];
      cache = new int[depth][depth];
      
      //Read file into array
      try {
         Scanner fr = new Scanner(new FileReader(file));
         
         while(fr.hasNextLine()){
         for(int i=0; i<depth; i++){
            for(int j=0; j<=i; j++){
               tree[i][j] = fr.nextInt();
            }
         }
      }
      }catch(Exception e){}
      
      //Fill bottom of cache
      for(int k=0; k<depth; k++){
         cache[depth-1][k] = tree[depth-1][k];
      }
      
      //Fill cache tree
      for(int a=depth-2; a>=0; a--){
         for(int b=0; b<=a; b++){
            if(cache[a+1][b] > cache[a+1][b+1])
               cache[a][b] = cache[a+1][b] + tree[a][b];
               
            else
               cache[a][b] = cache[a+1][b+1] + tree[a][b];
         }
      }
      return cache[0][0];
   }
}