class Solution {
    public int findPivot(int[] nums) {
        //using the concept of prefix sum. 
        int leftSum[]=new int[nums.length];
        int rightSum[]=new int[nums.length];

        //store the left sum excluding the current sum.
        int sum=0;
        leftSum[0]=0;
        for(int i=1;i<nums.length;i++){
            sum=sum+nums[i-1];
            leftSum[i]=sum;
        }

        sum=0;
        rightSum[nums.length-1]=0;
        for(int i=nums.length-2;i>=0;i--){
            sum=sum+nums[i+1];
            rightSum[i]=sum;
        }

        for(int i=0;i<nums.length;i++){
            if(leftSum[i]==rightSum[i]){
                return i;
            }
        }return -1;
    }
}