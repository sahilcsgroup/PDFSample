
package com.pdfsample.model.Form2Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Report2 {

    @SerializedName("authorised_sign_name")
    @Expose
    private String authorisedSignName = "dfgdfg";
    @SerializedName("reportdate2")
    @Expose
    private String reportdate2 = "dfgdfg";
    @SerializedName("authorised_by")
    @Expose
    private String authorisedBy = "1,2";
    @SerializedName("authorised_sign")
    @Expose
    private String authorisedSign = "";

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
     * @return The reportdate2
     */
    public String getReportdate2() {
        return reportdate2;
    }

    /**
     * @param reportdate2 The reportdate2
     */
    public void setReportdate2(String reportdate2) {
        this.reportdate2 = reportdate2;
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
