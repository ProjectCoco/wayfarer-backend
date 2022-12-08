package com.wayfarer.project.entity.vo;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter(value = AccessLevel.PROTECTED)
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class ProjectTime {

    @CreatedDate
    private LocalDateTime startTime;

    private LocalDateTime deadline;
}
