package com.strsoftware.strposn.model;

/**
 * Created by Wasabi on 10/5/2016.
 */

public class ProductList {
    public UnitList getUnitList() {
        return unitList;
    }

    public void setUnitList(UnitList unitList) {
        this.unitList = unitList;
    }

    private int id;
    private String productText;
    private UnitList unitList;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductText() {
        return productText;
    }

    public void setProductText(String productText) {
        this.productText = productText;
    }
}
