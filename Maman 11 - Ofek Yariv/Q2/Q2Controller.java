package application;

import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class Q2Controller {

    @FXML
    private Button btn;

    @FXML
    private Canvas canvas;
    
    @FXML
    void btnPressed(ActionEvent event) {
    	GraphicsContext gc = canvas.getGraphicsContext2D();
    	gc.clearRect(0,0,canvas.getWidth(), canvas.getHeight());
    	Random rand = new Random();
    	double randWidth=0;
    	double randHeight=0;
    	double endWidth=0;
    	double endHeight=0;
    	int randShape=0;
    	double red,green,blue;
    	for(int i=0;i<10;i++) {
    		randWidth = rand.nextDouble()*(canvas.getWidth());
    		randHeight = rand.nextDouble()*(canvas.getHeight());
    		endWidth =  (canvas.getWidth()/4) - (rand.nextDouble()*(canvas.getWidth()/4));
    		endHeight = (canvas.getHeight()/4) - (rand.nextDouble()*(canvas.getHeight()/4));
    		randShape = rand.nextInt(3);
    		red = Math.random();
			green = Math.random();
			blue = Math.random();
			gc.setStroke(new Color(red,green,blue,1));
			gc.setFill(new Color(red,green,blue,1));
    		switch (randShape){
    		case 0:
    			if(rand.nextBoolean()) {
        			gc.strokeLine(randWidth, randHeight, randWidth+endWidth, randHeight+endHeight);
        		}
        		else {
        			gc.strokeLine(randWidth+endWidth, randHeight, randWidth, randHeight+endHeight);
        		}
    			break;
    		case 1:
    			gc.fillOval(randWidth, randHeight, endWidth, endHeight);
    			break; 
    		case 2:
    			gc.fillRect(randWidth, randHeight, endWidth, endHeight);
    			break; 
    		}
    	}
    }
    	
}
