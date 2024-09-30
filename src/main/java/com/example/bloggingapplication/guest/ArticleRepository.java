package com.example.bloggingapplication.guest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ArticleRepository {
    private final ObjectMapper mapper = new ObjectMapper();
    private final String directoryPath="articles";
    private final List<Article> articles= new ArrayList<>();

    public ArticleRepository() {
        LoadArticles();
    }
    public List<Article> GetAllArticles() {
        return articles;
    }
    public Article GetArticleByTitle(String title) {
        for(Article article: articles) {
            if(article.getTitle().equals(title)) {
                return article;
            }
        }
        System.out.println("Aticle does not exist");
        return null;
    }

    void LoadArticles() {
        articles.clear();
        File folder=new File(directoryPath);
        File[] files=folder.listFiles((dir, name)
                -> name.endsWith(".json"));

        if(files!=null) {
            for(File file:files) {
                try{
                    Article article= mapper.readValue(file, Article.class);
                    articles.add(article);
                }
                catch(IOException e){
                        e.printStackTrace();
                }
            }
        }
    }

    // it will create as well as update files
    public  void AddArticle(Article article)
    throws IOException{
        String fileName=article.getTitle().replace(" ","_")
                +".json";
        File file=new File(directoryPath+File.separator+fileName);
        if(file.exists()) {
            System.out.println("File already exists");
            return;
        }
        mapper.writeValue(file, article);
        articles.add(article);
    }

    public void UpdateArticle(Article article) throws IOException {
        String fileName=article.getTitle().replace(" ","_")
                +".json";
        File file=new File(directoryPath+File.separator+fileName);
        mapper.writeValue(file, article);

        for (int i = 0; i < articles.size(); i++) {
            if (articles.get(i).getTitle().
                    equals(article.getTitle())) {
                articles.set(i, article); // Update the existing article
                break;
            }
        }
    }
    public void DeleteArticle(String title) throws IOException {

            String fileName = title.replace(" ", "_") + ".json";
            File file = new File(directoryPath + File.separator + fileName);

            if (file.exists()) {
                if (file.delete()) {
                    for (int i = 0; i < articles.size(); i++) {
                        if (articles.get(i).getTitle().equals(title)) {
                            articles.remove(i);
                            break;
                        }
                    }
                    System.out.println("Article and file deleted successfully.");
                } else {
                    System.out.println("Failed to delete the file.");
                }
            } else {
                System.out.println("File does not exist.");
            }
        }

}
