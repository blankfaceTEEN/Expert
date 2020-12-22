package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private Label meanVAL = new Label("0");
    @FXML
    private Label meanREL = new Label("0");
    @FXML
    private Label meanREP = new Label("0");
    @FXML
    private Label meanKSM = new Label("0");
    @FXML
    private TextField VAL1 = new TextField("0.9");
    @FXML
    private TextField VAL2 = new TextField("0.8");
    @FXML
    private TextField VAL3 = new TextField("0.6");
    @FXML
    private TextField VAL4 = new TextField("0.9");
    @FXML
    private TextField VAL5 = new TextField("0.7");
    @FXML
    private TextField VAL6 = new TextField("0.9");
    @FXML
    private TextField REL1 = new TextField("0.8");
    @FXML
    private TextField REL2 = new TextField("0.7");
    @FXML
    private TextField REL3 = new TextField("0.8");
    @FXML
    private TextField REL4 = new TextField("0.7");
    @FXML
    private TextField REL5 = new TextField("0.7");
    @FXML
    private TextField REL6 = new TextField("1");
    @FXML
    private TextField REP1 = new TextField("0.8");
    @FXML
    private TextField REP2 = new TextField("0.7");
    @FXML
    private TextField REP3 = new TextField("0.7");
    @FXML
    private TextField REP4 = new TextField("0.8");
    @FXML
    private TextField REP5 = new TextField("0.8");
    @FXML
    private TextField REP6 = new TextField("1");
    @FXML
    private TextField KSM1 = new TextField("0.7");
    @FXML
    private TextField KSM2 = new TextField("0.8");
    @FXML
    private TextField KSM3 = new TextField("0.7");
    @FXML
    private TextField KSM4 = new TextField("0.6");
    @FXML
    private TextField KSM5 = new TextField("0.7");
    @FXML
    private TextField KSM6 = new TextField("1");

    double[] vals;
    double[] rels;
    double[] reps;
    double[] ksms;

    double E;
    double S;
    String YESNO;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        vals = new double[6];
        vals[0] = Double.parseDouble(VAL1.getText());
        vals[1] = Double.parseDouble(VAL2.getText());
        vals[2] = Double.parseDouble(VAL3.getText());
        vals[3] = Double.parseDouble(VAL4.getText());
        vals[4] = Double.parseDouble(VAL5.getText());
        vals[5] = Double.parseDouble(VAL6.getText());
        double sum = vals[0] + vals[1] + vals[2] + vals[3] + vals[4] + vals[5];
        double mean = sum / 6;
        System.out.println("meanVAL: " + mean);
        meanVAL.setText(String.valueOf(String.format("%.2f",mean)));

        rels = new double[6];
        rels[0] = Double.parseDouble(REL1.getText());
        rels[1] = Double.parseDouble(REL2.getText());
        rels[2] = Double.parseDouble(REL3.getText());
        rels[3] = Double.parseDouble(REL4.getText());
        rels[4] = Double.parseDouble(REL5.getText());
        rels[5] = Double.parseDouble(REL6.getText());
        sum = rels[0] + rels[1] + rels[2] + rels[3] + rels[4] + rels[5];
        mean = sum / 6;
        System.out.println("meanREL: " + mean);
        meanREL.setText(String.valueOf(String.format("%.2f",mean)));

        reps = new double[6];
        reps[0] = Double.parseDouble(REP1.getText());
        reps[1] = Double.parseDouble(REP2.getText());
        reps[2] = Double.parseDouble(REP3.getText());
        reps[3] = Double.parseDouble(REP4.getText());
        reps[4] = Double.parseDouble(REP5.getText());
        reps[5] = Double.parseDouble(REP6.getText());
        sum = reps[0] + reps[1] + reps[2] + reps[3] + reps[4] + reps[5];
        mean = sum / 6;
        System.out.println("meanREP: " + mean);
        meanREP.setText(String.valueOf(String.format("%.2f",mean)));

        ksms = new double[6];
        ksms[0] = Double.parseDouble(KSM1.getText());
        ksms[1] = Double.parseDouble(KSM2.getText());
        ksms[2] = Double.parseDouble(KSM3.getText());
        ksms[3] = Double.parseDouble(KSM4.getText());
        ksms[4] = Double.parseDouble(KSM5.getText());
        ksms[5] = Double.parseDouble(KSM6.getText());
        sum = ksms[0] + ksms[1] + ksms[2] + ksms[3] + ksms[4] + ksms[5];
        mean = sum / 6;
        System.out.println("meanKSM: " + mean);
        meanKSM.setText(String.valueOf(String.format("%.2f",mean)));
    }

    @FXML
    private void insertWindow(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLDocumentController(stage);
    }

    protected void FXMLDocumentController(Stage stage) throws IOException {
        System.out.println("Переход на следующее окно");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("nextFrame.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 400, 300);
        stage.getIcons().add(new Image("file:src/sample/icon.png"));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Экспертиза - Диаграмма");
        UpdateController updateController = (UpdateController) loader.getController();
        E = updateController.transport(meanVAL.getText(), meanREL.getText(), meanREP.getText(), meanKSM.getText());
        stage.show();
    }

    @FXML
    private void opinionsWindow(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        opinionsWindowController(stage);
    }

    protected void opinionsWindowController(Stage stage) throws IOException {
        System.out.println("Переход на следующее окно");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("opinionFrame.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 400, 350);
        stage.getIcons().add(new Image("file:src/sample/icon.png"));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Экспертиза - Согласованность");
        OpinionController opinionController = (OpinionController) loader.getController();
        YESNO = opinionController.transport(vals, rels, reps, ksms);
        stage.show();
    }

    @FXML
    private void objectWindow(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        objectWindowController(stage);
    }

    protected void objectWindowController(Stage stage) throws IOException {
        System.out.println("Переход на следующее окно");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("objectFrame.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 500, 235);
        stage.getIcons().add(new Image("file:src/sample/icon.png"));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Экспертиза - Объективность");
        ObjectController objectController = (ObjectController) loader.getController();
        objectController.transport(E, YESNO);
        stage.show();
    }
}
