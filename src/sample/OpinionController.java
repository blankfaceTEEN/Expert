package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OpinionController {
    @FXML
    private TextField VAL1;
    @FXML
    private TextField VAL2;
    @FXML
    private TextField VAL3;
    @FXML
    private TextField VAL4;
    @FXML
    private TextField VAL5;
    @FXML
    private TextField VAL6;
    @FXML
    private TextField REL1;
    @FXML
    private TextField REL2;
    @FXML
    private TextField REL3;
    @FXML
    private TextField REL4;
    @FXML
    private TextField REL5;
    @FXML
    private TextField REL6;
    @FXML
    private TextField REP1;
    @FXML
    private TextField REP2;
    @FXML
    private TextField REP3;
    @FXML
    private TextField REP4;
    @FXML
    private TextField REP5;
    @FXML
    private TextField REP6;
    @FXML
    private TextField KSM1;
    @FXML
    private TextField KSM2;
    @FXML
    private TextField KSM3;
    @FXML
    private TextField KSM4;
    @FXML
    private TextField KSM5;
    @FXML
    private TextField KSM6;
    @FXML
    private TextField VALSUM;
    @FXML
    private TextField RELSUM;
    @FXML
    private TextField REPSUM;
    @FXML
    private TextField KSMSUM;
    @FXML
    private TextField textFieldr;
    @FXML
    private TextField V1;
    @FXML
    private TextField V2;
    @FXML
    private TextField V3;
    @FXML
    private TextField V4;
    @FXML
    private TextField V5;
    @FXML
    private TextField V6;
    @FXML
    private TextField T1;
    @FXML
    private TextField T2;
    @FXML
    private TextField T3;
    @FXML
    private TextField T4;
    @FXML
    private TextField T5;
    @FXML
    private TextField T6;
    @FXML
    private TextField Tsum;
    @FXML
    private TextField K;
    @FXML
    private TextField hi;
    @FXML
    private Label result;

    double[] VAL;
    double[] REL;
    double[] REP;
    double[] KSM;

    double[] expert1;
    double[] expert2;
    double[] expert3;
    double[] expert4;
    double[] expert5;
    double[] expert6;

    double[] r1;
    double[] r2;
    double[] r3;
    double[] r4;
    double[] r5;
    double[] r6;
    double[][] matrixR;

    double max;
    int maxIndex;
    int[] match;
    int[] order;
    double meanr;

    public String transport(double[] VAL, double[] REL, double[] REP, double[] KSM) {
        this.VAL = VAL;
        this.REL = REL;
        this.REP = REP;
        this.KSM = KSM;

        expert1 = new double[] {VAL[0], REL[0], REP[0], KSM[0]};
        expert2 = new double[] {VAL[1], REL[1], REP[1], KSM[1]};
        expert3 = new double[] {VAL[2], REL[2], REP[2], KSM[2]};
        expert4 = new double[] {VAL[3], REL[3], REP[3], KSM[3]};
        expert5 = new double[] {VAL[4], REL[4], REP[4], KSM[4]};
        expert6 = new double[] {VAL[5], REL[5], REP[5], KSM[5]};

        r1 = rank(expert1);
        r2 = rank(expert2);
        r3 = rank(expert3);
        r4 = rank(expert4);
        r5 = rank(expert5);
        r6 = rank(expert6);

        VAL1.setText(String.valueOf(r1[0]));
        VAL2.setText(String.valueOf(r2[0]));
        VAL3.setText(String.valueOf(r3[0]));
        VAL4.setText(String.valueOf(r4[0]));
        VAL5.setText(String.valueOf(r5[0]));
        VAL6.setText(String.valueOf(r6[0]));

        REL1.setText(String.valueOf(r1[1]));
        REL2.setText(String.valueOf(r2[1]));
        REL3.setText(String.valueOf(r3[1]));
        REL4.setText(String.valueOf(r4[1]));
        REL5.setText(String.valueOf(r5[1]));
        REL6.setText(String.valueOf(r6[1]));

        REP1.setText(String.valueOf(r1[2]));
        REP2.setText(String.valueOf(r2[2]));
        REP3.setText(String.valueOf(r3[2]));
        REP4.setText(String.valueOf(r4[2]));
        REP5.setText(String.valueOf(r5[2]));
        REP6.setText(String.valueOf(r6[2]));

        KSM1.setText(String.valueOf(r1[3]));
        KSM2.setText(String.valueOf(r2[3]));
        KSM3.setText(String.valueOf(r3[3]));
        KSM4.setText(String.valueOf(r4[3]));
        KSM5.setText(String.valueOf(r5[3]));
        KSM6.setText(String.valueOf(r6[3]));

        VALSUM.setText(String.valueOf(r1[0] + r2[0] + r3[0] + r4[0] + r5[0] + r6[0]));
        RELSUM.setText(String.valueOf(r1[1] + r2[1] + r3[1] + r4[1] + r5[1] + r6[1]));
        REPSUM.setText(String.valueOf(r1[2] + r2[2] + r3[2] + r4[2] + r5[2] + r6[2]));
        KSMSUM.setText(String.valueOf(r1[3] + r2[3] + r3[3] + r4[3] + r5[3] + r6[3]));

        matrixR = getMatrix(r1, r2, r3, r4, r5, r6);

        meanr = (Double.parseDouble(VALSUM.getText()) + Double.parseDouble(RELSUM.getText())
                + Double.parseDouble(REPSUM.getText()) + Double.parseDouble(KSMSUM.getText())) / 4;

        textFieldr.setText(String.valueOf(meanr));

        V1.setText(String.valueOf(getV(0)));
        V2.setText(String.valueOf(getV(1)));
        V3.setText(String.valueOf(getV(2)));
        V4.setText(String.valueOf(getV(3)));
        V5.setText(String.valueOf(getV(4)));
        V6.setText(String.valueOf(getV(5)));

        T1.setText(String.valueOf(getT(Integer.parseInt(V1.getText()))));
        T2.setText(String.valueOf(getT(Integer.parseInt(V2.getText())) + getT(Integer.parseInt(V2.getText()))));
        T3.setText(String.valueOf(getT(Integer.parseInt(V3.getText()))));
        T4.setText(String.valueOf(getT(Integer.parseInt(V4.getText()))));
        T5.setText(String.valueOf(getT(Integer.parseInt(V5.getText()))));
        T6.setText(String.valueOf(getT(Integer.parseInt(V6.getText()))));

        Tsum.setText(String.valueOf(Integer.parseInt(T1.getText()) + Integer.parseInt(T2.getText())
                + Integer.parseInt(T3.getText()) + Integer.parseInt(T4.getText())
                + Integer.parseInt(T5.getText()) + Integer.parseInt(T6.getText())));

        int sum = Integer.parseInt(T1.getText()) + Integer.parseInt(T2.getText())
                + Integer.parseInt(T3.getText()) + Integer.parseInt(T4.getText())
                + Integer.parseInt(T5.getText()) + Integer.parseInt(T6.getText());
        System.out.println(sum);
        K.setText(String.valueOf(getK(meanr, matrixR, sum)));
        hi.setText(String.valueOf(gethi(meanr, matrixR, sum)));

        if (Double.parseDouble(hi.getText()) < 7.8) {
            result.setText("Мнение экспертов не согласованно, относительно «отличного» качества теста");
            return "Нет";
        } else {
            result.setText("Мнение экспертов согласованно, относительно «отличного» качества теста");
            return "Да";
        }
    }

    private double getK(double rMean, double[][] matrix, int sumT) {
        double K = 0;
        double up = 0;
        double down = 0;
        System.out.println("rMean: " + rMean);
        up = (Double.parseDouble(VALSUM.getText()) - rMean) * (Double.parseDouble(VALSUM.getText()) - rMean)
                + (Double.parseDouble(RELSUM.getText()) - rMean) * (Double.parseDouble(RELSUM.getText()) - rMean)
                + (Double.parseDouble(REPSUM.getText()) - rMean) * (Double.parseDouble(REPSUM.getText()) - rMean)
                + (Double.parseDouble(KSMSUM.getText()) - rMean) * (Double.parseDouble(KSMSUM.getText()) - rMean);
        System.out.print("K = " + up + " / ");
        System.out.println(sumT);
        down = (0.083) * (36 * 60 - 6 * sumT);
        System.out.println("down " + down);
        K = up/down;
        System.out.println("K = " + K);
        return K;
    }

    private double gethi(double rMean, double[][] matrix, int sumT) {
        double hi = 0;
        double up = 0;
        double down = 0;
        System.out.println("rMean: " + rMean);
        up = (Double.parseDouble(VALSUM.getText()) - rMean) * (Double.parseDouble(VALSUM.getText()) - rMean)
                + (Double.parseDouble(RELSUM.getText()) - rMean) * (Double.parseDouble(RELSUM.getText()) - rMean)
                + (Double.parseDouble(REPSUM.getText()) - rMean) * (Double.parseDouble(REPSUM.getText()) - rMean)
                + (Double.parseDouble(KSMSUM.getText()) - rMean) * (Double.parseDouble(KSMSUM.getText()) - rMean);
        System.out.print("K = " + up + " / ");
        System.out.println(sumT);
        down = (0.083) * (24 * 3 - (double) sumT / (double) 3);
        System.out.println("down " + down);
        hi = up/down;
        System.out.println("K = " + hi);
        return hi;
    }

    private double[][] getMatrix(double[] a, double[] b, double[] c, double[] d, double[] e, double[] f) {
        double[][] matrix = new double[4][6];
        for(int i = 0; i < 4; i++) {
            matrix[i][0] = a[i];
            matrix[i][1] = b[i];
            matrix[i][2] = c[i];
            matrix[i][3] = d[i];
            matrix[i][4] = e[i];
            matrix[i][5] = f[i];
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        return matrix;
    }

    private double[] rank(double[] expert) {
        System.out.println();
        double[] rk = new double[4];
        match = new int[] {1, 2, 3, 4};
        max = getMax(expert);
        boolean matches = false;

        for(int i = 0; i < expert.length; i++) {
            double check = expert[i];
            for (int j = 0; j < match.length; j++) {
                if (i != j && check == expert[j]) {
                    match[j] = match[i];
                    matches = true;
                }
            }
        }

        System.out.println("Совпадения: ");
        for(int i = 0; i < 4; i++) {
            System.out.println("[" + i + "]: " + match[i]);
        }

        ArrayList<Double> buffer = new ArrayList<>();
        for(int i = 0; i < expert.length; i++) {
            buffer.add(expert[i]);
        }
        Collections.sort(buffer);
        Collections.reverse(buffer);

        int count = 0;
        order = new int[4];
        double[] data = new double[4];
        for(int i = 0; i < 4; i++) {
            data[i] = expert[i];
        }
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                if (buffer.get(i) == data[j]) {
                    order[j] = i + 1;
                    data[j] = -1;
                    break;
                }
            }
        }

        for(int i = 0; i < 4; i++) {
            rk[i] = order[i];
        }
        System.out.println("Ранги до исправления: ");
        for(int i = 0; i < order.length; i++) {
            System.out.println("[" + i + "]: " + rk[i]);
        }


        double sum;
        int c;
        for(int i = 0; i < 4; i++) {
            sum = 0;
            c = 0;
            for (int j = 0; j < 4; j++) {
                if(match[i] == match[j]){
                    sum += order[j];
                    c++;
                    rk[i] = sum / c;
                }
            }

        }
        System.out.println("Ранги: ");
        for(int i = 0; i < order.length; i++) {
            System.out.println("[" + i + "]: " + rk[i]);
        }

        return rk;
    }

    private double getMax(double[] b) {
        double m = b[0];
        maxIndex = 0;
        for(int i = 1; i < b.length; i++)
            if (m < b[i]) {
                m = b[i];
                maxIndex = i;
            }
        return m;
    }

    private int getV(int number) {
        int V = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (matrixR[i][number] == matrixR[j][number]) {
                    V++;
                }
            }
            if (V <= 1) {
                V = 0;
            }
            else {
                return V;
            }
        }
        System.out.println("V" + number + " = " + V);
        return V;
    }

    private int getT(int v) {
        System.out.println("T: " + (v*v*v - v));
        return v*v*v - v;
    }
}
