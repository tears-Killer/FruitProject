package com.wj.fruitproject.factory;

import com.wj.fruitproject.exception.FruitException;
import com.wj.fruitproject.service.PriceDiscount;
import com.wj.fruitproject.service.PriceFullMinus;
import com.wj.fruitproject.service.PriceNormal;

public class PriceFactory {

    /**
     * 草莓打折数
     */
    private static final Double discount = 0.8;

    /**
     * 达到减免的金额
     */
    private static final Double priceFull = 100d;

    /**
     * 减免金额
     */
    private static final Double priceMinus = 10d;

    public static PriceSuper createPriceSuper(String type) {
        return switch (type) {
            case "normal" -> new PriceNormal();
            case "discount" -> new PriceDiscount(discount);
            case "fullMinus" -> new PriceFullMinus(priceFull, priceMinus, new PriceDiscount(discount));
            default -> throw new FruitException("The type is not correct!");
        };
    }

}
