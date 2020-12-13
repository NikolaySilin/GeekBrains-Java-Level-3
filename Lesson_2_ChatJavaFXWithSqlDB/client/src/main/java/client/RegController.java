package client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class RegController {
    @FXML
    private TextField loginField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField nicknameField;
    @FXML
    private TextArea textArea;

    private Controller controller;

    public void setController(Controller controller) {
        this.controller = controller;
    }

    @FXML
    public void tryToReg(ActionEvent actionEvent) {
        String login = loginField.getText().trim();
        String password = passwordField.getText().trim();
        String nickname = nicknameField.getText().trim();

        controller.tryToReg(login, password, nickname);
    }

    /*
    Пытался прикрутить алерт, но безуспешно)
    public static void showErrorMessage(String message, String errorMessage) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Регистрация успешно завершена, можете закрыть окно и перейти к вводу логина и пароля.");
        alert.setHeaderText(errorMessage);
        alert.setContentText(message);
        alert.showAndWait();
    }

    */

    public void addMessage(String msg) {
        textArea.appendText(msg + "\n");
    }
}
