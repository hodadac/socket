package com.example.demo.repository.memo;

import com.example.demo.repository.memo.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemoRepository extends JpaRepository<Memo,Long> {
    List<Memo> findByMemberId(String memberId);

}
