package org.example.ktz.rxjava.chap5.httpserver.netty;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;

import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.*;

import java.io.UnsupportedEncodingException;

import static com.sun.xml.internal.stream.writers.WriterUtility.UTF_8;

public class HttpTcpNettyServer {

    /**
     *
     * Single Thread -> 비동기
     *
     * 이제 Netty를 이용하여서 서버를 만들어봅시다.
     *
     */

    public void main(String[] args) throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);    // Accept를 밭은 Loop Group
        EventLoopGroup workGroup = new NioEventLoopGroup();     // 받은 것을 처리하는 Loop Group
        try {
            new ServerBootstrap()
                    .option(ChannelOption.SO_BACKLOG, 50_000)
                    .group(bossGroup, workGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new HttpInitializer())    // Accept를 받으면 Handler로 넘긴다.
                    .bind(8080)
                    .sync()
                    .channel()
                    .closeFuture()
                    .sync();
        } finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }

    }

    @ChannelHandler.Sharable
    class HttpHandler extends ChannelInboundHandlerAdapter {

        @Override
        public void channelReadComplete(ChannelHandlerContext ctx) {
            ctx.flush();
        }

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws UnsupportedEncodingException {
            if(msg instanceof HttpRequest)
                sendResponse(ctx);
        }


        //  Response 부분
        private void sendResponse(ChannelHandlerContext ctx) throws UnsupportedEncodingException {
            final DefaultFullHttpResponse response =
                    new DefaultFullHttpResponse(
                            HttpVersion.HTTP_1_1,
                            HttpResponseStatus.OK,
                            Unpooled.wrappedBuffer("OK".getBytes(UTF_8)));
            response.headers().add("Content-length", 2);
            ctx.writeAndFlush(response);
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
            ctx.close();
        }
    }

    public class HttpInitializer extends ChannelInitializer<SocketChannel>{

        private final HttpHandler httpHandler = new HttpHandler();

        @Override
        protected void initChannel(SocketChannel ch) throws Exception {
            ch
                    .pipeline()
                    .addLast(new HttpServerCodec())     // HTTP Packet Decoding
                    .addLast(httpHandler);      // Event Handler
        }
    }

}
