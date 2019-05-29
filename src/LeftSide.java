import javafx.scene.layout.VBox;

public class LeftSide extends VBox {

    public NetLearnButtonPane netLearnButtonPane;
    public AlphabetButtonsPane alphabetButtonsPane;
    public int[] data = new int[]{110, 120, 130, 140, 150, 160, 170, 180};
    public CanvasChart canvasChart;

    public LeftSide() {
        netLearnButtonPane = new NetLearnButtonPane();
        alphabetButtonsPane = new AlphabetButtonsPane();
        canvasChart = new CanvasChart(data);
        getChildren().addAll(netLearnButtonPane, alphabetButtonsPane, canvasChart);


    }
}
