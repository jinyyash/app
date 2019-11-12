package hsm.webrequest;

import hsm.codec.Codec;
import hsm.models.MerchantWebhook;
import hsm.models.Payload;
import hsm.models.WebHookDetails;
import hsm.router.Router;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebRequest {

   private static Map<String, List<hsm.models.MerchantWebhook>>  webHookMap=new HashMap<>();

    public static void separateObjectsToEventType(String jsonString) throws IOException {

        Payload payload = Codec.convertJsonStrToPayLoadObj(jsonString);
        Map<String, List<WebHookDetails>> webHookDetailsMap= payload.getMerchants();
        for (Map.Entry<String, List<WebHookDetails>> webHookDetailsEntry: webHookDetailsMap.entrySet() ) {
            //get webhook detail list
            for (WebHookDetails  webHookDetails:webHookDetailsEntry.getValue()){
                String eventType=webHookDetails.getObjectId().split(":")[0];
                System.out.println(webHookMap.containsKey(eventType));
                //check map includes the object type
                if(webHookMap.containsKey(eventType)){
                    //get list of merchantWebH00ks for relevent event type
                   List<MerchantWebhook> merchantWebhookList= webHookMap.get(eventType);
                    //update webHookDetails list
                    merchantWebhookList.add(new MerchantWebhook(payload.getAppId(),eventType,webHookDetailsEntry.getKey(),webHookDetails));
                }else{
                    List<MerchantWebhook> merchantWebhookList=new ArrayList<>();
                    merchantWebhookList.add(new MerchantWebhook(payload.getAppId(),eventType,webHookDetailsEntry.getKey(),webHookDetails));
                    webHookMap.put(eventType,merchantWebhookList);
                }
            }

         }
        for (Map.Entry<String, List<hsm.models.MerchantWebhook>> web:webHookMap.entrySet()){
            System.out.println(" key   :"+web.getKey());
            for (MerchantWebhook webHookDetails:web.getValue())
                System.out.println(webHookDetails.getWebHookDetails().getObjectId() + "    :" + webHookDetails.getEventType() + "   : "
                        +webHookDetails.getMerchantId()+ "  : "+webHookDetails.getWebHookDetails().getType() + "   app :" +webHookDetails.getAppId());
        }
        Router.getClientConnection(webHookMap,"O");

        }

    }


