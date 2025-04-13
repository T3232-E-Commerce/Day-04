package lk.ac.vau.fas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import lk.ac.vau.fas.model.Course;
import java.util.Map;

@RestController
@RequestMapping("/api/courses")
public class CourseController extends CRUDcontroller<String, Course> {
    
    
    Course c1 = new Course("ICT01", "Java Programming", 3);
    Course c2 = new Course("ICT02", "Database Management", 4);
    Course c3 = new Course("ICT03", "Web Development", 3);
    
    public CourseController() {
       
        getmap().put(c1.getCourseId(), c1);
        getmap().put(c2.getCourseId(), c2);
        getmap().put(c3.getCourseId(), c3);
    }
    
    
    @Override
    @GetMapping("/")
    public Map<String, Course> getAll() {
        return getmap();
    }
    
    @Override
    @GetMapping("/{id}")
    public Course get(@PathVariable("id") String id) {
        return getmap().get(id);
    }
    
    @Override
    @PostMapping("/")
    public Course add(@RequestBody Course course) {
        getmap().put(course.getCourseId(), course);
        return course;
    }
    
    @Override
    @PutMapping("/{id}")
    public Course update(@PathVariable("id") String id, @RequestBody Course course) {
        if (getmap().containsKey(id)) {
            course.setCourseId(id); 
            getmap().put(id, course);
            return course;
        }
        return null;
    }
    
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