package words;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lunhengle on 2016/9/23.
 * 敏感词过滤.
 */
public final class WordsFilter {
    private WordsFilter() {
    }

    private static StringBuilder lineTxt = new StringBuilder();
    private static List<String> list = new ArrayList<String>();

    static {
        try {
            InputStream inputStream = WordsFilter.class.getResourceAsStream("/words.dict");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                lineTxt.append(str).append("#");
                list.add(str);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 检查到敏感词.
     *
     * @param words 输入词
     * @return true 检查到敏感词 false 未检查到敏感词
     */
    public static boolean isInclude(String words) {
        return list.contains(words);
    }

    /**
     * 替换敏感词.
     *
     * @param words 输入词
     * @return 新的敏感词
     */
    public static String filters(String words, String replacewords) {
        for (String str : list) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                stringBuilder.append(replacewords);
            }
            words = words.replaceAll(str, stringBuilder.toString());
        }
        return words;
    }

    public static void main(String[] args) {
        if (isInclude("法轮功")) {
            System.out.println("检查到敏感词");
        }
        System.out.println(filters("这是法轮功", "*"));
    }

}
