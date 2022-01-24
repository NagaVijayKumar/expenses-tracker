package com.vijaykumar.expense.repository;

import com.vijaykumar.expense.model.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ExpenseRepositoryImpl implements ExpenseRepository {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public ExpenseRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


    @Override
    public String saveExpense(Expense expense) {
        mongoTemplate.save(expense);
        return "Expense Added Successfully";
    }

    @Override
    public long getDue(String email) {
        Expense expense = mongoTemplate.findById(email,Expense.class);

        return expense.getAmount();
    }
}
