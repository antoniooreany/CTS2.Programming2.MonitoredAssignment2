import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class NetLearnButtonPane extends VBox {
    public final Button NEW_NET_BTN = new Button("New Net");
    public final ToggleButton NOISE_BTN = new ToggleButton("Noise");
    public final Button LEARN_500_CYCLES_BTN = new Button("Learn 500 Cycles");

    public NetLearnButtonPane() {
        getChildren().addAll(NEW_NET_BTN, NOISE_BTN, LEARN_500_CYCLES_BTN);
        NEW_NET_BTN.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
//            System.out.
                int colCount = Main.rightSide.colCount;
                int rowCount = Main.rightSide.rowCount;
                for (int col = 0; col < colCount; col++) {
                    for (int row = 0; row < rowCount; row++) {
                        if (row == 0) System.out.print("{" + NetLearnButtonPane.this.getaDouble(col, row) + ", ");
                        else if (row != rowCount - 1)
                            System.out.print(NetLearnButtonPane.this.getaDouble(col, row) + ", ");
                        else if (col != colCount - 1)
                            System.out.print(NetLearnButtonPane.this.getaDouble(col, row) + "},");
                        else System.out.print(NetLearnButtonPane.this.getaDouble(col, row) + "}");
                    }
                    System.out.println();
                }
            }
        });

//        NOISE_BTN.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                Main.leftSide.alphabetButtonsPane = new AlphabetButtonsPane();
//            }
//        });

    }

    private int getaDouble(int col, int row) {
        return Main.rightSide.getPixelsColorArray()[col][row];
    }
}
