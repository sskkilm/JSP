package org.example.mission1.wifiInfo;

import org.example.mission1.CalculateDist;
import org.example.mission1.GetPublicApiData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WifiInfoService {
    private WifiInfoRepository wifiInfoRepository = new WifiInfoRepository();

    public WifiInfoDto select(String wifiId) {
        return wifiInfoRepository.select(wifiId);
    }

    public void updateDB() {
        wifiInfoRepository.deleteAll();
        wifiInfoRepository.save(GetPublicApiData.getWifiList());
    }

    public int getAllCnt() {
        return wifiInfoRepository.selectAll().size();
    }

    public List<Map.Entry<WifiInfoDto, Double>> getCloseWifi(double myLat, double myLnt, int cnt) {
        List<WifiInfoDto> wifiInfoDtos = wifiInfoRepository.selectAll();
        Map<WifiInfoDto, Double> map = new HashMap<>();
        for (WifiInfoDto wifiInfoDto : wifiInfoDtos) {
            double lat = wifiInfoDto.getLAT();
            double lnt = wifiInfoDto.getLNT();
            double dist = CalculateDist.calculateDist(lat, lnt, myLat, myLnt);
            map.put(wifiInfoDto, dist);
        }
        List<Map.Entry<WifiInfoDto, Double>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort(Map.Entry.comparingByValue());
        return entryList.subList(0, cnt);
    }
}
