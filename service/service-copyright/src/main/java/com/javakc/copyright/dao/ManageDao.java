package com.javakc.copyright.dao;

import com.javakc.commonutils.api.APICODE;
import com.javakc.commonutils.jpa.base.dao.BaseDao;
import com.javakc.copyright.entity.Manage;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ManageDao extends BaseDao<Manage,String>, PagingAndSortingRepository<Manage, String>, JpaSpecificationExecutor<Manage> {


    public APICODE deleteByIdEquals(int id);

}
