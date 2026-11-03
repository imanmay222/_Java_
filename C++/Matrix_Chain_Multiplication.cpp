#include<iostream>
#include<climits>
#include<algorithm>
#include<vector>

using namespace std;

int mcm(int arr[],int i,int j,vector<vector<int>> &dp){
    
    if(i==j){
        return 0;
    }

    if(dp[i][j]!=-1){
        return dp[i][j];
    }
    int ans=INT_MAX;
    for(int k=i;k<j;k++){
        int cost1=mcm(arr,i,k,dp);
        int cost2=mcm(arr,k+1,j,dp);
        int cost3=arr[i-1]*arr[k]*arr[j];
        ans=min(ans,cost1+cost2+cost3);
    }
    return dp[i][j]=ans;
}

int main(){
    int arr[]={10, 20, 30, 40, 30};
    int n=5;
    vector<vector<int>> dp(n,vector<int>(n,-1));
    cout<<"MCM is : "<<mcm(arr,1,n-1,dp);
}