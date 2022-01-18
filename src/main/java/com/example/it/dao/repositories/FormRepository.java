package com.example.it.dao.repositories;

import com.example.it.dao.models.Form;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface FormRepository extends JpaRepository<Form, Integer>, JpaSpecificationExecutor<Form> {
}
