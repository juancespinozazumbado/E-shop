package com.eshop.shop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eshop.shop.interfaces.CategoryRepository;
import com.eshop.shop.models.Catrgory;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
    

    // @Autowired
    // private ProductRepository _repository;
    @Autowired
    private CategoryRepository _repository;

    @GetMapping("/")
    public List<Catrgory> GetCategories(@RequestParam(value = "name", defaultValue = "") String name ) {

        if(!name.isEmpty()){

          return _repository.Get( e -> e.Name.equals(name));
        }
        else   
          return _repository.Get();
  
    }

    @GetMapping("/{id}")
    public Optional<Catrgory> GetById(@PathVariable Long id) {
        return _repository.GetById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> Remove(@PathVariable Long id){

        var product = _repository.GetById(id).get();
        
        if(product != null){
            _repository.Remove(product);

            return ResponseEntity.ok("record succesfuly deleted!");
        }else {
            return ResponseEntity.badRequest().body("record not found!");
        }
       
    }

    @PutMapping("/{id}")

    public ResponseEntity<String> Update(@PathVariable Long id, @RequestBody String entity){

            var product = _repository.GetById(id).get();
            
            if(product != null){
                _repository.Update(product);
    
                return ResponseEntity.ok("record succesfuly deleted!");
            }

                return ResponseEntity.badRequest().body("record not found!");
           
    }


    record addCategoryRequest(Long categoryId){};


}

