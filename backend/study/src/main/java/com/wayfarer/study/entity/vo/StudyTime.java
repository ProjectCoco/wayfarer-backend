package com.wayfarer.study.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDateTime;


@Builder
@Getter
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
