public class PE0006 {
    public static int sumSquareDifference(int n) {
        return n*n*(n+1)*(n+1)/4-n*(n+1)*(2*n+1)/6;
    }

    public static void main(String[] args) {
        System.out.println(sumSquareDifference(10));
        System.out.println(sumSquareDifference(100));
    }
}
