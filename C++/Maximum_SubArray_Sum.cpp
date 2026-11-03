// Divide and Conquor
#include<iostream>
#include<climits>
using namespace std;

int crossSum(int arr[],int left,int mid,int right){
    int leftsum=INT_MIN;
    int sum=0;
    for(int i=mid;i>=left;i--){
        sum=sum+arr[i];
        leftsum=max(leftsum,sum);
    }


    int rightsum=INT_MIN;
    sum=0;

    for(int i=mid+1;i<=right;i++){
        sum=sum+arr[i];
        rightsum=max(rightsum,sum);
    }

    return leftsum+rightsum;
}


int maxSubArray(int arr[],int left,int right){
    if(left==right){
        return arr[left];
    }

    int mid=left+(right-left)/2;
    int leftMax=maxSubArray(arr,left,mid);
    int rightMax=maxSubArray(arr,mid+1,right);
    int cross=crossSum(arr,left,mid,right);
    return max({leftMax,rightMax,cross});
}

int main(){
    int n;
    cout<<"Enter the array : "<<endl;
    cout<<"Enter the value of n : "<<endl;
    cin>>n;
    int arr[n];
    for(int i=0;i<n;i++){
        cin>>arr[i];
    }

    cout<<"Max : "<<maxSubArray(arr,0,n-1);
    
    return 0;
}