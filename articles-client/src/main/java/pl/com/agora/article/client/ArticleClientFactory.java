package pl.com.agora.article.client;

import pl.com.agora.api.client.rest.RestfulClientProxyBuilder;
import pl.com.agora.api.client.rest.RestfulClientProxyFactory.ProxyConfiguration;

public class ArticleClientFactory {

    public ArticleClient createSimpleArticleClient(String host, int port) throws Exception {
        return new RestfulClientProxyBuilder().withHost(host).withPort(port).withErrorClass(ArticleError.class).build(ArticleClient.class);
    }
    
    public ArticleClient createCustomArticleClient(String host, int port, ProxyConfiguration config) throws Exception {
        return new RestfulClientProxyBuilder().withHost(host).withPort(port).withConfig(config).withErrorClass(ArticleError.class).build(ArticleClient.class);
    }
}
