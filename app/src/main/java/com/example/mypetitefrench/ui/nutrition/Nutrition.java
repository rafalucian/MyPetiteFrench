package com.example.mypetitefrench.ui.nutrition;

public class Nutrition {
    private String description;
    private int mIconId;

    public Nutrition (String description, int mIconId)
    {
        this.description=description;
        this.mIconId=mIconId;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getmIconId() {
        return mIconId;
    }

    public void setmIconId(int mIconId) {
        this.mIconId = mIconId;
    }
}
