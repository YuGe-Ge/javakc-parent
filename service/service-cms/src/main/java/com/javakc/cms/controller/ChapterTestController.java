package com.javakc.cms.controller;

import com.javakc.cms.entity.*;
import com.javakc.cms.service.ChapterContentService;
import com.javakc.cms.service.ChapterTestService;
import com.javakc.commonutils.api.APICODE;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "章节测试管理")
@RestController
@RequestMapping("/cms/book/chapterTest")
@CrossOrigin
public class ChapterTestController {

    @Autowired
    private ChapterTestService chapterTestService;

    @ApiOperation(value = "查询所有的章节内容")
    @GetMapping
    public APICODE findAll(){
        List<ChapterTest> chapterList=chapterTestService.findAll();
        return APICODE.OK().data("items",chapterList);
    }
    @ApiOperation(value = "根据条件进行分页查询")
    @PostMapping("{pageNo}/{pageSize}")
    public APICODE findPageBook(ChapterTestQuery chapterTestQuery, @PathVariable int pageNo, @PathVariable int pageSize) {
        Page<ChapterTest> page = chapterTestService.findPageChapterTest(chapterTestQuery, pageNo, pageSize);
        long totalElements = page.getTotalElements();
        List<ChapterTest> chapterTestsList = page.getContent();
        return APICODE.OK().data("total", totalElements).data("items", chapterTestsList);

    }

    @ApiOperation(value = "新增章节")
    @PostMapping("saveChapterTestContent")
    public APICODE saveBook(@RequestBody ChapterTest chapterTest,Book book) {
        System.out.println(chapterTest.toString());
        System.out.println(book.toString());
        chapterTestService.saveOrUpdate(chapterTest);
        return APICODE.OK();
    }

    @ApiOperation(value = "根据ID获取书籍")
    @GetMapping("getChapterById/{chapterId}")
    public APICODE getBookById(@PathVariable Integer chapterId) {
       ChapterTest chapterTest = chapterTestService.getById(chapterId);
        return APICODE.OK().data("chapterContent", chapterTest);
    }

    @ApiOperation(value = "修改书籍")
    @PostMapping("updateChapter")
    public APICODE updateBook(@RequestBody ChapterTest chapterTest) {
        chapterTestService.saveOrUpdate(chapterTest);
        return APICODE.OK();
    }

    @ApiOperation(value = "根据ID删除书籍")
    @DeleteMapping("deleteById/{chapterId}")
    public APICODE deleteById(@PathVariable Integer chapterId) {
        chapterTestService.removeById(chapterId);
        return APICODE.OK();
    }

}
