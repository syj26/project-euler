public class PE4 {
    /* 
    observations: a product of 2 3-digit numbers is either 5 or 6 digits
    first notice that there EXISTS a construction (405504=512*792),
    so 6 digits is possible.
    since we're looking for the MAXMIMUM, we only care about 6 digit numbers
    now, let the palindrome be abccba
    we cycle through values of abc decreasing from 999
    */
    public static void largestPalindroneProduct() {
        boolean done=false;
        for (int abc=999; abc>=100 && !done; abc--) {
            int abccba = 100001*(abc/100)+10010*(abc/10 % 10)+1100*(abc % 10);
            for (int i=999; i>=100 && !done; i--) {
                if (abccba % i == 0 && abccba/i<1000) {
                    System.out.println(abccba+"="+i+"*"+abccba/i);
                    done=true;
                }
            }
        }
    }
    public static void main(String[] args) {
        largestPalindroneProduct();
    }
}
