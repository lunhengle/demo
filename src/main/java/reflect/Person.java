package reflect;

/**
 * Created by lunhengle on 2016/10/21.
 */
public class Person extends Demo implements China {
    public Person() {

    }

    public Person(int age) {
        this.age = age;
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "[" + this.name + "," + this.age + "]";
    }

    public void sayChina() {
        System.out.print("say China");
    }

    public void sayHello(String name, int age) {
        System.out.println(name + "  " + age);
    }
}
