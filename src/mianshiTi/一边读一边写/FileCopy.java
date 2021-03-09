package mianshiTi.一边读一边写;

import java.io.*;

public class FileCopy {
    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream(new File("D:/myproject/mySuanFa/a.txt"));
        OutputStream os = new FileOutputStream(new File("D:/myproject/mySuanFa/b.txt"));

        byte[] buf = new byte[is.available()];
        int index;
        while((index=is.read(buf)) != -1) {
            os.write(buf);
        }

        is.close();
        os.close();
    }
}
