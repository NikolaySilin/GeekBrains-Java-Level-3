package chat.handler;

import chat.MyServer;
import chat.auth.AuthService;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class ClientHandler {

    private static final String AUTH_CMD_PREFIX = "/auth";
    private static final String AUTHOK_CMD_PREFIX = "/authok";
    private static final String AUTHERR_CMD_PREFIX = "/autherr";
    private static final String PRIVATE_MSG_CMD_PREFIX = "/w";
    private static final String CLIENT_MSG_CMD_PREFIX = "/clientMsg";
    private static final String SERVER_MSG_CMD_PREFIX = "/serverMsg";
    private static final String END_CMD = "/end";

    private final MyServer myServer;
    private final Socket clientSocket;
    private DataInputStream io;
    private DataOutputStream out;
    private String clientUsername;

    public ClientHandler(MyServer myServer, Socket clientSocket) {
        this.myServer = myServer;
        this.clientSocket = clientSocket;
    }

    public void handle() throws IOException {
        io = new DataInputStream(clientSocket.getInputStream());
        out = new DataOutputStream(clientSocket.getOutputStream());


        new Thread(() -> {
            try {
                authentication();
                readMessage();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }).start();

    }

    private void authentication() throws IOException {
        String message = io.readUTF();
        while (true) {
            if (message.startsWith(AUTH_CMD_PREFIX)) {
                String[] parts = message.split("\\s+", 3);
                String login = parts[1];
                String password = parts[2];

                AuthService authService = myServer.getAuthService();
                this.clientUsername = authService.getUsernameByLoginAndPassword(login, password);
                if (clientUsername != null) {
                    if (myServer.isUsernameBusy(clientUsername)) {
                        out.writeUTF(AUTHERR_CMD_PREFIX + " Логин уже используется");
                    }

                    out.writeUTF(AUTHOK_CMD_PREFIX + " " + clientUsername);
                    myServer.broadcastMessage(String.format(">>> %s присоединился к чату", clientUsername), this, true);
                    myServer.subscribe(this);
                    break;
                } else {
                    out.writeUTF(AUTHERR_CMD_PREFIX + " Логин или пароль не соответствуют действительности");
                }
            } else {
                out.writeUTF(AUTHERR_CMD_PREFIX + " Ошибка авторизации");
            }
        }
    }

    private void readMessage() throws IOException {
            while (true) {
                String message = io.readUTF();
                System.out.println("message | " + clientUsername + ": " + message);
                if (message.startsWith(END_CMD)) {
                    return;
                } else if (message.startsWith(PRIVATE_MSG_CMD_PREFIX)) {
                    String[] parts = message.split("\\s+", 3);
                    String recipient = parts[1];
                    String privateMessage = parts[2];
                    myServer.sendPrivateMessage(this, recipient, privateMessage);
                } else {
                    myServer.broadcastMessage(message, this, false);
                }
            }
    }

    public String getClientUsername() {
        return clientUsername;
    }

    public void sendMessage(String sender, String message) throws IOException {
        if (sender == null) {
            out.writeUTF(String.format("%s %s", SERVER_MSG_CMD_PREFIX, message));
        } else {
            out.writeUTF(String.format("%s %s %s", CLIENT_MSG_CMD_PREFIX, sender, message));
        }
    }
}
