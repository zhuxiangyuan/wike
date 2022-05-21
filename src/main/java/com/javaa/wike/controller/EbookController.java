package com.javaa.wike.controller;

import com.javaa.wike.req.EbookReq;
import com.javaa.wike.resp.CommonResp;
import com.javaa.wike.resp.EbookResp;
import com.javaa.wike.resp.PageResp;
import com.javaa.wike.service.EbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ebook")
public class EbookController {

    @Autowired
    private EbookService ebookService;


    @GetMapping("/list")
    public CommonResp list(EbookReq ebookReq){
        CommonResp<PageResp<EbookResp>> resp=new CommonResp<>();
        PageResp<EbookResp> list=ebookService.list(ebookReq);
        resp.setContent(list);
        return resp;
    }
}
