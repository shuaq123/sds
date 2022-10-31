package com.example.base;


import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface BaseMapper<T>
        extends tk.mybatis.mapper.common.BaseMapper<T>, Mapper<T>, MySqlMapper<T>, IdsMapper<T>, MyBatchUpdateMapperr<T> {
}