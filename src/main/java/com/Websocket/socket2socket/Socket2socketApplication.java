package com.Websocket.socket2socket;

import com.Websocket.socket2socket.Component.TransactionGen;
import com.Websocket.socket2socket.service.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableScheduling
public class Socket2socketApplication {
	@Autowired
	private WebSocketServer webSocketService;

	public static void main(String[] args) {
		SpringApplication.run(Socket2socketApplication.class, args);
	}




}
