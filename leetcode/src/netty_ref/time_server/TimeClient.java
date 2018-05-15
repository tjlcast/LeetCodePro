package netty_ref.time_server;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * Created by tangjialiang on 2018/3/30.
 */
public class TimeClient {
    final String HOST ;
    final int PORT ;

    public TimeClient(String HOST, int PORT) {
        this.HOST = HOST;
        this.PORT = PORT;
    }

    public void run() throws InterruptedException {
        EventLoopGroup workGroup = new NioEventLoopGroup() ;

        try {
            Bootstrap bootstrap = new Bootstrap() ;
            bootstrap.group(workGroup)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel channel) throws Exception {
                            channel.pipeline().addLast(new TimeClientHandler()) ;
                        }
                    })
                    .option(ChannelOption.SO_KEEPALIVE, true) ;

            ChannelFuture f = bootstrap.connect(HOST, PORT).sync();
            f.channel().closeFuture().sync() ;
        } finally {
            workGroup.shutdownGracefully() ;
        }
    }
}
