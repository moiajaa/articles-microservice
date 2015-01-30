package pl.com.agora.article.controller;

public class ArticleNotFoundException extends RuntimeException {

    private String articleId;
    
    public String getArticleId() {
        return articleId;
    }

    public ArticleNotFoundException() {
        super();
    }

    public ArticleNotFoundException(String articleId, String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.articleId = articleId;
    }

    public ArticleNotFoundException(String articleId, String message, Throwable cause) {
        super(message, cause);
        this.articleId = articleId;
    }

    public ArticleNotFoundException(String articleId, String message) {
        super(message);
        this.articleId = articleId;
    }

    public ArticleNotFoundException(String articleId, Throwable cause) {
        super(cause);
        this.articleId = articleId;
    }

    public ArticleNotFoundException(String articleId) {
        super();
        this.articleId = articleId;
    }
}
