package com.javakc.cms.service;

import com.javakc.cms.dao.BookDao;
import com.javakc.cms.entity.Book;
import com.javakc.cms.entity.BookQuery;
import com.javakc.commonutils.jpa.base.service.BaseService;
import com.javakc.commonutils.jpa.dynamic.SimpleSpecificationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService extends BaseService<BookDao,Book> {

    @Autowired
    private BookDao bookDao;

    public List<Book> findAll(){
        return bookDao.findAll();
    }

    /**
     * 根据条件进行分页查询
     * @param bookQuery
     * @param pageNo
     * @param pageSize
     * @return
     */
    public Page<Book> findPageBook(BookQuery bookQuery, int pageNo , int pageSize) {
        Specification<Book> specification=new SimpleSpecificationBuilder()
                .and("cpId",":",bookQuery.getCpId())
                .and("bookName", ":", bookQuery.getBookName())
                .and("author",":",bookQuery.getAuthor())
                .and("serialize","=",bookQuery.getSerialize())
                .and("status","=",bookQuery.getStatus())
                .and("original","=",bookQuery.getOriginal())
                .and("firstSort",":",bookQuery.getFirstSort())
                .and("secondSort",":",bookQuery.getSecondSort())
                .and("free","=",bookQuery.getFree())
                .getSpecification();
        Page page=bookDao.findAll(specification, PageRequest.of(pageNo-1,pageSize));
        return page;
    }
}
