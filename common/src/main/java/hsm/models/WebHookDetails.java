package hsm.models;

public class WebHookDetails {
    String objectId;
    String type;
    String ts;

    public WebHookDetails() {
    }

    public WebHookDetails(String objectId, String type, String ts) {
        this.objectId = objectId;
        this.type = type;
        this.ts = ts;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public String getObjectId() {
        return objectId;
    }

    public String getType() {
        return type;
    }

    public String getTs() {
        return ts;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof WebHookDetails)) {
            return false;
        }
        WebHookDetails webHookDetails = (WebHookDetails) o;
        return objectId.equals(webHookDetails.objectId) && type.equals(webHookDetails.type) && ts.equals(webHookDetails.ts);
    }
}



