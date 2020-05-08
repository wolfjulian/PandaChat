package de.pandastudios.chatengine.fxGraphics.serverGui;

import de.pandastudios.chatengine.controller.Server;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ServerGuiController implements Initializable
{
    @FXML
    private Button buttonStart;
    @FXML
    private Button buttonStop;
    @FXML
    private Button buttonSend;
    @FXML
    private Button buttonTPS;
    @FXML
    private TextField textFieldPort;
    @FXML
    private TextField textFieldMessage;
    @FXML
    private ListView listChat;

    private Server server = new Server();
    private int port;



    //private ArrayList<DefaultListModel>  listMessages = new ArrayList<DefaultListModel>();
    private DefaultListModel nachrichten = new DefaultListModel();

    @Override
    public void initialize ( URL url, ResourceBundle resourceBundle )
    {
        buttonStart.setOnAction(e -> startServer());
        buttonStop.setOnAction(e -> stopServer());
        buttonSend.setOnAction(e -> sendMessage());

    }

    public void sendMessage()
    {
        String nachricht = textFieldMessage.getText();
        server.broadcast(nachricht);
        textFieldMessage.setText("");
    }

    public void stopServer()
    {
    }

    public void startServer()
    {
        port = Integer.parseInt(textFieldPort.getText());

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                server.startServer(port, nachrichten);
            }
        }).start();
    }



}
