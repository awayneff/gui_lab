package main;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class DialogueController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea arr_len_textarea;

    @FXML
    private Button proceed_btn;

    @FXML
    private Text caption_text;

    static String inp;

    @FXML
    void initialize() {
        proceed_btn.setOnAction(event -> {
            inp = arr_len_textarea.getText();

            if (!inp.equals("")) {
                try {
                    SortController.leng = Integer.parseInt(inp.trim());

                    System.out.println(SortController.leng);
                    if (SortController.leng > 1) {
                        Stage stage = (Stage) proceed_btn.getScene().getWindow();
                        stage.close();
                    } else {
                        caption_text.setText("Число должно быть\nбольше 1");
                        caption_text.setTextAlignment(TextAlignment.CENTER);
                    }
                } catch (NumberFormatException e) {
                    caption_text.setText("Неверное значение\nВведите длину массива");
                    caption_text.setTextAlignment(TextAlignment.CENTER);
                }
            } else {
                caption_text.setTextAlignment(TextAlignment.CENTER);
                caption_text.setText("Пустое значение\nВведите длину массива");
            }
        });
    }

}
