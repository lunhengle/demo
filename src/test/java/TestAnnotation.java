import annotation.PluginService;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lunhengle on 2016/9/29.
 */
public class TestAnnotation {
    private String requestCode = "793";
    private Map<String, String> map = new HashMap<String, String>();

    @Before
    public void setUp() {
        map.put("792", "annotation.Service792");
        map.put("793", "annotation.Service793");
    }

    @Test
    public void test() {
        Class<?> cl = null;
        try {
            cl = Class.forName(map.get(requestCode));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        getReflectClass(cl, requestCode);
    }

    /**
     * 加载初始化init.
     */
    private void setReflectClass() {

    }

    /**
     * 映射处理方法.
     *
     * @param cl 映射类
     */
    private void getReflectClass(Class<?> cl, String filter) {
        //查看类是否使用PluginService注解
        PluginService pluginService = cl.getAnnotation(PluginService.class);
        if (null != pluginService) {
            for (Method m : cl.getDeclaredMethods()) {
                //查看方法是否使用PluginService注解
                pluginService = m.getAnnotation(PluginService.class);
                if (null != pluginService) {
                    if (filter.equals(pluginService.filter())) {
                        try {
                            Object object = cl.newInstance();
                            m.invoke(object);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
