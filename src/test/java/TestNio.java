import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 测试nio.
 * Created by lunhengle on 2017/5/15.
 */
public class TestNio {
    /**
     * 默认buffer 大小.
     */
    private static final int DEFAULT_SIZE = 1024;
    /**
     * 源路径.
     */
    private static final String srcPath = "E:\\迅雷下载.zip";
    /**
     * 目标路径.
     */
    private static final String descPath = "E:\\迅雷下载1.zip";

    /**
     * 测试io复制.
     *io 复制需要时间：415290
     * @throws IOException io异常
     */
    @Test
    public void testIo() throws IOException {
        this.copyFileIo(srcPath, descPath);
    }

    /**
     * 测试带缓存的io复制.
     * io buffer 复制需要时间：363208
     * @throws IOException io 异常
     */
    @Test
    public void testBufferTo() throws IOException {
        this.copyFileBufferIo(srcPath, descPath);
    }

    /**
     * 测试nio 复制文件.
     * nio 复制需要时间：321930
     * @throws IOException io异常
     */
    @Test
    public void testNio() throws IOException {
        this.copyFileNio(srcPath, descPath);
    }

    /**
     * 复制文件.
     *
     * @param srcPath  源文件路径
     * @param destPath 目标文件路径
     */
    private void copyFileIo(final String srcPath, final String destPath) throws IOException {
        long start = System.currentTimeMillis();
        InputStream inputStream = new FileInputStream(new File(srcPath));
        OutputStream outputStream = new FileOutputStream(new File(destPath));
        byte[] bytes = new byte[DEFAULT_SIZE];
        int readByte;
        while ((readByte = inputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, readByte);
        }
        inputStream.close();
        outputStream.close();
        long end = System.currentTimeMillis();
        System.out.println("io 复制需要时间：" + (end - start));
    }

    /**
     * 带缓存的复制文件.
     *
     * @param srcPath  源文件路径
     * @param destPath 目标文件路径
     */
    private void copyFileBufferIo(final String srcPath, final String destPath) throws IOException {
        long start = System.currentTimeMillis();
        InputStream inputStream = new BufferedInputStream(new FileInputStream(new File(srcPath)), DEFAULT_SIZE);
        OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(new File(destPath)), DEFAULT_SIZE);
        int readByte;
        byte[] bytes = new byte[1024];
        while ((readByte = inputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, readByte);
        }
        inputStream.close();
        outputStream.close();
        long end = System.currentTimeMillis();
        System.out.println("io buffer 复制需要时间：" + (end - start));
    }

    /**
     * 复制文件.
     *
     * @param srcPath  源文件路径
     * @param destPath 目的文件路径
     */
    private void copyFileNio(final String srcPath, final String destPath) throws IOException {
        long start = System.currentTimeMillis();
        //定义文件读入流
        FileInputStream fileInputStream = new FileInputStream(new File(srcPath));
        //文件输入流通道
        FileChannel fileInputChannel = fileInputStream.getChannel();
        //定义文章输出流
        FileOutputStream fileOutputStream = new FileOutputStream(new File(destPath));
        FileChannel fileOutputChannel = fileOutputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(DEFAULT_SIZE);
        while (fileInputChannel.read(byteBuffer) != -1) {
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                fileOutputChannel.write(byteBuffer);
            }
            byteBuffer.clear();
        }
        fileInputChannel.close();
        fileInputStream.close();
        fileOutputChannel.close();
        fileOutputStream.close();
        long end = System.currentTimeMillis();
        System.out.println("nio 复制需要时间：" + (end - start));
    }


}
