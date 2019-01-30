package com.example.myapplicationtest.socket;

import android.util.Base64;
import android.util.Log;

import com.stomped.stomped.client.StompedListenerRouter;
import com.stomped.stomped.component.StompedCommand;
import com.stomped.stomped.component.StompedFrame;
import com.stomped.stomped.component.StompedHeaders;
import com.stomped.stomped.component.StompedMessageParser;
import com.stomped.stomped.connection.WebSocketConnector;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

public class WebSocketConnectorAddHeaders  {
    private final static String TAG = WebSocketConnector.class.toString();

    private final Object monitor = new Object();
    private static WebSocket stompedWebSocket;
    private Builder builder;
    private boolean connected;
    private boolean stompConnected;

    private class OkWebSocketListener extends WebSocketListener {

        @Override
        public void onOpen(WebSocket webSocket, Response response){

            connected = true;
            stompedWebSocket = webSocket;
            String auth = "Basic " + Base64.encodeToString(("user:user").getBytes(), Base64.NO_WRAP);
            StompedFrame frame = StompedFrame.construct(StompedCommand.STOMP_COMMAND_CONNECT);
            frame.addHeader(StompedHeaders.STOMP_HEADER_ACCEPT_VERSION, "1.0,1.1,2.0");
            frame.addHeader(StompedHeaders.STOMP_HEADER_HOST, "stomp.github.org");
            frame.addHeader(StompedHeaders.STOMP_HEADER_HEARTBEAT, "0," + builder.heartBeat);

            frame.addHeader("Authorization", auth);
            write(frame.build());

            Log.d(TAG, "OkHttp WebSocket connection created.");
        }

        @Override
        public void onMessage(WebSocket webSocket, String message){

            StompedFrame frame = StompedMessageParser.constructFrame(message);

            synchronized(monitor){
                if(frame.getCommand().equals(StompedCommand.STOMP_COMMAND_CONNECTED)){
                    stompConnected = true;
                    monitor.notifyAll();
                }
            }

            if(frame.getStompedHeaders().hasHeader(StompedHeaders.STOMP_HEADER_DESTINATION)){
                StompedListenerRouter.getInstance().sendMessage(frame);
            }

            Log.d(TAG, "Message received from server");
        }

        @Override
        public void onMessage(WebSocket webSocket, ByteString bytes){
            Log.d(TAG, "ByteString message received");
        }

        @Override
        public void onClosing(WebSocket webSocket, int code, String reason){
            Log.d(TAG, "WebSocket is closing: " + reason);
        }

        @Override
        public void onFailure(WebSocket webSocket, Throwable t, Response response){
            Log.d(TAG, "WebSocket failure\n", t);
        }
    }

    public final static class Builder{

        private int heartBeat = 0;

        public WebSocketConnectorAddHeaders connect(String url){

            WebSocketConnectorAddHeaders connector = new WebSocketConnectorAddHeaders(this);
            connector.build(url);

            return connector;
        }

        public Builder setHeartBeat(int milliseconds){
            this.heartBeat = milliseconds;
            return this;
        }
    }

    private WebSocketConnectorAddHeaders(Builder builder){
        this.connected = false;
        this.stompConnected = false;
        this.builder = builder;
    }

    private WebSocketConnectorAddHeaders build(String url){
        String auth = "Basic " + Base64.encodeToString(("user:user").getBytes(), Base64.NO_WRAP);
        //Build the client
        OkHttpClient okClient = new OkHttpClient.Builder()
                .readTimeout(0, TimeUnit.MILLISECONDS)
                .build();

        //Build The Request
        Request request = new Request.Builder().addHeader("Authorization", auth)
                .url(url)
                .build();

        okClient.newWebSocket(request, new OkWebSocketListener());

        return this;
    }

    public void disconnect(){
        stompedWebSocket.close(1000, null);
    }

    public void write(String payload){
        stompedWebSocket.send(payload);
    }

    public void write(ByteString payload){
        stompedWebSocket.send(payload);
    }

    public boolean isConnected(){
        return connected;
    }

    public boolean isStompConnected(){
        return stompConnected;
    }

    public Object getMonitor(){
        return monitor;
    }
}
