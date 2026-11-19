
import java.util.*;

class Weighted_Strings {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter weight : ");
        long weight=sc.nextLong();
        sc.close();
        long w[]=new long[26];

        w[0]=1;
        for(int i=1;i<26;i++){
            if(w[i-1]>weight/(i+1)){
                break;
            }
            w[i]=w[i-1]*(i+2);
        }

        StringBuilder sb=new StringBuilder();

        for(int i=25;i>=0;i--){
            if(w[i]==0){
                continue;
            }
            long ct=weight/w[i];

            for(int j=0;j<ct;j++){
                sb.append((char)('A'+i));
            }

            weight%=w[i];
        }

        char res[]=sb.toString().toCharArray();
        Arrays.sort(res);
        System.out.println(new String(res));
    }
}
