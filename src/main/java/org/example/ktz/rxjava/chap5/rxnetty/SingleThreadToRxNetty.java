package org.example.ktz.rxjava.chap5.rxnetty;

import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.reactivex.netty.protocol.tcp.server.TcpServer;
import rx.Observable;

import java.io.IOException;

import static java.nio.charset.StandardCharsets.UTF_8;

public class SingleThreadToRxNetty {
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
                            .getInput()
                            .flatMap(line -> {
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
