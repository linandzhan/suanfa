package mianshiTi.一边读一边写.使用缓冲区复制;

import java.io.*;

public class TestAreaCopy1 {
    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream("D:/myproject/mySuanFa/a.txt");
        OutputStream out = new FileOutputStream("D:/myproject/mySuanFa/b.txt");

        byte[] buf = new byte[1024];
        int index = 0;
        while((index = is.read(buf)) != -1) {
            //index一次读多少个长度
            out.write(buf,0,index);
        }

        is.close();
        out.close();
    }
}

/**
 * 标准写法
 */
class BiaoZhun{
    public static void main(String[] args) {
        InputStream is = null;
        OutputStream out = null;

        try{
            is = new FileInputStream("D:/myproject/mySuanFa/a.txt");
            out = new FileOutputStream("D:/myproject/mySuanFa/b.txt");
            byte[] buf = new byte[1024];
            int index = 0;
            while((index = is.read(buf)) != -1) {
                out.write(buf,0,index);
            }
        }catch (IOException e) {
            System.out.println("io异常");
        }finally {
            if(is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
