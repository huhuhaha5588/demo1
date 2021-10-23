package com.dev.demo1.htmlhandler.dao;

import com.dev.demo1.htmlhandler.entity.HtmlPage;
import org.springframework.stereotype.Repository;

@Repository
public interface HtmlPageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HtmlPage record);

    int insertSelective(HtmlPage record);

    HtmlPage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HtmlPage record);

    int updateByPrimaryKey(HtmlPage record);
}