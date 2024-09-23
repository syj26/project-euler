public class PE0097 {
    public static int[] binaryArray(int n) { //assumes n>=0, n<2^31 (n is an int duh)
        int num=n;
        int[] ans=new int[32];
        for (int i=0; (i<32 || num!=0); i++) {
            if (num%2==1) { //checks if last binary digit is 1
                ans[31-i]=1;
                num=(num-1)/2; //equivalent to truncating last digit in binary rep
            }
            else {
                ans[31-i]=0;
                num/=2; //truncate last binary digit
            }
        }
        return ans;
    }
    
    public static int[] cleanBinaryArray(int n) {
        int[] binaryRep = binaryArray(n);
        int indexOfLeftmostNonzero=0;
        boolean done=false;
        for (int i=0; i<32 && !done; i++) {
            if (binaryRep[i]==1) {
                indexOfLeftmostNonzero=i;
                done=true;
            }
        }
        if (!done) {indexOfLeftmostNonzero=31;} //case when n=0
        if (indexOfLeftmostNonzero==0) {return binaryRep;}
        int[] ans=new int[32-indexOfLeftmostNonzero];
        for (int i=0; i<32-indexOfLeftmostNonzero; i++) {
            ans[i]=binaryRep[indexOfLeftmostNonzero+i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int n=0;
        System.out.print("the binary rep of "+n+" is ");
        for (int i=0; i<32; i++) {
            System.out.print(binaryArray(n)[i]);
        }
        System.out.print("\n");
        for (int i=0; i<cleanBinaryArray(n).length; i++) {
            System.out.print(cleanBinaryArray(n)[i]);
        }
        System.out.print("\n");
        n=15;
        System.out.print("the binary rep of "+n+" is ");
        for (int i=0; i<32; i++) {
            System.out.print(binaryArray(n)[i]);
        }
        System.out.print("\n");
        for (int i=0; i<cleanBinaryArray(n).length; i++) {
            System.out.print(cleanBinaryArray(n)[i]);
        }
        System.out.print("\n");
        n=8;
        System.out.print("the binary rep of "+n+" is ");
        for (int i=0; i<32; i++) {
            System.out.print(binaryArray(n)[i]);
        }
        System.out.print("\n");
        for (int i=0; i<cleanBinaryArray(n).length; i++) {
            System.out.print(cleanBinaryArray(n)[i]);
        }
        System.out.print("\n");
        n=2024;
        System.out.print("the binary rep of "+n+" is ");
        for (int i=0; i<32; i++) {
            System.out.print(binaryArray(n)[i]);
        }
        System.out.print("\n");
        for (int i=0; i<cleanBinaryArray(n).length; i++) {
            System.out.print(cleanBinaryArray(n)[i]);
        }
        System.out.print("\n");
    }
}
