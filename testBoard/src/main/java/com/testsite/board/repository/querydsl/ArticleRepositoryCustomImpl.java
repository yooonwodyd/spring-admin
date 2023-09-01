package com.testsite.board.repository.querydsl;


import com.testsite.board.domain.Article;
import com.testsite.board.domain.QArticle;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class ArticleRepositoryCustomImpl extends QuerydslRepositorySupport implements ArticleRepositoryCustom {

    public ArticleRepositoryCustomImpl() {
        super(Article.class);
    }

    @Override
    public List<String> findAllDistinctHashtags() {
        QArticle article = QArticle.article; // 길어지는게 싫어서 그냥 꺼내온거. 별다른 의미는 없음.
        return from(article)
                .distinct() // 해시태그는 중복이 많으니까 추려내는 기능을 넣을 예정.
                .select(article.hashtag)
                .where(article.hashtag.isNotNull())
                .fetch();
    }

}