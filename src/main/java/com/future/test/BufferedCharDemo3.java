package com.future.test;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author guorui
 * @create 2022-06-06-10:40
 */
public class BufferedCharDemo3 {
    public static void main(String[] args) throws Exception {
        try (
                Reader fr1 = new FileReader("./src/新建文本文档9.txt");
                BufferedReader br1 = new BufferedReader(fr1);
                Writer fw1 = new FileWriter("./src/新建文本文档a.txt",true);
                BufferedWriter bw1 = new BufferedWriter(fw1);
        ){
            String line;
            List<String> list = new ArrayList<>();
            while ((line = br1.readLine()) != null){
                list.add(line);
            }
            List<String> list2 = new ArrayList<>();
            System.out.println(list);
            Collections.addAll(list2,"第一行","第二行","第三行","第四行","第五行","第六行","第七行","第八行","第九行");
            Collections.sort(list, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return list2.indexOf(o1.substring(0,o1.indexOf("."))) - list2.indexOf(o2.substring(0,o2.indexOf(".")));
                }
            });
            System.out.println(list);
            for (String s : list) {
                bw1.write(s.toCharArray());
                bw1.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
