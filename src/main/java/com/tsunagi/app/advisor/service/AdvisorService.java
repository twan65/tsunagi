package com.tsunagi.app.advisor.service;

import com.tsunagi.app.advisor.dto.AdvisorDto;
import com.tsunagi.app.advisor.dto.AdvisorListRequestDto;
import com.tsunagi.app.advisor.dto.AdvisorListResponseDto;
import com.tsunagi.app.domain.advisor.Advisor;
import com.tsunagi.app.domain.advisor.AdvisorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * ServiceではトランザクションとJPA実行順番だけを扱う。
 * ビジネスロジックはドメインで扱う。
 */
@RequiredArgsConstructor
@Service
public class AdvisorService {

  private final AdvisorRepository advisorRepository;

  /**
   * 検索条件によるアドバイザー一覧を取得する。
   *
   * @param requestDto 検索条件
   * @return アドバイザー一覧
   */
  @Transactional(readOnly = true)
  public AdvisorListResponseDto findAllBy(AdvisorListRequestDto requestDto) {

    List<Advisor> advisors;

    // TODO: ソートはどうするのか検討が必要、検討後に適用しよう。
    if (requestDto.getExpertise() != null && requestDto.getGender() != null) {
      advisors = advisorRepository.findByExpertiseAndGenderIsDeletedFalse(requestDto.getExpertise(), requestDto.getGender());
    } else if (requestDto.getExpertise() != null) {
      advisors = advisorRepository.findByExpertiseAndIsDeletedFalse(requestDto.getExpertise());
    } else if (requestDto.getGender() != null) {
      advisors = advisorRepository.findByGenderAndIsDeletedFalse(requestDto.getGender());
    } else {
      advisors = advisorRepository.findByIsDeletedFalse();
    }

    // EntityリストからDtoリストに変換する。
    List<AdvisorDto> AdvisorDtoList =
            advisors.stream()
            .map(AdvisorDto::new)
            .collect(Collectors.toList());

    return new AdvisorListResponseDto(AdvisorDtoList);
  }
}
