package in.ineuron.comp;

import org.springframework.stereotype.Component;

@Component(value = "java")
public class JavaCourseMaterial implements ICourse {
	
	static {
		System.out.println("JavaCourseMaterial.class file is loading ....");
	}

	public JavaCourseMaterial() {
		System.out.println("JavaCourseMaterial :: zero param Contructor ");
	}
	@Override
	public String courseContent() {
		System.out.println("courseContent method");
		return "1.oops 2.Exception Handling 3.Collections....";
	}

	@Override
	public float price() {
		return 4000;
	}

}
