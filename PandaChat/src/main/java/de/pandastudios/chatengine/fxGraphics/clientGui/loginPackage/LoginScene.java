package de.pandastudios.chatengine.fxGraphics.clientGui.loginPackage;

import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcons;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginScene implements Initializable
{
    @FXML
    private Button buttonClose;
    @FXML
    private Button buttonZurueck;
    @FXML
    private Button buttonLogin;
    @FXML
    private TextField textFieldUsername;
    @FXML
    private PasswordField textFieldPasswort;
    @FXML
    private Label labelUsername;
    @FXML
    private Label labelPasswort;
    @FXML
    private BorderPane borderPaneLogin;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        labelUsername.setGraphic(GlyphsDude.createIcon(FontAwesomeIcons.USER,"20px"));
        labelPasswort.setGraphic(GlyphsDude.createIcon(FontAwesomeIcons.KEY,"20px"));
        buttonClose.setGraphic(GlyphsDude.createIcon(FontAwesomeIcons.CLOSE,"20px"));
        buttonZurueck.setGraphic(GlyphsDude.createIcon(FontAwesomeIcons.MAIL_REPLY,"20px"));

        buttonClose.setOnAction(e -> {
            (( Stage )buttonClose.getScene().getWindow()).close();
        });

        buttonZurueck.setOnAction(e -> {
            try
            {
                Stage stage;
                Parent root;

                if(e.getSource() == buttonZurueck)
                {
                    stage = (Stage) buttonZurueck.getScene().getWindow();
                    root = FXMLLoader.load(getClass().getResource("/StartScene.fxml"));
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }

            } catch (IOException ioException)
            {
                ioException.printStackTrace();
            }
        });
    }

    public void createUser(ActionEvent e) throws IOException
    {
        //hier der Code zum Userloin und erstellen der Verbindung zum Server

        //öffnen der ChatGui nach erfolgreichem Login
        Stage stage;
        Parent root;

        if(e.getSource() == buttonLogin)
        {
            stage = (Stage) buttonLogin.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/ClientChatroom.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
}