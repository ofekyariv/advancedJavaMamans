

public class Words {
    private String remain="A B C D E F G H I J K L M N O P Q R S T U V W X Y Z";
    private int guesses=0;
    private int correct=0;
	private String word;
    private boolean[] hider;

    //constructor gets a word to initialise
    public Words(String word){
        this.word=word;
        hider=new boolean[word.length()];
        for (int i=0;i<word.length();i++) {
            hider[i]=false;
        }
    }

    //return the number of guesses
    public int getguesses() {
        return guesses;
    }

    //return the remaining letters
    public String getremain() {
        return remain;
    }

    //deletes a letter
    private void deleteLetter(char c){
        remain=remain.replaceAll((c+" "),"");
    }

    //return the current word guessed
    public String getCurrent(){
        String str="";
        for(int i=0;i<word.length();i++){
            if(hider[i])
                str+=word.charAt(i);
            else
                str+="_";
            str+=" ";
        }
        return str;
    }

    //return true if the game ended
    public boolean endGame(){
        return (word.length()==correct);
    }

    // return true if c is in the word
    public boolean guess(char c){
        boolean flag=false;
        if (remain.indexOf(c)<0)
            return false;
        guesses++;
        int i=0;
        while((i=word.indexOf(c,i))>=0){
            correct++;
            hider[i]=true;
        	flag=true;
            i++;
        }
        deleteLetter(c);
        return flag;
    }
}
