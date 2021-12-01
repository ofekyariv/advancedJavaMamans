
/* 31/10/2021 - Ofek Yariv */
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PressMeController {

	private Words word;
    @FXML
    private Button btn;

    @FXML
    private TextField tfInput;

    @FXML
    private Label txtWord;

    @FXML
    void btnPress(ActionEvent event) {
    	String input = tfInput.getText().toString();
        char c;
        if (input!=null && !input.isEmpty() && input.length()==1) {
            c = input.toUpperCase().charAt(0);
            word.guess(c);
        }
        String text = word.getCurrent();
        text += "\n Choose letter from: \n";
        text += word.getremain();
        txtWord.setText(text);
        if (word.endGame()) {
        	tfInput.setText(word.getguesses()+" guesses");
        	tfInput.setEditable(false);
        }
        else {
        	tfInput.setText("");
            tfInput.requestFocus();
        }
    }
    @FXML
    public void initialize(){
    	Randomer randomer=new Randomer();
        word = new Words(randomer.getWord());
        String text = word.getCurrent();
        text += "\n Choose letter from: \n";
        text += word.getremain();
        txtWord.setText(text);
        btn.setText("Submit");
    }

}