package application;

public class Map {
    private boolean[][] liveMap;
    private int size;
    //Random map
    public Map(int size){
        this.size=size;
        liveMap=new boolean[size][size];
        for(int i=0;i<size;i++) {
            for (int j = 0; j < size; j++) {
                liveMap[i][j] = (0 == (int) (Math.random() * 2));
            }
        }
    }
  //create the next generation
    public void nextGen(){
        boolean[][] temp=new boolean[size][size];
        for(int i=0;i<size;i++) {
            for (int j = 0; j < size; j++) {
                int liveNeighbours=countLiveNeighbours(i,j);
                if (liveNeighbours>=4) 
                    temp[i][j]=false;
                else if(liveNeighbours==3) 
                    temp[i][j]=true;
                else if(liveNeighbours<=1) 
                    temp[i][j]=false;
                else temp[i][j]=liveMap[i][j];
            }
        }

        for(int i=0;i<size;i++)
            for (int j = 0; j < size; j++)
                liveMap[i][j]=temp[i][j];
    }

	//count live neighbours of a cell
	public int countLiveNeighbours(int i,int j){
	    int counter=0;
	    if(i!=0)
	        if (liveMap[i-1][j])
	            counter++;
	    if(i!=size-1)
	        if (liveMap[i+1][j])
	            counter++;
	    if(j!=0)
	        if (liveMap[i][j-1])
	            counter++;
	    if (j!=size-1)
	        if (liveMap[i][j+1])
	            counter++;
	    if(i!=0&&j!=0)
	        if (liveMap[i-1][j-1])
	            counter++;
	    if (i!=0&&j!=size-1)
	        if (liveMap[i-1][j+1])
	            counter++;
	    if (i!=size-1&&j!=0)
	        if (liveMap[i+1][j-1])
	            counter++;
	    if (i!=size-1&&j!=size-1)
	        if (liveMap[i+1][j+1])
	            counter++;
	
	    return counter;
	}
	
    public int getSize() {
        return size;
    }

    public boolean[][] getBoard() {
        return liveMap;
    }
    
    
}