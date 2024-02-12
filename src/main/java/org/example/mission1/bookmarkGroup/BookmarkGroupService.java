package org.example.mission1.bookmarkGroup;

import java.util.List;

public class BookmarkGroupService {
    BookmarkGroupRepository bookmarkGroupRepository = new BookmarkGroupRepository();

    public void delete(int id) {
        bookmarkGroupRepository.delete(id);
    }

    public void update(String id, String name, String order, String updateDate) {
        bookmarkGroupRepository.update(Integer.parseInt(id), name, Integer.parseInt(order), updateDate);
    }

    public void add(String name, String order, String registerDate) {
        BookmarkGroupDto bookmarkGroupDto = new BookmarkGroupDto();
        bookmarkGroupDto.setId(bookmarkGroupRepository.getMaxId() + 1);
        bookmarkGroupDto.setName(name);
        bookmarkGroupDto.setOrder(Integer.parseInt(order));
        bookmarkGroupDto.setRegisterDate(registerDate);
        bookmarkGroupRepository.save(bookmarkGroupDto);
    }

    public List<BookmarkGroupDto> getList() {
        return bookmarkGroupRepository.selectAll();
    }
}
