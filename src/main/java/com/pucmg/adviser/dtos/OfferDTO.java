package com.pucmg.adviser.dtos;

import java.math.BigDecimal;

public class OfferDTO {
    private String currency;
    private BigDecimal price;

    public OfferDTO() {}
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
