package de.pandastudios.chatengine.fxGraphics.clientGui.chatroomPackage;

import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        buttonExtra.setOnAction(e -> chooseExtra());
        buttonSendMessage.setOnAction(e -> sendMessages());
        buttonEmoji.setOnAction(e -> showEmojiList());

        buttonClose.setOnAction(e -> {
            (( Stage )buttonClose.getScene().getWindow()).close();
        });

        /*buttonClose.setGraphic(GlyphsDude.createIcon(FontAwesomeIcon.CLOSE,"20px"));
        buttonExtra.setGraphic(GlyphsDude.createIcon(FontAwesomeIcon.PAPERCLIP,"20px"));
        buttonEmoji.setGraphic(GlyphsDude.createIcon(FontAwesomeIcon.SMILE_ALT,"20px"));
        buttonSendMessage.setGraphic(GlyphsDude.createIcon(FontAwesomeIcon.SEND,"18px"));
        */
        showUser();
        sendEmoji();
    }

    public void sendEmoji()
    {
        for( Node emoji :emojiList.getChildren())
        {
            emoji.setOnMouseClicked(event -> {
                textAreaMessage.setText(textAreaMessage.getText()+" "+(( Text )emoji).getText());
                emojiList.setVisible(false);
            });
        }
    }

    public void showUser()
    {

    }

    public void chooseExtra()
    {
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
