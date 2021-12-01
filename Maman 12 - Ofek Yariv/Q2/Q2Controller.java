package application;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;

public class Q2Controller {
	Map map;
    @FXML
    private Button btn;
    @FXML
    private Canvas canvas;
    @FXML
    public void initialize(){
    	map=new Map(10);
        btn.setText("Start");
    }
    @FXML
    void btnPressed(ActionEvent event) {
    	btn.setText("Next Generation");
    	GraphicsContext gc = canvas.getGraphicsContext2D();
    	gc.clearRect(0,0,canvas.getWidth(), canvas.getHeight());  
		int mapSize=map.getSize();
        double cellWidth=canvas.getWidth()/mapSize;
        double cellHeight=canvas.getHeight()/mapSize;
        for (int i=0;i<mapSize;i++){
            for (int j=0;j<mapSize;j++){
                if(map.getBoard()[i][j]) {
                    gc.strokeRect(i, mapSize, cellWidth, cellHeight);
                    gc.fillRect(i * cellWidth, j * cellHeight, cellWidth, cellHeight);
                }
                else {
                    gc.strokeRect(i * cellWidth, j * cellHeight, cellWidth, cellHeight);
                }
            }
        }
        map.nextGen();	 
    }	
}
