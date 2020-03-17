package me.jordy.toy.schedular.vo.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
public class Schedule {

    @Id
    @GeneratedValue
    long seq;

    String name;

    String details;

    @OneToMany(mappedBy = "schedule")
    private List<Git> git = new ArrayList<Git>();

    @OneToMany(mappedBy = "schedule")
    private List<Blog> blog = new ArrayList<Blog>();

    // 동적 스케쥴러
}
