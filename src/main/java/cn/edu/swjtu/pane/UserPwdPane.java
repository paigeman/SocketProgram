package cn.edu.swjtu.pane;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class UserPwdPane extends GridPane {

    private Label alert;

    private Label lbPwd;

    private PasswordField tfPwd;

    private Button submit;

    public UserPwdPane(){
        getChildren().clear();
        alert = new Label("Please input your password!");
        lbPwd = new Label("Password:");
        tfPwd = new PasswordField();
        submit = new Button("submit");
        add(alert,0,0);
        add(lbPwd,0,1);
        add(tfPwd,1,1);
        add(submit,1,2);
    }

    public TextField getTfPwd() {
        return tfPwd;
    }

    public void setTfPwd(PasswordField tfPwd) {
        this.tfPwd = tfPwd;
    }

    public Button getSubmit() {
        return submit;
    }

    public void setSubmit(Button submit) {
        this.submit = submit;
    }
}
