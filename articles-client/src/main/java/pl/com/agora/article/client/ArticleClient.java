package pl.com.agora.article.client;

import java.util.List;
import java.util.concurrent.Future;

import pl.com.agora.api.client.rest.bind.annotation.RestPathVariable;
import pl.com.agora.api.client.rest.bind.annotation.RestRequestMapping;
import pl.com.agora.api.client.rest.hash.LBHash;

@RestRequestMapping("/article")
public interface ArticleClient {

    @RestRequestMapping("")
    public Future<List<Article>> findAll();
    
    @RestRequestMapping("/{articleId}")
    public Future<Article> load(@LBHash @RestPathVariable("articleId") String articleId);
    
}
