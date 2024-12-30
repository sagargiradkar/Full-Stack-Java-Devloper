package in.ineuron.comp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Student {

	@Autowired(required = true)
	@Qualifier(value = "java")
	private ICourse course;
	static {
		System.out.println("Student.class file is loading ....");
	}

	public Student() {
		System.out.println("Student :: zero param Contructor ");
	}
	
	public void preparation(String examName) {
		System.out.println("Student.preparation()");
		System.out.println("Course choose is :: "+course.getClass().getName());
		String couseContent = course.courseContent();
		System.out.println("Prepareation is going on using "+ couseContent+" material with price ::"+ course.price());
		System.out.println("Preparetion is completed for :: "+examName);
	}

	@Override
	public String toString() {
		return "Student [course=" + course + "]";

	}
	
}
