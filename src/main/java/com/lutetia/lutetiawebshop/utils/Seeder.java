package com.lutetia.lutetiawebshop.utils;

import com.lutetia.lutetiawebshop.dao.*;
import com.lutetia.lutetiawebshop.models.*;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Seeder {
    private ProductRepository productRepository;
    private ArtistRepository artistRepository;
    private GenreRepository genreRepository;
    private CategoryRepository categoryRepository;
    private UserRepository userRepository;
    private AddressRepository addressRepository;

    public Seeder(ProductRepository productRepository, ArtistRepository artistRepository, GenreRepository genreRepository, CategoryRepository categoryRepository, UserRepository userRepository, AddressRepository addressRepository) {
        this.productRepository = productRepository;
        this.artistRepository = artistRepository;
        this.genreRepository = genreRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        this.seedProducts();
        this.seedUser();
    }

    public void seedProducts() {
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

    private void seedUser() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        Address address = new Address("Zernikedreef", "11", "2333CK", "Leiden", "Zuid-Holland");
        this.addressRepository.save(address);

        CustomUser testUser = new CustomUser("Jim", "Wiggers", "jim@mail.com", passwordEncoder.encode("Test123!"));
        testUser.setAddress(address);


        CustomUser customUser = new CustomUser("test@mail.com", passwordEncoder.encode("Test123!"));
        userRepository.save(customUser);
        userRepository.save(testUser);
    }
}
