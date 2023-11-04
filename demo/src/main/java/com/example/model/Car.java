package com.example.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="cars")
public class Car {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="manufacturer_name")
    private String manufacturerName;

    
    @Column(name="date_of_purchase")
    private LocalDate dateOfPurchase;

    @Column(name="price")
    private BigDecimal price;

    @Column(name="mileage")
    private int mileage;

    @Column(name="makeModel")
    private String makeModel;

    @Column(name ="description")
    private String description;

    @Column(name = "pictureUrl", length = 1000)
    private String pictureUrl;

    @Column(name="sold")
    private boolean sold;

    @Column(name="bidprice")
    private Double bidPrice;

    @Column(name="year")
    private Integer year;

    @Column(name = "newUsed")
    private boolean newUsed;

    @ManyToMany(mappedBy = "itemsinCart" )
    private List<Cart> cart;

    
    public boolean isNewUsed() {
        return newUsed;
    }

    public void setNewUsed(boolean newUsed) {
        this.newUsed = newUsed;
    }

    public Double getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(Double bidPrice) {
        this.bidPrice = bidPrice;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id=id;
    }

    public String getManufacturerName(){
        return manufacturerName;
    }


    public void setManufacturerName(String manufacturerName){
        this.manufacturerName=manufacturerName;
    }

    public LocalDate getDateOfPurchase(){
        return dateOfPurchase;
    }

    public void setDateOfPurchase(LocalDate dateOfPurchase){
        this.dateOfPurchase=dateOfPurchase;

    }

    public int getMileage(){
        return mileage;
    }

    public void setMileage(int mileage){
        this.mileage = mileage;

    }

    public BigDecimal getPrice(){
        return price;
    }


    public void setPrice(BigDecimal price){
        this.price=price;
    }

    public String getMakeModel(){
        return makeModel;
    }

    public void setMakeModel(String makeModel){
        this.makeModel=makeModel;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description=description;
    }

    public String getPictureUrl(){
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl){
        this.pictureUrl=pictureUrl;
    }

    public boolean isBidable(){
        LocalDate cutoffDate = LocalDate.now().minusDays(120);

    
        return dateOfPurchase.isBefore(cutoffDate);

    }



    public BigDecimal getDiscountedPrice(){ //eligible for selling at discount price
        if(isBidable()){
            return price.multiply(BigDecimal.valueOf(0.9));
        }
        return price;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }



}
