package hsm.codec;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import hsm.models.Payload;
import hsm.models.WebHookDetails;

import java.io.IOException;
import java.util.*;

public class Codec {

    private  static final transient Gson gson = new Gson();
    private static WebHookDetails convertJsonObjWebHookDetails(JsonObject webhookJsonobj) {
        return gson.fromJson(webhookJsonobj, WebHookDetails.class);
    }

    public JsonObject convertWebHookDetailsToJsonObj(WebHookDetails webHookDetails) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonStr = ow.writeValueAsString(webHookDetails);
        return new JsonParser().parse(jsonStr).getAsJsonObject();
    }
    public static String convertPayLoadToJsonStr(Payload payload) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonStr = ow.writeValueAsString(payload);
        return gson.toJson(payload);
    }

    public static JsonObject convertStringToJsonObject(String jsonString) {
        return new JsonParser().parse(jsonString).getAsJsonObject();
    }


    public static Payload convertJsonStrToPayLoadObj(String jsonStr) throws IOException {
      JsonObject payloadJson = convertStringToJsonObject(jsonStr);
        String appId = payloadJson.get("appId").getAsString();
        JsonObject jsonObject = payloadJson.getAsJsonObject("merchants");
        Map<String, List<WebHookDetails>> merchantsMap=new HashMap<>();
        //get keyset
        Set<String> merchantKeys = jsonObject.keySet();
        for (String key : merchantKeys) {
            List<WebHookDetails> webHookDetailsList=new ArrayList<>();
            //get json array from one object
            JsonArray jsonElements = jsonObject.getAsJsonArray(key);
            for (int i = 0; i < jsonElements.size(); i++) {
               WebHookDetails webHookDetails= convertJsonObjWebHookDetails((JsonObject) jsonElements.get(i));
               webHookDetailsList.add(webHookDetails);
            }
            merchantsMap.put(key,webHookDetailsList);
        }
       return gson.fromJson(jsonStr, Payload.class);
      //  return new Payload(appId,merchantsMap);


    }
}

