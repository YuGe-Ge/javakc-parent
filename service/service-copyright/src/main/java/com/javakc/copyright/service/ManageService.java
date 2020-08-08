package com.javakc.copyright.service;

import com.javakc.commonutils.api.APICODE;
import com.javakc.commonutils.jpa.base.service.BaseService;
import com.javakc.commonutils.jpa.dynamic.SimpleSpecificationBuilder;
import com.javakc.copyright.dao.ClientDao;
import com.javakc.copyright.dao.ManageDao;
import com.javakc.copyright.entity.Client;
import com.javakc.copyright.entity.MaQuery;
import com.javakc.copyright.entity.Manage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class ManageService extends BaseService<ManageDao, Manage> {

    @Autowired
    private ManageDao manageDao;
    @Autowired
    private ClientDao clientDao;
    public Page<Manage> findPageBook(MaQuery maQuery, int pageNo, int pageSize) {
        Specification<Manage> specification = new SimpleSpecificationBuilder().and("copyright", ":", maQuery.getCopyright())
                .and("company", ":", maQuery.getCompany())
                .and("noteName", ":", maQuery.getNoteName()).getSpecification();
        Page page=manageDao.findAll(specification, PageRequest.of(pageNo-1,pageSize));
        return page;

    }
    public APICODE delete(int id){

        clientDao.deleteByMidEquals(id);
        manageDao.deleteByIdEquals(id);
        return APICODE.OK();
    }
}