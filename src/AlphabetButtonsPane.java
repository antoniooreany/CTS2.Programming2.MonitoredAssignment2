import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class AlphabetButtonsPane extends VBox {
    private static final Button A_BTN = new Button("A");
    private static final Button B_BTN = new Button("B");
    private static final Button C_BTN = new Button("C");
    private static final Button D_BTN = new Button("D");
    private static final Button E_BTN = new Button("E");
    private static final Button F_BTN = new Button("F");
    private static final Button G_BTN = new Button("G");
    private static final Button H_BTN = new Button("H");

    public AlphabetButtonsPane() {
        getChildren().addAll(A_BTN, B_BTN, C_BTN, D_BTN, E_BTN, F_BTN, G_BTN, H_BTN);
        A_BTN.setOnMouseClicked(ae -> Main.rightSide.paintPattern(PaintData.getDoubles(Patterns.patternA)));
        B_BTN.setOnMouseClicked(ae -> Main.rightSide.paintPattern(PaintData.getDoubles(Patterns.patternB)));
        C_BTN.setOnMouseClicked(ae -> Main.rightSide.paintPattern(PaintData.getDoubles(Patterns.patternC)));
        D_BTN.setOnMouseClicked(ae -> Main.rightSide.paintPattern(PaintData.getDoubles(Patterns.patternD)));
        E_BTN.setOnMouseClicked(ae -> Main.rightSide.paintPattern(PaintData.getDoubles(Patterns.patternE)));
        F_BTN.setOnMouseClicked(ae -> Main.rightSide.paintPattern(PaintData.getDoubles(Patterns.patternF)));
        G_BTN.setOnMouseClicked(ae -> Main.rightSide.paintPattern(PaintData.getDoubles(Patterns.patternG)));
        H_BTN.setOnMouseClicked(ae -> Main.rightSide.paintPattern(PaintData.getDoubles(Patterns.patternH)));


//        B_BTN.setOnMouseClicked(ae -> Main.rightSide.paintPattern(Patterns.patternB));
//        C_BTN.setOnMouseClicked(ae -> Main.rightSide.paintPattern(Patterns.patternC));
//        D_BTN.setOnMouseClicked(ae -> Main.rightSide.paintPattern(Patterns.patternD));
//        E_BTN.setOnMouseClicked(ae -> Main.rightSide.paintPattern(Patterns.patternE));
//        F_BTN.setOnMouseClicked(ae -> Main.rightSide.paintPattern(Patterns.patternF));
//        G_BTN.setOnMouseClicked(ae -> Main.rightSide.paintPattern(Patterns.patternG));
//        H_BTN.setOnMouseClicked(ae -> Main.rightSide.paintPattern(Patterns.patternH));
    }

}
