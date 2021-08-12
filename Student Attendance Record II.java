public class Solution {
    long M = 1000000007;
    public int checkRecord(int n) {
        long[] f = new long[n <= 5 ? 6 : n + 1];
        f[0] = 1;
        f[1] = 2;
        f[2] = 4;
        f[3] = 7;
        long k=1;
        for (int i = 4; i <= n; i++){
            
            long x = M - f[i - 4]; //substract with level so %
            long y = (2 * f[i - 1]);
        
            f[i] = (y % M  + x) % M;
            //---------------------------------
            System.out.println("i :" + i);
            System.out.println("x :" + x);
            System.out.println("y :" + y);
           
            //-------------------------------------
            
        }
         System.out.println("f[i] :" + f[n]);
        long sum = f[n];
        for (int i = 1; i <= n; i++) {
            sum += (f[i - 1] * f[n - i]) % M;
        }
        System.out.println("sum :" + (sum - f[n]));
        return (int)(sum % M);
    }
}
