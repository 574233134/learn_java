import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
public class Main {

    public static void main(String[] args) {
        Map result = new HashMap();
        String path = "/Users/limengke1/Desktop/jsondic/src/main/java/test.json";
        String resultStr = readJsonFile(path);
        JSONObject jsonObject = JSONObject.parseObject(resultStr);
        if (jsonObject.containsKey("data")) {
            JSONArray json = jsonObject.getJSONArray("data");
            if (json != null) {

                if (json.isEmpty() || json.size() < 1) {
                    String[] array = new String[0];
                    result.put("data", array);
                } else {
                    result.put("data", json);
                }
            }
        }
        TreeMap treetest = new TreeMap(result);
        System.out.println(result);
        System.out.println(treetest);
    }
    /**
     * 读取json文件，返回json串
     * @param fileName
     * @return
     */
    public static String readJsonFile(String fileName) {
        String jsonStr = "";
        try {
            File jsonFile = new File(fileName);
            FileReader fileReader = new FileReader(jsonFile);

            Reader reader = new InputStreamReader(new FileInputStream(jsonFile),"utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
