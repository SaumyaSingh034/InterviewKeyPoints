package org.example;

public class RequestPayload {

    public static String addBookRequestPayload(String isbn, String aisle){
        String payload = "{\n" +
                "\n" +
                "\"name\":\"Learn Appium Automation with Java\",\n" +
                "\"isbn\":\""+isbn+"\",\n" +
                "\"aisle\":\""+aisle+"\",\n" +
                "\"author\":\"John foe\"\n" +
                "}";
        return payload;
    }

    public static String deletRequestPayload(String id) {
        String payload = "{\n" +
                " \n" +
                "\"ID\" : \""+id+"\"\n" +
                " \n" +
                "}";
        return payload;
    }
    }


