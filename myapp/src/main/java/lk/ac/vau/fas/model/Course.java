package lk.ac.vau.fas.model;

public class Course {
	private String courseId;
	private String name;
	private int credit;
	public Course(String courseId, String name, int credit) {
		super();
		this.courseId = courseId;
		this.name = name;
		this.credit = credit;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	
	
}
