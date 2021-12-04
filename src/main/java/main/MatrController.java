package main;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class MatrController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button go_btn;

    @FXML
    private TextArea main_diagonal_textarea;

    @FXML
    private TextArea matr_textarea;

    @FXML
    private Button menu_btn;

    @FXML
    private TextArea sec_diagonal_textarea;

    @FXML
    private Text not_rect_text;

    @FXML
    private Text size_text;

    @FXML
    void initialize() {
        go_btn.setOnAction(event -> {
            HashMap<String, String> solved = main.alg.task19.solve();
            size_text.setText(solved.get("size"));

            matr_textarea.setText(solved.get("matr"));

            if (solved.get("main").equals("")) {
                not_rect_text.setVisible(true);

                main_diagonal_textarea.setText(solved.get(""));
                sec_diagonal_textarea.setText(solved.get(""));

            } else {
                not_rect_text.setVisible(false);
                main_diagonal_textarea.setText(solved.get("main"));
                sec_diagonal_textarea.setText(solved.get("secondary"));
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
