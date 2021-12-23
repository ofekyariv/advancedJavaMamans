package application;
/* 21/12/2021 - Ofek Yariv */

import java.util.Map;

public class Main {
	
	public static void main(String[] args) {
		Student[] arrStudents = new Student[3];
		String[] arrPhones = new String[3];
		arrStudents[0]= new Student("ofek","yariv","208572467",1997);
		arrStudents[1]= new Student("ofek2","yariv2","208571468",1997);
		arrStudents[2]= new Student("ofek3","yariv3","108574469",1997);
		arrPhones[0]="0545780801";
		arrPhones[1]="0545780802";
		arrPhones[2]="0545780803";
		AssociationTable<Student, String> at = new AssociationTable<Student, String>(arrStudents,arrPhones);

		at.add(new Student("ofek4","yariv4","208574470",1997), "0545780804");
		at.add(arrStudents[0],"0545780805");
		at.remove(arrStudents[1]);
		for (Student entry : at.keyIterator()) {
		     System.out.println("Key: " + entry.toString() + ". Value: " + at.get(entry));
		}
	}
}
