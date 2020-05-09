package de.pandastudios.chatengine.fxGraphics.serverGui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.nio.file.Paths;

public class ServerMain extends Application
{
    @Override
    public void start ( Stage stage ) throws Exception
    {
        System.out.println(Paths.get("/src/main/resources/ServerGui.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("../../../../../../resources/ServerGui.fxml"));
        stage.setTitle("Server");
        stage.setScene(new Scene(root, 400, 400));
        stage.show();
    }
}
