public class Move_Hyphen_to_begining {
    public static void main(String args[]){
        String str="a-b-c-d";

        StringBuilder hyp=new StringBuilder();
        StringBuilder rem=new StringBuilder();
        
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch=='-'){
                hyp.append(ch);
            }else{
                rem.append(ch);
            }
        }

        System.out.println(hyp.toString()+rem.toString());
    }
}
