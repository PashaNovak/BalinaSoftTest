package com.novakpavel.balinasofttest.mvp.model.repository.dto;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DnsResponse {

    @SerializedName("Status")
    @Expose
    private Integer status;
    @SerializedName("TC")
    @Expose
    private Boolean tC;
    @SerializedName("RD")
    @Expose
    private Boolean rD;
    @SerializedName("RA")
    @Expose
    private Boolean rA;
    @SerializedName("AD")
    @Expose
    private Boolean aD;
    @SerializedName("CD")
    @Expose
    private Boolean cD;
    @SerializedName("Question")
    @Expose
    private List<Question> question = null;
    @SerializedName("Answer")
    @Expose
    private List<Answer> answer = null;
    @SerializedName("Authority")
    @Expose
    private List<Authority> authority = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Boolean getTC() {
        return tC;
    }

    public void setTC(Boolean tC) {
        this.tC = tC;
    }

    public Boolean getRD() {
        return rD;
    }

    public void setRD(Boolean rD) {
        this.rD = rD;
    }

    public Boolean getRA() {
        return rA;
    }

    public void setRA(Boolean rA) {
        this.rA = rA;
    }

    public Boolean getAD() {
        return aD;
    }

    public void setAD(Boolean aD) {
        this.aD = aD;
    }

    public Boolean getCD() {
        return cD;
    }

    public void setCD(Boolean cD) {
        this.cD = cD;
    }

    public List<Question> getQuestion() {
        return question;
    }

    public void setQuestion(List<Question> question) {
        this.question = question;
    }

    public List<Answer> getAnswer() {
        return answer;
    }

    public void setAnswer(List<Answer> answer) {
        this.answer = answer;
    }

    public List<Authority> getAuthority() {
        return authority;
    }

    public void setAuthority(List<Authority> authority) {
        this.authority = authority;
    }
}
