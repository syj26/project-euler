public class PE3 {
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

  public static void largestPrimeFactor(long n) {
    long ans=1; boolean composite=false; long productTracker=1;
    for (int i=0; nthPrime(i)<=Math.sqrt(n) && (productTracker != n); i++) {
      if (n%nthPrime(i)==0) {
        ans=nthPrime(i);
        composite=true;
        productTracker*=nthPrime(i);
        System.out.println(nthPrime(i));
      }
    }
    if (composite==false) {System.out.println("lpf is "+n);}
    else {System.out.println("lpf is "+ans);}
  }
  public static void main(String[] args) {
    /* System.out.println(isPrime(2));
    System.out.println(isPrime(3));
    System.out.println(isPrime(4));
    System.out.println(isPrime(5));
    System.out.println(isPrime(6));
    System.out.println(nthPrime(0));
    System.out.println(nthPrime(1));
    System.out.println(nthPrime(2));
    System.out.println(nthPrime(3));
    System.out.println(nthPrime(4)); */
    largestPrimeFactor(600851475143L);
  }
}


