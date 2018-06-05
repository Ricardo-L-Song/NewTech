/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

/**
 *
 * @author sl
 */
public class CartItem {
      private BookDetails book;// 图书对象的成员变量
     private Integer number;// 购买的数量；
 
     public BookDetails getBook() {
         return book;
     }
 
     public void setBook(BookDetails book) {
         this.book = book;
     }
 
     public Integer getNumber() {
         return number;
     }
 
     public void setNumber(Integer number) {
         this.number = number;
     }
}
