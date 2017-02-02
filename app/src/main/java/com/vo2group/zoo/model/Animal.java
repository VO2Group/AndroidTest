package com.vo2group.zoo.model;

public class Animal {

    private long id;

    private String name;

    private long birthDay;

    private String pictureUrl;

    private long categoryId;

    public void setId(long id){
        this.id = id;
    }

    public long getId(){
        return this.id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setBirthDay(long birthDay){
        this.birthDay = birthDay;
    }

    public long getBirthDay(){
        return this.birthDay;
    }

    public void setPicureUrl(String pictureUrl){
        this.pictureUrl = pictureUrl;
    }

    public String getPicureUrl(){
        return this.pictureUrl;
    }

    public void setCategoryId(long categoryId){
        this.categoryId = categoryId;
    }

    public long getCategoryId(){
        return this.categoryId;
    }
}
