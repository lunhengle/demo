import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 测试nio.
 * Created by lunhengle on 2017/5/15.
 */
public class TestNio {
    @Test
    public void testNio() throws IOException {
        String inputPath = "D:\\hello.txt";
        String outPath = "D:\\world.txt";
        FileInputStream inputStream = new FileInputStream(new File(inputPath));
        FileOutputStream outputStream = new FileOutputStream(new File(outPath));
        FileChannel inChannel = inputStream.getChannel();
        FileChannel outChannel = outputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while (true) {
            int eof = inChannel.read(byteBuffer);
            if (eof == -1) {
                break;
            }
            byteBuffer.flip();
            outChannel.write(byteBuffer);
            byteBuffer.clear();
        }
        inChannel.close();
        outChannel.close();
        inputStream.close();
        outputStream.close();
    }
}
