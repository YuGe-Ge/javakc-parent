package com.javakc.cms.controller;

import com.javakc.cms.entity.Book;
import com.javakc.cms.entity.ChapterContent;
import com.javakc.cms.service.ChapterContentService;
import com.javakc.commonutils.api.APICODE;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "章节测试管理")
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

}
