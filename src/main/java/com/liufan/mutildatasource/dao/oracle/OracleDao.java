package com.liufan.mutildatasource.dao.oracle;

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
public interface OracleDao {

    List<Map<String, Object>> selectOracle();
}
