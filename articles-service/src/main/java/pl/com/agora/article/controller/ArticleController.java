package pl.com.agora.article.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import pl.com.agora.article.dto.ArticleDTO;
import pl.com.agora.article.dto.ArticleErrorResponse;
import pl.com.agora.article.repo.ArticleService;

@Controller
@RequestMapping("/article")
public class ArticleController {

    public static Logger log = LoggerFactory.getLogger(ArticleController.class);
    
    @Autowired
    private ArticleService repository;

    @RequestMapping
    @ResponseBody
    public List<ArticleDTO> getAllArticles() {
        log.debug("Article getAll invoked.");
        return repository.findAll();
    }
    
    @RequestMapping("/{articleId}")
    @ResponseBody
    public ArticleDTO get(@PathVariable("articleId") String articleId) {
        log.debug("Article get invoked. Article id : {}", articleId);
        ArticleDTO result = repository.load(articleId);
        if (result == null) {
            throw new ArticleNotFoundException(articleId, "Article not found");
        }
        return result;
    }
    
    @ExceptionHandler(ArticleNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ArticleErrorResponse handleNotFound(ArticleNotFoundException e) {
        return new ArticleErrorResponse(e.getArticleId(), e.getMessage());
    }
}
