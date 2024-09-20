public class PE0009 {
    /*
    ngl typing these out gets kinda annoying when they're not very cs-y problems
    anyway
    we use the 2rs, r^2-s^2, r^2+s^2 pythag triple generating formula
    so their sum is 2r^2+2rs, which is 2r(r+s), which must divide 1000
    (i'm accounting for scalar multiples bc this formula assumes relprime)
    anyway we need r(r+s) | 500, and r>s
    i guess we could do r=20 and s=5?? i mean the problem gives us uniqueness so haha
    */
    public static void main(String[] args) {
        int r=20; int s=5;
        int a=2*r*s; int b=r*r-s*s; int c=r*r+s*s;
        System.out.println(a+", "+b+", "+c);
        System.out.println(a*b*c);
    }
}
