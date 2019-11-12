package hsm.models;

import java.util.List;

public class MerchantWebhook {
    private String appId;
    private String eventType;
    private String merchantId;
    private WebHookDetails webHookDetails;

    public MerchantWebhook(String appId, String eventType, String merchantId, WebHookDetails webHookDetails) {
        this.appId = appId;
        this.eventType = eventType;
        this.merchantId = merchantId;
        this.webHookDetails = webHookDetails;
    }

    public WebHookDetails getWebHookDetails() {
        return webHookDetails;
    }

    public void setWebHookDetails(WebHookDetails webHookDetails) {
        this.webHookDetails = webHookDetails;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

}
