package lk.ac.vau.fas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import lk.ac.vau.fas.MyappApplication;
import lk.ac.vau.fas.model.Student;

@RestController
@RequestMapping("/app")
public class StudentController extends CRUDcontroller<String,Student> {

    
    Student s1= new Student("2020ICT07", "Udara", 21, "ICT", 3.9);
    Student s2= new Student("2020ICT06", "Jello", 27, "ICT", 3.2);
    Student s3= new Student("2020ICT91", "Dilmy", 32, "ICT", 2.9);
    
    public StudentController(MyappApplication myappApplication) {
        getmap().put(s1.getRegNo(), s1);
        getmap().put(s2.getRegNo(), s2);
        getmap().put(s3.getRegNo(), s3);
        
    }
    
	    //get all students
	    @Override
	    @GetMapping("/")
	    public Map<String, Student> getAll(){
	        return getmap();
	    }
	        
	    
	    //get student by id
	    @Override
	    @GetMapping("/{id}")
	    public Student get(@PathVariable("id") String id) {
	        Student student = getmap().get(id);
	        if (student == null) {
	            //printf("student not found");
	        }
	        return student;
	    }
	    
        //add student
        @Override
        @PostMapping("/") 
        public Student add(@RequestBody Student student) {
            getmap().put(student.getRegNo(), student);
            return student;
        }
        
        //update
        @Override
        @PutMapping("/{id}")
        public Student update(@PathVariable("id") String id, @RequestBody Student student) {
            if (getmap().containsKey(id)) {
                student.setRegNo(id); // Ensure registration number consistency
                getmap().put(id, student);
                return student;
            }
            return null;
        }
        
        //delete 
        @Override
        @DeleteMapping("/{id}")
        public boolean delete(@PathVariable("id") String id) {
            if (getmap().containsKey(id)) {
                getmap().remove(id);
                return true;
            }
            return false;
        }
}