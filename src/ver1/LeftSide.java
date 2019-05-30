package ver1;

import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;

public class LeftSide extends VBox {

    public NetLearnButtonPane netLearnButtonPane;
    private Separator separator1;
    public AlphabetButtonsPane alphabetButtonsPane;
    private Separator separator2;
    public CanvasChart canvasChart;



    public LeftSide(double[] ov) {
        netLearnButtonPane = new NetLearnButtonPane();
        separator1 = new Separator();
        alphabetButtonsPane = new AlphabetButtonsPane();
        separator2 = new Separator();
        canvasChart = new CanvasChart(ov);
        getChildren().addAll(netLearnButtonPane, separator1, alphabetButtonsPane, separator2, canvasChart);


    }
}
