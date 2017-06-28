package com.baidu.ScopeSKL.datacollector;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;

/**
 * Created by zhangzhibo on 17-6-28.
 */

public class DownloadNet {

    static final boolean DEBUG = false;
    static int DownloadSpeed = 0;
    static boolean fo = true;

    public static void main(String[] args) throws  IOException{
        String addressUrl="http://www.goupuzi.com/attachment/thumb/Mon_1612/2_157591_9ea7b94035fd317.jpg";
        String file = System.getProperty("user.dir") + File.separator +"ApkDownLoadTest/2_157591_9ea7b94035fd317.jpg"; // 保存地址
        savaTofile(addressUrl,file);
    }
    public static void savaTofile(String addressUrl, String fileName) throws IOException {
        boolean DEBUG = true;
        int BUFFER_SIZE = 512000;
        long Allsize = 0;

        FileOutputStream fileOutputStream = null;
        BufferedInputStream bufferedInputStream = null;
        HttpURLConnection httpUrl = null;
        URL url = null;
        byte[] buf = new byte[BUFFER_SIZE];
        int dowloadSize = 0;

        url = new URL(addressUrl);
        httpUrl = (HttpURLConnection) url.openConnection();
        long count = Long.parseLong(httpUrl.getHeaderField("Content-Length"));
        httpUrl.connect();
        bufferedInputStream = new BufferedInputStream(httpUrl.getInputStream());

        File file = new File(fileName);
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdir();
            }
            file.createNewFile();
        }
        fileOutputStream = new FileOutputStream(fileName);
        if (DEBUG) {
            System.out.println("getting  [ " + addressUrl + " ] ,saving as [ " + fileName + " ]");
        }
        fileOutputStream.write(buf, 0, dowloadSize);
        fileOutputStream.close();
        bufferedInputStream.close();
        httpUrl.disconnect();
    }
}