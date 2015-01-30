package pl.com.agora.article.repo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.com.agora.article.domain.Article;
import pl.com.agora.article.dto.ArticleDTO;
import pl.com.agora.article.repo.jpa.ArticleDAO;

@Service
public class DaoArticleRepository implements ArticleRepository {

    @Autowired
    private ArticleDAO dao;

    @Override
    public List<ArticleDTO> findAll() {
        return map(() -> dao.findAll());
    }

    @Override
    @Transactional
    public ArticleDTO load(String articleId) {
        return map(dao.findOne(articleId));
    }    
    
    private List<ArticleDTO> map(DaoCall callback) {
        return StreamSupport.stream(callback.call().spliterator(), false)
                .map((a) -> new ArticleDTO(a.getId(), a.getTitle(), a.getContent())).collect(Collectors.toList());
    }

    private static ArticleDTO map(Article article) {
        if (article == null) {
            return null;
        }
        return new ArticleDTO(article.getId(), article.getTitle(), article.getContent());
    }
    
    static interface DaoCall {
        public Iterable<Article> call();
    }
}
