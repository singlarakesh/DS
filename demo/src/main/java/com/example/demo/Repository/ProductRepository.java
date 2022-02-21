package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

//import com.example.demo.model.Product;
import com.example.demo.model.Users;

public interface ProductRepository extends ElasticsearchRepository<Users, String> {

	List<Users> findByName(String name);

	List<Users> findByNameContaining(String name);

//	List<Users> findByManufacturerAndCategory(String manufacturer, String category);
}