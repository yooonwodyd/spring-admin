package com.testsite.board.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;


@Getter
@ToString(callSuper = true)
@Table(indexes = {
        @Index(columnList = "title"),
        @Index(columnList = "hashtag"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy"),
})
@Entity
public class Article extends AuditingFields{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter @ManyToOne(optional = false) @JoinColumn(name = "userId") private UserAccount userAccount; //유저 정보(ID)

    @Setter @Column(nullable = false) private String title;
    @Setter @Column(nullable = false, length = 10000) private String content;


    @Setter private String hashtag;


    @OrderBy("createdAt DESC ")
    @OneToMany(mappedBy = "article",cascade = CascadeType.ALL) // mappedBy =
    @ToString.Exclude
    private final Set<ArticleComment> articleComments = new LinkedHashSet<>();



    protected Article(){}
    // 비어있는 생성자를 protected로 막아둠으로서 외부에서 생성하지 못하도록 해두기

    private Article(UserAccount userAccount,String title, String content, String hashtag) {
        this.userAccount = userAccount;
        this.title = title;
        this.content = content;
        this.hashtag = hashtag;
    }

    public static Article of(UserAccount userAccount,String title, String content, String hashtag) {
        return new Article(userAccount,title, content, hashtag);
    }

    // 동일성, 동등성 검사가 필요. why? -> 리스트에 담아서 쓸 때, 중복요소 제거 or 제거할 수 있어야 함.
    // 서비스 영역에 들어가야하는 지는 생각해보자.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article that)) return false;
        return this.getId() != null && this.getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId());
    }
}
