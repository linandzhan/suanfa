package 重新整理一份算法设计模式以及常用面试题.算法题;

import java.util.HashMap;

/**
 * 将罗马数字转为数字
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * 还有六种可能组合
 * IV 4    IX 9
 * XL 40   XC 90
 * CD 400  CM 900
 *
 * 思路：简单粗暴法：将上面13种可能分别用map集合存储
 *                  key存罗马   value存数字
 */
public class LuoMa {

    public static int zhuanhuan(String luoma) {
        HashMap<String,Integer> map = new HashMap<>();
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);//....

        Integer sum = 0;
        for (int i = 0; i < luoma.length(); i++) {
            if(i<luoma.length()-1) {
                if(luoma.charAt(i) == 'I' && (luoma.charAt(i+1) == 'V' || luoma.charAt(i+1)=='X')) {
                    String subs = luoma.substring(i, i + 2);
                    sum = sum +map.get(subs);
                    i++;
                    continue;
                }
                if(luoma.charAt(i) == 'X' && (luoma.charAt(i+1) == 'L' || luoma.charAt(i+1)=='C')) {
                    String subs = luoma.substring(i, i + 2);
                    sum = sum +map.get(subs);
                    i++;
                    continue;
                }
                if(luoma.charAt(i) == 'C' && (luoma.charAt(i+1) == 'D' || luoma.charAt(i+1)=='M')) {
                    String subs = luoma.substring(i, i + 2);
                    sum = sum +map.get(subs);
                    i++;
                    continue;
                }

            }

            Character c = luoma.charAt(i);
            sum = sum+map.get(c);  //叠加
        }

        return sum;
    }

}
