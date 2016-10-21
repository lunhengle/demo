import enums.Classroom;
import org.junit.Test;

/**
 * Created by lunhengle on 2016/10/17.
 */
public class TestClassroom {
    @Test
    public void testClassroom() {
        for (Classroom classroom : Classroom.values()) {
            System.out.println(classroom);
        }
    }
}
