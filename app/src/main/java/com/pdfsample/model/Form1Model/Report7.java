
package com.pdfsample.model.Form1Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Report7 implements Serializable {

    @SerializedName("time_completed")
    @Expose
    private String timeCompleted="cvbv";
    @SerializedName("traveltime")
    @Expose
    private String traveltime="cvbcvb";
    @SerializedName("mileage")
    @Expose
    private String mileage="cvbv";
    @SerializedName("work_completed_last")
    @Expose
    private String workCompletedLast="cvbcvb";
    @SerializedName("email_address")
    @Expose
    private String emailAddress="cvbvcbvc";

    /**
     * @return The timeCompleted
     */
    public String getTimeCompleted() {
        return timeCompleted;
    }

    /**
     * @param timeCompleted The time_completed
     */
    public void setTimeCompleted(String timeCompleted) {
        this.timeCompleted = timeCompleted;
    }

    /**
     * @return The traveltime
     */
    public String getTraveltime() {
        return traveltime;
    }

    /**
     * @param traveltime The traveltime
     */
    public void setTraveltime(String traveltime) {
        this.traveltime = traveltime;
    }

    /**
     * @return The mileage
     */
    public String getMileage() {
        return mileage;
    }

    /**
     * @param mileage The mileage
     */
    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    /**
     * @return The workCompletedLast
     */
    public String getWorkCompletedLast() {
        return workCompletedLast;
    }

    /**
     * @param workCompletedLast The work_completed_last
     */
    public void setWorkCompletedLast(String workCompletedLast) {
        this.workCompletedLast = workCompletedLast;
    }

    /**
     * @return The emailAddress
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * @param emailAddress The email_address
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

}
