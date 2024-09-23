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

    public static long powModN(int base, int exp, int n) {
        int[] expBinaryRep = cleanBinaryArray(exp);
        long[] modNValues = new long[expBinaryRep.length]; 
        long ans=1;
        //basically, each value is base^(2^i) mod n 
        //chat was it a mistake to make the binary rep array go forwards... (it was)
        //(i made it go backwards again yayyy)
        modNValues[0]=(long) base%n;
        for (int i=1; i<modNValues.length; i++) {
            modNValues[i]=(modNValues[i-1]*modNValues[i-1])%n;
        }
        for (int i=0; i<modNValues.length; i++) {
            if (expBinaryRep[i]==1) {
                ans*=modNValues[i];
                ans%=n;
            }
        }
        return ans;
    }
    public static void testCasesBinary(int n) {
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

    public static void testCasesPowModN(int base, int exp, int n) {
        System.out.print(base + "^" + exp + " mod " + n + " is ");
        System.out.println(powModN(base, exp, n));
    }

    public static void main(String[] args) {
        testCasesBinary(0);
        testCasesBinary(15);
        testCasesBinary(8);
        testCasesBinary(2024);
        testCasesBinary((int)Math.pow(2, 30)-1+(int)Math.pow(2, 30));
        testCasesPowModN(2, 5, 1000);
        testCasesPowModN(3, 8, 1000);
        testCasesPowModN(4, 6, 1000);
        testCasesPowModN(5, 4, 1000);
        int expmod5to9 = 7830457 % (4*(int) Math.pow(5, 9)); //euler's thm phi(5^10)=4*5^9
        System.out.println("exponent mod phi(5^10) is " + expmod5to9);
        int fiveto10 = (int) Math.pow(5, 10);
        System.out.println("2 to the big thing is " + powModN(2, expmod5to9, fiveto10));
        testCasesPowModN(2, expmod5to9, fiveto10);
        long answer=Long.sum((28433L*powModN(2, expmod5to9, fiveto10))%fiveto10, 1L);
        System.out.println("answer is " + answer + " mod 5^10");
        System.out.println("answer mod 5^10 is " + answer%1024 + " mod 2^10"); //gonna use crt, manually bc i don't wanna code anymore
        System.out.println("5^10 is " + fiveto10%1024 + " mod 2^10");
        for (int i=0; i<1024; i++) {
            if ((627+761*i)%1024==0) {System.out.println("627+761*"+i+" == 0 mod 1024");}
        }
        System.out.print("ACTUAL answer is " + (answer+53*fiveto10));
    }
}
