package com.example.retroo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Post {

    @SerializedName("day")
    @Expose
    private String day;
    @SerializedName("icon")
    @Expose
    private String icon;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("degree")
    @Expose
    private String degree;
    @SerializedName("min")
    @Expose
    private String min;
    @SerializedName("max")
    @Expose
    private String max;
    @SerializedName("night")
    @Expose
    private String night;
    @SerializedName("humidity")
    @Expose
    private String humidity;

    @SerializedName("date")
    @Expose
    private String main;




    public String getDay() { return day; }

    public String getIcon() {
        return icon;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public String getDegree() {
        return degree;
    }

    public String getMin() {
        return min;
    }

    public String getMax() {
        return max;
    }

    public String getNight() {
        return night;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getMain() {
        return main;
    }

}
