package cn.edu.swjtu.pane;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class IndexPane extends GridPane {

    private Label lbHost;

    private Label lbPort;

    private TextField tfHost;

    private TextField tfPort;

    private Button submit;

    public IndexPane(){
        getChildren().clear();
        lbHost = new Label("Host:");
        lbPort = new Label("Port:");
        tfHost = new TextField();
        tfPort = new TextField();
        submit = new Button("submit");
        add(lbHost,0,0);
        add(tfHost,1,0);
        add(lbPort,0,1);
        add(tfPort,1,1);
        add(submit,1,3);
    }

    public TextField getTfHost() {
        return tfHost;
    }

    public void setTfHost(TextField tfHost) {
        this.tfHost = tfHost;
    }

    public TextField getTfPort() {
        return tfPort;
    }

    public void setTfPort(TextField tfPort) {
        this.tfPort = tfPort;
    }

    public Button getSubmit() {
        return submit;
    }

    public void setSubmit(Button submit) {
        this.submit = submit;
    }
}
