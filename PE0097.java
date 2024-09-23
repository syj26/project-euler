public class PE0097 {
    public static int[] binaryArray(int n) { //assumes n>=0, n<2^31 (n is an int duh)
        int num=n;
        int[] ans=new int[32];
        for (int i=0; (i<32 || num==0); i++) {
            if (num%2==1) { //checks if last binary digit is 1
                ans[i]=1;
                num=(num-1)/2; //equivalent to truncating last digit in binary rep
            }
            else {
                ans[i]=0;
                num/=2; //truncate last binary digit
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
