package com.wayfarer.community.dto.article;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
public class CommunityArticleUpdateRequestDto {

    private List<Long> topics;

    @NotBlank(message = "제목은 하나 이상의 공백이 아닌 문자를 입력해야 합니다.")
    private String title;

    @NotBlank(message = "본문은 하나 이상의 공백이 아닌 문자를 입력해야 합니다.")
    private String content;

}
