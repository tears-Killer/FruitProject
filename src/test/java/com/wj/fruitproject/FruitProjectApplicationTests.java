package com.wj.fruitproject;

import com.wj.fruitproject.enums.SaleEnum;
import com.wj.fruitproject.service.PriceCalculate;
import com.wj.fruitproject.to.FruitTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class FruitProjectApplicationTests {

    @Autowired
    private PriceCalculate priceCalculate;

    // 苹果8元/斤 草莓13元/斤 芒果20元/斤
    // 草莓打0.8折
    // 满100减10块

    @Test
    @DisplayName("场景1：购买苹果和草莓得到正确的价格")
    void calculateTestOne() {
        // 购买2斤苹果 3斤草莓 正常销售
        FruitTO fruitTO = new FruitTO();
        fruitTO.setAppleQuantity(2);
        fruitTO.setStrawberryQuantity(3);
        fruitTO.setType(SaleEnum.Normal.getType());

        Double totalMoney = priceCalculate.calculatePrice(fruitTO);
        log.info("总金额为：{}", totalMoney);
    }

    @Test
    @DisplayName("场景2：购买苹果,草莓和芒果")
    void calculateTestTwo() {
        // 购买1斤苹果 2斤草莓 3斤芒果 正常销售
        FruitTO fruitTO = new FruitTO();
        fruitTO.setAppleQuantity(1);
        fruitTO.setStrawberryQuantity(2);
        fruitTO.setMongoQuantity(3);
        fruitTO.setType(SaleEnum.Normal.getType());

        Double totalMoney = priceCalculate.calculatePrice(fruitTO);
        log.info("总金额为：{}", totalMoney);
    }

    @Test
    @DisplayName("场景3：草莓打8折")
    void calculateTestThree() {
        // 购买1斤苹果 2斤草莓 3斤芒果 草莓打8折
        FruitTO fruitTO = new FruitTO();
        fruitTO.setAppleQuantity(1);
        fruitTO.setStrawberryQuantity(2);
        fruitTO.setMongoQuantity(3);
        fruitTO.setType(SaleEnum.Discount.getType());

        Double totalMoney = priceCalculate.calculatePrice(fruitTO);
        log.info("总金额为：{}", totalMoney);
    }

    @Test
    @DisplayName("场景4：购物不到100 支付原价格")
    void calculateTestFour() {
        // 购买1斤苹果 2斤草莓 3斤芒果 不符合满减
        FruitTO fruitTO = new FruitTO();
        fruitTO.setAppleQuantity(1);
        fruitTO.setStrawberryQuantity(2);
        fruitTO.setMongoQuantity(3);
        fruitTO.setType(SaleEnum.FullMinus.getType());

        Double totalMoney = priceCalculate.calculatePrice(fruitTO);
        log.info("总金额为：{}", totalMoney);
    }

    @Test
    @DisplayName("场景4：购物刚好100 支付90元")
    void calculateTestFive() {
        // 购买5斤芒果 满100减10
        FruitTO fruitTO = new FruitTO();
        fruitTO.setMongoQuantity(5);
        fruitTO.setType(SaleEnum.FullMinus.getType());

        Double totalMoney = priceCalculate.calculatePrice(fruitTO);
        log.info("总金额为：{}", totalMoney);
    }

    @Test
    @DisplayName("场景4：购物超过100元")
    void calculateTestSix() {
        // 购买5斤草莓 5斤芒果 草莓打8折 满100减10
        FruitTO fruitTO = new FruitTO();
        fruitTO.setStrawberryQuantity(5);
        fruitTO.setMongoQuantity(5);
        fruitTO.setType(SaleEnum.FullMinus.getType());

        Double totalMoney = priceCalculate.calculatePrice(fruitTO);
        log.info("总金额为：{}", totalMoney);
    }
}
