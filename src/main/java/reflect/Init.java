package reflect;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by lunhengle on 2016/10/21.
 */
public class Init {
    /**
     * 加载配置文件.
     *
     * @return 配置属性
     */
    public static Properties getProperties() {
        Properties properties = new Properties();
        File file = new File("fruit.properties");
        if (file.exists()) {
            try {
                properties.load(new FileInputStream(file));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            properties.setProperty("apple", "reflect.Apple");
            properties.setProperty("orange", "reflect.Orange");
            try {
                properties.store(new FileOutputStream(file), "FRUIT CLASS");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return properties;
    }
}
