package com.wj.fruitproject.service;

import com.wj.fruitproject.enums.FruitEnum;
import com.wj.fruitproject.factory.PriceSuper;
import com.wj.fruitproject.to.FruitTO;

public class PriceNormal extends PriceSuper {

    @Override
    public double calculatePrice(FruitTO fruitTO) {
        return fruitTO.getAppleQuantity() * FruitEnum.Apple.getPrice()
                + fruitTO.getStrawberryQuantity() * FruitEnum.Strawberry.getPrice()
                + fruitTO.getMongoQuantity() * FruitEnum.Mongo.getPrice();
    }
}
