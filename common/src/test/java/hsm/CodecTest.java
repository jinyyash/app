package hsm;

import com.fasterxml.jackson.core.JsonProcessingException;
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

    String tst = "{\n" +
            "    \"appId\" "+ ":\"DRKVJT2ZRRRSC\",\n" +
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
            "        ],\n" +

             "XYZVJT2ZRRRSCD\":[\n" +
            "            {\n" +
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
            "     }\n" ;

    @Test
    public void  testConvertJsonStrToPayLoadObj() throws IOException {
        System.out.println(tst);
     Map<String, List<WebHookDetails>> merchantList=new HashMap<>();
     List<WebHookDetails> webHookDetailsList1=new ArrayList<>();
     webHookDetailsList1.add(new WebHookDetails("O:GHIVJT2ABCRSC","CREATE","1537970958000"));
     webHookDetailsList1.add(new WebHookDetails("O:ABCVJTABCRRSC","UPDATE","1536156558000"));
     merchantList.put("XYZVJT2ZRRRSC",webHookDetailsList1);
     List<WebHookDetails> webHookDetailsList2=new ArrayList<>();
     webHookDetailsList2.add(new WebHookDetails("O:GHIVJT2ABCRSCD","CREATE","15379709580001"));
     webHookDetailsList2.add(new WebHookDetails("O:ABCVJTABCRRSCD","UPDATE","15361565580001"));
     merchantList.put("XYZVJT2ZRRRSCD",webHookDetailsList1);
     Payload payload=new Payload("DRKVJT2ZRRRSC",merchantList);

     Assert.assertSame(Codec.convertPayLoadToJsonObj(payload),Codec.convertPayLoadToJsonObj(Codec.convertJsonStrToPayLoadObj(tst)));


    }
}
