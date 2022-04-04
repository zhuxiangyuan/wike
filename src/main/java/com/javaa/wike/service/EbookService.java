package com.javaa.wike.service;

import com.javaa.wike.domain.Ebook;
import com.javaa.wike.domain.EbookExample;
import com.javaa.wike.mapper.EbookMapper;
import com.javaa.wike.req.EbookReq;
import com.javaa.wike.resp.EbookResp;
import com.javaa.wike.util.CopyUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EbookService {

    @Resource
    private EbookMapper ebookMapper;

    public List<EbookResp> list(EbookReq ebookReq){
        EbookExample ebookExample=new EbookExample();
        EbookExample.Criteria criteria=ebookExample.createCriteria();

        criteria.andNameLike("%"+ebookReq.getName()+"%");
        List<Ebook> ebookList= ebookMapper.selectByExample(ebookExample);

        List<EbookResp> ebookRespList = CopyUtil.copyList(ebookList,EbookResp.class);

//        for (Ebook ebook : ebookList){
////            EbookResp ebookResp=new EbookResp();
////            BeanUtils.copyProperties(ebook,ebookResp);
//            EbookResp ebookResp= CopyUtil.copy(ebook,EbookResp.class);
//            ebookRespList.add(ebookResp);
//        }


        return ebookRespList;
    }

}
