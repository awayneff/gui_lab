package main;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class FuncController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button launch_btn;

    @FXML
    private Button menu_btn;

    @FXML
    private TextArea output_textarea;

    @FXML
    void initialize() {
        launch_btn.setOnAction(event -> {
            String solved = main.alg.task21.solve();

            output_textarea.setText(solved);

            launch_btn.setDisable(true);
            launch_btn.setText("Выполнено");
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
