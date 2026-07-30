package com.pradeepthi.smart_expense_tracker.service;
import org.springframework.stereotype.Service;
import com.pradeepthi.smart_expense_tracker.model.Expense;
import com.pradeepthi.smart_expense_tracker.repository.ExpenseRepository;
import java.util.List;

@Service
public class ExpenseService {
    private final ExpenseRepository repository;
    public ExpenseService(ExpenseRepository repository){
        this.repository = repository;
    }
    public void addExpense(Expense expense){
        repository.save(expense);
    }
    /*public List<Expense> showExpenses(){
        return repository.findAll();
    }*/
    //error thrown
    public List<Expense> showExpenses(){
        List<Expense> expenses = repository.findAll();
        return expenses;
    } 
    //adding the expense
    public double calulateTotalExpense(){
        double total = 0;
        List<Expense> expenses = repository.findAll();
        for(Expense expense : expenses){
            total+=expense.getAmount();
        }
        return total;

    }
    public Expense getExpenseById(int id){
        return repository.findById(id);
    }
    public Expense updateExpense(int id , Expense expense){
        return repository.updateExpense(id, expense);
    }
    public boolean deleteExpense(int id){
        return repository.deleteExpense(id);
    }

}
