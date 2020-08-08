package com.javakc.copyright.service;

import com.javakc.commonutils.jpa.base.service.BaseService;
import com.javakc.copyright.dao.ClientDao;
import com.javakc.copyright.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService extends BaseService<ClientDao, Client> {
    @Autowired
    private ClientDao clientDao;


}
