package com.example.bloggingapplication.guest;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArticleRepository {
    private final ObjectMapper mapper = new ObjectMapper();
    private final String directoryPath="articles";
    private final List<Article> articles= new ArrayList<>();

    public ArticleRepository() {
        LoadArticles();
    }

    void LoadArticles() {
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
}
