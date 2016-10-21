package reflect;

/**
 * Created by lunhengle on 2016/10/21.
 */
public class Factory {
    public static Fruit getInstance(String className) {
        Fruit fruit = null;
        try {
            fruit = (Fruit) Class.forName(className).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return fruit;
    }
}
