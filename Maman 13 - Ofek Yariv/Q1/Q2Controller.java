package application;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.text.Text;

public class Q2Controller {
	private int status;
	private int numOfCurrentAns; 
	private int numOfQuestions; 
	private Scanner input;
	private String correctAns; 
		
	@FXML
    private Button btnNext;
	@FXML
    private Text txtQuestion;
	@FXML
    private Text txtAnswer;
	@FXML
    private Text txtScore;
	@FXML
    private RadioButton answer1;
	@FXML
    private RadioButton answer2;
	@FXML
    private RadioButton answer3;
    @FXML
    private RadioButton answer4;
    @FXML
    public void initialize(){
    	try {
			buildTest();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
    }
    @FXML
    void answer1Pressed(ActionEvent event) {
    	answer1.setSelected(true);
    	answer2.setSelected(false);
    	answer3.setSelected(false);
    	answer4.setSelected(false);
    }
    @FXML
    void answer2Pressed(ActionEvent event) {
    	answer1.setSelected(false);
    	answer2.setSelected(true);
    	answer3.setSelected(false);
    	answer4.setSelected(false);
    }
    @FXML
    void answer3Pressed(ActionEvent event) {
    	answer1.setSelected(false);
    	answer2.setSelected(false);
    	answer3.setSelected(true);
    	answer4.setSelected(false);
    }
    @FXML
    void answer4Pressed(ActionEvent event) {
    	answer1.setSelected(false);
    	answer2.setSelected(false);
    	answer3.setSelected(false);
    	answer4.setSelected(true);
    }
    @FXML
    void btnNextPressed(ActionEvent event) {
    	switch (status){
    	case 0://normal question (next question)
			if((selectedAnswer() != -1))
			{ 
				String answer="";
				switch (selectedAnswer()) {
				case 1:
					answer = answer1.getText();
					break;
				case 2:
					answer = answer2.getText();
					break;
		    	case 3:
					answer = answer3.getText();
					break;
			    case 4:
					answer = answer4.getText();
					break;
				}
				if(correctAns.equals(answer)) 
				{
					numOfCurrentAns++;
					txtAnswer.setText("Currect");
				}
				else
				{
					txtAnswer.setText("InCorrect");
				}
				if(btnNext.getText().equals("Next")||btnNext.getText().equals("next")) {//see if not in the last question
					updateQuestion(); 	
					answer1.setSelected(false);
					answer2.setSelected(false);
					answer3.setSelected(false);
					answer4.setSelected(false);
				}
				else {//last question
					btnNext.setText("Reset Test");
		    		status=2;
		    		txtScore.setText(("you got " +numOfCurrentAns + " right ,your grade is "+(((double)numOfCurrentAns)/numOfQuestions)*100));
				}
			}
			break;
    	case 2://finished test (reset)
    		try {
				buildTest();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			btnNext.setText("next");
			break;
    	}
    }	
    private void buildTest() throws FileNotFoundException {//initialize
    	answer1.setSelected(false);
		answer2.setSelected(false);
		answer3.setSelected(false);
		answer4.setSelected(false);
		numOfCurrentAns = numOfQuestions = 0;
		correctAns ="";
		txtAnswer.setText("");
		txtScore.setText("");
		try {
			input = new Scanner(new File("exam.txt"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		status=0;
		updateQuestion();
	}
	public void updateQuestion()  {
		String [] questionsAnswers = new String [5]; 	
		if(input.hasNextLine()) {
				for (int i = 0; i < questionsAnswers.length ; i++) {
					questionsAnswers[i] = input.nextLine();
				}
				numOfQuestions++;
				correctAns = questionsAnswers[1] ;
				shuffle(questionsAnswers);
		}
		if(!input.hasNextLine()) {
			btnNext.setText("sumbit");
		}
		if(questionsAnswers[0] != null)
			txtQuestion.setText(questionsAnswers[0]);
		answer1.setText(questionsAnswers[1]);
		answer2.setText(questionsAnswers[2]);
		answer3.setText(questionsAnswers[3]);
		answer4.setText(questionsAnswers[4]);		
	}
	private void shuffle(String [] answers) {
		Random rand = new Random();
		int des = rand.nextInt(3)+1;
		for(int i = 1 ; i < answers.length ; i++) {
			String temp = answers[i];
			answers[i] = answers[des];
			answers[des] = temp;
			des = rand.nextInt(3)+1;
		}
	}
	private int selectedAnswer() {
		if(answer1.isSelected()) {
			return 1;
		}
		if(answer2.isSelected()) {
			return 2;
		}
		if(answer3.isSelected()) {
			return 3;
		}
		if(answer4.isSelected()) {
			return 4;
		}
		return -1;
	}
}
