package pl.com.agora.article.dto;

public class ArticleErrorResponse {

    private String articleId;
    private String message;

    public ArticleErrorResponse() {
    }
    
    public ArticleErrorResponse(String articleId, String message) {
        super();
        this.articleId = articleId;
        this.message = message;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
