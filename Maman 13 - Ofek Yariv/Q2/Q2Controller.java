package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Q2Controller {
	 
    private int numberStatus;
    public Calculator cl = new Calculator();
    @FXML
	private TextField textField;
    @FXML
    private Text massage;
    @FXML
    public void initialize(){
        textField.setEditable(false);
        numberStatus = -1;
    }
    @FXML
    void btnNumberPressed(ActionEvent event) {
    	String strNumber=event.getSource().toString();
    	strNumber=strNumber.substring(strNumber.length()-2, strNumber.length()-1);
    	int num = Integer.parseInt(strNumber);
        if (numberStatus <= 0)
            numberStatus += 2;
        textField.setText(textField.getText()+num);
    }	
    @FXML
    void btnActionPressed(ActionEvent event) {
    	String strAction=event.getSource().toString();
    	strAction=strAction.substring(strAction.length()-2, strAction.length()-1);
    	String action = strAction;
        switch (action){
            case ".":
                if (numberStatus == 1)
                {
                    textField.setText(textField.getText() + action);
                    numberStatus = 0;
                }
                else
                {
                    if (numberStatus == 2)
                        massage.setText("You can click '.' only ones");
                    if (numberStatus == -1)
                        massage.setText("You can click '.' in the middel of the number");
                }
                break;
            case ")"://(+/-)
                if (numberStatus == -1)
                {
                    textField.setText(textField.getText() + "(+/-)");
                }
                else{
                    massage.setText("You can click '(+/-)' only at begging of a number");
                }
                break;
            case "+":
            case "-":
            case "*":
            case "/":
                if (numberStatus >0)
                {
                    textField.setText(textField.getText() + action);
                    numberStatus = -1;
                }
                else{
                   massage.setText("You can click '"+action+"' only after a number");
                }
                break;
            case "C":
                textField.setText("");
                numberStatus=-1;
                break;
            case "=":
                if (numberStatus >0)
                {
                    System.out.printf("Start calculation%n");
                    try{
                        cl.equation(textField.getText());
                        if(cl.status) {
                            String res;
                            if (cl.result<0)
                                res = "(+/-)"+(cl.result+"").substring(1);
                            else
                                res = cl.result+"";
                            if (res.contains("."))
                                numberStatus = 2;
                            else
                                numberStatus = 1;
                            textField.setText(res);
                        }
                    }catch (Exception er){
                        if (er instanceof Errors){
                        	massage.setText(er.getMessage());
                        }
                    }
                }
                else{
                	massage.setText("You can click '"+action+"' only after a number");
                }
                break;
            default:
            	massage.setText("Un recognise Input");
                break;
        }
    }
}
