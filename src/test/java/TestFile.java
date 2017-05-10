import org.junit.Test;

import java.io.*;

/**
 * 测试文件.
 * Created by lunhengle on 2017/4/26.
 */
public class TestFile {
    private static final String BASE_PATH = "D:\\webFile\\";
    private static final String TOP_DATA_PATH = "\\topData\\";

    /**
     * 测试创建文件夹.
     */
    @Test
    public void testMkdir() {
        File file = new File(this.replaceFilePath(BASE_PATH), this.replaceFilePath(TOP_DATA_PATH));
        if (file.exists()) {
            System.out.println("文件夹已经存在!");
        } else {
            if (file.mkdirs()) {
                System.out.println("文件夹创建成功！");
            } else {
                System.out.println("文件夹未创建！");
            }
        }
    }

    @Test
    public void testIsExists() throws IOException {
        String oldFilePath = this.replaceFilePath(BASE_PATH) + this.replaceFilePath(TOP_DATA_PATH) + "a44e2ae2-c7bb-495f-9b18-e956f7d4319c_160x205.png";
        String newFilePath = this.replaceFilePath(BASE_PATH) + this.replaceFilePath(TOP_DATA_PATH) + oldFilePath.substring(oldFilePath.lastIndexOf(File.separator) + 1);
        File oldFile = new File(oldFilePath);
        File newFile = new File(newFilePath);
        if (oldFile.exists() && !newFile.exists()) {
            System.out.println("文件存在！");
            InputStream inputStream = new FileInputStream(oldFile);
            FileOutputStream fileOutputStream = new FileOutputStream(newFile);
            byte[] buffer = new byte[1444];
            while (inputStream.read(buffer) != -1) {
                fileOutputStream.write(buffer);
            }
            inputStream.close();
            fileOutputStream.close();
        } else {
            System.out.println("文件不存在！");
        }
    }

    /**
     * 替换文件目录间隔符.
     *
     * @param filePath 文件路径
     * @return 新的文件目录
     */
    private String replaceFilePath(final String filePath) {
        String newPath = filePath.replaceAll("\\\\\\\\", File.separator);
        newPath = newPath.replaceAll("/", File.separator);
        return newPath;
    }

    @Test
    public void testReplace() {
        String filePath = "/hello/world/";
        filePath = filePath.replace("/", File.separator);
        System.out.println(filePath);
    }

}
