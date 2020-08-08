package com.javakc.copyright.dao;

import com.javakc.commonutils.jpa.base.dao.BaseDao;
import com.javakc.copyright.entity.Manage;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ManageDao extends BaseDao<Manage,String>, PagingAndSortingRepository<Manage, String>, JpaSpecificationExecutor<Manage> {



}
