package com.obss.week3.springdemo.springwebservice.DAO;

import com.obss.week3.springdemo.learningmanagementsystem.model.content.ElearningContent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ContentRepository extends CrudRepository<ElearningContent, Long> {

    @Override
    List<ElearningContent> findAll();

    @Transactional
    ElearningContent deleteElearningContentById(Long id);

    List<ElearningContent> findByName(String name);

    List<ElearningContent> findBySuccessRatio(Double ratio);

    List<ElearningContent> findByNameAndSuccessRatio(String name, Double ratio);
}
