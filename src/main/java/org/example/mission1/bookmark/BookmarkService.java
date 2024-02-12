package org.example.mission1.bookmark;

import java.util.List;

public class BookmarkService {
    private BookmarkRepository bookmarkRepository = new BookmarkRepository();

    public void delete(int id) {
        bookmarkRepository.delete(id);
    }

    public BookmarkDto select(int id) {
        return bookmarkRepository.select(id);
    }

    public List<BookmarkDto> getList() {
        return bookmarkRepository.selectAll();
    }

    public void register(BookmarkDto bookmarkDto) {
        bookmarkDto.setId(bookmarkRepository.getMaxId() + 1);
        bookmarkRepository.save(bookmarkDto);
    }
}
