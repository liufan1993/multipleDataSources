package com.liufan.mutildatasource.service.impl;

import com.alibaba.fastjson.JSON;
import com.liufan.mutildatasource.dao.mysql.MysqlDao;
import com.liufan.mutildatasource.dao.oracle.OracleDao;
import com.liufan.mutildatasource.dao.sqlserver.SqlserverDao;
import com.liufan.mutildatasource.service.CeshiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author insistOn
 * @Title:
 * @Package
 * @Description:
 * @date 2020/3/2518:31
 */
@Slf4j
@Service
public class CeshiServiceImpl implements CeshiService {

    @Autowired
    private MysqlDao mysqlDao;

    @Autowired
    private SqlserverDao sqlserverDao;

    @Autowired
    private OracleDao oracleDao;

    @Override
    public void ceshi() {
        log.info("mysql结果：{}", JSON.toJSONString(mysqlDao.selectMysql()));
        log.info("sqlserver结果：{}", JSON.toJSONString(sqlserverDao.selectSqlServer()));
        log.info("oracle结果：{}", JSON.toJSONString(oracleDao.selectOracle()));
    }
}
