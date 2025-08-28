package pro.skypro.skyshop.model.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.skypro.skyshop.model.article.Article;
import pro.skypro.skyshop.model.product.Product;
import pro.skypro.skyshop.model.search.SearchResult;
import pro.skypro.skyshop.model.service.SearchService;
import pro.skypro.skyshop.model.service.StorageService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
public class ShopController {
    private final StorageService storageService;
    private final SearchService searchService;

    public ShopController(StorageService storageService, SearchService searchService) {
        this.storageService = storageService;
        this.searchService = searchService;
    }

    @GetMapping
    public String showGreeting() {
        return "Welcome to the SkyShop";
    }

    @GetMapping("/products")
    public Collection<Product> getAllProduct() {
        return new ArrayList<>(storageService.getAllProducts());
    }

    @GetMapping("/articles")
    public Collection<Article> getAllArticle() {
        return new ArrayList<>(storageService.getAllArticles());
    }

    @GetMapping("/search")
    public List<SearchResult> search(@RequestParam String pattern) {
        return searchService.search(pattern);
    }
}
