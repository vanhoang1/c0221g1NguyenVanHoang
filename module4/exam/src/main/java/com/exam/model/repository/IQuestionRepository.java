package com.exam.model.repository;

import com.exam.model.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuestionRepository extends JpaRepository<Question, Long> {
    @Query( value="select * from question q WHERE q.title like :keyword order by q.status , q.date_create desc",nativeQuery=true)
    Page<Question> findAllWithKeyWord(Pageable pageable, String keyword);
}
