package application;

public class Student implements Comparable<Student>  {
	private String fName;
	private String lName;
	private String id;
	private int bDate;
	
	public Student (String fName, String lName, String id, int bDate) {
		this.fName = fName;
		this.lName = lName;
		this.id = id;
		this.bDate = bDate;
	}
	public String getId() {
		return this.id;
	}
	@Override
	public int compareTo(Student student){
		return this.id.compareTo(student.getId());
	}
	@Override
	public String toString() {
		return fName+" "+lName+" id: "+id+" born at: "+bDate;
	}
}
