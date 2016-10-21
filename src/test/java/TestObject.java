import org.junit.Test;

/**
 * Created by lunhengle on 2016/9/21.
 */
public class TestObject {
    @Test
    public void test() {
        Hello hello = new Hello();
        if (hello instanceof Hello) {
            System.out.println("hello 对象是 Hello " + true);
        } else {
            System.out.println("hello 对象不是 Hello " + false);
        }

        if (hello instanceof Object) {
            System.out.println("hello 对象是 Object " + true);
        } else {
            System.out.println("hello 对象不是 Object " + false);
        }
        if(hello instanceof World){
            System.out.println("hello 对象是 World "+true);
        }else{
            System.out.println("hello 对象不是 World "+ false);
        }

    }
}
