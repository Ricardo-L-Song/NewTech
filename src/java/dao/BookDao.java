/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import pack.BookDetails;

/**
 *
 * @author sl
 */
public interface BookDao {
       /***
15      * 图书的查询的方法
16      * @param sql
17      * @param arr
18      * @return
19      */
     public List<BookDetails> select(String sql,Object[] arr);
     
     /***
23      * 按照图书编号进行查询
24      * @param id
25      * @return
26      */
     public BookDetails getBook(Integer id);
     
     public List<BookDetails> getBooks(String category);
     
     public List<BookDetails> queryAll();
}
