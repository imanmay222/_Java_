public class Longest_bit_flipping_1 {
    public static void main(String args[]){
        String bin="11011101111";
        int curr=0;
        int prev=0;
        int maxLength=0;

        for(char bit:bin.toCharArray()){
            if(bit=='1'){
                curr++;
            }else{
                maxLength=Math.max(maxLength,prev+curr+1);
                prev=curr;
                curr=0;
            }
        }
        maxLength=Math.max(maxLength,prev+curr+1);
        maxLength=Math.min(maxLength,bin.length());
        System.out.println(maxLength);
    }
}
