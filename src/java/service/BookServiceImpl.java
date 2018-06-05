/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.BookDao;
import dao.BookDaoImpl;
import java.util.ArrayList;
import java.util.List;
import pack.BookDetails;

/**
 *
 * @author sl
 */
public class BookServiceImpl implements BookService{
    private BookDao dao=new BookDaoImpl();
     
     public List<BookDetails> select(BookDetails book){
         //String sql="select * from book ";
         StringBuilder sql=new StringBuilder("select * from book_details where 1=1 ");
         //sql语句
         List<Object> list=new ArrayList<Object>();
         if(book!=null){
             
             if( book.getBookId()!=0){
                 sql.append(" and book_id=? ");
                 list.add(book.getBookId());
             }
             /*list.add(book.getBookname());
32             list.add(book.getPrice());
33             list.add(book.getAuthor());
34             list.add(book.getPic());
35             list.add(book.getPublish());*/
         }
         
        return dao.select(sql.toString(), list.toArray());
     }
 
    @Override
    public BookDetails getBook(BookDetails book) {
        if(book!=null && book.getBookId()!=0){
             return dao.getBook(book.getBookId());
         }
         return null;
    }

    @Override
    public List<BookDetails> getBooks(BookDetails book) {
        if(book!=null && !book.getCategoryName().equals("")){
              return dao.getBooks(book.getCategoryName());
         }
        else{
         return null;
        }
       
    }

    @Override
    public List<BookDetails> queryAll() {
            return dao.queryAll();
    }
    
    
}
