package com.example.demo.dao;

import com.example.demo.entity.Danmu;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DanmuMapper {

    @Select("select * from danmu where vid=#{vid}")
    public List<Danmu> selectDanmubyVid(int vid) ;
}