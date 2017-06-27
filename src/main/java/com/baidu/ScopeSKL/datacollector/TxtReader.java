package com.baidu.ScopeSKL.datacollector;

import java.io.*;
import java.util.*;

/**
 * Created by Gavin.Stevenson on 2016/9/4.
 */
public class TxtReader {
    ArrayList<String> row = new ArrayList<String>();

    public static void main(String[] args) {
        ArrayList<String> row = new ArrayList<String>();
        ArrayList<String> url = new ArrayList<String>();
        Map<String, Integer> repeatmap = new HashMap<String, Integer>();
        try {
            // read file content from file
            StringBuffer sb = new StringBuffer("");

            FileReader reader = new FileReader(System.getProperty("user.dir") + File.separator + "sourcefilr" + File.separator + "data_train.txt");
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
            String u = str.split(" ")[1];
            url.add(u);
            if (repeatmap.containsKey(u)) {
                int t = repeatmap.get(u);
                repeatmap.put(u, t + 1);
            } else {
                repeatmap.put(u, 1);
            }
        }
        System.out.println(url.size());
        Set<String> set = new HashSet<String>();
        set.addAll(url);

        System.out.println(set.size());
        ArrayList<String> repeat = new ArrayList<String>();
        for (String str :
                set) {
            url.remove(str);
        }
        System.out.println(url.size());
        //for (String str :
        //        url) {
        //    System.out.println(str);
        //}
        System.out.println(repeatmap.size());
        Iterator it = repeatmap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (Integer.parseInt(entry.getValue().toString()) != 1)
                System.out.println(entry.getKey() + "  ===============================>  " + entry.getValue());
        }
    }
}
