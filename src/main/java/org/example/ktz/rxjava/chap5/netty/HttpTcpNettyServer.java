package org.example.ktz.rxjava.chap5.netty;


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
    public void main(String[] args) throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            new ServerBootstrap()
                    .option(ChannelOption.SO_BACKLOG, 50_000)
                    .group(bossGroup, workGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new HttpInitializer())
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
                    .addLast(new HttpServerCodec())
                    .addLast(httpHandler);
        }
    }

}
