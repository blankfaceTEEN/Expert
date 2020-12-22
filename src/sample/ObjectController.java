package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ObjectController {
    @FXML
    private TextField E;
    @FXML
    private TextField S;
    @FXML
    private TextField hi;
    @FXML
    private TextField Z;
    @FXML
    private TextField meanS;

    double P = 0.95;

    public void transport(double E, String YESNO) {
        this.E.setText(String.valueOf(E));
        this.hi.setText(YESNO);
        this.S.setText(meanS.getText());
        this.Z.setText(String.valueOf(Math.sqrt(E * P)));
    }
}
