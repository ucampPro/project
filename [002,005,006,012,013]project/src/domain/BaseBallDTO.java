package domain;

import java.io.Serializable;

public class BaseBallDTO implements Serializable{
	private String teamname;
	private int gamecount;
	private int win;
	private int moo;
	private int lose;
	private double percent;
	
	public BaseBallDTO() {
		super();
	}

	public BaseBallDTO(int gamecount, int win) {
		super();
		this.gamecount = gamecount;
		this.win = win;
	}

	public BaseBallDTO(String teamname, int gamecount, int win, int moo,
			int lose, double percent) {
		super();
		this.teamname = teamname;
		this.gamecount = gamecount;
		this.win = win;
		this.moo = moo;
		this.lose = lose;
		this.percent = percent;
	}
	
	public String getTeamname() {
		return teamname;
	}

	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}

	public int getGamecount() {
		return gamecount;
	}

	public void setGamecount(int gamecount) {
		this.gamecount = gamecount;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public int getMoo() {
		return moo;
	}

	public void setMoo(int moo) {
		this.moo = moo;
	}

	public int getLose() {
		return lose;
	}

	public void setLose(int lose) {
		this.lose = lose;
	}

	public double getPercent() {
		return percent;
	}

	public void setPercent(double percent) {
		this.percent = percent;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BaseBallBean [teamname=");
		builder.append(teamname);
		builder.append(", gamecount=");
		builder.append(gamecount);
		builder.append(", win=");
		builder.append(win);
		builder.append(", moo=");
		builder.append(moo);
		builder.append(", lose=");
		builder.append(lose);
		builder.append(", percent=");
		builder.append(percent);
		builder.append("]");
		return builder.toString();
	}
}
