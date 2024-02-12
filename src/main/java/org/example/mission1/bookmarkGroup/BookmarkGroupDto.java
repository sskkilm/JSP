package org.example.mission1.bookmarkGroup;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookmarkGroupDto implements Comparable<BookmarkGroupDto>{
    private int id;
    private String name;
    private int order;
    private String registerDate;
    private String updateDate;

    @Override
    public int compareTo(@NotNull BookmarkGroupDto o) {
        return getOrder() - o.getOrder();
    }
}
