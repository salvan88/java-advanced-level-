package task2.sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    public TextField resultField;
    @FXML
    public TextField mainField;
    @FXML
    public Label operation;
    @FXML
    public Button buttonAdd;
    @FXML
    public Button buttonSub;
    @FXML
    public Button buttonMult;
    @FXML
    public Button buttonDiv;
    @FXML
    public Button buttonExp;
    @FXML
    public Button buttonResult;
    @FXML
    public Button clear;
    @FXML
    public Button changeSign;

    public void operands(ActionEvent event) {
        String s = ((Node)event.getSource()).getId();
        eraseNullMessage();
        if (!mainField.getText().isEmpty() && !resultField.getText().isEmpty()) {
            result();
        } else {
            resultField.appendText((mainField.getText()));
        }
        switch (s) {
            case "buttonAdd": {
                operation.setText(buttonAdd.getText());
                break;
            }
            case "buttonSub": {
                operation.setText(buttonSub.getText());
                break;
            }
            case "buttonMult": {
                operation.setText(buttonMult.getText());
                break;
            }
            case "buttonDiv": {
                operation.setText(buttonDiv.getText());
                break;
            }
            case "buttonExp": {
                operation.setText(buttonExp.getText());
                break;
            }
        }
        mainField.clear();
        mainField.requestFocus();
    }

    public void change() {
        if(mainField.getText().isEmpty()) {
            mainField.setText("-");
        } else if(mainField.getText().charAt(0) == '-'){
            mainField.setText(mainField.getText().substring(1));
        }
        else {
            mainField.setText("-" + mainField.getText());
        }
    }

    public void result() {
        double num1 = Double.parseDouble(resultField.getText());
        double num2 = Double.parseDouble(mainField.getText());
        char oper = operation.getText().charAt(0);
        switch (oper) {
            case '+': {
                resultField.setText(" " + (num1 + num2));
                break;
            }
            case '-': {
                resultField.setText(" " + (num1 - num2));
                break;
            }
            case '*': {
                resultField.setText(" " + (num1 * num2));
                break;
            }
            case '/': {
                if(num2 == 0) {
                    resultField.setText("Деление на ноль невозможно!");
                }
                else {
                    resultField.setText(" " + (num1 / num2));
                }
                break;
            }
            case '^': {
                resultField.setText(" " + (Math.pow(num1, num2)));
                break;
            }
        }
        operation.setText("");
        mainField.clear();
        mainField.requestFocus();
    }

    public void clear() {
        resultField.clear();
        mainField.clear();
        operation.setText("");
        mainField.requestFocus();
    }

    public void eraseNullMessage() {
        if(resultField.getText().equals("Деление на ноль невозможно!")){
            resultField.clear();
        }
    }
}