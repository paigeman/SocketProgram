package cn.edu.swjtu.pane;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class UserNamePane extends GridPane {

    private Label welcome;

    private Label lbName;

    private TextField tfName;

    private Button submit;

    public UserNamePane(){
        getChildren().clear();
        welcome = new Label("Welcome!Please input your username!");
        lbName = new Label("username:");
        tfName = new TextField();
        submit = new Button("submit");
        add(welcome,0,0);
        add(lbName,0,1);
        add(tfName,1,1);
        add(submit,1,2);
    }

    public TextField getTfName() {
        return tfName;
    }

    public void setTfName(TextField tfName) {
        this.tfName = tfName;
    }

    public Button getSubmit() {
        return submit;
    }

    public void setSubmit(Button submit) {
        this.submit = submit;
    }
}
