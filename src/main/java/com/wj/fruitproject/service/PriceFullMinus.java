package com.wj.fruitproject.service;

import com.wj.fruitproject.enums.FruitEnum;
import com.wj.fruitproject.factory.PriceSuper;
import com.wj.fruitproject.to.FruitTO;

public class PriceFullMinus extends PriceSuper {

    private Double priceFull = 100d;

    private Double priceMinus = 10d;

    private PriceDiscount priceDiscount;

    public PriceFullMinus(Double priceFull, Double priceMinus, PriceDiscount priceDiscount) {
        this.priceFull = priceFull;
        this.priceMinus = priceMinus;
        this.priceDiscount = priceDiscount;
    }

    @Override
    public double calculatePrice(FruitTO fruitTO) {
        // 获取打折后的总价
        double discountMoney = priceDiscount.calculatePrice(fruitTO);
        if (discountMoney >= priceFull) {
            Integer multiple = (int) Math.floor(discountMoney / priceFull);
            discountMoney = discountMoney - multiple * priceMinus;
        }

        return discountMoney;
    }
}
