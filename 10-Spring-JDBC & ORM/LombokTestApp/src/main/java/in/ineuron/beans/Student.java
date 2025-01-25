package in.ineuron.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class Student {

	@NonNull
	private Integer sid;
	@NonNull
	private String sname;
	private String saddress;
	private Integer sage;
}
