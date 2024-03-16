package com.Websocket.socket2socket.Component;

import org.bitbucket.openisoj2.postilion.Iso8583Postilion;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@Component
public class TransactionGen {
    // Create an instance of Iso8583Postilion and other necessary objects
    public byte[] generateTransactionData() throws Exception {
        Iso8583Postilion isoMsg = new Iso8583Postilion();
        isoMsg.setMsgType(RandomMsgType());
        isoMsg.set(3, RandomProcCode()); // Processing Code
        isoMsg.set(4, CashAmount());   // Transaction Amount (in cents)
        isoMsg.set(7, Datetime()); // Transmission Date & Time (MMDDhhmmss)
        isoMsg.set(11, "123456"); // System Trace Audit Number
        isoMsg.set(12, Local_time()); // Time, Local Transaction (hhmmss)
        isoMsg.set(13, Local_date()); // Date, Local Transaction (MMDD)
        isoMsg.set(22, "021"); // Point of Service Entry Mode
        isoMsg.set(32, "12345678901"); // Acquiring Institution ID
        isoMsg.set(37, "123456789012"); // Retrieval Reference Number
        isoMsg.set(41, "12345678"); // Card Acceptor Terminal ID
        isoMsg.set(42, "876543210000000"); // Card Acceptor ID
        isoMsg.set(43, "Merchant Name                           "); // Card Acceptor Name/Location
        isoMsg.set(49, "840"); // Transaction Currency Code
        return isoMsg.toMsg();
    }

    private String Local_date() {
        LocalDate currentDate = LocalDate.now();
        // Define the format pattern
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMdd");
        // Format the current date
        String formattedDate = currentDate.format(formatter);

        return formattedDate;
    }

    private String Local_time() {
        LocalTime currentTime = LocalTime.now();
        // Define the format pattern
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmmss");
        // Format the current time
        String formattedTime = currentTime.format(formatter);

        return formattedTime;
    }

    private String CashAmount() {
        String[] arr = new String[] { "000000010000", "000000022000", "000000000300", "000000000100","000000000400","000000007000"};
        System.err.println(arr[new Random().nextInt(arr.length)]);
        return arr[new Random().nextInt(arr.length)];
    }

    private String Datetime() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddHHmmss");
        // Format the current time
        String formattedDateTime = currentDateTime.format(formatter);
        System.out.println(formattedDateTime);
        return formattedDateTime;
    }

    private String RandomProcCode() {
        String[] arr = new String[] { "000000", "010000", "210000", "130000"};
        return arr[new Random().nextInt(arr.length)];
    }

    private int RandomMsgType() {
        int[] arr = new int[] { 512, 528, 256, 272, 1056, 1072};
        return arr[new Random().nextInt(arr.length)];
    }
}
