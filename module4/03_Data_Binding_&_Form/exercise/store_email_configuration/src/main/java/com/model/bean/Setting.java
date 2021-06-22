package com.model.bean;
public class Setting {
    String language;
    Integer pageSite;
    Boolean spamFiler;
    String signature;

    public Setting() {
    }

    public Setting(String language, Integer pageSite, Boolean spamFiler, String signature) {
        this.language = language;
        this.pageSite = pageSite;
        this.spamFiler = spamFiler;
        this.signature = signature;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getPageSite() {
        return pageSite;
    }

    public void setPageSite(Integer pageSite) {
        this.pageSite = pageSite;
    }

    public Boolean getSpamFiler() {
        return spamFiler;
    }

    public void setSpamFiler(Boolean spamFiler) {
        this.spamFiler = spamFiler;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
