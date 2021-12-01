
/* 31/10/2021 - Ofek Yariv */
public class Randomer {
	private String[] words={"HELLO","WORLD","OFEK","YARIV","BOSS","DINER","FLY","DANCE","MONKEY","LOLIPOP","HUMAN","MOON","SPACE","TESLA"};

    public String getWord(){
        int i=(int)(words.length*Math.random());
        return words[i];
    }
}
