package hsm;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.JsonObject;
import hsm.codec.Codec;
import hsm.models.Payload;
import hsm.models.WebHookDetails;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CodecTest {

    String tstStr1="{\n" +
            "    \"appId\":\"DRKVJT2ZRRRSC\",\n" +
            "    \"merchants\":\n" +
            "      {\n" +
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
            "        ],\n" +
            "        \"MNOVJT2ZRRRSC\":[\n" +
            "         {\n" +
            "                \"objectId\":\"O:GHIVJT2ABCRSCD\",\n" +
            "                \"type\":\"CREATE\",\n" +
            "                \"ts\":15379709580001\n" +
            "            },\n" +
            "            {\n" +
            "                \"objectId\":\"O:ABCVJTABCRRSCD\",\n" +
            "                \"type\":\"UPDATE\",\n" +
            "                \"ts\":15361565580001\n" +
            "            }\n" +
            "        ]\n" +
            "    }\n" +
            "}";

    String tstStr2="{\n" +
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
            "    }\n" +
            "}";

    @Test
    public void  testConvertJsonStrToPayLoadObjwithtwo() throws IOException {
     Map<String, List<WebHookDetails>> merchantList=new HashMap<>();
     List<WebHookDetails> webHookDetailsList1=new ArrayList<>();
     webHookDetailsList1.add(new WebHookDetails("O:GHIVJT2ABCRSC","CREATE","1537970958000"));
     webHookDetailsList1.add(new WebHookDetails("O:ABCVJTABCRRSC","UPDATE","1536156558000"));
     merchantList.put("XYZVJT2ZRRRSC",webHookDetailsList1);
     List<WebHookDetails> webHookDetailsList2=new ArrayList<>();
     webHookDetailsList2.add(new WebHookDetails("O:GHIVJT2ABCRSCD","CREATE","15379709580001"));
     webHookDetailsList2.add(new WebHookDetails("O:ABCVJTABCRRSCD","UPDATE","15361565580001"));
     merchantList.put("MNOVJT2ZRRRSC",webHookDetailsList2);
     Payload payload=new Payload("DRKVJT2ZRRRSC",merchantList);
        System.out.println(Codec.convertPayLoadToJsonObj(Codec.convertJsonStrToPayLoadObj(tstStr1)).toString());
    // Assert.assertEquals(Codec.convertPayLoadToJsonObj(payload),Codec.convertPayLoadToJsonObj(Codec.convertJsonStrToPayLoadObj(tstStr1)));
        Assert.assertTrue(payload.equals(Codec.convertJsonStrToPayLoadObj(tstStr1)));


    }

    @Test
    public void  testConvertJsonStrToPayLoadObjwithOneObj() throws IOException {
        Map<String, List<WebHookDetails>> merchantList=new HashMap<>();
        List<WebHookDetails> webHookDetailsList1=new ArrayList<>();
        webHookDetailsList1.add(new WebHookDetails("O:GHIVJT2ABCRSC","CREATE","1537970958000"));
        webHookDetailsList1.add(new WebHookDetails("O:ABCVJTABCRRSC","UPDATE","1536156558000"));
        merchantList.put("XYZVJT2ZRRRSC",webHookDetailsList1);
        Payload payload=new Payload("DRKVJT2ZRRRSC",merchantList);
        System.out.println();
        Assert.assertTrue(payload.equals(Codec.convertJsonStrToPayLoadObj(tstStr2)));

    }

    @Test
    public void testConvertJsonObjToWebHookDetails(){

        WebHookDetails webHookDetails=new WebHookDetails("O:GHIVJT2ABCRSC","CREATE","1537970958000");
        WebHookDetails webHookDetails1=new WebHookDetails("O:GHIVJT2ABCRSC","CREATE","1537970958000");

        JsonObject jsonObject=new JsonObject();
        jsonObject.addProperty("objectId","O:GHIVJT2ABCRSC");
        jsonObject.addProperty("type","CREATE");
        jsonObject.addProperty("ts","1537970958000");

        Assert.assertTrue(webHookDetails.equals(webHookDetails1));
    }
    @Test
    public void testConvertStringToJsonObj(){
        String jsnStr="{\\n\" +\n" +
                "            \"                \\\"objectId\\\":\\\"O:GHIVJT2ABCRSC\\\",\\n\" +\n" +
                "            \"                \\\"type\\\":\\\"CREATE\\\",\\n\" +\n" +
                "            \"                \\\"ts\\\":1537970958000\\n\" +\n" +
                "            \"            }";

        JsonObject jsonObject=new JsonObject();
        jsonObject.addProperty("objectId","O:GHIVJT2ABCRSC");
        jsonObject.addProperty("type","CREATE");
        jsonObject.addProperty("ts","1537970958000");

      //  Assert.assertEquals(jsonObject,Codec.convertStringToJsonObject(jsnStr));

    }



}
