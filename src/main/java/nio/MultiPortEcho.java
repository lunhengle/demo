package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * 测试网络nio.
 * Created by lunhengle on 2017/5/15.
 */
public class MultiPortEcho {
    /**
     * 定义端口.
     */
    private int ports[];
    /**
     * 定义缓存大小.
     */
    private ByteBuffer echoBuffer = ByteBuffer.allocate(1024);

    /**
     * 带端口的构造函数.
     *
     * @param ports 端口
     */
    private MultiPortEcho(int ports[]) throws IOException {
        this.ports = ports;
        go();
    }

    /**
     * 创建监听端口.
     *
     * @throws IOException 异常信息
     */
    private void go() throws IOException {
        Selector selector = Selector.open();
        for (int i = 0; i < ports.length; i++) {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            ServerSocket serverSocket = serverSocketChannel.socket();
            InetSocketAddress address = new InetSocketAddress(ports[i]);
            serverSocket.bind(address);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            selector.selectedKeys();
            System.out.println("Going to listen on " + ports[i]);
        }
        while (true) {
            selector.select();
            Set selectedKeys = selector.selectedKeys();
            Iterator iterator = selectedKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = (SelectionKey) iterator.next();
                if ((selectionKey.readyOps() & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT) {
                    ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                    iterator.remove();
                    System.out.println("Going connection from " + socketChannel);
                } else if ((selectionKey.readyOps() & SelectionKey.OP_READ) == SelectionKey.OP_READ) {
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    int bytesEchoed = 0;
                    while (true) {
                        echoBuffer.clear();
                        int r = socketChannel.read(echoBuffer);
                        if (r <= 0) {
                            break;
                        }
                        echoBuffer.flip();
                        socketChannel.write(echoBuffer);
                        bytesEchoed += r;
                    }
                    System.out.println("Echoed " + bytesEchoed + " from" + socketChannel);
                }
            }
        }
    }

    public static void main(String args[]) throws Exception {
        String strings[] = {"9001", "9002", "9003"};
        if (strings.length <= 0) {
            System.err.println("Usage: java MultiPortEcho port [port port ...]");
            System.exit(1);
        }
        int ports[] = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            ports[i] = Integer.parseInt(strings[i]);
        }
        new MultiPortEcho(ports);
    }
}
