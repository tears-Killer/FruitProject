package com.wj.fruitproject.factory;

import com.wj.fruitproject.to.FruitTO;

public abstract class PriceSuper {

    /**
     * 计算价格
     *
     * @param fruitTO fruitTO
     * @return 支付金额
     */
    public abstract double calculatePrice(FruitTO fruitTO);
}
