package org.example.ktz.rxjava.chap5;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.*;
import io.netty.handler.codec.http.*;

import java.io.UnsupportedEncodingException;

import static com.sun.xml.internal.stream.writers.WriterUtility.UTF_8;

@Sharable
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