
package com.pdfsample.model.Form1Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Report2 implements Serializable {

    @SerializedName("reportdate2")
    @Expose
    private String reportdate2 = "231232";
    @SerializedName("authorised_sign_name")
    @Expose
    private String authorisedSignName = "sdcsdcsdc";
    @SerializedName("authorised_by")
    @Expose
    private String authorisedBy = "2";
    @SerializedName("authorised_sign")
    @Expose
    private String authorisedSign = "";

    /**
     * @return The date
     */
    public String getDate() {
        return reportdate2;
    }

    /**
     * @param date The date
     */
    public void setDate(String date) {
        this.reportdate2 = date;
    }

    /**
     * @return The authorisedSignName
     */
    public String getAuthorisedSignName() {
        return authorisedSignName;
    }

    /**
     * @param authorisedSignName The authorised_sign_name
     */
    public void setAuthorisedSignName(String authorisedSignName) {
        this.authorisedSignName = authorisedSignName;
    }

    /**
     * @return The authorisedBy
     */
    public String getAuthorisedBy() {
        return authorisedBy;
    }

    /**
     * @param authorisedBy The authorised_by
     */
    public void setAuthorisedBy(String authorisedBy) {
        this.authorisedBy = authorisedBy;
    }

    /**
     * @return The authorisedSign
     */
    public String getAuthorisedSign() {
        return authorisedSign;
    }

    /**
     * @param authorisedSign The authorised_sign
     */
    public void setAuthorisedSign(String authorisedSign) {
        this.authorisedSign = authorisedSign;
    }

}
