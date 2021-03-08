package suanfa.字符串练习;
//计算1到某个数有多少个一
public class Yi {

    public static int jisuan(int n) {
        int count = 0;

        for (int i = n;  n>=1; n--) {  //n=123
            int len = String.valueOf(n).length();
            int temp = n;
            while(len > 0) {
                int ge =  temp%10;
                if(ge == 1) {
                    count++;
                }
                temp = temp/10;
                len--;
            }
        }

        return count;
    }




    public static void main(String[] args) {
        int jisuan = jisuan(123);
        System.out.println(jisuan);
    }
}
