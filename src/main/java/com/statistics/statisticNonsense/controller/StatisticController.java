package com.statistics.statisticNonsense.controller;

import com.statistics.statisticNonsense.entity.Product;
import com.statistics.statisticNonsense.model.ButtonLog;
import com.statistics.statisticNonsense.service.ButtonService;
import com.statistics.statisticNonsense.service.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StatisticController {

    private final ButtonService buttonService;
    private final ProductService productService;

    public StatisticController(ButtonService buttonService, ProductService productService){
        this.buttonService = buttonService;
        this.productService = productService;
    }

    //Requests for buttons logging and reading data to/from csv file
    @PostMapping("/button/A")
    public ButtonLog buttona(@RequestParam String value){
        return buttonService.registerClick("A", value);
    }

    @PostMapping("/button/B")
    public ButtonLog buttonb(@RequestParam String value){
        return buttonService.registerClick("B", value);
    }

    @GetMapping("/clicks")
    public List<ButtonLog> getLogs() {
        return buttonService.getLogs();
    }

    //Requests for products using MySQL with JPA
    @PostMapping
    public Product create(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @GetMapping
    public List<Product> getAll(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getOne(@PathVariable Long id) {
        return productService.getProduct(id);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
