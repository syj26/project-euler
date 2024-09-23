public class PE0097 {
    public static int[] binaryArray(int n) { //assumes n>=0, n<2^31 (n is an int duh)
        int num=n;
        int[] ans=new int[31];
        for (int i=0; (i<31 || num!=0); i++) {
            if (num%2==1) { //checks if last binary digit is 1
                ans[i]=1;
                num=(num-1)/2; //equivalent to truncating last digit in binary rep
            }
            else {
                ans[i]=0;
                num/=2; //truncate last binary digit
            }
        }
        return ans; //this is "backwards", ans[i] corresponds to 2^i
    }
    
    public static int[] cleanBinaryArray(int n) {
        int[] binaryRep = binaryArray(n);
        int indexOfLeftmostNonzero=0;
        boolean done=false;
        for (int i=30; i>=0 && !done; i--) {
            if (binaryRep[i]==1) {
                indexOfLeftmostNonzero=i;
                done=true;
            }
        }
        if (!done) {indexOfLeftmostNonzero=0;} //case when n=0
        if (indexOfLeftmostNonzero==30) {return binaryRep;}
        int[] ans=new int[indexOfLeftmostNonzero+1];
        for (int i=0; i<indexOfLeftmostNonzero+1; i++) {
            ans[i]=binaryRep[i];
        }
        return ans;
    }

    public static int powModN(int base, int exp, int n) {
        int[] expBinary = cleanBinaryArray(exp);
        int[] modNValues = new int[expBinary.length]; 
        //basically, each value is base^(2^i) mod n 
        //chat was it a mistake to make the binary rep array go forwards... (it was)
        modNValues[modNValues.length-1]=base;
        for (int i=modNValues.length-2; i>=0; i--) {
            modNValues[i]=modNValues[i+1]*modNValues[i+1];
        }
        return 0;
    }
    public static void testCases(int n) {
        System.out.print("the binary rep of "+n+" is ");
        for (int i=0; i<31; i++) {
            System.out.print(binaryArray(n)[i]);
        }
        System.out.print("\n");
        for (int i=0; i<cleanBinaryArray(n).length; i++) {
            System.out.print(cleanBinaryArray(n)[i]);
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        testCases(0);
        testCases(15);
        testCases(8);
        testCases(2024);
        testCases((int)Math.pow(2, 30)-1+(int)Math.pow(2, 30));
    }
}
