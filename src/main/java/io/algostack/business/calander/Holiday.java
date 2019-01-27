package io.algostack.business.calander;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.time.LocalDate;
import java.util.Objects;

public class Holiday {

    private Long id;
    private LocalDate date;
    private String currency;
    private String desciption;

    @JsonCreator
    public Holiday(long id, LocalDate date, String currency, String desciption) {
        this.id = id;
        this.date = date;
        this.currency = currency;
        this.desciption = desciption;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getCurrency() {
        return currency;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Holiday holiday = (Holiday) o;
        return Objects.equals(date, holiday.date) &&
                Objects.equals(currency, holiday.currency);
    }

    @Override
    public int hashCode() {

        return Objects.hash(date, currency);
    }

    @Override
    public String toString() {
        return "Holiday{" +
                "date=" + date +
                ", currency='" + currency + '\'' +
                ", desciption='" + desciption + '\'' +
                '}';
    }
}
