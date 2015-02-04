package pl.com.agora.article.repo;

import java.util.List;

import pl.com.agora.article.dto.ArticleDTO;

public interface ArticleService {

    List<ArticleDTO> findAll();

    ArticleDTO load(String articleId);

}
