package com.decisivestudious.incessant.Managers;

import com.decisivestudious.incessant.States.State;
import com.decisivestudious.incessant.States.StateManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Immortan on 8/1/2016.
 */
public class SocketManager implements Runnable{

    private static final String serverAddress = "54.149.125.93";
    private static final int portNumber = 9090;
    private String answer = "Not connected";
    private StateManager stateManager;
    private State activeState;
    private PrintWriter out;
    private BufferedReader input;
    private boolean listening = false;
    Socket socket = null;

    public SocketManager(StateManager stateManager) {
        this.stateManager = stateManager;
        Thread listeningThread = new Thread(this);
        listeningThread.start();
    }

    public void restartService() {
        if(listening)
            return;

        Thread listeningThread = new Thread(this);
        listeningThread.start();
    }

    private void setListener() {
        try {
            socket = new Socket(serverAddress,portNumber);
            out = new PrintWriter(socket.getOutputStream(),true);
            out.println("VerifiedUser");
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            answer = input.readLine();
            if(socket!=null){
                listening = true;
            }
        } catch (IOException e) {
            listening = false;
        }

        while(listening) {
            try {
                String string = input.readLine();
                activeState.socketMessage(string);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            if(socket!=null)
                socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void transferString(String string) {
        if(out !=null){
            out.println(string);
            System.out.println("Sent "+string);
        }
    }

    public void transferObject(Object object) {

    }

    public void setActiveState(State activeState){
        this.activeState = activeState;
    }

    public void deactivateState() {
        activeState = null;
    }

    public String getAnswer(){
        return answer;
    }

    @Override
    public void run() {
        setListener();
    }
}
