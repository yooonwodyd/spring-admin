package com.testsite.board.repository;

import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.StringExpression;
import com.testsite.board.domain.Article;
import com.testsite.board.domain.QArticle;
import com.testsite.board.repository.querydsl.ArticleRepositoryCustom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;



// QuerydslPredicateExecutor -> Article 안에 있는 모든 필드에 대한 기본 검색기능을 추가해줌
// QuerydslBinderCustomizer -> 입맛에 맞는 검색기능을 추가하기 위함
@RepositoryRestResource
public interface ArticleRepository extends
        JpaRepository<Article,Long>,
        ArticleRepositoryCustom,
        QuerydslPredicateExecutor<Article>,
        QuerydslBinderCustomizer<QArticle> {

    Page<Article> findByTitleContaining(String title, Pageable pageable);
    Page<Article> findByContentContaining(String content, Pageable pageable);
    Page<Article> findByUserAccount_UserIdContaining(String userId, Pageable pageable);
    Page<Article> findByUserAccount_NicknameContaining(String nickname, Pageable pageable);
    Page<Article> findByHashtag(String hashtag, Pageable pageable);

    void deleteByIdAndUserAccount_UserId(Long articleId, String userId);

    @Override
    default void customize(QuerydslBindings bindings, QArticle root){
        // article에 대한 모든 필드가 검색기능이 열려있는데 선택적으로 검색 가능하게 만들고 싶을 때 사용 -> listing을 하지 않은 property는 검색에서 제외시킴
        bindings.excludeUnlistedProperties(true);
        // 검색 추가하고 싶은 것들 추가
        bindings.including(root.title, root.content,root.hashtag,root.createdAt,root.createdBy);

        //현재 완전히 일치해야 검색이 됨 -> 이를 바꾸기 위한 것 first = 검색 파라미터의 개수는 하나만 받겠다는 것.
        bindings.bind(root.title).
                first(StringExpression::containsIgnoreCase);
        // 위의 식을 람다로 표현하면?
        // bindings.bind(root.title).first((path, value) -> path.eq(value));

        bindings.bind(root.content).first(StringExpression::containsIgnoreCase);
        bindings.bind(root.hashtag).first(StringExpression::containsIgnoreCase);
        bindings.bind(root.createdAt).first(DateTimeExpression::eq);
        bindings.bind(root.createdBy).first(StringExpression::containsIgnoreCase);
    }
}


