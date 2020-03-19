package me.jordy.toy.schedular.vo.entity;

import lombok.*;
import me.jordy.toy.schedular.vo.enumerate.ScheduleProcessingResult;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "scheduleHistory")
    private List<Git> git = new ArrayList<Git>();

    @OneToMany(mappedBy = "scheduleHistory")
    private List<Site> blog = new ArrayList<Site>();
}
