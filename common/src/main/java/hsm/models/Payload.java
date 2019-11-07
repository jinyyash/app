package hsm.models;

import java.util.List;
import java.util.Map;

public class Payload {
    String appId;
    Map <String, List<WebHookDetails>> merchants;

    public Payload(String appId, Map<String, List<WebHookDetails>> merchants) {
        this.appId = appId;
        this.merchants = merchants;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public Map<String, List<WebHookDetails>> getMerchants() {
        return merchants;
    }

    public void setMerchants(Map<String, List<WebHookDetails>> merchants) {
        this.merchants = merchants;
    }
}
