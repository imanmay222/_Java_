class Solution {
    int k=0;
    void append(List<Integer> list,int arr[]){
        for(int i=0;i<list.size();i++){
            arr[k++]=list.get(i);
        }
    }
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> left=new ArrayList<>();
        List<Integer> mid=new ArrayList<>();
        List<Integer> right=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==pivot){
                mid.add(pivot);
            }else if(nums[i]<pivot){
                left.add(nums[i]);
            }else{
                right.add(nums[i]);
            }
        }

        append(left,nums);
        append(mid,nums);
        append(right,nums);

        return nums;
        
    }
}