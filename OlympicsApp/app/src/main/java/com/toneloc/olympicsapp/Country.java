package com.toneloc.olympicsapp;

/**
 * Created by t on 6/9/16.
 */
public class Country {
    private String mName;
    private float mPrice;
    private int mIconID;
    private int mProjectedPoints;


    public Country(String name, float price, int iconID, int projectedPoints) {
        super();
        this.mName = name;
        this.mPrice = price;
        this.mIconID = iconID;
        this.mProjectedPoints = projectedPoints;
    }

    public String getmName() {
        return mName;
    }

    public float getmPrice() {
        return mPrice;
    }

    public int getmIconID() {
        return mProjectedPoints;
    }

    public int getmProjectedPoints() {
        return mProjectedPoints;
    }


}
