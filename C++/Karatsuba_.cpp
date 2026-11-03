#include<iostream>
#include<cmath>
#include<string>

using namespace std; 
long long karatsuba(long long n1,long long n2){
    if(n1<10 || n2<10){
        return n1 * n2;
    }

    long long n=max(to_string(n1).length(),to_string(n2).length());
    long long half=n/2;
    long long pow=1;

    for(long long  i=1;i<=half;i++){
        pow=pow*10;
    }
    
    long long a=n1/pow;
    long long b=n1%pow;
    long long c=n2/pow;
    long long d=n2%pow;

    long long ac=karatsuba(a,c);
    long long bd=karatsuba(b,d);
    long long abcd=karatsuba(a+b,c+d);

    long long rem=abcd-ac-bd;

    return ac*pow*pow+rem*pow+bd;



}

int main(){
    long long n1,n2;
    cout<<"Enter n1 n2 : "<<endl;
    cin>>n1>>n2;

    cout<<"Multiptlication is : "<<karatsuba(n1,n2);
    return 0;
}