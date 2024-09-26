import java.util.ArrayList;
import java.util.List;

public class PE0010 {
    public static int[] first250primes() {
        int[] ans = new int[250];
        for (int i=0; i<250; i++) {
            ans[i]=Prime.nthPrime(i);
        }
        return ans;
    }
    /* 
    public static boolean isPrimeButBigger(int n) {
        //assume n is less than ~2 million, and larger than 1583 (250th prime)
        double sqrtn=Math.sqrt(n);
        for (int i=0; first250primes()[i]<=sqrtn; i++) {
            if (n%first250primes()[i]==0) {return false;}
        }
        return true;
    }
    */
    /* 
    public static int nthPrimeButForReallyBigNumbers(int n) {
        //assume n to be 250 or greater
        int count=249; int i=1583;
        while (count<=n) {
            if (isPrimeButBigger(i)) {count++;}
            i++;
        }
      return i-1;
    }
      */
    public static void main(String[] args) {
        int[] first250p = first250primes();
        System.out.println(first250p[249]);
        
        int[] nums=new int[2000001];
        for (int i=0; i<=2000000; i++) {
            nums[i]=i;
        }
        for (int i=0; i<250; i++) {
            for (int j=2; j<=2000000/first250p[i]; j++) {
                nums[first250p[i]*j]=0;
            }
        }
        nums[1]=0;
        long sum=0;
        for (int i=0; i<2000000; i++) {
            sum=Long.sum(sum, (long) nums[i]);
        }
        System.out.print(sum);
        /*long sum=0;
        for (int i=0; Prime.nthPrime(i)<10; i++) {
            sum+=Prime.nthPrime(i);
        }
        System.out.println(sum);*/
    }
}
