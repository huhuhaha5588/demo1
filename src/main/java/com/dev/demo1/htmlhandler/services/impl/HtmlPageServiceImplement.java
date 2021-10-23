package com.dev.demo1.htmlhandler.services.impl;

import com.dev.demo1.htmlhandler.dao.HtmlPageMapper;
import com.dev.demo1.htmlhandler.entity.HtmlPage;
import com.dev.demo1.htmlhandler.services.HtmlPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class HtmlPageServiceImplement implements HtmlPageService {

    @Autowired
    private HtmlPageMapper htmlPageMapper;

    @Override
    public List<HtmlPage> getHtmlPages(Integer id, Integer organizationId, Integer userId, Integer documentNo, Integer pageNo, Integer order, String title, Integer stakeHolderId, Integer yesr) {
        List<HtmlPage> htmlPages = new ArrayList<>();
        htmlPages.add(htmlPageMapper.selectByPrimaryKey(id));
        return htmlPages;
    }

    @Override
    public HtmlPage getHtmlPage(Integer id) {
        return htmlPageMapper.selectByPrimaryKey(id);
    }

    @Override
    public int isertHtmlPage(HtmlPage htmlPage) {
        return htmlPageMapper.insert(htmlPage);
    }

    @Override
    public int updateHtmlPage(HtmlPage htmlPage) {
        return htmlPageMapper.updateByPrimaryKey(htmlPage);
    }

    @Override
    public int deleteHtmlPage(HtmlPage htmlPage) {
        return htmlPageMapper.deleteByPrimaryKey(htmlPage.getId());
    }

}
