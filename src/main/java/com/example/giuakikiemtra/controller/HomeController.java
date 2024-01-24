package com.example.giuakikiemtra.controller;

import com.example.giuakikiemtra.model.Product;
import com.example.giuakikiemtra.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/products")
public class HomeController {
    @Autowired
    IProductRepository productRepository;

    @GetMapping("")
    public ModelAndView showAll() {
        ModelAndView modelAndView = new ModelAndView("/home");
        modelAndView.addObject("listProduct", productRepository.findAll());
        return modelAndView;
    }

    @GetMapping("/{id}/view")
    public ModelAndView showView(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("/view");
        modelAndView.addObject("product", productRepository.findById(id).get());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView addProduct(Product product) {
        ModelAndView modelAndView = new ModelAndView("redirect:/products");
        productRepository.save(product);
        List<Product> listProduct = productRepository.findAll();
        modelAndView.addObject("listProduct", listProduct);
        return modelAndView;
    }

    @GetMapping("/{id}/delete")
    public ModelAndView deleteProduct(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/products");
        productRepository.deleteById(id);
        return modelAndView;
    }

    @GetMapping("/search")
    public ModelAndView searchByName(@RequestParam("keyword") String keyword) {
        ModelAndView modelAndView = new ModelAndView("/home");
        modelAndView.addObject("listProduct", productRepository.findAllByNameContains(keyword));
        return modelAndView;
    }

    @GetMapping("/{id}/update")
    public ModelAndView showUpdateForm(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("/update");
        modelAndView.addObject("product", productRepository.findById(id).get());
        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView update(Product product) {
        ModelAndView modelAndView = new ModelAndView("redirect:/products");
        productRepository.save(new Product(product.getId(),product.getName(),product.getDetail(),product.getPrice(),product.getDay()));
        List<Product> listProduct = productRepository.findAll();
        modelAndView.addObject("listProduct",listProduct);
        return modelAndView;
    }

}
