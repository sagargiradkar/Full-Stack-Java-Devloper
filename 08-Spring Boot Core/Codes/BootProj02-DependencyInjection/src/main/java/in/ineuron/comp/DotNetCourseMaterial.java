package in.ineuron.comp;

import org.springframework.stereotype.Component;

@Component(value = "dotNet")
public class DotNetCourseMaterial implements ICourse {

	static {
		System.out.println("DotNetCourseMaterial.class file is loading ....");
	}

	public DotNetCourseMaterial() {
		System.out.println("DotNetCourseMaterial :: zero param Contructor ");
	}
	@Override
	public String courseContent() {
		System.out.println("courseContent dot net ");
		return "1.C#opps 2.Exception Handling";
	}

	@Override
	public float price() {
		return 699;
	}

}
