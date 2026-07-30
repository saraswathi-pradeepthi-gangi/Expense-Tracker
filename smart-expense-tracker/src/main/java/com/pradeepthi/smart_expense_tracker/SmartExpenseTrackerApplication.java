package com.pradeepthi.smart_expense_tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.pradeepthi.smart_expense_tracker.service.GreetingService;
import org.springframework.boot.CommandLineRunner;
import com.pradeepthi.smart_expense_tracker.model.Expense;
import com.pradeepthi.smart_expense_tracker.service.ExpenseService;

@SpringBootApplication
public class SmartExpenseTrackerApplication implements CommandLineRunner {
	//private final GreetingService greetingService;
	private final ExpenseService expenseService;
	//constructor Injection
	public SmartExpenseTrackerApplication(GreetingService greetingService,ExpenseService expenseService){
		//this.greetingService=greetingService;
		this.expenseService=expenseService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SmartExpenseTrackerApplication.class, args);
	}
	@Override
	//Dependency injection
	public void run(String... args){
		Expense expense = new Expense(1,"Lunch",250);
		Expense expense1 = new Expense(2,"Uber",150);
		expenseService.addExpense(expense);
		expenseService.addExpense(expense1);
		System.out.println(expenseService.showExpenses());
		System.out.println(expenseService.calulateTotalExpense());


	}
	

}
