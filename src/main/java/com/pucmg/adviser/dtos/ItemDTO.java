package com.pucmg.adviser.dtos;

import com.pucmg.adviser.enums.Action;

public class ItemDTO {

    private Action action;
    private Long id;
    private String title;
    private String description;
    private OfferDTO offer;

    public ItemDTO() {}

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OfferDTO getOffer() {
        return offer;
    }

    public void setOffer(OfferDTO offer) {
        this.offer = offer;
    }
}
