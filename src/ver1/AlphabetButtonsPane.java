package ver1;

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
        A_BTN.setOnMouseClicked(ae -> Main.rightSide.paintByPattern(PaintData.getPixelsRowCol(Patterns.patternA)));
        B_BTN.setOnMouseClicked(ae -> Main.rightSide.paintByPattern(PaintData.getPixelsRowCol(Patterns.patternB)));
        C_BTN.setOnMouseClicked(ae -> Main.rightSide.paintByPattern(PaintData.getPixelsRowCol(Patterns.patternC)));
        D_BTN.setOnMouseClicked(ae -> Main.rightSide.paintByPattern(PaintData.getPixelsRowCol(Patterns.patternD)));
        E_BTN.setOnMouseClicked(ae -> Main.rightSide.paintByPattern(PaintData.getPixelsRowCol(Patterns.patternE)));
        F_BTN.setOnMouseClicked(ae -> Main.rightSide.paintByPattern(PaintData.getPixelsRowCol(Patterns.patternF)));
        G_BTN.setOnMouseClicked(ae -> Main.rightSide.paintByPattern(PaintData.getPixelsRowCol(Patterns.patternG)));
        H_BTN.setOnMouseClicked(ae -> Main.rightSide.paintByPattern(PaintData.getPixelsRowCol(Patterns.patternH)));


//        B_BTN.setOnMouseClicked(ae -> ver1._Main.rightSide.paintByMatrix(ver1.Patterns.pattern2DB));
//        C_BTN.setOnMouseClicked(ae -> ver1._Main.rightSide.paintByMatrix(ver1.Patterns.pattern2DC));
//        D_BTN.setOnMouseClicked(ae -> ver1._Main.rightSide.paintByMatrix(ver1.Patterns.pattern2DD));
//        E_BTN.setOnMouseClicked(ae -> ver1._Main.rightSide.paintByMatrix(ver1.Patterns.pattern2DE));
//        F_BTN.setOnMouseClicked(ae -> ver1._Main.rightSide.paintByMatrix(ver1.Patterns.pattern2DF));
//        G_BTN.setOnMouseClicked(ae -> ver1._Main.rightSide.paintByMatrix(ver1.Patterns.pattern2DG));
//        H_BTN.setOnMouseClicked(ae -> ver1._Main.rightSide.paintByMatrix(ver1.Patterns.pattern2DH));
    }

}
