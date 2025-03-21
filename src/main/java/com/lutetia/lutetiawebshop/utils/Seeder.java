package com.lutetia.lutetiawebshop.utils;

import com.lutetia.lutetiawebshop.dao.ArtistRepository;
import com.lutetia.lutetiawebshop.dao.CategoryRepository;
import com.lutetia.lutetiawebshop.dao.GenreRepository;
import com.lutetia.lutetiawebshop.dao.ProductRepository;
import com.lutetia.lutetiawebshop.models.Artist;
import com.lutetia.lutetiawebshop.models.Category;
import com.lutetia.lutetiawebshop.models.Genre;
import com.lutetia.lutetiawebshop.models.Product;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Seeder {
    private ProductRepository productRepository;
    private ArtistRepository artistRepository;
    private GenreRepository genreRepository;
    private CategoryRepository categoryRepository;

    public Seeder(ProductRepository productRepository, ArtistRepository artistRepository, GenreRepository genreRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.artistRepository = artistRepository;
        this.genreRepository = genreRepository;
        this.categoryRepository = categoryRepository;
    }

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        Artist artist = new Artist("G-DRAGON");
        Genre genre = new Genre("K-POP");
        Category category = new Category("CD");
        this.artistRepository.save(artist);
        this.genreRepository.save(genre);
        this.categoryRepository.save(category);

        Product product1 = new Product("Ubermensch Blue", 29.99, "Description", 60, "25-02-2025", artist, genre, category);
        Product product2 = new Product("Kwon Ji Yong", 34.99, "Description", 14, "08-06-2017", artist, genre, category);
        Product product3 = new Product("One of a Kind", 42.99, 21, "15-09-2012", artist, genre, category);
        Product product4 = new Product("Ubermensch Red", 29.99, "Description", 64, "25-02-2025", artist, genre, category);
        Product product5 = new Product("Coup d'Etat", 36.99, "Description", 34, "02-09-2013", artist, genre, category);

        this.productRepository.save(product1);
        this.productRepository.save(product2);
        this.productRepository.save(product3);
        this.productRepository.save(product4);
        this.productRepository.save(product5);
    }
}
