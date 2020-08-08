package com.javakc.cms.controller;

import com.javakc.cms.dao.BookDao;
import com.javakc.cms.entity.Book;
import com.javakc.cms.entity.BookQuery;
import com.javakc.cms.entity.ChapterContent;
import com.javakc.cms.entity.ChapterQuery;
import com.javakc.cms.service.BookService;
import com.javakc.cms.service.ChapterContentService;
import com.javakc.commonutils.api.APICODE;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Api(tags = "章节管理")
@RestController
@RequestMapping("/cms/book/chapterContent")
@CrossOrigin
public class ChapterContentController {

    @Autowired
    private ChapterContentService chapterContentService;

    @ApiOperation(value = "查询所有的章节内容")
    @GetMapping
    public APICODE findAll(){
        List<ChapterContent> chapterList=chapterContentService.findAll();
        return APICODE.OK().data("items",chapterList);
    }
    @ApiOperation(value = "根据条件进行分页查询")
    @PostMapping("{pageNo}/{pageSize}")
    public APICODE findPageBook(ChapterQuery chapterQuery, @PathVariable int pageNo, @PathVariable int pageSize) {
        Page<ChapterContent> page = chapterContentService.findPageChapterContent(chapterQuery, pageNo, pageSize);
        long totalElements = page.getTotalElements();
        List<ChapterContent> bookList = page.getContent();
        return APICODE.OK().data("total", totalElements).data("items", bookList);

    }

    @ApiOperation(value = "新增章节")
    @PostMapping("saveChapterContent")
    public APICODE saveBook(@RequestBody ChapterContent chapterContent,Book book) {
        System.out.println(chapterContent.toString());
        System.out.println(book.toString());
        chapterContentService.saveOrUpdate(chapterContent);
        return APICODE.OK();
    }

    @ApiOperation(value = "根据ID获取书籍")
    @GetMapping("getChapterById/{chapterId}")
    public APICODE getBookById(@PathVariable Integer chapterId) {
       ChapterContent chapterContent = chapterContentService.getById(chapterId);
        return APICODE.OK().data("chapterContent", chapterContent);
    }

    @ApiOperation(value = "修改书籍")
    @PostMapping("updateChapter")
    public APICODE updateBook(@RequestBody ChapterContent chapterContent) {
        chapterContentService.saveOrUpdate(chapterContent);
        return APICODE.OK();
    }

    @ApiOperation(value = "根据ID删除书籍")
    @DeleteMapping("deleteById/{chapterId}")
    public APICODE deleteById(@PathVariable Integer chapterId) {
        chapterContentService.removeById(chapterId);
        return APICODE.OK();
    }

}
