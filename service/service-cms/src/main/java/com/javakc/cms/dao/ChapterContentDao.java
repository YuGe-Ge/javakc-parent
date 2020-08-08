package com.javakc.cms.dao;

import com.javakc.cms.entity.Book;
import com.javakc.cms.entity.ChapterContent;
import com.javakc.cms.entity.ChapterQuery;
import com.javakc.commonutils.jpa.base.dao.BaseDao;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;
import java.util.List;

public interface ChapterContentDao extends BaseDao<ChapterContent,Integer>, JpaSpecificationExecutor<ChapterContent>,PagingAndSortingRepository<ChapterContent,Integer> {

    public List<ChapterContent> findByChapterNameLikeAndChapterStatusEqualsAndGmtModifiedBetween(String name, Integer status, Date start,Date end);

}
