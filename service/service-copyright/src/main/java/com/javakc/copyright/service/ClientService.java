package com.javakc.copyright.service;

import com.javakc.commonutils.api.APICODE;
import com.javakc.commonutils.jpa.base.service.BaseService;
import com.javakc.commonutils.jpa.dynamic.SimpleSpecificationBuilder;
import com.javakc.copyright.dao.ClientDao;
import com.javakc.copyright.entity.ClQuery;
import com.javakc.copyright.entity.Client;
import com.javakc.copyright.entity.MaQuery;
import com.javakc.copyright.entity.Manage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService extends BaseService<ClientDao, Client> {
    @Autowired
    private ClientDao clientDao;

    public Page<Client> findPageBook(ClQuery clQuery, int pageNo, int pageSize) {
        Specification<Client> specification = new SimpleSpecificationBuilder().and("copyright", ":", clQuery.getCopyright())
                .and("name", ":", clQuery.getName()).getSpecification();
        Page page=clientDao.findAll(specification, PageRequest.of(pageNo-1,pageSize));
        return page;


    }

    public APICODE deleteAllBy(){

        List<Client> list=clientDao.findAll();

        for (int i=0;i<list.size();i++)
        {
            clientDao.deleteById(list.get(i).getId());

        }

        return APICODE.OK();
    }

}
