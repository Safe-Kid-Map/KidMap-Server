package com.codeboogie.kidmapbackend.api.member.service;

import com.codeboogie.kidmapbackend.common.member.domain.dto.ErrandDTO;
import com.codeboogie.kidmapbackend.common.member.domain.dto.MemberDTO;
import com.codeboogie.kidmapbackend.common.member.domain.model.Errand;

public interface ErrandService {

    void registerErrand(ErrandDTO errandDTO);   // 심부름 설정하기

    void updateErrandChecking(MemberDTO memberDTO);  // 심부름 완료시 완료 업데이트 하기

    boolean fetchErrandChecking(MemberDTO memberDTO);   // 심부름 완료 여부 가져오기

    Errand fetchRecentErrand(String userId);    // 최근 부모 심부름 가져오기
}
