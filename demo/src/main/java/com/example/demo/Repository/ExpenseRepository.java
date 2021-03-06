package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.example.demo.model.Expense;
//@Repository
@Component
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
 
	public List<Expense> findByItem(String item);
	
	@Query("select e from Expense e where e.amount>=:amt")
	public List<Expense>  findAllItemAbove(@Param("amt") float amt);
}
