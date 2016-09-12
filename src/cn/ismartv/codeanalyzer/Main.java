package cn.ismartv.codeanalyzer;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        // write your code here

        Set<String> newList = findDimens("C:\\Users\\huibin\\Games\\AndroidProject\\DetailPageModule\\appdaisy\\src\\main\\res\\layout\\popup_message.xml");
        for (String str : newList) {

            findDimensFrom("C:\\Users\\huibin\\Games\\AndroidProject\\Daisy\\Daisy\\res\\values-sw1080dp\\dimens.xml", str);
        }
    }


    private static Set<String> findDimens(String newPath) {
        File file = new File(newPath);
        Set<String> dimensList = new HashSet<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains("@dimen/")) {
                    String str =
                            (line.split("@dimen/")[1].replace("\"", "").replace("/>", ""));
                    dimensList.add(str);
                }

            }
            fileReader.close();
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dimensList;
    }

    private static List<String> findDimensFrom(String newPath, String str) {
        File file = new File(newPath);
        List<String> dimensList = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains(str)) {
                    System.out.println(line);
                }

            }
            fileReader.close();
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dimensList;
    }

}
