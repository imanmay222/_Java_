class Solution {
    void reverse(int arr[],int left,int right){
        while(left<right){
            int temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;

            left++;
            right--;
        }
    }

    public void rotate(int[] nums, int k) {
        if(nums.length>=2){
            reverse(nums,0,nums.length-1);
            int n=k%nums.length;
            reverse(nums,0,n-1);
            reverse(nums,n,nums.length-1);
        }
    }
}