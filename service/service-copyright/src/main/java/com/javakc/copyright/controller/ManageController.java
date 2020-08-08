package com.javakc.copyright.controller;

import com.javakc.commonutils.api.APICODE;
import com.javakc.copyright.entity.Client;
import com.javakc.copyright.entity.MaQuery;
import com.javakc.copyright.entity.Manage;
import com.javakc.copyright.service.ClientService;
import com.javakc.copyright.service.ManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "版权管理")
@RestController
@RequestMapping("/copyright")
@CrossOrigin
public class ManageController {
    @Autowired
    private ManageService manageService;
    @Autowired
    private ClientService clientService;

    @ApiOperation(value = "条件查询")
    @GetMapping("/query/{pageNo}/{pageSize}")
    public APICODE query(@RequestBody MaQuery maQuery,int pageNo,int pageSize)
    {
        pageSize=3;
        pageNo=1;
        Page<Manage> page = manageService.findPageBook(maQuery, pageNo, pageSize);
        long totalElements = page.getTotalElements();
        List<Manage> ManageList = page.getContent();
        return APICODE.OK().data("total", totalElements).data("items", ManageList);
    }

    @ApiOperation(value = "版权方添加")
    @PostMapping("/insert/manage")
    public APICODE insert(@RequestBody Manage manage)
    {
            manageService.saveOrUpdate(manage);
//        clientService.saveOrUpdate(client);
        return APICODE.OK();
    }

    @ApiOperation(value = "版权方修改")
    @PutMapping("/update/manage")
    public APICODE update(@RequestBody Manage manage){


        return  APICODE.OK();
    }

    @ApiOperation(value = "版权方删除")
    @DeleteMapping("{id}")
    public APICODE delete(@PathVariable int id){
        manageService.removeById(id);

        return APICODE.OK();
    }

}
