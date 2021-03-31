import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.net.URL;
import java.util.ResourceBundle;

public class Window implements Initializable {
    @FXML
    public AnchorPane pane;

    @FXML
    public TextField textW;

    @FXML
    public TextField textH;

    @FXML
    public TextField textR;

    @FXML
    public ComboBox warunek;

    Funkcje funkcje;

    Group group;
    int war;

    public void dzialaj(){
        war = warunek.getSelectionModel().getSelectedIndex();
        funkcje = new Funkcje();
        group = new Group();

        Rectangle r;    // prostokat
        int width = Integer.parseInt(textW.getText());
        int height = Integer.parseInt(textH.getText());
        int rules = Integer.parseInt(textR.getText());

        int[] firstTable = funkcje.makeTable(width);
        int[] newTable = null;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0) {
                    if (firstTable[j] == 1) {

                        r = new Rectangle(j * 1, 0, 1, 1);   //czarny kwadrat
                        r.setFill(Color.BLACK);
                        group.getChildren().add(r);     //kwadracik do grupy by trafil do painta
                    }
                } else {

                    if (newTable[j] == 1) {
                        r = new Rectangle(j * 1, i * 1, 1, 1);
                        r.setFill(Color.BLACK);
                        group.getChildren().add(r);
                    }
                }
            }
            if (i == 0 && height > 1) {
                newTable = funkcje.makeTable2(rules, firstTable, war);
            } else {
                newTable = funkcje.makeTable2(rules, newTable, war);
            }
        }

        pane.getChildren().add(group);
    }


    public void reset(){
        pane.getChildren().remove(group);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        warunek.setItems(FXCollections.observableArrayList(
                "periodyczne", "jedynki na brzegach"));
        warunek.setValue("periodyczne");

    }
}
