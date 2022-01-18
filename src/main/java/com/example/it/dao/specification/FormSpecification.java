package com.example.it.dao.specification;

import com.example.it.dao.data.form.SearchForm;
import com.example.it.dao.models.Form;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import static org.apache.commons.lang3.StringUtils.isNoneBlank;

@RequiredArgsConstructor
public class FormSpecification implements Specification<Form> {


    private final SearchForm searchForm;

    @Override
    public Predicate toPredicate(Root<Form> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

        Predicate predicate = criteriaBuilder.conjunction();

        if(isNoneBlank(searchForm.getEmail())){
            predicate.getExpressions().add(criteriaBuilder.equal(root.get("email"), searchForm.getEmail()));
        }

        return predicate;
    }
}
