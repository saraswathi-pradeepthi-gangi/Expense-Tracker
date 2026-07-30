package com.pradeepthi.smart_expense_tracker.repository;
import com.pradeepthi.smart_expense_tracker.model.Expense;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ExpenseRepository {
    private List<Expense> expenses = new ArrayList<>();
    public void save(Expense expense){
        expenses.add(expense);
    }
    public List<Expense> findAll(){
        return expenses;
    }
    public Expense findById(int Id){
        for(Expense expense:expenses){
            if(expense.getId()==Id){
                return expense;
            }
        }
        return null;
    }
    public Expense updateExpense(int id,Expense updatedExpense){
        for(Expense expense: expenses){
            if(expense.getId()==id){
                expense.setTitle(updatedExpense.getTitle());
                expense.setAmount(updatedExpense.getAmount());
                return expense;
            }
           
        }
         return null;
        
    }
    public boolean deleteExpense(int id){
        for(Expense expense : expenses){
            if(expense.getId()==id){
                expenses.remove(expense);
                return true;
            }
        }
        return false;
    }
}
