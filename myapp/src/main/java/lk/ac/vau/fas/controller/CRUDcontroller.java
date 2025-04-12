package lk.ac.vau.fas.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class CRUDcontroller<K,T> {
	private Map<K,T> objects = new HashMap<K,T>();
	
	public Map<K,T>getmap() {
		return objects;
	}
	
	//get all
	@GetMapping("/")
	public Map<K,T> getAll(){
		return objects;
	}
	
	//get by id
	@GetMapping("/{id}")
	public T get(@PathVariable("id") K id) {
		return objects.get(id);
	}
	
	//add
	@PostMapping("/")
	public T add(@RequestBody T object, @RequestBody K id) {
	    objects.put(id, object);
	    return object;
	}
	
	//update
	@PutMapping("/{id}")
	public T update(@PathVariable("id") K id, @RequestBody T object) {
	    if (objects.containsKey(id)) {
	        objects.put(id, object);
	        return object;
	    }
	    return null; 
	}

	//delete
	@DeleteMapping("/{id}")
	public boolean delete(@PathVariable("id") K id) {
	    if (objects.containsKey(id)) {
	        objects.remove(id);
	        return true;
	    }
	    return false; 
	}
}


