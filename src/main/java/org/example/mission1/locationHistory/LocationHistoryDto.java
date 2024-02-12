package org.example.mission1.locationHistory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocationHistoryDto implements Comparable<LocationHistoryDto>{
    private int id;
    private double gpsX;
    private double gpsY;
    private String viewDate;

    @Override
    public int compareTo(@NotNull LocationHistoryDto o) {
        return o.getId() - getId();
    }
}
