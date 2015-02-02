import java.math.BigInteger;

public class Problem16 {
    public static void main(String[] args){
        Problem16 p = new Problem16();
        long time = System.currentTimeMillis();
        System.out.println("Sum: " + p.powerDigitSum(2,1000));
        System.out.println("Time: " + (System.currentTimeMillis()-time));
    }
    
    /* x^y
       Trying this without BigInteger (even though this is pretty much BigInteger...)
       x must be a single digit */ 
       
    public int powerDigitSum(int x, int y) {
        int sum = 0;
        int digits = (int) Math.floor(y*Math.log10(x)+1);
        int[] largeNumber = new int[digits];
        
        largeNumber[0]=x;
        
        for(int i=1; i<y; i++){
            for(int j=0; j<digits; j++){
                largeNumber[j] = largeNumber[j]*x;
            }
            for(int k=0; k<digits-1; k++){
                if(largeNumber[k]>9){
                    largeNumber[k+1] += largeNumber[k]/10;
                    largeNumber[k] = largeNumber[k]%10;    
                }
            }
        }
        
        for(int a=0;a<digits;a++){
            sum += largeNumber[a];
        }
        return sum;
    }
}