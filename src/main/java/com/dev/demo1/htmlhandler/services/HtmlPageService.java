package com.dev.demo1.htmlhandler.services;

import com.dev.demo1.htmlhandler.entity.HtmlPage;

import java.util.List;

public interface HtmlPageService {

    List<HtmlPage> getHtmlPages(Integer id,
                                Integer organizationId,
                                Integer userId,
                                Integer documentNo,
                                Integer pageNo,
                                Integer order,
                                String title,
                                Integer stakeHolderId,
                                Integer yesr);

    HtmlPage getHtmlPage(Integer id);

    int isertHtmlPage(HtmlPage htmlPage);

    int updateHtmlPage(HtmlPage htmlPage);

    int deleteHtmlPage(HtmlPage htmlPage);

}
