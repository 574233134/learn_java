import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class SorterMapMain {

    /**
     * @param map
     * @return
     */
    public static Map<Object, Object> sort(Map<Object, Object> map) {
        Map<Object, Object> mapVK = new TreeMap<Object, Object>(
                new Comparator<Object>() {
                    public int compare(Object obj1, Object obj2) {
                        String version1 = (String) obj1;
                        String version2 = (String) obj2;
                        // 注意此处为正则匹配，不能用.
                        String[] versionArray1 = version1.split("\\.");
                        String[] versionArray2 = version2.split("\\.");
                        int idx = 0;
                        // 取数组最小长度值
                        int minLength = Math.min(versionArray1.length, versionArray2.length);
                        int diff = 0;
                        // 先比较长度，再比较字符
                        while (idx < minLength
                                && (diff = versionArray2[idx].length() - versionArray1[idx].length()) == 0
                                && (diff = versionArray2[idx].compareTo(versionArray1[idx])) == 0) {
                            ++idx;
                        }
                        // 如果已经分出大小，则直接返回，如果未分出大小，则再比较位数，有子版本的为大
                        diff = (diff != 0) ? diff : versionArray2.length - versionArray1.length;
                        return diff;

                    }
                });
        Set<Object> col = map.keySet();
        Iterator<Object> iter = col.iterator();
        while (iter.hasNext()) {
            Object key = iter.next();
            Object value = map.get(key);
            mapVK.put(key, value);
        }
        return mapVK;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // 1. 创建一个Map对象
        Map<Object,Object> map = new HashMap<Object,Object>();
        map.put("4.2.0", new Object());
        map.put("3.1.8", new Object());
        map.put("4.10.0", new Object());
        map.put("4.0.1", new Object());
        // 2. 对Map进行排序
        Map<Object,Object> sortMap = sort(map);
        // 3. 遍历Map，排序前
        Set<Object> keySet = map.keySet();
        for(Object key : keySet){
            System.out.println(key + "=" + sortMap.get(key));
        }
        System.out.println("------------------------------------");
        // 4. 遍历Map，排序后
        Set<Object> keySet2 = sortMap.keySet();
        for(Object key : keySet2){
            System.out.println(key + "=" + sortMap.get(key));
        }
    }

}