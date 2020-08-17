package kr.co.wook.prac.repo;

import kr.co.wook.prac.domain.Block;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
public interface BlockRepository extends JpaRepository<Block, Long> {

}
