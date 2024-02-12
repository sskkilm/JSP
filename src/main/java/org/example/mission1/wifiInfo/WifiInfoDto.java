package org.example.mission1.wifiInfo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WifiInfoDto {
    /*
    create table WIFI_INFO
    (
        X_SWIFI_MGR_NO      TEXT not null
            primary key,
        X_SWIFI_WRDOFC      TEXT null,
        X_SWIFI_MAIN_NM     TEXT null,
        X_SWIFI_ADRES1      TEXT null,
        X_SWIFI_ADRES2      TEXT null,
        X_SWIFI_INSTL_FLOOR TEXT null,
        X_SWIFI_INSTL_TY    TEXT null,
        X_SWIFI_INSTL_MBY   TEXT null,
        X_SWIFI_SVC_SE      TEXT null,
        X_SWIFI_CMCWR       TEXT null,
        X_SWIFI_CNSTC_YEAR  INT        null,
        X_SWIFI_INOUT_DOOR  TEXT null,
        X_SWIFI_REMARS3     TEXT null,
        LAT               REAL      null,
        LNT               REAL      null,
        WORK_DTTM         TEXT    null
    );
    */
    private String X_SWIFI_MGR_NO;
    private String X_SWIFI_WRDOFC;
    private String X_SWIFI_MAIN_NM;
    private String X_SWIFI_ADRES1;
    private String X_SWIFI_ADRES2;
    private String X_SWIFI_INSTL_FLOOR;
    private String X_SWIFI_INSTL_TY;
    private String X_SWIFI_INSTL_MBY;
    private String X_SWIFI_SVC_SE;
    private String X_SWIFI_CMCWR;
    private int X_SWIFI_CNSTC_YEAR;
    private String X_SWIFI_INOUT_DOOR;
    private String X_SWIFI_REMARS3;
    private double LAT;
    private double LNT;
    private String WORK_DTTM;

}
