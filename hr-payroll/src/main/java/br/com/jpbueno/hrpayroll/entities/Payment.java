package br.com.jpbueno.hrpayroll.entities;

import java.io.Serializable;

public class Payment implements Serializable {

    private static final long serialVerisonUID = 1l;
    private String name;
    private Double dailyIncome;
    private Integer days;

    public double getTotal() {
        return dailyIncome * days;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getDailyIncome() {
        return dailyIncome;
    }

    public void setDailyIncome(Double dailyIncome) {
        this.dailyIncome = dailyIncome;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Payment() {
    }

    public Payment(String name, Double dailyIncome, Integer days) {
        this.name = name;
        this.dailyIncome = dailyIncome;
        this.days = days;
    }
}
