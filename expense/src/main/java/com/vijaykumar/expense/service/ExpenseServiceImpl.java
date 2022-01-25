package com.vijaykumar.expense.service;

import com.vijaykumar.expense.model.Expense;
import com.vijaykumar.expense.model.User;
import com.vijaykumar.expense.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
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

        User user =  restTemplate.getForObject("http://USER-SERVICE/user/"+email,User.class);
        //check the user is exitst with this email, form user microservice
        if(user==null){
            return "No user exists with this email";
        }
        expense.setCreatedTime(System.currentTimeMillis());
        expenseRepository.saveExpense(expense);

        //Now add Current amount to Due amount
        user.setDueAmount(user.getDueAmount()+expense.getAmount());

        restTemplate.put("http://USER-SERVICE/user/updateUser/"+email, user, User.class);

        return "Expensed added successfully";
    }


}
