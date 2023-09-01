package com.testsite.board.service;

import com.testsite.board.dto.ArticleDto;
import com.testsite.board.domain.constant.SearchType;
import com.testsite.board.repository.ArticleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;

import static org.assertj.core.api.Assertions.*;

// test를 가볍게 하기 위해 springboottest x

@DisplayName("비즈니스 로직 - 게시글")
@ExtendWith(MockitoExtension.class)
class ArticleServiceTest {
    @InjectMocks private ArticleService sut; // sut <- 테스트 대상이라는 뜻으로 많이 씀

    @Mock private ArticleRepository articleRepository;

    @DisplayName("게시글을 검색하면 게시글 리스트를 반환한다.")
    @Test
    void givenSearchParameters_whenSearchingArticles_thenReturnsArticleList(){
        //Given


        //When
        Page<ArticleDto> articles = sut.searchArticles(SearchType.TITLE,"search keyword");

        //Then
        assertThat(articles).isNotNull();
    }
}