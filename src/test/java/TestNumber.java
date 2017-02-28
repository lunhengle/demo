import org.apache.commons.lang.StringUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lunhengle on 2016/12/21.
 */
public class TestNumber {
    private List<Map<String, String>> list = new ArrayList<Map<String, String>>();
    private static List<NodeTree> listNode = new ArrayList<NodeTree>();
    private static Map<String, String> tempMap = new HashMap<String, String>();
    private static Map<String, String> tempTop = new HashMap<String, String>();
    private static final int NUM_LENGTH = 6;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;

    @Before
    public void setUp() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("area", "华中");
        map.put("city", "郑州");
        map.put("manager", "张三");
        list.add(map);
        Map<String, String> map1 = new HashMap<String, String>();
        map1.put("area", "华中");
        map1.put("city", "郑州");
        map1.put("manager", "李四");
        list.add(map1);
        Map<String, String> map2 = new HashMap<String, String>();
        map2.put("area", "华中");
        map2.put("city", "合肥");
        map2.put("manager", "李四");
        list.add(map2);
        Map<String, String> map3 = new HashMap<String, String>();
        map3.put("area", "华南");
        map3.put("city", "广州");
        map3.put("manager", "王五");
        list.add(map3);
    }

    @Test
    public void testNumber() {
        for (Map<String, String> map : list) {
            String area = map.get("area");
            String city = map.get("city");
            String manager = map.get("manager");
            this.addNodeTree(area, "ROOT", ONE);
            this.addNodeTree(city, area, TWO);
            this.addNodeTree(manager, city, THREE);
        }

        for (NodeTree nodeTree : listNode) {
            System.out.println("id = " + nodeTree.getId() + " pid = " + nodeTree.getPid() + " name = " + nodeTree.getName() + " level = " + nodeTree.getLevel());
        }
    }

    /**
     * 添加 树形.
     *
     * @param name  名字
     * @param pName 父名字
     * @param level 等级
     */
    public void addNodeTree(final String name, final String pName, final int level) {
        if (!tempMap.containsKey(name)) {
            NodeTree nodeTree = new NodeTree();
            String pTemp = tempMap.get(pName);
            String temp = tempTop.get(pTemp);
            temp = getNumber(pTemp, temp, level);
            nodeTree.setId(temp);
            //保存最大值
            tempTop.put(pTemp, temp);
            nodeTree.setPid(pTemp);
            nodeTree.setName(name);
            nodeTree.setLevel(level);
            listNode.add(nodeTree);
            //添加到缓存map中 避免重复添加
            tempMap.put(name, temp);
        }
    }

    /**
     * 编号.
     *
     * @param top   当前最大值
     * @param level 等级
     * @return 编号
     */
    private synchronized String getNumber(String pid, String top, int level) {
        String number;
        if (StringUtils.isBlank(top)) {
            if (level == 1) {
                number = "A000001";
            } else {
                number = pid + "000001";
            }
        } else {
            String begin = top.substring(0, top.length() - NUM_LENGTH);
            String end = top.substring(top.length() - NUM_LENGTH, top.length());
            int i = Integer.parseInt(end);
            i = i + 1;
            end = String.valueOf(i);
            end = this.length(end);
            number = begin + end;
        }
        return number;
    }

    @Test
    public void testLength() {
        String s = this.length("1");
        System.out.println(s);
    }

    /**
     * 拼接长度.
     *
     * @param str 要拼接的字符串.
     * @return 拼接好的字符串
     */
    private String length(String str) {
        if (str.length() < NUM_LENGTH) {
            String s = "0" + str;
            return length(s);
        } else {
            return str;
        }
    }

    @Test
    public void testSubstring() {
        String str = "123456789";
        System.out.println(str.substring(0, str.length() - 3));
        System.out.println(str.substring(str.length() - 3, str.length()));
    }

    class NodeTree {
        private String id;
        private String pid;
        private String name;
        private int level;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }
    }
}
