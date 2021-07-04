package Core;

import java.net.Socket;

public class ClientManager {
    Bank serverHolder;
    Socket clientHolder;

    public ClientManager(Bank server, Socket client) {
        serverHolder = server;
        clientHolder = client;
    }

}
