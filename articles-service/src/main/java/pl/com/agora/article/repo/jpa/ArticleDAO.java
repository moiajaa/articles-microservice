package pl.com.agora.article.repo.jpa;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import pl.com.agora.article.domain.Article;

public interface ArticleDAO extends CrudRepository<Article, String> {

    List<Article> findAll(Sort sort);
}
