package com.example.demo.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.ExpenseRepository;
import com.example.demo.Repository.ProductRepository;
import com.example.demo.Repository.ProductSearchServiceWithRepo;
import com.example.demo.model.Expense;
//import com.example.demo.model.Product;
import com.example.demo.model.userException;

@RestController
public class ExpenseController {
	Logger logger = LoggerFactory.getLogger(ExpenseController.class);
	@Autowired
	ExpenseRepository repository;
//
//	@Autowired
//	ProductSearchServiceWithRepo repo;
//	@Autowired
//	private ProductRepository productRepository;

//	@RequestMapping("/putProduct")
//	public void putProduct(@RequestBody Product p) {
//		repo.createProductIndex(p);
//	}
//
//	@GetMapping(value = "/getProduct")
//	public void putProduct() {
//		System.out.println("dshgdfh");
//		List<Product> list = productRepository.findByName("Shisdgshrts");
//		System.out.println(list);
////		return productRepository.findByName("Shirts");
//	}

	@RequestMapping("/hello")
	public void expenseFunc() {
		repository.save(new Expense("breakfast", 5));
		repository.save(new Expense("coffee", 2));
		repository.save(new Expense("New SSD drive", 200));
		repository.save(new Expense("Tution for baby", 350));
		repository.save(new Expense("Some apples", 5));

		Iterable<Expense> iterator = repository.findAll();
		if (iterator == null) {
			throw new userException("no expense found");
		}
		System.out.println("All expense items: ");
		iterator.forEach(item -> System.out.println(item));

		List<Expense> breakfast = repository.findByItem("breakfast");
		System.out.println("\nHow does my breakfast cost?: ");
		breakfast.forEach(item -> System.out.println(item));

		List<Expense> expensiveItems = repository.findAllItemAbove(200);
		System.out.println("\nExpensive Items: ");
		expensiveItems.forEach(item -> System.out.println(item));
	}
}
