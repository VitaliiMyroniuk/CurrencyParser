package com.epam.myroniuk.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Currency {
    private String name;
    private Double rate;
    private LocalDate date;

    public Currency() {
    }

    public Currency(String name, Double rate, LocalDate date) {
        this.name = name;
        this.rate = rate;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Currency currency = (Currency) o;
        return Objects.equals(name, currency.name) &&
                Objects.equals(rate, currency.rate) &&
                Objects.equals(date, currency.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, rate, date);
    }

    @Override
    public String toString() {
        return "Currency{" +
                "name='" + name + '\'' +
                ", rate=" + rate +
                ", date=" + date +
                '}';
    }
}
