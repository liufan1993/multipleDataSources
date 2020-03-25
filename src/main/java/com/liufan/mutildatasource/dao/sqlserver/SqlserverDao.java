package com.liufan.mutildatasource.dao.sqlserver;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author insistOn
 * @Title:
 * @Package
 * @Description:
 * @date 2020/3/2518:10
 */
@Mapper
@Repository
public interface SqlserverDao {

    List<Map<String, Object>> selectSqlServer();
}
