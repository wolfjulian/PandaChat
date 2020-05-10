package de.pandastudios.chatengine.fxGraphics.clientGui.startPackage;

import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcons;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StartScene implements Initializable
{
    //Elemente von StartScene
    @FXML
    private Button buttonLogin;
    @FXML
    private Button buttonRegister;
    @FXML
    private Button buttonClose;
    @FXML
    private AnchorPane anchorPaneStart;

    private double xOffset;
    private double yOffset;

    /*Elemente von LoginScene
    private LoginScene loginScene;

    //Elemente von RegisterScene
    private RegisterScene registerScene;

    */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        buttonClose.setGraphic(GlyphsDude.createIcon(FontAwesomeIcons.CLOSE,"20px"));
        buttonClose.setOnAction(e -> closeForm());
    }

    public void closeForm()
    {
        (( Stage )buttonClose.getScene().getWindow()).close();
    }

    public void registerUser(ActionEvent e) throws IOException
    {
        Stage stage;
        Parent root;

        if(e.getSource() == buttonRegister)
        {
            stage = (Stage) buttonRegister.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/RegisterScene.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    public void loginUser(ActionEvent e) throws IOException
    {
        Stage stage;
        Parent root;

        if(e.getSource() == buttonLogin)
        {
            stage = (Stage) buttonLogin.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/LoginScene.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }


}