public class Problem21 {
    public static void main(String[] args){
        Problem21 p = new Problem21();
        int[] sums = new int[10001];
        int totalSum = 0;
        
        for(int i=1; i<10000; i++) {
            sums[i] = p.sumDivisors(i);
        }
        
        for(int i=1; i<10000; i++){
            for(int j=i+1; j<10000; j++){
                if(sums[i] == j && sums[j] == i)
                    totalSum += (sums[i]+sums[j]);
            }
        }
        System.out.println(totalSum);
    }
    
    public int sumDivisors(int n) {
        int sum = 1;
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i==0) {
                sum += (i+(n/i));    
            }
        }
        return sum;
    }   
}