package com.testsite.board.repository;

import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.StringExpression;
import com.testsite.board.domain.Article;
import com.testsite.board.domain.ArticleComment;
import com.testsite.board.domain.QArticle;
import com.testsite.board.domain.QArticleComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


@RepositoryRestResource
public interface ArticleCommentRepository extends
        JpaRepository<ArticleComment,Long>,
        QuerydslPredicateExecutor<ArticleComment>,
        QuerydslBinderCustomizer<QArticleComment> {


    List<ArticleComment> findByArticle_Id(Long articleId);
    void deleteByIdAndUserAccount_UserId(Long articleCommentId, String userId);

    @Override
    default void customize(QuerydslBindings bindings, QArticleComment root){
        // article에 대한 모든 필드가 검색기능이 열려있는데 선택적으로 검색 가능하게 만들고 싶을 때 사용 -> listing을 하지 않은 property는 검색에서 제외시킴
        bindings.excludeUnlistedProperties(true);
        // 검색 추가하고 싶은 것들 추가
        bindings.including(root.content,root.createdAt,root.createdBy);

        //현재 완전히 일치해야 검색이 됨 -> 이를 바꾸기 위한 것
        bindings.bind(root.content).first(StringExpression::containsIgnoreCase);
        bindings.bind(root.createdAt).first(DateTimeExpression::eq);
        bindings.bind(root.createdBy).first(StringExpression::containsIgnoreCase);
    }

}
