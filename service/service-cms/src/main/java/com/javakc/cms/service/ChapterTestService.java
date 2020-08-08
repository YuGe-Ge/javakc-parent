package com.javakc.cms.service;

import com.javakc.cms.dao.ChapterContentDao;
import com.javakc.cms.dao.ChapterTestDao;
import com.javakc.cms.entity.ChapterContent;
import com.javakc.cms.entity.ChapterQuery;
import com.javakc.cms.entity.ChapterTest;
import com.javakc.cms.entity.ChapterTestQuery;
import com.javakc.commonutils.jpa.base.service.BaseService;
import com.javakc.commonutils.jpa.dynamic.SimpleSpecificationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChapterTestService extends BaseService<ChapterTestDao, ChapterTest> {


    @Autowired
    private ChapterTestDao chapterTestDao;

    public List<ChapterTest> findAll(){
        return chapterTestDao.findAll();
    }



    public Page<ChapterTest> findPageChapterTest(ChapterTestQuery chapterTestQuery, int pageNo , int pageSize) {
        Specification<ChapterTest> specification=new SimpleSpecificationBuilder()
                .and("chapterName",":",chapterTestQuery.getChapterName())
                .and("chapterStatus", "=", chapterTestQuery.getChapterStatus())
                .getSpecification();
        Page page=chapterTestDao.findAll(specification, PageRequest.of(pageNo-1,pageSize));
        return page;
    }



}
