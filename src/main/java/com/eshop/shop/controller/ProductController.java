package com.eshop.shop.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.eshop.shop.interfaces.CategoryRepository;
import com.eshop.shop.interfaces.ProductRepository;
import com.eshop.shop.models.Product;

@Controller
public class ProductController {

   
    @Autowired
    private ProductRepository _repository;
    @Autowired
    private CategoryRepository _catRepository;
    private final Logger logger  = LoggerFactory.getLogger(ProductController.class);


    @GetMapping("/")
    public String HomePage(){
        return "index";
    }

    @GetMapping("/products")
    public String GetProducts(@RequestParam(value = "name", defaultValue = "") String name, Model model ) {

        logger.info("Receiving message.....");
        logger.error("Somethings happen");
        List<Product> productsList;
        if(!name.isEmpty()){
            productsList =  _repository.Get(e -> e.getName().equals(name));
        }
        else {
            productsList = _repository.Get();
        }
        model.addAttribute("productList", productsList);
        return "products/index";
  
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> GetById(@PathVariable Long id) {
        var product = _repository.GetById(id);
        if(product.isPresent() )
          return ResponseEntity.ok(product); 
        else  return ResponseEntity.badRequest().body(product); 
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

    @PostMapping("/")

    public ResponseEntity<Product> AddProduct( @RequestBody AddProductRecord requet){

        Product product = new Product(requet.Name, requet.Description); 
        _repository.Add(product);
              return ResponseEntity.ok(product);             
           
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

    @PostMapping("/{id}")
    public ResponseEntity<String> AddCategory(@PathVariable Long id, @RequestBody addCategoryRequest entity){

        var product = _repository.GetById(id).get();
            
        if(product != null){

            var category = _catRepository.GetById(entity.categoryId).get();
            if(category != null){

                product.CategoryId = entity.categoryId;
                category.Produsts.add(product);

                _catRepository.Update(category);
                
            return ResponseEntity.ok("category succesfuly added to a product"+ id +"!");

            }else return ResponseEntity.badRequest().body("Category not found");

        }
            return ResponseEntity.badRequest().body("record not found!");
    }


    record addCategoryRequest(Long categoryId){};

    record AddProductRecord(String Name, String Description, String CategoryName){}
}
