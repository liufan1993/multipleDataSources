package com.liufan.mutildatasource.dao.mysql;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author insistOn
 * @Title:
 * @Package
 * @Description:
 * @date 2020/3/2518:09
 */
@Mapper
@Repository
public interface MysqlDao {

    List<Map<String, Object>> selectMysql();
}
