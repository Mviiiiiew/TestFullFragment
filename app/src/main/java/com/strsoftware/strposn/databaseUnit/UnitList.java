package com.strsoftware.strposn.databaseUnit;

/**
 * Created by Wasabi on 9/27/2016.
 */

public class UnitList {
    private int id;
    private String unitText;

    public String getUnitText() {
        return unitText;
    }

    public void setUnitText(String unitText) {
        this.unitText = unitText;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String toString(){
        return this.id +" "+this.unitText;
    }
}
