package pl.com.agora.article.client;

import pl.com.agora.api.client.rest.UriInvocationException;

public class ArticleClientException extends UriInvocationException {

    public ArticleClientException(String uri, String message, ArticleError result, int responseStatus) {
        super(uri, message, result, responseStatus);
    }

    public ArticleClientException(String uri, String message, Throwable cause, ArticleError result, Integer responseStatus) {
        super(uri, message, cause, result, responseStatus);
    }

    public ArticleClientException(String uri, String message) {
        super(uri, message);
    }
    
    @Override
    public ArticleError getResult() {
        return (ArticleError) super.getResult();
    }
}
