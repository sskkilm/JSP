package org.example.mission1.locationHistory;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class LocationHistoryService {
    private LocationHistoryRepository locationHistoryRepository = new LocationHistoryRepository();

    public List<LocationHistoryDto> getList() {
        return locationHistoryRepository.selectAll();
    }

    public void saveLocation(double lat, double lnt) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-ddEHH:mm:ss");
        Date now = Calendar.getInstance().getTime();
        String viewDate = simpleDateFormat.format(now).toString();
        int id = locationHistoryRepository.getMaxId() + 1;
        LocationHistoryDto locationHistoryDto = new LocationHistoryDto(id, lat, lnt, viewDate);
        locationHistoryRepository.save(locationHistoryDto);
    }

    public void deleteLocation(int id) {
        locationHistoryRepository.delete(id);
    }
}
