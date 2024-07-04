package com.wj.fruitproject.service;

import com.wj.fruitproject.exception.FruitException;
import com.wj.fruitproject.factory.PriceFactory;
import com.wj.fruitproject.factory.PriceSuper;
import com.wj.fruitproject.to.FruitTO;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Objects;

@Service
public class PriceCalculate {

    /**
     * 计算价格
     *
     * @param fruitTO 入参
     * @return 支付金额
     * @throws FruitException 异常信息
     */
    public Double calculatePrice(FruitTO fruitTO) throws FruitException {
        // 入参校验
        checkParam(fruitTO);
        // 获取当前销售模式
        PriceSuper priceSuper = PriceFactory.createPriceSuper(fruitTO.getType());
        // 计算价格
        return priceSuper.calculatePrice(fruitTO);
    }

    private void checkParam(FruitTO fruitTO) {
        if (Objects.isNull(fruitTO)) {
            throw new FruitException("The parameter fruitTO is null");
        }
        if (StringUtils.isEmpty(fruitTO.getType())) {
            throw new FruitException("The parameter fruitTO type can't be empty");
        }
        if (Objects.nonNull(fruitTO.getAppleQuantity()) && fruitTO.getAppleQuantity() < 0) {
            throw new FruitException("The apple quantity is negative");
        }

        if (Objects.nonNull(fruitTO.getStrawberryQuantity()) && fruitTO.getStrawberryQuantity() < 0) {
            throw new FruitException("The strawberry quantity is negative");
        }

        if (Objects.nonNull(fruitTO.getMongoQuantity()) && fruitTO.getMongoQuantity() < 0) {
            throw new FruitException("The mongo quantity is negative");
        }
    }
}
