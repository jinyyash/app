package hsm.serverInitializer;

import hsm.serverHandler.HttpServerHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpContentCompressor;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;


public class HttpServerInitializer extends ChannelInitializer <SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline channelPipeline=socketChannel.pipeline();

        channelPipeline.addLast("httpRequestDecoder", new HttpRequestDecoder());
        channelPipeline.addLast("httpResponseEncoder", new HttpResponseEncoder());
        channelPipeline.addLast("httpServerCodec", new HttpServerCodec());
        channelPipeline.addLast("httpContentCompressor", new HttpContentCompressor());
        channelPipeline.addLast("chunkedWriteHandler", new ChunkedWriteHandler());
        channelPipeline.addLast("httpHandler", new HttpServerHandler());
    }
}
