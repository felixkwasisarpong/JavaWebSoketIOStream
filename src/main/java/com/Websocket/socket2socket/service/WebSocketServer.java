package com.Websocket.socket2socket.service;

import com.Websocket.socket2socket.Component.TransactionGen;
import org.java_websocket.client.WebSocketClient;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.Arrays;

@Service
public class WebSocketServer{
    // Define host and port
    private static final String HOST = "localhost";
    private static final int PORT = 5050;

    // Data to be sent
    private static final String MESSAGE = "Hello, Server!";
    private static final byte[] DATA = MESSAGE.getBytes();

    // Method to send data to socket
    @Scheduled(fixedRate = 60000) // Send data every 1 minute
    public void sendDataToSocket() {
        try (Socket socket = new Socket(HOST, PORT)) {
            OutputStream outputStream = socket.getOutputStream();
            byte [] data = new TransactionGen().generateTransactionData();
            System.err.println(String.format("Parsing incoming: '%s'", new String(data)));
            outputStream.write(data);
            outputStream.flush();
            System.out.println("Data written to socket successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

