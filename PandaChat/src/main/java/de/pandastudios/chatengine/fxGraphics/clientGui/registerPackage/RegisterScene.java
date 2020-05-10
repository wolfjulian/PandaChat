package de.pandastudios.chatengine.fxGraphics.clientGui.registerPackage;

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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterScene implements Initializable
{
    @FXML
    private Button buttonClose;
    @FXML
    private Button buttonZurueck;
    @FXML
    private Button buttonRegister;
    @FXML
    private TextField textFieldUsername;
    @FXML
    private TextField textFieldChatname;
    @FXML
    private PasswordField textFieldPasswort;
    @FXML
    private PasswordField textFieldPasswortWdh;
    @FXML
    private Label labelUsername;
    @FXML
    private Label labelPasswort;
    @FXML
    private BorderPane borderPaneRegister;

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

    public void createNewUser(ActionEvent e) throws IOException
    {
        //hier der Code zum UserRegister und erstellen der Verbindung zum Server

        //öffnen der ChatGui nach erfolgreichem Registrieren
        Stage stage;
        Parent root;

        if(e.getSource() == buttonRegister)
        {
            stage = (Stage) buttonRegister.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/ClientChatroom.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
}