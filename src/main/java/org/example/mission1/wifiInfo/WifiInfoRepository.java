package org.example.mission1.wifiInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WifiInfoRepository{

    public WifiInfoDto select(String wifiId) {
        WifiInfoDto wifiInfoDto = new WifiInfoDto();

        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            String dbFile = "/Users/limseong-geun/Desktop/JSP/Mission1/Mission1.db";
            conn = DriverManager.getConnection("jdbc:sqlite:" + dbFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String sql = " select * from WIFI_INFO where MGR_NO = ? ";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, wifiId);

            rs = ps.executeQuery();
            wifiInfoDto.setX_SWIFI_MGR_NO(rs.getString("MGR_NO"));
            wifiInfoDto.setX_SWIFI_WRDOFC(rs.getString("WRDOFC"));
            wifiInfoDto.setX_SWIFI_MAIN_NM(rs.getString("MAIN_NM"));
            wifiInfoDto.setX_SWIFI_ADRES1(rs.getString("ADRES1"));
            wifiInfoDto.setX_SWIFI_ADRES2(rs.getString("ADRES2"));
            wifiInfoDto.setX_SWIFI_INSTL_FLOOR(rs.getString("INSTL_FLOOR"));
            wifiInfoDto.setX_SWIFI_INSTL_TY(rs.getString("INSTL_TY"));
            wifiInfoDto.setX_SWIFI_INSTL_MBY(rs.getString("INSTL_MBY"));
            wifiInfoDto.setX_SWIFI_SVC_SE(rs.getString("SVC_SE"));
            wifiInfoDto.setX_SWIFI_CMCWR(rs.getString("CMCWR"));
            wifiInfoDto.setX_SWIFI_CNSTC_YEAR(rs.getInt("CNSTC_YEAR"));
            wifiInfoDto.setX_SWIFI_INOUT_DOOR(rs.getString("INOUT_DOOR"));
            wifiInfoDto.setX_SWIFI_REMARS3(rs.getString("REMARS3"));
            wifiInfoDto.setLAT(rs.getDouble("LAT"));
            wifiInfoDto.setLNT(rs.getDouble("LNT"));
            wifiInfoDto.setWORK_DTTM(rs.getString("WORK_DTTM"));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return wifiInfoDto;
    }

    public void deleteAll() {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            String dbFile = "/Users/limseong-geun/Desktop/JSP/Mission1/Mission1.db";
            conn = DriverManager.getConnection("jdbc:sqlite:" + dbFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        PreparedStatement ps = null;
        String sql = " delete from WIFI_INFO ";
        try {
            ps = conn.prepareStatement(sql);
            int affected = ps.executeUpdate();
            if (affected > 0) {
                System.out.println("삭제 성공");
            } else {
                System.out.println("삭제 실패");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void save(List<WifiInfoDto> wifiInfoDtos) {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            String dbFile = "/Users/limseong-geun/Desktop/JSP/Mission1/Mission1.db";
            conn = DriverManager.getConnection("jdbc:sqlite:" + dbFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        PreparedStatement ps = null;
        String sql = " insert into WIFI_INFO " +
                " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
        for (WifiInfoDto wifiInfoDto : wifiInfoDtos) {
            try {
                ps = conn.prepareStatement(sql);
                ps.setString(1, wifiInfoDto.getX_SWIFI_MGR_NO());
                ps.setString(2, wifiInfoDto.getX_SWIFI_WRDOFC());
                ps.setString(3, wifiInfoDto.getX_SWIFI_MAIN_NM());
                ps.setString(4, wifiInfoDto.getX_SWIFI_ADRES1());
                ps.setString(5, wifiInfoDto.getX_SWIFI_ADRES2());
                ps.setString(6, wifiInfoDto.getX_SWIFI_INSTL_FLOOR());
                ps.setString(7, wifiInfoDto.getX_SWIFI_INSTL_TY());
                ps.setString(8, wifiInfoDto.getX_SWIFI_INSTL_MBY());
                ps.setString(9, wifiInfoDto.getX_SWIFI_SVC_SE());
                ps.setString(10, wifiInfoDto.getX_SWIFI_CMCWR());
                ps.setInt(11, wifiInfoDto.getX_SWIFI_CNSTC_YEAR());
                ps.setString(12, wifiInfoDto.getX_SWIFI_INOUT_DOOR());
                ps.setString(13, wifiInfoDto.getX_SWIFI_REMARS3());
                ps.setDouble(14, wifiInfoDto.getLAT());
                ps.setDouble(15, wifiInfoDto.getLNT());
                ps.setString(16, wifiInfoDto.getWORK_DTTM());

                int affected = ps.executeUpdate();
                if (affected > 0) {
                    System.out.println("저장 성공");
                } else {
                    System.out.println("저장 실패");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (ps != null && !ps.isClosed()) {
                        ps.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public List<WifiInfoDto> selectAll() {
        List<WifiInfoDto> wifiInfoDtos = new ArrayList<>();

        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            String dbFile = "/Users/limseong-geun/Desktop/JSP/Mission1/Mission1.db";
            conn = DriverManager.getConnection("jdbc:sqlite:" + dbFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String sql = " select * from WIFI_INFO ";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                WifiInfoDto wifiInfoDto = new WifiInfoDto();
                wifiInfoDto.setX_SWIFI_MGR_NO(rs.getString("MGR_NO"));
                wifiInfoDto.setX_SWIFI_WRDOFC(rs.getString("WRDOFC"));
                wifiInfoDto.setX_SWIFI_MAIN_NM(rs.getString("MAIN_NM"));
                wifiInfoDto.setX_SWIFI_ADRES1(rs.getString("ADRES1"));
                wifiInfoDto.setX_SWIFI_ADRES2(rs.getString("ADRES2"));
                wifiInfoDto.setX_SWIFI_INSTL_FLOOR(rs.getString("INSTL_FLOOR"));
                wifiInfoDto.setX_SWIFI_INSTL_TY(rs.getString("INSTL_TY"));
                wifiInfoDto.setX_SWIFI_INSTL_MBY(rs.getString("INSTL_MBY"));
                wifiInfoDto.setX_SWIFI_SVC_SE(rs.getString("SVC_SE"));
                wifiInfoDto.setX_SWIFI_CMCWR(rs.getString("CMCWR"));
                wifiInfoDto.setX_SWIFI_CNSTC_YEAR(rs.getInt("CNSTC_YEAR"));
                wifiInfoDto.setX_SWIFI_INOUT_DOOR(rs.getString("INOUT_DOOR"));
                wifiInfoDto.setX_SWIFI_REMARS3(rs.getString("REMARS3"));
                wifiInfoDto.setLAT(rs.getDouble("LAT"));
                wifiInfoDto.setLNT(rs.getDouble("LNT"));
                wifiInfoDto.setWORK_DTTM(rs.getString("WORK_DTTM"));

                wifiInfoDtos.add(wifiInfoDto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return wifiInfoDtos;
    }
}
