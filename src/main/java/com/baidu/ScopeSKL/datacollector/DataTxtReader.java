package com.baidu.ScopeSKL.datacollector;

import java.io.*;
import java.util.*;
/**
 * Created by zhangzhibo on 17-6-27.
 */
public class DataTxtReader {
    ArrayList<String> row = new ArrayList<String>();

    public static void main(String[] args) {
        Map<String, String> filemap = new HashMap<String, String>();
        ArrayList<String> row = new ArrayList<String>();
        try {
            // read file content from file
            StringBuffer sb = new StringBuffer("");

            FileReader reader = new FileReader(System.getProperty("user.dir") + File.separator + "sourcefile" + File.separator + "data_train.txt");
            BufferedReader br = new BufferedReader(reader);

            String str = null;

            while ((str = br.readLine()) != null) {
                sb.append(str + "/n");
                row.add(str);
            }
            br.close();
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(row.size());
        for (String str :
                row) {
            String uri = str.split(" ")[1];
            StringBuffer lab = new StringBuffer(str.split(" ")[0]);
            while (lab.length()<3){
                lab.insert(0,"0");
            }
            filemap.put(uri,lab.toString());
        }
        //for (String str :
        //        url) {
        //    System.out.println(str);
        //}
        System.out.println(filemap.size());
        Iterator it = filemap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (Integer.parseInt(entry.getValue().toString()) != 1)
                System.out.println(entry.getKey() + "  ===============================>  " + entry.getValue());
        }
    }
}
