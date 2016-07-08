package com.toneloc.olympicsapp;

/**
 * Created by t on 6/9/16.
 */
public class Country {
    private String mName;
    private int mPrice;
    private int mIconID;
    private int mProjectedPoints;
    private int mPredictedGolds;
    private int mPredictedSilvers;
    private int mPredictedBronzes;

    public Country(String mName, int mPrice, int mIconID, int mProjectedPoints, int mPredictedGolds, int mPredictedSilvers, int mPredictedBronzes) {
        this.mName = mName;
        this.mPrice = mPrice;
        this.mIconID = mIconID;
        this.mProjectedPoints = mProjectedPoints;
        this.mPredictedGolds = mPredictedGolds;
        this.mPredictedSilvers = mPredictedSilvers;
        this.mPredictedBronzes = mPredictedBronzes;
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

    public int getmPredictedGolds() {
        return mPredictedGolds;
    }

    public int getmPredictedSilvers() {
        return mPredictedSilvers;
    }

    public int getmPredictedBronzes() {
        return mPredictedBronzes;
    }


}
