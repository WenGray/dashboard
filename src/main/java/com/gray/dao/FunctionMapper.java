package com.gray.dao;

import com.gray.entity.Function;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User表相关语句
 * Created by gray on 2017/5/7.
 */
@Repository
public interface FunctionMapper {

    /**
     * 查询所有User
     * @return 所有user
     */
    List<Function> selectAll();
}
