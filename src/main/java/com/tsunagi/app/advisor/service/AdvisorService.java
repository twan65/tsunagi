package com.tsunagi.app.advisor.service;

import com.tsunagi.app.advisor.dto.AdvisorDto;
import com.tsunagi.app.advisor.dto.AdvisorListRequestDto;
import com.tsunagi.app.advisor.dto.AdvisorListResponseDto;
import com.tsunagi.app.advisor.dto.AdvisorUpdateRequestDto;
import com.tsunagi.app.domain.advisor.Advisor;
import com.tsunagi.app.domain.advisor.AdvisorRepository;
import com.tsunagi.common.constant.MessageCode;
import com.tsunagi.common.exception.NoSearchResultException;
import com.tsunagi.common.utils.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/** ServiceではトランザクションとJPA実行順番だけを扱う。 ビジネスロジックはドメインで扱う。 */
@RequiredArgsConstructor
@Service
public class AdvisorService {

  private final AdvisorRepository advisorRepository;
  private final MessageHelper messageHelper;

  /**
   * 検索条件によるアドバイザー一覧を取得する。
   *
   * @param requestDto 検索条件
   * @return アドバイザー一覧
   */
  @Transactional(readOnly = true)
  public AdvisorListResponseDto findAllBySearchCondition(AdvisorListRequestDto requestDto) {

    List<Advisor> advisors;

    // TODO: ソートはどうするのか検討が必要、検討後に適用しよう。
    if (requestDto.getExpertise() != null && requestDto.getGender() != null) {
      advisors =
          advisorRepository.findByExpertiseAndGender(
              requestDto.getExpertise(), requestDto.getGender());
    } else if (requestDto.getExpertise() != null) {
      advisors = advisorRepository.findByExpertise(requestDto.getExpertise());
    } else if (requestDto.getGender() != null) {
      advisors = advisorRepository.findByGender(requestDto.getGender());
    } else {
      advisors = advisorRepository.findAll();
    }

    // EntityリストからDtoリストに変換する。
    List<AdvisorDto> AdvisorDtoList =
        advisors.stream()
                .map(AdvisorDto::new)
                .collect(Collectors.toList());

    return new AdvisorListResponseDto(AdvisorDtoList);
  }

  /**
   * アドバイザーの詳細情報を取得する。
   *
   * @param advisorId
   * @return アドバイザーの詳細情報
   */
  @Transactional(readOnly = true)
  public AdvisorDto findById(Long advisorId) {
    Advisor advisor =
        advisorRepository
            .findById(advisorId)
            .orElseThrow(() -> new NoSearchResultException(MessageCode.E00002));

    return new AdvisorDto(advisor);
  }

  /**
   * アドバイザー情報を更新する。
   *
   * @param advisorId アドバイザーID
   * @param requestDto 更新内容
   * @return
   */
  @Transactional
  public Long update(Long advisorId, AdvisorUpdateRequestDto requestDto) {

    Advisor advisor =
        advisorRepository
            .findById(advisorId)
            .orElseThrow(() -> new NoSearchResultException(MessageCode.E00002));

    // 特にSQLを投げなくてもJPAの永続性コンテキストのため、Updateされる。（Dirty checking）
    advisor.update(requestDto.getName(), requestDto.getIntroduce(), requestDto.getExpertise());

    return advisorId;
  }
}
