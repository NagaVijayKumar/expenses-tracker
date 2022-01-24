package com.vijaykumar.expense.repository;

import com.vijaykumar.expense.model.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface ExpenseRepository{

    String saveExpense(Expense expense);

    long getDue(String email);

}