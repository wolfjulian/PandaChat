package de.pandastudios.chatengine.fxGraphics.clientGui.chatroomPackage;

import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcons;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class ClientChatroom implements Initializable
{
    @FXML
    private Button buttonClose;
    @FXML
    private Button buttonExtra;
    @FXML
    private Button buttonSendMessage;
    @FXML
    private Button buttonEmoji;
    @FXML
    private TextArea textAreaMessage;
    @FXML
    private VBox chatBox;
    @FXML
    private TextFlow emojiList;
    @FXML
    private ImageView listImage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        buttonExtra.setOnAction(e -> chooseExtra());
        buttonSendMessage.setOnAction(e -> sendMessages());
        buttonEmoji.setOnAction(e -> showEmojiList());

        buttonClose.setOnAction(e -> {
            (( Stage )buttonClose.getScene().getWindow()).close();
        });

        buttonClose.setGraphic(GlyphsDude.createIcon(FontAwesomeIcons.CLOSE,"20px"));
        buttonExtra.setGraphic(GlyphsDude.createIcon(FontAwesomeIcons.PAPERCLIP,"20px"));
        buttonEmoji.setGraphic(GlyphsDude.createIcon(FontAwesomeIcons.SMILE_ALT,"20px"));
        buttonSendMessage.setGraphic(GlyphsDude.createIcon(FontAwesomeIcons.SEND,"18px"));

        showUser();
        sendEmoji();
    }

    public void sendEmoji()
    {
        for( Node emoji :emojiList.getChildren())
        {
            emoji.setOnMouseClicked(event -> {
                textAreaMessage.setText(textAreaMessage.getText()+ " "+(( Text )emoji).getText());
                emojiList.setVisible(false);
            });
        }
    }

    public void showUser()
    {

    }

    public void chooseExtra()
    {
        // to do: einfuegen von einzelnen ListViews und eines onclick events zum öffnen der größeren Desktopansicht

        Stage chooserScene = new Stage();

        FileChooser choose = new FileChooser();
        choose.setTitle("Datei auswählen!");
        choose.setInitialDirectory(new File(System.getProperty("user.home")));

        choose.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("BMP", "*.bmp"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png"),
                new FileChooser.ExtensionFilter("GIF", "*.gif")
        );
        File selectedFile = choose.showOpenDialog(listImage.getScene().getWindow());

        if (selectedFile != null)
        {
            System.out.println(selectedFile.getPath());
            Image selectedImage = new Image(selectedFile.toURI().toString());
            listImage.setImage(selectedImage);

        } else  {
            System.out.println("error");
        }
    }

    public void showEmojiList()
    {
        if(emojiList.isVisible())
        {
            emojiList.setVisible(false);
        }
        else {
            emojiList.setVisible(true);
        }
    }

    public void sendMessages()
    {
    }
}
