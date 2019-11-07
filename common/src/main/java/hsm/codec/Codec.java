package hsm.codec;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import hsm.models.Payload;
import hsm.models.WebHookDetails;

import java.io.IOException;
import java.util.*;

public class Codec {
    public static WebHookDetails convertJsonObjWebHookDetails(JsonObject webhookJsonobj) {
        Gson g = new Gson();
        WebHookDetails webHookDetails = g.fromJson(webhookJsonobj, WebHookDetails.class);
        return webHookDetails;
    }

    public JsonObject convertWebHookDetailsToJsonObj(WebHookDetails webHookDetails) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonStr = ow.writeValueAsString(webHookDetails);
        return new JsonParser().parse(jsonStr).getAsJsonObject();
    }
    public static JsonObject convertPayLoadToJsonObj(Payload payload) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonStr = ow.writeValueAsString(payload);
        return new JsonParser().parse(jsonStr).getAsJsonObject();
    }

    public static JsonObject convertStringToJsonObject(String jsonString) {
        return new JsonParser().parse(jsonString).getAsJsonObject();
    }


    public static Payload convertJsonStrToPayLoadObj(String jsonStr) throws IOException {
     /*   JsonObject payloadJson = convertStringToJsonObject(jsonStr);
        String appId = payloadJson.get("appId").getAsString();
        JsonObject jsonObject = payloadJson.getAsJsonObject("merchants");
        System.out.println("merchants"+jsonObject.toString());
        Map<String, List<WebHookDetails>> merchantsMap=new HashMap<>();
        //get keyset
        Set<String> merchantKeys = jsonObject.keySet();
        for (String key : merchantKeys) {
            System.out.println("i        :" + key);
            List<WebHookDetails> webHookDetailsList=new ArrayList<>();
            //get json array from one object
            JsonArray jsonElements = jsonObject.getAsJsonArray(key);
            for (int i = 0; i < jsonElements.size(); i++) {
               WebHookDetails webHookDetails= convertJsonObjWebHookDetails((JsonObject) jsonElements.get(i));
               webHookDetailsList.add(webHookDetails);
            }
            merchantsMap.put(key,webHookDetailsList);
        }*/
        ObjectMapper mapper=new ObjectMapper();
        return mapper.readValue(jsonStr, Payload.class);

    }

    public static void main(String[] args) {
        String tst = "{\n" +
                "    \"appId\":\"DRKVJT2ZRRRSC\",\n" +
                "    \"merchants\":\n" +
                "    {\n" +
                "        \"XYZVJT2ZRRRSC\":[\n" +
                "            {\n" +
                "                \"objectId\":\"O:GHIVJT2ABCRSC\",\n" +
                "                \"type\":\"CREATE\",\n" +
                "                \"ts\":1537970958000\n" +
                "            },\n" +
                "            {\n" +
                "                \"objectId\":\"O:ABCVJTABCRRSC\",\n" +
                "                \"type\":\"UPDATE\",\n" +
                "                \"ts\":1536156558000\n" +
                "            }\n" +
                "        ]\n" +
                "     }\n" +
                "}";
        JsonObject jsn = convertStringToJsonObject(tst);
        JsonObject jsonpObject = convertStringToJsonObject(tst);
        JsonObject jsonObject = jsn.getAsJsonObject("merchants");
        Set<String> strings = jsonObject.keySet();
        for (String s : strings) {
            String key = s;
            System.out.println("i        :" + key);
            JsonArray jsonElements = jsonObject.getAsJsonArray(key);
            for (int i = 0; i < jsonElements.size(); i++) {
                System.out.println(jsonElements.get(i));
            }
        }

    }
}

