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
    
    public Map<K,T> getmap() {
        return objects;
    }
    
    @GetMapping("/")
    public Map<K,T> getAll(){
        return objects;
    }
    
    @GetMapping("/{id}")
    public T get(@PathVariable("id") K id) {
        return objects.get(id);
    }
    
    @PostMapping("/")
    public T add(@RequestBody T object) {
        // This method needs to be implemented in subclasses
        // since we need type-specific way to get the ID
        return null;
    }
    
    @PutMapping("/{id}")
    public T update(@PathVariable("id") K id, @RequestBody T object) {
        // This method needs to be implemented in subclasses
        // since we need type-specific way to handle updates
        return null;
    }
    
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") K id) {
        if (objects.containsKey(id)) {
            objects.remove(id);
            return true;
        }
        return false;
    }
}