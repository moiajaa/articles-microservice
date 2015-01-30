package pl.com.agora.article;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan
public class ArticlesMicroservice 
{    
    public static void main( String[] args )
    {
        SpringApplication.run(ArticlesMicroservice.class, args);    
    }
}
