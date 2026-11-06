class Solution {
    public int magicalString(int n) {
        String s="122";
        int i=2;
        int ct=1;
        char t='1';
        while(i<n){
            if(s.length()==n){
                break;
            }
            if(s.charAt(i)=='2'){
                s=s+t+t;
            }else if(s.charAt(i)=='1'){
                ct++;
                s=s+t;
            }
            //toggle the value
            if(t=='1'){
                t='2';
            }

            else if(t=='2'){
                t='1';
            }
            i++;
        }

        while(i<n){
            if(s.charAt(i)=='1'){
                ct++;
            }
            i++;
        }return ct;
    }
}