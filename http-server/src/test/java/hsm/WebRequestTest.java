package hsm;

import hsm.models.MerchantWebhook;
import hsm.models.WebHookDetails;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class WebRequestTest {
    private static Map<String, List<MerchantWebhook>> webHookMap=new HashMap<>();

    String tstStr1="{\n" +
            "    \"appId\":\"DRKVJT2ZRRRSC\",\n" +
            "    \"merchants\":\n" +
            "      {\n" +
            "        \"XYZVJT2ZRRRSC\":[\n" +
            "            {\n" +
            "                \"objectId\":\"I:GHIVJT2ABCRSC\",\n" +
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
            "                \"objectId\":\"I:GHIVJT2ABCRSCD\",\n" +
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

    @Test
    public void testSeparateObjectsToEventType()

    {
        List<MerchantWebhook> merchantWebhookList=new ArrayList<>();
        merchantWebhookList.add(new MerchantWebhook("DRKVJT2ZRRRSC","O","XYZVJT2ZRRRSC",new WebHookDetails("O:ABCVJTABCRRSC","UPDATE","1537970958000")));
        merchantWebhookList.add(new MerchantWebhook("DRKVJT2ZRRRSC","O","MNOVJT2ZRRRSC",new WebHookDetails("O:ABCVJTABCRRSCD","UPDATE","15361565580001")));

    }


}
