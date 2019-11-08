package hsm.models;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Payload)) {
            return false;
        }
        Payload payload = (Payload) o;
        return appId.equals(payload.appId) && merchants.keySet().equals(payload.merchants.keySet()) && payload.merchants.equals(merchants);
    }

    private Map<String, Boolean> areEqualKeyValues( Map <String, List<WebHookDetails>> merchants1,  Map <String, List<WebHookDetails>> merchants2) {
        return merchants1.entrySet().stream()
                .collect(Collectors.toMap(e -> e.getKey(),
                        e -> e.getValue().equals(merchants2.get(e.getKey()))));
    }
}
