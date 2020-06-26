package task1.sample;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class Controller {
    @FXML
    public TextArea chatField;
    @FXML
    public TextField messageField;

    public void enterPressed(KeyEvent enter) {
        if (enter.getCode() == KeyCode.ENTER)
            sendMessageAction();
    }

    public void sendMessageAction() {
        if (!messageField.getText().isEmpty()) {
            chatField.appendText(messageField.getText() + "\n");
        }
        messageField.requestFocus();
        messageField.clear();
    }
}