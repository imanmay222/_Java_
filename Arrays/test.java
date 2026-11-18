public class test {
    public static void main(String args[]){
        // String str="123";
        // Integer num=Integer.parseInt(str);
        // System.out.println("Integer : "+num);

        // System.out.println(String.valueOf(num));

        // String str1="file1.txt";

        // String list[]=str1.split("\\.");
        // for(String i:list){
        //     System.out.println(i);
        // }

        int num=172;
        String bin=Integer.toBinaryString(num);
        System.out.println("Binary Format is : "+bin);
        
        String upper=bin.substring(0,bin.length()/2);
        String lower=bin.substring(bin.length()/2);

        String newbin=lower+upper;
        System.out.println("Binary is : "+newbin+","+Integer.parseInt(newbin,2));
    }
}
