public class Functions {
    public static void printArray(int[] nums) {
      String ans="[";
      for (int i=0; i<nums.length; i++) {
        ans+=nums[i];
        if (i<nums.length-1) {ans+=", ";}
      }
      ans+="]";
      System.out.println(ans);
    }
  }