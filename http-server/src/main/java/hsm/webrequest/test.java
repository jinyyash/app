package hsm.webrequest;

import java.io.IOException;

public class test {
    public static void main(String args[]){
        System.out.println("CA:ABCVJTABCRRSC".split(":")[0]);
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

        try {
            WebRequest.separateObjectsToEventType(tstStr1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
