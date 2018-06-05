/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import pack.BookDetails;

/**
 *
 * @author sl
 */
public interface BookService {
     /***
15      * 图书信息查询的方法
16      * @return
17      */
     public List<BookDetails> select(BookDetails book);
     
     public List<BookDetails> getBooks(BookDetails book);
    
     /***
21      * 根据id进行查询
22      * @param id
23      * @return
24      */
     public BookDetails getBook(BookDetails book);
     
     public List<BookDetails> queryAll();
}
