package com.nhs_test.model;

import com.nhs_test.validator.Amount;

import javax.validation.constraints.NotNull;

public class RegularAmount {

    @NotNull
    private Frequency frequency;

    @Amount
    private String amount;

    public RegularAmount() {
    }

    public RegularAmount(final Frequency frequency, final String amount){
        this.frequency = frequency;
        this.amount = amount;
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

}
