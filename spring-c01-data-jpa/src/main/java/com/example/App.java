package com.example;

import com.example.entities.Book;
import com.example.entities.Employee;
import com.example.repositories.BookRepository;
import com.example.repositories.EmployeeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class App {

     public static void main(String[] args) {
        System.out.println("==============INICIALIZAR SPRING ==============");
        ApplicationContext spring = SpringApplication.run(App.class,args);

        // EJEMPLO CRUDO DE BOOKS

        // Crear objeto BookRepository (lo crea Spring)

        BookRepository bookRepository = spring.getBean(BookRepository.class);


        // Crear y guardar un libro en base de datos
        System.out.println("==================== SAVE BOOK ====================");
        Book book1 = new Book(null, "book1", 9.99, 150);
        Book book2 = new Book(null, "book2", 25.99, 366);
        Book book3 = new Book(null, "book3", 49.99, 450);
        bookRepository.save(book1); // 1 Guardar cada articulo
        bookRepository.save(book2); // 2
        bookRepository.save(book3); // 3


        // Recuperar libros de base de datos
        System.out.println("==================== FIND ALL BOOKS ====================");
        List<Book> books = bookRepository.findAll();
        System.out.println(books);


        System.out.println("==================== UPDATE BOOK ====================");
        // para actualizar hay que pasar un objeto libro con 1 id que ya exista
        book1.setPrice(15.47);
        bookRepository.save(book1);

        book2.setNumPages(421);
        bookRepository.save(book2);



        // Borrar un libro por su id
        System.out.println("==================== DELETE BY ID BOOK ====================");
        bookRepository.deleteById(2L);

        // comprobar que se ha borrado verificando que no aparece al recuperarlos de nuevo
        books = bookRepository.findAll();
        System.out.println(books);



        System.out.println("==================== FIND BY ID BOOK ====================");
        // Buscar libro por id:

//		Book book = bookRepository.findById(1L);
//		if(book != null)
//			System.out.println(book.getTitle());
        // Optional: permite evitar tener que trabajar con null directamente
        // Optional: indica que un valor puede estar o puede no estar
        Optional<Book> bookOptional = bookRepository.findById(1L);

        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            System.out.println(book.getTitle());

        } else {
            System.out.println("No existe el libro");
        }





        // CRUD EMPLOYEES

        EmployeeRepository employeeRepo = spring.getBean(EmployeeRepository.class);
        System.out.println("==================== SAVE EMPLOYEES ====================");

        Employee emp1 = new Employee(null, "employee1", "1111A");
        Employee emp2 = new Employee(null, "employee2", "2222A");
        employeeRepo.save(emp1);
        employeeRepo.save(emp2);

        System.out.println("==================== FIND ALL EMPLOYEES ====================");
        List<Employee> employees = employeeRepo.findAll();
        System.out.println(employees);

        System.out.println("==================== DELETE BY ID EMPLOYEE ====================");
        employeeRepo.deleteById(1L);
        System.out.println(employeeRepo.findAll());


    }

}




