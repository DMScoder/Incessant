package com.decisivestudious.incessant.Managers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Immortan on 8/1/2016.
 */
public class SocketManager {

    private static final String serverAddress = "54.149.125.93";
    private static final int portNumber = 9090;
    private String answer = "Not connected";

    public SocketManager() {
        Socket socket = null;
        try {
            socket = new Socket(serverAddress,portNumber);
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            out.println("VerifiedUser");
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            answer = input.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getAnswer(){
        return answer;
    }
}
