package org.example.mission1;

import com.google.gson.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.example.mission1.wifiInfo.WifiInfoDto;

import java.util.ArrayList;

public class GetPublicApiData {
    public static int getTotalListCnt() {
        int cnt = 0;
        try {
            String url = "http://openapi.seoul.go.kr:8088/{인증키}/json/TbPublicWifiInfo/1/5";
            url = url.replace("{인증키}", "5572716a4b73736b323744526e5472");

            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url(url).get().build();
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                ResponseBody responseBody = response.body();
                if (responseBody != null) {
                    String obj = responseBody.string();
                    JsonParser jsonParser = new JsonParser();
                    JsonObject jsonObject = (JsonObject) jsonParser.parse(obj);
                    jsonObject = (JsonObject) jsonObject.get("TbPublicWifiInfo");
                    JsonPrimitive jsonPrimitive = (JsonPrimitive) jsonObject.get("list_total_count");
                    cnt = jsonPrimitive.getAsInt();
                } else {
                    System.out.println("Error Occurred");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cnt;
    }
    public static ArrayList<WifiInfoDto> getWifiList() {
        ArrayList<WifiInfoDto> wifiList = new ArrayList<>();
        int page = 1;
        int pageSize = 1000;
        int listTotalCnt = GetPublicApiData.getTotalListCnt();
        while (pageSize - 1000 <= listTotalCnt) {
            try {
                String url = "http://openapi.seoul.go.kr:8088/{인증키}/json/TbPublicWifiInfo/{page}/{pageSize}";
                url = url.replace("{인증키}", "5572716a4b73736b323744526e5472");
                url = url.replace("{page}", Integer.toString(page));
                url = url.replace("{pageSize}", Integer.toString(pageSize));

                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder().url(url).get().build();
                Response response = client.newCall(request).execute();
                if (response.isSuccessful()) {
                    ResponseBody responseBody = response.body();
                    if (responseBody != null) {
                        String obj = responseBody.string();
                        JsonParser jsonParser = new JsonParser();
                        JsonObject jsonObject = (JsonObject) jsonParser.parse(obj);
                        jsonObject = (JsonObject) jsonObject.get("TbPublicWifiInfo");
                        JsonArray jsonArray = (JsonArray) jsonObject.get("row");
                        Gson gson = new Gson();
                        for (Object item : jsonArray) {
                            wifiList.add(gson.fromJson(item.toString(), WifiInfoDto.class));
                        }
                    } else {
                        System.out.println("Error Occurred");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            page += 1000;
            pageSize += 1000;
        }

        return wifiList;
    }
}