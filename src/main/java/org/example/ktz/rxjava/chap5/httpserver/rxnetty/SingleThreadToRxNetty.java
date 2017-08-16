package org.example.ktz.rxjava.chap5.httpserver.rxnetty;

import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.reactivex.netty.protocol.tcp.server.TcpServer;
import rx.Observable;

import java.io.IOException;

import static java.nio.charset.StandardCharsets.UTF_8;

public class SingleThreadToRxNetty {

    /**
     *
     * RxNetty는 그냥 Netty를 Rx Interface로 감싼것.
     *
     */



    private static final Observable<String> RESPONSE = Observable.just(
            "HTTP/1.1 200 OK\r\n" +
                    "Content-length: 2\r\n" +
                    "\r\n" +
                    "OK");

    private static int n = 0;


    public static void main(String[] args) throws IOException {
        TcpServer
                .newServer(8080)
                .<String, String>pipelineConfigurator(pipeline -> {
                    pipeline.addLast(new LineBasedFrameDecoder(128));
                    pipeline.addLast(new StringDecoder(UTF_8));
                })
                .start(connection -> {

                    Observable<String> output = connection
                            .getInput()     // getInput이 Observable<T> 상속을 갖는 ContentSource<T>를 리턴.
                                            // 이것이 Input을 Observable<String>로 감싸서 받는다.
                            .flatMap(line -> {      // 이제 Rx 시작!
                                if (line.isEmpty())
                                    return RESPONSE;
                                else
                                    return Observable.empty();
                            });

                    return connection.writeAndFlushOnEach(output);
                })
                .awaitShutdown();
    }
}
