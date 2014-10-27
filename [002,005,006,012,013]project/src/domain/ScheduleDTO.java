package domain;

public class ScheduleDTO {
	private int code;
	private String year;
	private String month;
	private String day;
	private String hour;
	private String firstTeam;
	private String secondTeam;
	private int firstScore;
	private int secondScore;
	public ScheduleDTO() {
		super();
	}
	public ScheduleDTO(int code, String year, String month, String day,
			String hour, String firstTeam, String secondTeam, int firstScore,
			int secondScore) {
		super();
		this.code = code;
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.firstTeam = firstTeam;
		this.secondTeam = secondTeam;
		this.firstScore = firstScore;
		this.secondScore = secondScore;
	}
	
	public ScheduleDTO(int code, int firstScore, int secondScore) {
		super();
		this.code = code;
		this.firstScore = firstScore;
		this.secondScore = secondScore;
	}
	public ScheduleDTO(int code, String year, String month, String day,
			String hour, String firstTeam, String secondTeam) {
		super();
		this.code = code;
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.firstTeam = firstTeam;
		this.secondTeam = secondTeam;
	}
	public ScheduleDTO(String year, String month, String day,
			String hour, String firstTeam, String secondTeam) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.firstTeam = firstTeam;
		this.secondTeam = secondTeam;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getHour() {
		return hour;
	}
	public void setHour(String hour) {
		this.hour = hour;
	}
	public String getFirstTeam() {
		return firstTeam;
	}
	public void setFirstTeam(String firstTeam) {
		this.firstTeam = firstTeam;
	}
	public String getSecondTeam() {
		return secondTeam;
	}
	public void setSecondTeam(String secondTeam) {
		this.secondTeam = secondTeam;
	}
	public int getFirstScore() {
		return firstScore;
	}
	public void setFirstScore(int firstScore) {
		this.firstScore = firstScore;
	}
	public int getSecondScore() {
		return secondScore;
	}
	public void setSecondScore(int secondScore) {
		this.secondScore = secondScore;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ScheduleDTO [code=");
		builder.append(code);
		builder.append(", year=");
		builder.append(year);
		builder.append(", month=");
		builder.append(month);
		builder.append(", day=");
		builder.append(day);
		builder.append(", hour=");
		builder.append(hour);
		builder.append(", firstTeam=");
		builder.append(firstTeam);
		builder.append(", secondTeam=");
		builder.append(secondTeam);
		builder.append(", firstScore=");
		builder.append(firstScore);
		builder.append(", secondScore=");
		builder.append(secondScore);
		builder.append("]");
		return builder.toString();
	}
}
