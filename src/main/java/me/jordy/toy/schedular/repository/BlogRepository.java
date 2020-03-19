package me.jordy.toy.schedular.repository;

import me.jordy.toy.schedular.vo.entity.Site;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Site, Integer> {
}
