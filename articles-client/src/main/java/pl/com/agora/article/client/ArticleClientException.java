package pl.com.agora.article.client;

import pl.com.agora.api.client.rest.UriInvocationException;

public class ArticleClientException extends UriInvocationException {

    public ArticleClientException(String uri, String message, Object result, int responseStatus) {
        super(uri, message, result, responseStatus);
    }

    public ArticleClientException(String uri, String message, Throwable cause, Object result, Integer responseStatus) {
        super(uri, message, cause, result, responseStatus);
    }

    public ArticleClientException(String uri, String message) {
        super(uri, message);
    }

    public ArticleClientException(String uri, Throwable cause) {
        super(uri, cause);
    }

    @Override
    public ArticleError getResult() {
        return (ArticleError) super.getResult();
    }
}
