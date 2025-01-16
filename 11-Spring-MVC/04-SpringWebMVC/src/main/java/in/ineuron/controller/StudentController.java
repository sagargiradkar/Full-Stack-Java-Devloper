package in.ineuron.controller;

import in.ineuron.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    // Mapping to show the admission form
    @GetMapping("/admissionForm")
    public String showAdmissionForm() {
        return "admissionForm"; // Corresponds to `admissionForm.jsp`
    }

    // Mapping to handle form submission
    @PostMapping("/submitAdmissionForm")
    public String submitAdmissionForm(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("phone") String phone,
            @RequestParam("course") String course,
            Model model) {

        // Add form data to the model to display in the confirmation view
        model.addAttribute("name", name);
        model.addAttribute("email", email);
        model.addAttribute("phone", phone);
        model.addAttribute("course", course);

        return "admissionSuccess"; // Corresponds to `admissionSuccess.jsp`
    }

    @GetMapping("/studentinfo")
    public String getData(Model m){
        Student st = new Student();
        st.setId(1);
        st.setFirstName("Sagar");
        st.setLastName("Giradkar");
        st.setGender("MAle");
        st.setCity("Pune");
        st.setDob("09/09/2002");

        m.addAttribute("std",st);
        return "student";
    }

    @GetMapping("/studentform")
    public String showForm(Model m) {
        m.addAttribute("student", new Student());
        return "student_form";
    }

    @PostMapping("/submitstudent")
    public String submitForm(@ModelAttribute("student") Student student, Model m) {
        m.addAttribute("submittedStudent", student);
        return "student_display";
    }
}
