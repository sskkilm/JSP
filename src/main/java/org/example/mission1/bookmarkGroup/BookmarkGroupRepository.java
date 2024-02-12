package org.example.mission1.bookmarkGroup;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookmarkGroupRepository {

    public void delete(int id) {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            String dbFile = "/Users/limseong-geun/Desktop/JSP/Mission1/Mission1.db";
            conn = DriverManager.getConnection("jdbc:sqlite:" + dbFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String sql = " delete from BOOKMARK_GROUP where ID = ? ";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

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

    public void update(int id, String name, int order, String updateDate) {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            String dbFile = "/Users/limseong-geun/Desktop/JSP/Mission1/Mission1.db";
            conn = DriverManager.getConnection("jdbc:sqlite:" + dbFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String sql = " update BOOKMARK_GROUP set NAME = ?, ORDER_ = ?, UPDATE_DATE = ? where ID = ? ";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, order);
            ps.setString(3, updateDate);
            ps.setInt(4, id);

            int affected = ps.executeUpdate();
            if (affected > 0) {
                System.out.println("수정 성공");
            } else {
                System.out.println("수정 실패");
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
    public List<BookmarkGroupDto> selectAll() {
        List<BookmarkGroupDto> bookmarkGroupDtoList = new ArrayList<>();

        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            String dbFile = "/Users/limseong-geun/Desktop/JSP/Mission1/Mission1.db";
            conn = DriverManager.getConnection("jdbc:sqlite:" + dbFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String sql = " select * from BOOKMARK_GROUP ";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                BookmarkGroupDto bookmarkGroupDto = new BookmarkGroupDto();

                bookmarkGroupDto.setId(rs.getInt("ID"));
                bookmarkGroupDto.setName(rs.getString("NAME"));
                bookmarkGroupDto.setOrder(rs.getInt("ORDER_"));
                bookmarkGroupDto.setRegisterDate(rs.getString("REGISTER_DATE"));
                bookmarkGroupDto.setUpdateDate(rs.getString("UPDATE_DATE"));

                bookmarkGroupDtoList.add(bookmarkGroupDto);
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

        return bookmarkGroupDtoList;
    }
    public int getMaxId() {
        int id = 0;

        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            String dbFile = "/Users/limseong-geun/Desktop/JSP/Mission1/Mission1.db";
            conn = DriverManager.getConnection("jdbc:sqlite:" + dbFile);
        } catch (Exception e) {
            e.printStackTrace();
        }


        String sql = " select MAX(ID) from BOOKMARK_GROUP ";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            id = rs.getInt("MAX(ID)");
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

        return id;
    }

    public void save(BookmarkGroupDto bookmarkGroupDto) {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            String dbFile = "/Users/limseong-geun/Desktop/JSP/Mission1/Mission1.db";
            conn = DriverManager.getConnection("jdbc:sqlite:" + dbFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String sql = " insert into BOOKMARK_GROUP values (?, ?, ?, ?, ?) ";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, bookmarkGroupDto.getId());
            ps.setString(2, bookmarkGroupDto.getName());
            ps.setInt(3, bookmarkGroupDto.getOrder());
            ps.setString(4, bookmarkGroupDto.getRegisterDate());
            if (bookmarkGroupDto.getUpdateDate() == null) {
                ps.setString(5, "");
            }
            else ps.setString(5, bookmarkGroupDto.getUpdateDate());

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
