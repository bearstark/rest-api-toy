package me.jordy.toy.schedular.vo.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity @Getter @Setter @EqualsAndHashCode(of = "seq")
@Builder @NoArgsConstructor @AllArgsConstructor
@ToString
public class Git {

    @Id
    @GeneratedValue
    long seq;

    String name;

    String url;

    @ManyToOne(optional = true)
    private ScheduleHistory scheduleHistory;
}
