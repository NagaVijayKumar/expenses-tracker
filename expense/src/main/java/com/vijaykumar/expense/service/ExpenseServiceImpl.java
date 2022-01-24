package com.vijaykumar.expense.service;

import com.vijaykumar.expense.model.Expense;
import com.vijaykumar.expense.model.User;
import com.vijaykumar.expense.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class ExpenseServiceImpl implements ExpenseService {


    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String addExpense(Expense expense) {

        String email = expense.getEmail();

        User user =  restTemplate.getForObject("http://localhost:8081/user/"+email,User.class);
        //check the user is exitst with this email, form user microservice
        if(user==null){
            return "No user exists with this email";
        }

        expense.setCreatedTime(System.currentTimeMillis());

        //Get prevDue;


        expenseRepository.saveExpense(expense);
        return "Expensed added successfully";
    }

    @Override
    public long getDueAmount(String email) {
        //check the user is exitst with this email, form user microservice
       long dueAmount = expenseRepository.getDue(email);

       return dueAmount;
    }


}
