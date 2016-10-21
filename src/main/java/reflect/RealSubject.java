package reflect;

/**
 * Created by lunhengle on 2016/10/21.
 */
public class RealSubject implements Subject {
    public String say(String name, int age) {
        return name + " " + age;
    }
}
