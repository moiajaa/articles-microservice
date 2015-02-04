package pl.com.agora.article.repo;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import pl.com.agora.article.domain.Article;
import pl.com.agora.article.dto.ArticleDTO;
import pl.com.agora.article.repo.jpa.ArticleDAO;
import pl.com.agora.article.util.ArticleUtil;

@Service
public class DaoArticleService implements ArticleService {

    @Autowired
    private ArticleDAO dao;

    @Value("${article.lead.length}")
    private int leadLength = 30;

    @Override
    @Transactional
    public List<ArticleDTO> findAll() {
        List<ArticleDTO> result = new ArrayList<ArticleDTO>();
        dao.findAll(new Sort("id")).forEach(a -> result.add(map(a, true)));
        return result;
//        return dao.findAll(new Sort("id")).stream().map(a -> map(a, true)).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ArticleDTO load(String articleId) {
        return map(dao.findOne(articleId), false);
    }    
    
    private ArticleDTO map(Article article, boolean shortenArticle) {
        if (article == null) {
            return null;
        }
        
        final String articleText = ArticleUtil.removeSpecialTags(article.getContent(), shortenArticle);
        return new ArticleDTO(article.getId(), article.getTitle(), shortenArticle ? articleText.substring(0, Math.min(leadLength, articleText.length())) + "..." : articleText);
    }    
}
