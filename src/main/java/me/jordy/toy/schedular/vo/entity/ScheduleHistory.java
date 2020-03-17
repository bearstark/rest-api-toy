package me.jordy.toy.schedular.vo.entity;

import lombok.*;
import me.jordy.toy.schedular.vo.entity.enumerate.ScheduleProcessingResult;

import javax.persistence.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "seq")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@ToString
public class ScheduleHistory {

    @Id
    @GeneratedValue
    long seq;

    String result;

    @Enumerated(EnumType.STRING)
    ScheduleProcessingResult scheduleProcessingResult;
}
