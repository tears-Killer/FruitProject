package com.wj.fruitproject.service;

import com.wj.fruitproject.enums.FruitEnum;
import com.wj.fruitproject.factory.PriceSuper;
import com.wj.fruitproject.to.FruitTO;

public class PriceDiscount extends PriceSuper {

    private Double priceDiscount = 0.8;

    public PriceDiscount(Double priceDiscount) {
        this.priceDiscount = priceDiscount;
    }

    @Override
    public double calculatePrice(FruitTO fruitTO) {
        return fruitTO.getAppleQuantity() * FruitEnum.Apple.getPrice()
                + fruitTO.getStrawberryQuantity() * FruitEnum.Strawberry.getPrice() * priceDiscount
                + fruitTO.getMongoQuantity() * FruitEnum.Mongo.getPrice();
    }
}
