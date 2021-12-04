package main;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class ConvertController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button menu_btn;

    @FXML
    private TextArea num_bin;

    @FXML
    private TextArea num_dec;

    @FXML
    private TextArea num_hex;

    @FXML
    void initialize() {
        num_bin.setEditable(false);
        num_hex.setEditable(false);

        // Реализация слежения за изменением текста
        num_dec.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
                try {
                    num_bin.setText(main.alg.task20.dec_to_bin(Integer.parseInt(arg2)));
                    num_hex.setText(Integer.toHexString(Integer.parseInt(arg2)).toUpperCase());
                } catch (Exception e) {
                    // Исключение ошибки конвертации пустой строки в целочисленный
                    if (num_dec.getText().equals("")) {
                        num_bin.setText("");
                        num_hex.setText("");
                    } else {
                        num_bin.setText("Ошибка");
                        num_hex.setText("Ошибка");
                    }
                }
            }
        });

        menu_btn.setOnAction(event -> {
            try {
                App.setRoot("primary");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }

}
