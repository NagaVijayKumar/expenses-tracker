package com.vijaykumar.expense.controller;

import com.vijaykumar.expense.model.Expense;
import com.vijaykumar.expense.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/expenses")
public class ExpensesController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/test")
    public String test(){
        return "Expenses is running";
    }

    @PostMapping(path = "/addExpense")
    public String addExpense(@RequestBody Expense expense){

        return expenseService.addExpense(expense);
    }

    @GetMapping(path = "/getDue/{email}")
    public int getDueAmount(@PathVariable String email){

        return 0;
    }
}
