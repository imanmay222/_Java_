class NumArray {
    int arr[];
    int tree[];
    //function to build the segment tree.
    public void buildTree(int i,int si,int sj,int nums[]){
        //base case
        if(si==sj){
            tree[i]=nums[si];
            return;
        }
        int mid=si+(sj-si)/2;
        buildTree(2*i+1,si,mid,nums);
        buildTree(2*i+2,mid+1,sj,nums);
        tree[i]=tree[2*i+1]+tree[2*i+2];
    }
    public NumArray(int[] nums) {
        arr=nums;
        tree=new int[4*nums.length];
        buildTree(0,0,nums.length-1,nums);
    }

    public void updateUtil(int i,int si,int sj,int diff,int index){
        
        //check whether index lies outside the range.
        if(si>index || index>sj){
            return;
        }

        tree[i]=tree[i]+diff;

        //base cond
        if(si==sj){
            return;
        } //no need to traverse furthur
        int mid=si+(sj-si)/2;
        updateUtil(2*i+1,si,mid,diff,index);
        updateUtil(2*i+2,mid+1,sj,diff,index);
    }
    
    public void update(int index, int val) {
        int diff=val-arr[index];
        arr[index]=val;

        updateUtil(0,0,arr.length-1,diff,index);
    }

    public int sumUtil(int i,int si,int sj,int qi,int qj){
        //check 3 conditions : 
        //i> not overlapping at all. 
        if(sj<qi || qj<si){
            return 0;
        }
        //ii> completely overlapping
        if(qi<=si && sj<=qj){
            return tree[i];
        }
        //iii> partially overlapping
        else{
            int mid=si+(sj-si)/2;
            return sumUtil(2*i+1,si,mid,qi,qj)+sumUtil(2*i+2,mid+1,sj,qi,qj); //computes left and write and returns back.
        }
    }
    
    public int sumRange(int left, int right) {
        return sumUtil(0,0,arr.length-1,left,right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */