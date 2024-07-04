package com.wj.fruitproject.enums;

import lombok.Getter;

/**
 * 水果类型
 */
@Getter
public enum FruitEnum {

    Apple("apple", 8.00),
    Strawberry("strawberry", 13.00),
    Mongo("mongo", 20.00);

    private String name;

    private Double price;

    FruitEnum(String name, Double price) {
        this.name = name;
        this.price = price;
    }
}
