package pl.com.agora.article.repo.jpa;

import org.springframework.data.repository.CrudRepository;

import pl.com.agora.article.domain.Article;

public interface ArticleDAO extends CrudRepository<Article, String> {

}
