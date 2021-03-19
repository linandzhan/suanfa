package suanfa.字符串练习;

public class ShuJiaXing {

    public static String jiaxing(String str) {



        return null;
    }

    public static void main(String[] args) {
        String str = "abc12d3c9s";
        StringBuilder newstr = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) >=48  && str.charAt(i) <=57) {
                newstr.append("*"+str.charAt(i));
            }else  {
                newstr.append(str.charAt(i));
            }
        }


        System.out.println(newstr);
    }
}
