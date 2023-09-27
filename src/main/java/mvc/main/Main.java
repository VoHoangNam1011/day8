package mvc.main;

import mvc.configuration.JPAConfig;
import mvc.entity.BookDetailsEntity;
import mvc.entity.BookEntity;
import mvc.entity.CategoryEntity;
import mvc.repository.BookRepository;
import mvc.repository.CategoryRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import java.time.LocalDate;
import java.util.List;

public class Main {
    static ApplicationContext context = new AnnotationConfigApplicationContext(JPAConfig.class);
    static BookRepository bookRepository = (BookRepository) context.getBean("bookRepository", BookRepository.class);
    static CategoryRepository categoryRepository = (CategoryRepository) context.getBean("categoryRepository", CategoryRepository.class);

    public static void main(String[] args) {
        createNewBookEntryWithNewCategory();
        createNewBookEntry();
        //findByAuthor("Roger");
        //findByNameAndAuthor("linux","Roger");
        //findByNameOrAuthor("linux","Roger");
        //findByPriceLessThan(80);
        //findBybookDetailsIsbn("ISIBF1219321");
        //findByNameContaining("Nu");
    }
    public static void findByAuthor(String author) {
        List<BookEntity> bookEntityList = bookRepository.findByAuthor(author);
        if (bookEntityList != null) {
            System.out.println("\nFound" + bookEntityList.size() + " books which author = " + author);
            for(BookEntity bookEntity: bookEntityList) {
                System.out.println(bookEntity.toString());
            }
        }
    }
    public static void findByNameAndAuthor(String name, String author) {
        List<BookEntity> bookEntityList = bookRepository.findByNameAndAuthor(name, author);
        if (bookEntityList != null) {
            System.out.println("\nFound" + bookEntityList.size() + " books which name = " + name + " and author = " + author);
            for(BookEntity bookEntity: bookEntityList) {
                System.out.println(bookEntity.toString());
            }
        }
    }
    public static void findByNameOrAuthor(String name, String author) {
        List<BookEntity> bookEntityList = bookRepository.findByNameOrAuthor(name, author);
        if (bookEntityList != null) {
            System.out.println("\nFound" + bookEntityList.size() + " books which name = " + name + " or author = " + author);
            for(BookEntity bookEntity: bookEntityList) {
                System.out.println(bookEntity.toString());
            }
        }
    }
    public static void findByPriceLessThan(int price) {
        List<BookEntity> bookEntityList = bookRepository.findByBookDetailsPriceLessThan(price);
        if (bookEntityList != null) {
            System.out.println("\nFound" + bookEntityList.size() + " books which price is less than = " + price);
            for (BookEntity bookEntity : bookEntityList) {
                System.out.println(bookEntity.toString());
            }
        }
    }
    public static void findByNameContaining(String name) {
        List<BookEntity> bookEntityList = bookRepository.findByNameContaining(name);
        if (bookEntityList != null) {
            System.out.println("\nFound" + bookEntityList.size() + " books containing name = " + name);
            for (BookEntity bookEntity : bookEntityList) {
                System.out.println(bookEntity.toString());
            }
        }
    }
    public static void findAllUsingQuery() {
        List<BookEntity> bookEntityList = (List<BookEntity>) bookRepository.findAll();
        if (bookEntityList != null) {
            System.out.println("\nFound" + bookEntityList.size() + " books");
            for (BookEntity bookEntity : bookEntityList) {
                System.out.println(bookEntity.toString());
            }
        }
    }
    public static void findBybookDetailsIsbn(String isbn) {
        BookEntity bookEntity = bookRepository.findBybookDetailsIsbn(isbn);
        if (bookEntity != null) {
            System.out.println("\nFound book which isbn = " + isbn);
            System.out.println(bookEntity.toString());
        }
    }
    public static void createNewBookEntry() {
        // Instance object Category with ID = 1
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(1);

        BookEntity bookEntity = createNewBook();
        // set book category
        bookEntity.setCategory(categoryEntity);
        bookRepository.save(bookEntity);
    }
    public static void createNewBookEntryWithNewCategory() {
        CategoryEntity categoryEntity = createNewCategory();
        categoryRepository.save(categoryEntity);

        BookEntity bookEntity = createNewBook();
        bookEntity.setCategory(categoryEntity);
        bookRepository.save(bookEntity);
    }
    private static CategoryEntity createNewCategory(){
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName("IT");
        categoryEntity.setDescription("IT books");
        return categoryEntity;
    }
    private static BookEntity createNewBook(){
        BookDetailsEntity bookDetailsEntity = new BookDetailsEntity();
        bookDetailsEntity.setIsbn("ISIBF1219323");
        bookDetailsEntity.setNumberOfPage(23);
        bookDetailsEntity.setPrice(65);
        bookDetailsEntity.setPublishDate(LocalDate.now());

        BookEntity bookEntity = new BookEntity();
        bookEntity.setName("Java A-Z");
        bookEntity.setAuthor("Roger");
        bookEntity.setBookDetails(bookDetailsEntity);
        bookDetailsEntity.setBook(bookEntity);
        return bookEntity;

    }

}