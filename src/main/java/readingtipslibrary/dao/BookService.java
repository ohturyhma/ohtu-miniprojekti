/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readingtipslibrary.dao;

import java.util.ArrayList;
import java.util.List;
import readingtipslibrary.dao.BookDao;
import readingtipslibrary.dao.Database;
import readingtipslibrary.dao.VideoDao;
import readingtipslibrary.domain.Book;
import readingtipslibrary.domain.Tip;

/**
 *
 * @author johyry
 */
public class BookService {

    private BookDao bookDao;

    public BookService(Database database) {
        this.bookDao = new BookDao(database);
    }

    public boolean insertBook(String author, String title, String isbn, String type) {
        Book book = new Book(author, title, isbn, type);

        try {
            bookDao.insert(book);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public List<Tip> findAll() {
        List<Tip> books = new ArrayList<>();
        
        try {
            books = bookDao.findAll();
        } catch (Exception e) {
            return books;
        }

        return books;

    }

}
