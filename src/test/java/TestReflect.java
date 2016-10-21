import org.junit.Test;
import reflect.*;

import java.lang.reflect.*;
import java.util.Properties;

/**
 * Created by lunhengle on 2016/10/21.
 * java 反射机制
 */
public class TestReflect {
    /**
     * 通过一个对象获取完整的包名和对象名.
     */
    @Test
    public void getDemoClassName() {
        Demo demo = new Demo();
        System.out.println(demo.getClass().getName());
    }

    /**
     * 实例化Class对象.
     */
    @Test
    public void getDemoClassName2() {
        Class<?> demo1 = null;
        Class<?> demo2 = null;
        Class<?> demo3 = null;
        try {
            demo1 = Class.forName("reflect.Demo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        demo2 = new Demo().getClass();
        demo3 = Demo.class;
        System.out.println("类名称  " + demo1.getName());
        System.out.println("类名称  " + demo2.getName());
        System.out.println("类名称  " + demo3.getName());
    }

    /**
     * 通过无参构造函数实例对象.
     */
    @Test
    public void getPersonClassName() {
        Class<?> demo = null;
        try {
            demo = Class.forName("reflect.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Person person = null;
        try {
            person = (Person) demo.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        person.setName("伦恒乐");
        person.setAge(1);
        System.out.println(person.toString());
    }

    /**
     * 根据构造函数 实例化多个对象.
     */
    @Test
    public void getPersonClassName2() {
        Class<?> demo = null;
        try {
            demo = Class.forName("reflect.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Person person = null;
        Person person1 = null;
        Person person2 = null;
        Person person3 = null;
        Constructor<?>[] constructor = demo.getConstructors();
        try {
            person = (Person) constructor[0].newInstance(20, "伦恒乐");
            person1 = (Person) constructor[1].newInstance("伦恒乐");
            person2 = (Person) constructor[2].newInstance(20);
            person3 = (Person) constructor[3].newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(person.toString());
        System.out.println(person1.toString());
        System.out.println(person2.toString());
        System.out.print(person3.toString());
    }

    /**
     * 获取实现的接口名称.
     */
    @Test
    public void getPersonInterfaceName() {
        Class<?> demo = null;
        try {
            demo = Class.forName("reflect.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Class<?>[] inters = demo.getInterfaces();
        for (int i = 0; i < inters.length; i++) {
            System.out.println(inters[i].getName());
        }
    }

    /**
     * 获取继承的父类.
     */
    @Test
    public void getPersonSubName() {
        Class<?> demo = null;
        try {
            demo = Class.forName("reflect.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Class<?> sub = demo.getSuperclass();
        System.out.println("继承的父类为：" + sub.getName());
    }

    /**
     * 获取所有的构造函数.
     */
    @Test
    public void getConstructorName() {
        Class<?> demo = null;
        try {
            demo = Class.forName("reflect.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Constructor<?>[] constructors = demo.getConstructors();
        for (int i = 0; i < constructors.length; i++) {
            System.out.println("构造方法：" + constructors[i]);
        }
    }

    /**
     * 获取所有的构造函数.
     */
    @Test
    public void getConstructorName1() {
        Class<?> demo = null;
        try {
            demo = Class.forName("reflect.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Constructor<?>[] constructors = demo.getConstructors();
        for (int i = 0; i < constructors.length; i++) {
            System.out.print("构造函数：");
            int mo = constructors[i].getModifiers();
            System.out.print(Modifier.toString(mo) + " ");
            System.out.print(constructors[i].getName());
            System.out.print("(");
            Class<?> p[] = constructors[i].getParameterTypes();
            for (int j = 0; j < p.length; j++) {
                System.out.print(p[j].getName());
                if (j < p.length - 1) {
                    System.out.print(",");
                }
            }
            System.out.println("){}");
        }
    }

    /**
     * 获取所有的方法.
     */
    @Test
    public void getMethodName() {
        Class<?> demo = null;
        try {
            demo = Class.forName("reflect.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Method[] methods = demo.getMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.print("方法名称：");
            //修饰符 public final .........
            System.out.print(Modifier.toString(methods[i].getModifiers()) + " ");
            //获取返回值
            Class<?> r = methods[i].getReturnType();
            System.out.print(r.getName() + " ");
            System.out.print(methods[i].getName());
            System.out.print("(");
            //获取参数值
            Class<?>[] p = methods[i].getParameterTypes();
            for (int j = 0; j < p.length; j++) {
                System.out.print(p[j].getName());
                if (j < p.length - 1) {
                    System.out.print(",");
                }
            }
            System.out.print(")");
            //获取异常
            Class<?>[] execs = methods[i].getExceptionTypes();
            if (null != execs && execs.length > 0) {
                System.out.print(" throws ");
                for (int j = 0; j < execs.length; j++) {
                    System.out.print(execs[j].getName());
                    if (j < execs.length - 1) {
                        System.out.print(",");
                    }
                }
            }
            System.out.println(" {}");
        }
    }

    /**
     * 获取属性.
     */
    @Test
    public void getFieldsName() {
        Class<?> demo = null;
        try {
            demo = Class.forName("reflect.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("获取本类的属性: ");
        Field[] fields = demo.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            int m = fields[i].getModifiers();
            //修饰符
            String mod = Modifier.toString(m);
            //类型值
            Class<?> type = fields[i].getType();
            System.out.println(mod + " " + type.getName() + " " + fields[i].getName());
        }
        System.out.println("获取分类和接口中的属性:");
        Field[] fields1 = demo.getFields();
        for (int i = 0; i < fields1.length; i++) {
            int m = fields1[i].getModifiers();
            //修饰符
            String mod = Modifier.toString(m);
            //类型值
            Class<?> type = fields1[i].getType();
            System.out.println(mod + " " + type.getName() + " " + fields1[i].getName());
        }
    }

    /**
     * 执行方法.
     */
    @Test
    public void invokeMethod() {
        Class<?> demo = null;
        try {
            demo = Class.forName("reflect.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            //调用Person类中的sayChina方法
            Method method = demo.getMethod("sayChina");
            method.invoke(demo.newInstance());
            //调用Person的sayHello方法
            method = demo.getMethod("sayHello", String.class, int.class);
            method.invoke(demo.newInstance(), "Rollen", 20);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * 调用set get
     */
    @Test
    public void invokeMethod1() {
        Class<?> demo = null;
        Object obj = null;
        try {
            demo = Class.forName("reflect.Person");
            obj = demo.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        setter(obj, "Age", 1, int.class);
        getter(obj, "Age");
    }

    /**
     * 处理getter 方法.
     *
     * @param obj 对象
     * @param att 方法名
     */
    private void getter(Object obj, String att) {
        try {
            Method method = obj.getClass().getMethod("get" + att);
            System.out.println(method.invoke(obj));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * 处理getter.
     *
     * @param obj   对象
     * @param att   方法名
     * @param value 方法参数
     * @param type  方法类型
     */
    private void setter(Object obj, String att, Object value, Class<?> type) {
        try {
            Method method = obj.getClass().getMethod("set" + att, type);
            method.invoke(obj, value);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * 处理属性.
     */
    @Test
    public void invokeField() {
        Class<?> demo = null;
        Object object = null;
        try {
            demo = Class.forName("reflect.Person");
            object = demo.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        try {
            Field field = demo.getDeclaredField("name");
            //可以访问私用属性
            field.setAccessible(true);
            field.set(object, "伦恒乐");
            System.out.println(field.get(object));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过反射修改数组.
     */
    @Test
    public void getArray() {
        int[] temp = {1, 2, 3, 4, 5};
        Class<?> demo = temp.getClass().getComponentType();
        System.out.println("数组类型：" + demo.getName());
        System.out.println("数组长度：" + Array.getLength(temp));
        System.out.println("数组的第一个元素：" + Array.get(temp, 0));
        Array.set(temp, 0, 100);
        System.out.println("修改后的第一个元素为：" + Array.get(temp, 0));
    }

    /**
     * 通过反射修改数组.
     */
    @Test
    public void getArray1() {
        int[] temp = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] newTemp = (int[]) arryInc(temp, 15);
        print(newTemp);
        System.out.println("====================");
        String[] str = {"a", "b", "c"};
        String[] strings = (String[]) arryInc(str, 8);
        print(strings);
    }

    /**
     * 修改数组大小.
     */
    public Object arryInc(Object obj, int len) {
        Class<?> arr = obj.getClass().getComponentType();
        Object newArr = Array.newInstance(arr, len);
        int co = Array.getLength(obj);
        System.arraycopy(obj, 0, newArr, 0, co);
        return newArr;
    }

    /**
     * 打印
     */
    public void print(Object obj) {
        Class<?> c = obj.getClass();
        if (!c.isArray()) {
            return;
        }
        System.out.println("数组长度为：" + Array.getLength(obj));
        for (int i = 0; i < Array.getLength(obj); i++) {
            System.out.println(Array.get(obj, i) + " ");
        }
    }

    class test {
    }

    /**
     * 获取类加载器.
     * java 中有三种类类加载器
     * Bootstrap ClassLoader 此加载器采用c++编写，一般开发中很少用。
     * Extension ClassLoader 用来进行扩展类的加载，一般对应的是jre\lib\ext目录中的类。
     * AppClassLoader 加载classpath指定的类，是最常用的加载器。同时也是java 中默认的加载器。
     */
    @Test
    public void testClassLoader() {
        test t = new test();
        System.out.println("类加载器 " + t.getClass().getClassLoader().getClass().getName());
    }

    /**
     * 测试动态代理.
     * 类的生命周期
     * 在一个类编译完成之后，下一步就是需要开始使用类，如果要使用一个类，肯定离不开jvm.
     * 在程序执行中jvm通过 装载，链接，初始化 3个步骤完成。
     * 类的装载是通过类加载器完成的，加载器将.class文件的二进制文件进入jvm的方法去，并且在堆区创建描述这个类的java.lang.Class对象。用来封装数据.
     * 但是这个类被类装载器装载以后 链接 就把二进制数据封装为可以运行的状态。
     * 链接分为校验，准备，解析这3个阶段
     * 校验一般用来确认二进制文件是否适合当前jvm(版本)
     * 准备就是为静态成员分配内存空间。并设置默认值。
     * 解析指的是转换常量池中代码作为直接引用的过程，知道所有的符号引用都可以被运行程序使用（建立完成的对应关系）
     * 完成之后，类型也就完成了初始化，初始化之后类的对象就可以正常使用了，知道一个对象不再使用之后，将被垃圾回收，释放空间。
     * 当没有任何引用指向Class 对象是就会被卸载，结束类的生命周期。
     */
    @Test
    public void testProxyHandler() {
        MyInvocationHandler demo = new MyInvocationHandler();
        Subject subject = (Subject) demo.bind(new RealSubject());
        String info = subject.say("Rollen", 20);
        System.out.println(info);
    }

    /**
     * 利用反射工厂方法加载类.
     */
    @Test
    public void testHandler() {
        Properties properties = Init.getProperties();
        Fruit fruit = Factory.getInstance((String) properties.get("apple"));
        if (null != fruit) {
            fruit.eat();
        }
    }

}
