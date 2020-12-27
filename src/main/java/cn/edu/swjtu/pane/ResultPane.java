package cn.edu.swjtu.pane;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class ResultPane extends GridPane {

    private Label result;

    public ResultPane(){
        getChildren().clear();
        result = new Label("");
        add(result,1,1);
    }

    public Label getResult() {
        return result;
    }

    public void setResult(Label result) {
        this.result = result;
    }
}
