package com.wayfarer.community.dto.comment;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CommunityCommentRequestDto {

    @NotBlank(message = "본문은 하나 이상의 공백이 아닌 문자를 입력해야 합니다.")
    private String content;

}
