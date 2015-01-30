package pl.com.agora.article.controller;

import java.util.Collections;
import java.util.List;

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
import pl.com.agora.article.repo.ArticleRepository;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleRepository repository;

    @RequestMapping
    @ResponseBody
    public List<ArticleDTO> getAllArticles() {
        return repository.findAll();
    }
    
    @RequestMapping("/{articleId}")
    @ResponseBody
    public List<ArticleDTO> get(@PathVariable("articleId") String articleId) {
        ArticleDTO result = repository.load(articleId);
        if (result == null) {
            throw new ArticleNotFoundException(articleId, "Article not found");
        }
        return Collections.singletonList(result);
    }
    
    @ExceptionHandler(ArticleNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ArticleErrorResponse handleNotFound(ArticleNotFoundException e) {
        return new ArticleErrorResponse(e.getArticleId(), e.getMessage());
    }
}
