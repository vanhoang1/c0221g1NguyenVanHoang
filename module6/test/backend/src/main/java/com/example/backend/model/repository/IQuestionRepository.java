package com.example.backend.model.repository;

import com.example.backend.model.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface IQuestionRepository extends JpaRepository<Question, Long> {
    @Query(value = "select * from question q WHERE q.title like :keyword order by q.status , q.date_create desc", nativeQuery = true)
    Page<Question> findAllWithKeyWord(Pageable pageable, String keyword);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO exam_final.question (date_question, flag, question_answer, question_content, question_title, status, question_type_id, user_create_id, user_feed_back_id) VALUES (:date,:flag,:answer,:content,:title,:status,:type,:create,:feed_back )", nativeQuery = true)
    void create(String date,boolean flag,String answer,String content,String title,boolean status,Long type,Long create,@Param("feed_back") Long feedback);
}
