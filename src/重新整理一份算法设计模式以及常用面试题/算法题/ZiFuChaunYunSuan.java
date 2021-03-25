package 重新整理一份算法设计模式以及常用面试题.算法题;

import java.util.HashMap;

/**
 * 字符串运算 k*[]
 * "3*[a2*[c]]"==》"accaccacc"
 *
 * 任务未完成！！！
 */
public class ZiFuChaunYunSuan {

    public static String computeString (String str) {
        int rear = str.length()-1;
        HashMap<String,String> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        while(rear >= 0 ) {
            char c = str.charAt(rear);
            System.out.println(c);
            if(str.charAt(rear) == '[') {
                Character beishu = str.charAt(rear - 2);
                int i = Integer.parseInt(beishu.toString());
                for (int j = 0; j < i; j++) {
                    sb.append(str.charAt(rear+1));
                }
            }
            rear--;
        }
        return null;
    }

    public static void main(String[] args) {
        computeString("2*[e3*[a]]");
    }
}
