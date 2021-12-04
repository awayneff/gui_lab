package main;

import java.io.IOException;

import java.util.HashMap;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class SortController {

    @FXML
    private Text launch_again_text;

    @FXML
    private Text preview_text;

    @FXML
    private Button sort_btn;

    @FXML
    private Text sorted_arr_text;

    @FXML
    private TextArea sorted_arr_textarea;

    @FXML
    private Text source_arr_text;

    @FXML
    private TextArea source_arr_textarea;

    @FXML
    private Text sum_arr_text;

    @FXML
    private TextArea sum_arr_textarea;

    @FXML
    private Button menu_btn;

    static boolean len_det = false;
    public static int leng;

    @FXML
    void initialize() {
        sorted_arr_textarea.setEditable(false);
        source_arr_textarea.setEditable(false);
        sum_arr_textarea.setEditable(false);

        // Stage stage = (Stage) sort_btn.getScene().getWindow();
        // stage.setTitle("Сортировка");

        // Работа с GUI и выводом
        sort_btn.setOnAction(event -> {
            if (!len_det) {
                // Первый или повторный запуск
                try {
                    Stage dialogue_stage = new Stage();
                    Parent root = App.loadFXML("dialogue");
                    Scene scene = new Scene(root);

                    dialogue_stage.setScene(scene);
                    dialogue_stage.setTitle("Генератор массива");
                    dialogue_stage.show();

                    sort_btn.setText("Сортировка");

                    sorted_arr_textarea.setText("");
                    source_arr_textarea.setText("");
                    sum_arr_textarea.setText("");

                    len_det = true;

                } catch (IOException ioe) {
                    preview_text.setText("Возникла ошибка");
                    preview_text.setTextAlignment(TextAlignment.CENTER);
                    ioe.printStackTrace();
                }
            } else {
                // Решение задачи
                HashMap<String, String> solved = main.alg.task11.solve(leng);

                // Работа с внешним видом окна
                preview_text.setVisible(false);

                source_arr_textarea.setVisible(true);
                source_arr_text.setVisible(true);
                sorted_arr_textarea.setVisible(true);
                sorted_arr_text.setVisible(true);
                sum_arr_text.setVisible(true);
                sum_arr_textarea.setVisible(true);

                launch_again_text.setVisible(true);
                launch_again_text.setText("Для повторного запуска нажмите кнопку ещё раз");

                source_arr_textarea.setText(solved.get("source"));
                sorted_arr_textarea.setText(solved.get("sorted"));
                sum_arr_textarea.setText(solved.get("sum_arr"));

                sort_btn.setText("Запуск");
                len_det = false;
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
