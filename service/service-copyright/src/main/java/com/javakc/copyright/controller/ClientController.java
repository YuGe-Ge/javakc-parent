package com.javakc.copyright.controller;

import com.javakc.commonutils.api.APICODE;
import com.javakc.copyright.dao.ClientDao;
import com.javakc.copyright.entity.ClQuery;
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

@Api(tags = "客户管理")
@RestController
@RequestMapping("/copyright/client")
@CrossOrigin
public class ClientController {

    @Autowired
    private ClientService clientService;
    @Autowired
    private ManageService manageService;
    @Autowired
    private ClientDao clientDao;

    @ApiOperation(value = "条件查询")
    @GetMapping("/query/{pageNo}/{pageSize}")
    public APICODE query(@RequestBody ClQuery clQuery, int pageNo, int pageSize)
    {
        pageSize=3;
        pageNo=1;
        Page<Client> page = clientService.findPageBook(clQuery, pageNo, pageSize);
        long totalElements = page.getTotalElements();
        List<Client> ClientList = page.getContent();
        return APICODE.OK().data("total", totalElements).data("items", ClientList);
    }

    @ApiOperation(value = "客户添加")
    @PostMapping("/insert/client")
    public APICODE insert(@RequestBody Client client){
            clientService.saveOrUpdate(client);
            return APICODE.OK();
    }



    @ApiOperation(value = "通过ID查询")
    @GetMapping("/update/query/{id}")
    public APICODE findById(@PathVariable String id)
    {
        Client client=clientService.getById(id);
        return APICODE.OK().data("items",client);
    }

    @ApiOperation(value = "客户修改")
    @PutMapping("/update/client")
    public APICODE update(@RequestBody Client client){

        clientService.saveOrUpdate(client);
        return  APICODE.OK();
    }

    @ApiOperation(value = "客户删除")
    @DeleteMapping("{id}")
    public APICODE delete(@PathVariable String id){


       clientService.removeById(id);

        return APICODE.OK();
    }

    @ApiOperation(value = "清空")
    @DeleteMapping("/remove")
    public APICODE deleteAll(){

        List<Client> list=clientDao.findAll();
        for (int i=0;i<list.size();i++){
            clientService.removeById(list.get(i).getId());
        }


        return APICODE.OK();
    }

    @ApiOperation(value = "Id数组删除")
    @DeleteMapping("/remove/ids")
    public APICODE deleteByIds(@RequestBody String[] ids)
    {
        for(int i=0;i<ids.length;i++)
        {
            clientService.removeById(ids[i]);
        }
        return APICODE.OK();
    }



}
