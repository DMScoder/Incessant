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

    private static final String serverAddress = "54.213.145.190";
    private static final int portNumber = 9090;
    private String answer = "Not connected";
    private StateManager stateManager;
    private State activeState;
    private PrintWriter out;
    private BufferedReader input;
    private boolean listening = false;
    Thread listeningThread;
    Socket socket = null;

    public SocketManager(StateManager stateManager) {
        this.stateManager = stateManager;
    }

    public void startService(State state) {
        listeningThread = new Thread(this);
        listeningThread.start();
        setActiveState(state);
    }

    public void endService() {
        transferString("Exit");
        activeState = null;
        setListening(false);
    }

    private void setListener() {
        try {
            socket = new Socket(serverAddress,portNumber);
            out = new PrintWriter(socket.getOutputStream(),true);
            out.println("VerifiedUser");
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            answer = input.readLine();
            if(socket!=null){
                setListening(true);
            }
        } catch (IOException e) {
            setListening(false);
        }

        while(getListening()) {
            try {
                String string = input.readLine();
                if(activeState!=null)
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

    public synchronized void setActiveState(State activeState){
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

    private synchronized boolean getListening() {
        return listening;
    }

    private synchronized void setListening(boolean value){
        listening = value;
    }
}
