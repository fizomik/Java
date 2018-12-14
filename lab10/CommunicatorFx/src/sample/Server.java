package sample;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.function.Consumer;

public class Server extends NetworkConnection{

    private int port;
    private ArrayList<Client> al;

    public Server(int port, Consumer<Serializable> onReceiveCallback) {
        super(onReceiveCallback);
        this.port=port;
        al = new ArrayList<Client>();
    }

    @Override
    protected boolean isServer() {
        return true;
    }

    @Override
    public String getIp() {
        return null;
    }

    @Override
    protected int getPort() {
        return port;
    }
}
