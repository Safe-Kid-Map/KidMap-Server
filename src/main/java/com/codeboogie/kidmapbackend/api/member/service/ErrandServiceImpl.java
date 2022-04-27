package com.codeboogie.kidmapbackend.api.member.service;

import com.codeboogie.kidmapbackend.common.member.domain.dto.ErrandDTO;
import com.codeboogie.kidmapbackend.common.member.domain.dto.MemberDTO;
import com.codeboogie.kidmapbackend.common.member.domain.model.Child;
import com.codeboogie.kidmapbackend.common.member.domain.model.Errand;
import com.codeboogie.kidmapbackend.common.member.domain.model.Member;
import com.codeboogie.kidmapbackend.common.member.domain.repository.ErrandRepository;
import com.codeboogie.kidmapbackend.common.member.domain.repository.MemberRepository;
import com.codeboogie.kidmapbackend.util.RandomString;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ErrandServiceImpl implements ErrandService{

    @Autowired
    private final ErrandRepository errandRepository;

    @Autowired
    private MongoTemplate mongoTemplate; //몽고DB 템플릿 불러오기

    @Override
    public void registerErrand(final ErrandDTO errandDTO){
      try{
//        if(memberDTO == null) {
//            throw new NullPointerException("Data Null");
//        }
        Errand errand = new Errand();
        errand.setUUID(errandDTO.getUUID());
        errand.setE_date(errandDTO.getE_date());
        errand.setE_content(errandDTO.getE_content());
        errand.setTarget_latitude(errandDTO.getTarget_latitude());
        errand.setTarget_longitude(errandDTO.getTarget_longitude());

        System.out.println("안드로이드 -> 서버 ServiceImpl registerErrand 업데이트:"+ errandDTO.getE_date()+errandDTO.getE_content());

        errandRepository.save(errand);


    } catch (Exception e){
        System.out.println("심부름 정보 저장 오류......");
        e.printStackTrace();
    }
    }

}