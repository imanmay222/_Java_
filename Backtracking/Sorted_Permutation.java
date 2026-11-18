
import java.util.TreeSet;

public class Sorted_Permutation {
    static TreeSet<String> hs=new TreeSet<>();
    static void permutation(String str,String ans){
        if(str.length()==0){
            hs.add(ans);
            return;
        }

        for(int i=0;i<str.length();i++){
            char curr=str.charAt(i);
            String newStr=str.substring(0,i)+str.substring(i+1);
            permutation(newStr, ans+curr);
        }

    }
    public static void main(String args[]){

        permutation("BAA","");
        for(String s:hs){
            System.out.println(s);
        }
    }
}
