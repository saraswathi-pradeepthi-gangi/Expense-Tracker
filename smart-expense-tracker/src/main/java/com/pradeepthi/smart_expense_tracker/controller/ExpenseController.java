package com.pradeepthi.smart_expense_tracker.controller;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pradeepthi.smart_expense_tracker.model.Expense;
import com.pradeepthi.smart_expense_tracker.service.ExpenseService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;


@RestController
public class ExpenseController{
    private final ExpenseService service;
    public ExpenseController(ExpenseService service){
        this.service = service;
    }
    @GetMapping("/expenses")
    public List<Expense>  getExpenses(){
        return service.showExpenses();
    }
    @GetMapping("/expenses./{id}")
    public ResponseEntity<Expense> getExpenseById(@PathVariable int id){
        Expense expense =  service.getExpenseById(id);
        if(expense!=null){
            return ResponseEntity.ok(expense);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    @PostMapping("/expenses")
    public void addExpense(@RequestBody Expense expense){
        service.addExpense(expense);
    }
    @PutMapping("/expenses/{id}")
    public ResponseEntity<Expense> updateExpense(@PathVariable int id,@RequestBody Expense expense){
        Expense updatedExpense = service.updateExpense(id,expense);
        if(updatedExpense!=null){
            return ResponseEntity.ok(updatedExpense);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    @DeleteMapping("/expenses/{id}")
    public ResponseEntity<Void> deleteExpense(@PathVariable int id){
        boolean deleted = service.deleteExpense(id);
        if(deleted){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}

