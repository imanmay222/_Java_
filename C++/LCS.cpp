#include<iostream>
#include<string>
#include<algorithm>

using namespace std;

int main(){
    string str1,str2;
    cout<<"Enter string 1 and 2 : "<<endl;
    cin>>str1>>str2;

    int n=str1.length();
    int m=str2.length();

    vector<vector<int>> dp(n+1,vector<int>(m+1,0));

    for(int i=1;i<n+1;i++){
        for(int j=1;j<m+1;j++){
            if(str1[i-1]==str2[j-1]){
                dp[i][j]=1+dp[i-1][j-1];
            }else{
                dp[i][j]=max(dp[i-1][j],dp[i][j-1]);
            }
        }
    }
    cout<<"LCS : "<<dp[n][m];
}