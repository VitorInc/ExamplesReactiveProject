package com.example.reactiveProjectExample;

import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;

public class LowLevelReactiveProgramming {

    try

    {
        AsynchronousSocketChannel channel = AsynchronousSocketChannel.open(AsynchronousChannelGroup.withThreadPool(ExecutorService))

        channel.connect(new InetSocketAddress("http://localhost/", 8080),null, new CompletionHandler<Void, Void>()) {
            @Override
            public void completed(Void result, Void attachment) {
                String httpRequest = "GET" + path + "HTTP/1.1\r \n" +
                        "Host: " + url + " : " + port + " \r \n" +
                        "Connection : close \r \n \r \n";
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                buffer.put(httpRequest.getBytes(StandardCharsets.UTF_8));
                buffer.flip();

                channel.write(buffer, null, new CompletionHandler<Integer, Void>() {
                    @Override
                    public void completed(Integer result,Void attachment ) {
                        ByteBuffer responseBuffer = ByteBuffer.allocate(1024);
                        channel.read(responseBuffer, responseBuffer, new CompletionHandler<Integer, ByteBuffer>() {
                            @Override
                            public void completed(Integer bytesRead, ByteBuffer responseBuffer) {
                                responseBuffer.flip();
                                String responseBody = StandardCharsets.UTF_8.decode(responseBuffer).toString();
                                subscriber.onNext(responseBody);
                                subscriber.onCompleted();
                            }

                            @Override
                            public void failed(Throwable exc, ByteBuffer attachment) {
                                subscriber.onError(exc);
                            }
                        })
                        @Override
                        public void failed(Throwable exc, ByteBuffer attachment) {
                            subscriber.onError(exc);
                        }
                    }
                });
    }

    }

    }
}

