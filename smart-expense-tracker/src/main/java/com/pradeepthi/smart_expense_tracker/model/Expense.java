package com.pradeepthi.smart_expense_tracker.model;

public class Expense {
    private int id;
    private String title;
    private double amount;
    public Expense(int id,String title,double amount){
        this.id = id;
        this.title = title;
        this.amount = amount;
    }
    @Override
    public String toString(){
		return "Expense{id: " + id +", title: " + title +" ,amount: " +amount+ "}";
	}
    public double getAmount(){
        return amount;
    }
    public int getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public void setAmount(double amount){
        this.amount = amount;
    }
    public void setTitle(String title){
        this.title = title;
    }
    //private String category;
    // private String date;
}
