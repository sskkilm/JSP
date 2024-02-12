package org.example.mission1.bookmark;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookmarkDto {
    private int id;
    private String bookmarkName;
    private String wifiName;
    private String registerDate;
}
