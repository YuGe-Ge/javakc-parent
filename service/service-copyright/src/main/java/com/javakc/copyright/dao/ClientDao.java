package com.javakc.copyright.dao;

import com.javakc.commonutils.api.APICODE;
import com.javakc.commonutils.jpa.base.dao.BaseDao;
import com.javakc.copyright.entity.Client;
import com.javakc.copyright.entity.Manage;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ClientDao extends BaseDao<Client,String>, PagingAndSortingRepository<Client, String>, JpaSpecificationExecutor<Client> {

//        @Query("delete  from Client  where mid=?1")
        public APICODE deleteByMidEquals(int mid);





}
