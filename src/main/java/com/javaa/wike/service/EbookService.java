package com.javaa.wike.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javaa.wike.domain.Ebook;
import com.javaa.wike.domain.EbookExample;
import com.javaa.wike.mapper.EbookMapper;
import com.javaa.wike.req.EbookReq;
import com.javaa.wike.resp.EbookResp;
import com.javaa.wike.resp.PageResp;
import com.javaa.wike.util.CopyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;


@Service
public class EbookService {

    private static final Logger LOG = LoggerFactory.getLogger(EbookService.class);

    @Resource
    private EbookMapper ebookMapper;

    public PageResp<EbookResp> list(EbookReq ebookReq){
//
        EbookExample ebookExample=new EbookExample();
        EbookExample.Criteria criteria=ebookExample.createCriteria();

        if (!ObjectUtils.isEmpty(ebookReq.getName())){
            criteria.andNameLike("%"+ebookReq.getName()+"%");
        }
        PageHelper.startPage(ebookReq.getPage(), ebookReq.getSize());
        List<Ebook> ebookList= ebookMapper.selectByExample(ebookExample);

        PageInfo<Ebook> pageInfo = new PageInfo<>(ebookList);
        LOG.info("总行数：{}", pageInfo.getTotal());
        LOG.info("总页数：{}", pageInfo.getPages());

        List<EbookResp> ebookRespList = CopyUtil.copyList(ebookList,EbookResp.class);


//        for (Ebook ebook : ebookList){
////            EbookResp ebookResp=new EbookResp();
////            BeanUtils.copyProperties(ebook,ebookResp);
//            EbookResp ebookResp= CopyUtil.copy(ebook,EbookResp.class);
//            ebookRespList.add(ebookResp);
//        }
        PageResp<EbookResp> pageResp = new PageResp();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(ebookRespList);

        return pageResp;
    }

}
