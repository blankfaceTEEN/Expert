package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class UpdateController implements Initializable {
    @FXML
    private Label labelE;
    @FXML
    private PieChart pie;
    @FXML
    private Label resultE;

    String VAL;
    String REL;
    String REP;
    String KSM;

    public double transport(String VAL, String REL, String REP, String KSM) {
        this.VAL = VAL.replace(',', '.');
        this.REL = REL.replace(',', '.');
        this.REP = REP.replace(',', '.');
        this.KSM = KSM.replace(',', '.');

        double val = Double.parseDouble(this.VAL);
        double rel = Double.parseDouble(this.REL);
        double rep = Double.parseDouble(this.REP);
        double ksm = Double.parseDouble(this.KSM);

        System.out.println("val: " + val);
        System.out.println("rel: " + rel);
        System.out.println("rep: " + rep);
        System.out.println("ksm: " + ksm);
        System.out.println("умножение: " + (val * rel * rep * ksm));
        double e = Math.pow((val * rel * rep * ksm), (1./4));
        System.out.println("e: " + e);
        labelE.setText("E = " + String.format("%.2f", e));

        PieChart.Data slice1 = new PieChart.Data("VAL", val);
        PieChart.Data slice2 = new PieChart.Data("REL", rel);
        PieChart.Data slice3 = new PieChart.Data("REP", rep);
        PieChart.Data slice4 = new PieChart.Data("KSM", ksm);

        pie.getData().add(slice1);
        pie.getData().add(slice2);
        pie.getData().add(slice3);
        pie.getData().add(slice4);
        pie.setLabelsVisible(true);

        resultE.setText("Качество теста в рассматриваемом курсе " + String.format("%.0f",(e * 100)) + "% из 100%");
        return e;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
