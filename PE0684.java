public class PE0684 {
    public static int s(int n) {
        int nmod9=n%9;
        int ndiv9=n/9;
        int ans=0;
        for (int i=0; i<ndiv9; i++) {
            ans=10*ans+9;
        }
        return nmod9*(ans+1)+ans;
    }

    public static int sumOfS(int n) {
        int ans=0;
        for (int i=1; i<=n; i++) {
            ans+=s(i);
        }
        return ans;
    }
    public static void main (String[] args) {
        System.out.println(s(10));
        System.out.println(sumOfS(20));
    }
}
