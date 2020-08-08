package com.javakc.cms.service;

import com.javakc.cms.dao.BookDao;
import com.javakc.cms.dao.ChapterContentDao;
import com.javakc.cms.entity.Book;
import com.javakc.cms.entity.BookQuery;
import com.javakc.cms.entity.ChapterContent;
import com.javakc.cms.entity.ChapterQuery;
import com.javakc.commonutils.jpa.base.service.BaseService;
import com.javakc.commonutils.jpa.dynamic.SimpleSpecificationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChapterContentService extends BaseService<ChapterContentDao, ChapterContent> {


    @Autowired
    private ChapterContentDao chapterContentDao;

    public List<ChapterContent> findAll(){
        return chapterContentDao.findAll();
    }

    public Page<ChapterContent> findPageChapterContent(ChapterQuery chapterQuery, int pageNo , int pageSize) {
        Specification<ChapterContent> specification=new SimpleSpecificationBuilder()
                .and("chapterName",":",chapterQuery.getChapterName())
                .and("chapterStatus", "=", chapterQuery.getChapterStatus())
                .and("startTime",">=",chapterQuery.getStartTime())
                .and("endTime","<=",chapterQuery.getEndTime())
                .getSpecification();
        Page<ChapterContent> page=chapterContentDao.findAll(specification, PageRequest.of(pageNo-1,pageSize));
        return page;
    }

}
