package com.toneloc.olympicsapp;

/**
 * Created by t on 6/9/16.
 */
public class Country {
    private String mName;
    private int mPrice;
    private int mId;
    private int mProjectedPoints;
    private int mPredictedGolds;
    private int mPredictedSilvers;
    private int mPredictedBronzes;

    public Country(String mName, int mPrice, int mId, int mProjectedPoints, int mPredictedGolds, int mPredictedSilvers, int mPredictedBronzes) {
        this.mName = mName;
        this.mPrice = mPrice;
        this.mId = mId;
        this.mProjectedPoints = mProjectedPoints;
        this.mPredictedGolds = mPredictedGolds;
        this.mPredictedSilvers = mPredictedSilvers;
        this.mPredictedBronzes = mPredictedBronzes;
    }

    public String getmName() {
        return mName;
    }

    public int getmPrice() {
        return mPrice;
    }

    public int getmId() {
        return mId;
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
