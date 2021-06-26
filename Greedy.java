package Greedy;

import java.util.*;

/**
 * @program: DataStructure
 * @description: 贪心算法
 * @author: Mr.Sun
 * @create: 2021-06-26 18:22
 **/
/*
* 假设存在下面需要付费的广播台，以及广播台信号可以覆盖的地区，如何选择最少的广播台，让所有的地区都可以接收到信号
* 广播台     覆盖地区
* K1        "北京"，"上海"，"天津"
* K2        "广州"，"北京"，"深圳"
* K3        "成都"，"上海"，"杭州"
* K4        "上海"，"天津"
* K5        "杭州"，"大连"
* */
public class Greedy {

    public static void main(String[] args) {
//        创建一个 map ，将广播台信息存到其中
        Map<String, HashSet<String>> boardcast = new HashMap<>();
        HashSet<String> area1 = new HashSet<>();
        area1.add("北京");
        area1.add("上海");
        area1.add("天津");
        HashSet<String> area2 = new HashSet<>();
        area2.add("广州");
        area2.add("北京");
        area2.add("深圳");
        HashSet<String> area3 = new HashSet<>();
        area3.add("成都");
        area3.add("上海");
        area3.add("杭州");
        HashSet<String> area4 = new HashSet<>();
        area4.add("上海");
        area4.add("天津");
        HashSet<String> area5 = new HashSet<>();
        area5.add("杭州");
        area5.add("大连");
        boardcast.put("K1",area1);
        boardcast.put("K2",area2);
        boardcast.put("K3",area3);
        boardcast.put("K4",area4);
        boardcast.put("K5",area5);

        HashSet<String> allArea = new HashSet<>();
        allArea.add("北京");
        allArea.add("深圳");
        allArea.add("成都");
        allArea.add("杭州");
        allArea.add("大连");
        allArea.add("天津");
        allArea.add("上海");
        allArea.add("广州");

//        用于临时存放当前 K 覆盖集合的 HashSet
        HashSet<String> tempArea = new HashSet<>();
//        用于存放当前最大覆盖未覆盖区域的 keyMax
        String keyMax = null ;
//        用于存放结果的hashSet
        List<String> res = new ArrayList<>();
//        当所有要被覆盖的区域为完全覆盖则继续循环遍历
        while(!allArea.isEmpty()){
            keyMax = null ;
            for (String k:boardcast.keySet()) {
                tempArea.clear();
                HashSet<String> hashSet = boardcast.get(k);
                tempArea.addAll(hashSet);
                tempArea.retainAll(allArea);

                if(tempArea.size()>0 && (keyMax == null || tempArea.size() > boardcast.get(keyMax).size())){
                    keyMax = k;
                }
            }
                allArea.removeAll(boardcast.get(keyMax));
                res.add(keyMax);
        }
        System.out.println(res);
    }
}




