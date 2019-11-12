package hsm.router;

import com.fasterxml.jackson.core.JsonProcessingException;
import hsm.codec.Codec;
import hsm.models.MerchantWebhook;
import hsm.models.Payload;
import hsm.models.WebHookDetails;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Router {

    public String getClientRequestJson(Map<String, List<MerchantWebhook>> webHookMap,String entryId) throws JsonProcessingException {
        Payload payload=null;
        String appId="";
        Map <String, List<WebHookDetails>> merchantsWebHookDetails=new HashMap<>();

        for(Map.Entry<String, List<MerchantWebhook>> merchantWebHookobjectMap:webHookMap.entrySet()){
            if (entryId.equals(merchantWebHookobjectMap.getKey())){
                for(MerchantWebhook merchantWebHook: merchantWebHookobjectMap.getValue()){
                    appId=merchantWebHook.getAppId();
                    if (merchantsWebHookDetails.containsKey(merchantWebHook.getMerchantId())){
                        merchantsWebHookDetails.get(merchantWebHook.getMerchantId()).add(merchantWebHook.getWebHookDetails());
                    }else{
                        List<WebHookDetails> webHookDetails=new ArrayList<>();
                        webHookDetails.add(merchantWebHook.getWebHookDetails());
                        merchantsWebHookDetails.put(merchantWebHook.getMerchantId(),webHookDetails);
                    }
                }
                payload=new Payload(appId,merchantsWebHookDetails);
            }
            return Codec.convertPayLoadToJsonStr(payload);
        }
       return "";

    }


}
