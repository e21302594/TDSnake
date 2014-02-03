package ubo.snake;

public class Score {
	private int score;
	public Score()
	{
		score=0;
	}
	
	public void inc()
	{
		score++;
	}
	
	public int getScore(){return score;}
	
	public String toString(){return ""+score;}
}
