#include<iostream>
#include<cmath>
#include<vector>

using namespace std;

bool subsetSum(vector<int>& arr, int i, int target,int sum){
    //base case
    if(sum==target){
        return true;
    }

    if(i==arr.size()){
        return false;
    }

    sum=sum+arr[i];
    if(subsetSum(arr,i+1,target,sum)){
        return true;
    }
    sum=sum-arr[i];
    if(subsetSum(arr,i+1,target,sum)){
        return true;
    }
    return false;
}

int main(){
    vector<int> arr={1, 2, 3, 7};
    int target=6;
    int sum=0;
    cout<<"Subset Sum is : "<<subsetSum(arr,0,target,sum);
}