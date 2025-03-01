package in.ineuron.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.model.Student;

@RestController
@RequestMapping("/api/student")
public class StudentRestController {
	
	@PostMapping("/register")
	public ResponseEntity<String> saveStudent(@RequestBody Student student){
		
		return new ResponseEntity<String>(null)
	}
}
