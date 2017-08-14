package org.ktz.example.rxjava;

import org.example.ktz.rxjava.chap5.netty.HttpTcpNettyServer;
import org.example.ktz.rxjava.chap5.rxnetty.SingleThreadToRxNetty;
import org.example.ktz.rxjava.chap5.single.SingleThread;
import org.junit.Test;

import java.io.IOException;

public class Chapter5 {
    static String[] empty = {};

    @Test
    public void SingleThreadServer() throws IOException {
        // Thread 한개만 갖고 시작을 해보자
        SingleThread.main(empty);
    }

    @Test
    public void NettyServer() throws Exception {
        // Netty는 이렇게 할 수 있다.
        HttpTcpNettyServer httpTcpNettyServer = new HttpTcpNettyServer();

        httpTcpNettyServer.main(empty);
    }

    @Test
    public void RxNettyServer() throws IOException {
        // 이것을 RxNetty로 바꾸어 보자
        SingleThreadToRxNetty.main(empty);
    }

    // Page 199 벤치 마크
    // 물론 한번에 한개의 요청이 들어온다면, Single Thread가 가장 적합하다. Thread 운영에 대한 Overhead가 없으니까.
    // Page 202
    // Thread Pool 방식도 문제가 있다. 1,000개 이상이 될 경우, Thread도 1,000개가 되므로!


}
