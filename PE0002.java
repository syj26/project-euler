public class PE2 {
  public static int fib(int n) {
    if (n==0) {return 1;}
    if (n==1) {return 2;}
    return fib(n-1)+fib(n-2);
  }
  public static void main(String[] args) {
    int sum=0;
    for (int n=1; fib(n)<=4000000; n+=3) {
      sum+=fib(n);
    }
    System.out.print(sum);
  }
}
