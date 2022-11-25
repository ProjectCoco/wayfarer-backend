package com.wayfarer.study.entity;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDateTime;


@Builder
@Getter
@Setter(value = AccessLevel.PROTECTED)
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class StudyTime {

    @Column()
    @CreatedDate
    private LocalDateTime startTime;

    @Column()
    private LocalDateTime deadline;

}
