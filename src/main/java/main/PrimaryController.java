package main;

import java.io.IOException;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class PrimaryController {

    @FXML
    private Button go_btn;

    @FXML
    private Text preview_text;

    @FXML
    private RadioButton radio_convert;

    @FXML
    private RadioButton radio_func;

    @FXML
    private RadioButton radio_matr;

    @FXML
    private RadioButton radio_sort;

    @FXML
    void initialize() {
        RadioButton[] rbs = new RadioButton[] { radio_convert, radio_sort, radio_matr, radio_func };

        rbs_mechanics(rbs);

        // Загрузка выбранного задания
        go_btn.setOnAction(event -> {
            try {
                if (radio_sort.isSelected())
                    App.setRoot("task_sort");
                if (radio_convert.isSelected())
                    App.setRoot("task_convert");
                if (radio_matr.isSelected())
                    App.setRoot("task_matr");
                if (radio_func.isSelected())
                    App.setRoot("task_func");

            } catch (IOException e) {
                preview_text.setText("Произошла ошибка");
                preview_text.setTextAlignment(TextAlignment.CENTER);

                e.printStackTrace();
            }
        });
    }

    // Метод для выбора лишь одного варианта
    public static void rbs_mechanics(RadioButton[] rbs) {
        for (RadioButton radio : rbs) {
            radio.setOnMouseClicked(event -> {
                RadioButton selected_radio = radio;
                for (RadioButton radio1 : rbs) {
                    if (radio1 != selected_radio) {
                        radio1.setSelected(false);
                    }
                }

                // Тест работы

                // for (RadioButton rb : rbs)
                // System.out.printf("%s|%s\n", rb, rb.isSelected());
            });
        }

    }
}
