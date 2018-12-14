package sample;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.function.Consumer;

public abstract class NetworkConnection {

    public static ArrayList<ConnectionThread> clientConnections= new ArrayList<ConnectionThread>();
    private ConnectionThread connThread;

    private Consumer<Serializable> onReceiveCallback;

    public NetworkConnection(Consumer<Serializable> onReceiveCallback){
        connThread=new ConnectionThread();
        clientConnections.add(connThread);
        this.onReceiveCallback = onReceiveCallback;
        connThread.setDaemon(true);
    }

    public void startConnection() throws Exception{
        connThread.start();
    }

    public void send(Serializable data)throws Exception{
        connThread.out.writeObject(data);
    }

    public void closeConnection() throws Exception{
        connThread.socket.close();
    }

    protected abstract boolean isServer();
    public abstract String getIp();
    protected abstract int getPort();

    private class ConnectionThread extends Thread {
        private Socket socket;
        private ObjectOutputStream out;
        public void run(){
            try(ServerSocket server = isServer() ? new ServerSocket(getPort()) : null;
                Socket socket = isServer() ? server.accept() : new Socket(getIp(), getPort());
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

                this.socket=socket;
                this.out=out;

                while(true){
                    Serializable data = (Serializable) in.readObject();
                    onReceiveCallback.accept(data);

                }
            }
            catch(Exception e){
                e.printStackTrace();
                onReceiveCallback.accept("Connection closed");
            }


        }
    }
}
