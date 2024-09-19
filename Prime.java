public class Prime {
    public static boolean isPrime(int n) {
      if (n==1) {return false;}
      for (int i=2; i<=Math.sqrt(n); i++) {
        if (n%i==0) {return false;}
      }
      return true;
    }
  
    public static int nthPrime(int n) {
      int count=0; int i=1;
      while (count<=n) {
        if (isPrime(i)) {count++;}
        i++;
      }
      return i-1;
    }
  }