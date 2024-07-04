package com.wj.fruitproject.enums;

import lombok.Getter;

/**
 * 销售类型
 */
@Getter
public enum SaleEnum {

    Normal("normal"),
    Discount("discount"),
    FullMinus("fullMinus");

    private String type;

    SaleEnum(String type) {
        this.type = type;
    }
}
