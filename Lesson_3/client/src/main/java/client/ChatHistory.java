package client;

import java.io.*;
import java.nio.file.*;
import java.util.*;


public class ChatHistory {

    private static PrintWriter out;

    private static String getTheChatHistoryLogByLogin(String login) {
        return "ChatHistory/chatlog_" + login + ".txt";
    }

    public static void start(String login) {
        try {
            out = new PrintWriter(new FileOutputStream(getTheChatHistoryLogByLogin(login), true), true);
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    public static void stop() {
        if (out != null) {
            out.close();
        }
    }

    public static void msgRecording(String message) {
        out.println(message);
    }

    public static String getThe100LastMessages(String login) {
        if (!Files.exists(Paths.get(getTheChatHistoryLogByLogin(login)))) { // Если файл не существует вернуть ""
            return "";
        }
        StringBuilder stringbuilder = new StringBuilder();
        try {
            List<String> msgHistoryLines = Files.readAllLines(Paths.get(getTheChatHistoryLogByLogin(login)));
            int initialPosition = 0;
            if (msgHistoryLines.size() > 100) {
                initialPosition = msgHistoryLines.size() - 100;
            }
            for (int i = initialPosition; i < msgHistoryLines.size(); i++) {
                stringbuilder.append(msgHistoryLines.get(i)).append(System.lineSeparator());
            }
        }catch (IOException exception) {
            exception.printStackTrace();
        }
        return stringbuilder.toString();
    }
}