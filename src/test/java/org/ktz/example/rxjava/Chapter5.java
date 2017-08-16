package org.ktz.example.rxjava;

import org.example.ktz.rxjava.chap5.completable.TravelServiceExampleMains;
import org.example.ktz.rxjava.chap5.httpserver.netty.HttpTcpNettyServer;
import org.example.ktz.rxjava.chap5.httpserver.rxnetty.SingleThreadToRxNetty;
import org.example.ktz.rxjava.chap5.httpserver.single.SingleThread;
import org.example.ktz.rxjava.chap5.single.SingleHttpRequest;
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
    // Rx를 쓴다면, 우리는 단 몇개의 Thread로 많은 Socket을 Handle할 수 있다!


    /**
     *
     * 한번 더 기존의 Code를 Rx로 바꿔보자!
     *
     */

    @Test
    public void BlockingTravelService() throws Exception {
        TravelServiceExampleMains.main(empty);
    }

    @Test
    public void BlockingTravelServiceAync() throws Exception {
        TravelServiceExampleMains.asyncMain(empty);
    }

    @Test
    public void BlockingTravelServiceRx() throws Exception {
        TravelServiceExampleMains.rxMain(empty);
    }


    /**
     *
     * 결과가 한개만 나오고 끝나는 Single
     *
     */

    @Test
    public void SingleTest() throws Exception {
        SingleHttpRequest.main(empty);
    }
}
