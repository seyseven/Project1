package ru.sbrf.itc;

import ru.sbrf.itc.service.BookService;

import java.util.Scanner;

public class Startup {
    public static void main(String[] args) {
        BookService bookService = new BookService();
        Scanner scan = new Scanner(System.in);

        System.out.println("Book Service Shell");
        bookService.ShowMenu();

        while(true) {
            System.out.print(">");
            int num = scan.nextInt();

            switch (num) {
                case 3: bookService.showBook();break;
                case 4: bookService.showAuthor();break;
                case 5: bookService.addAuthor();break;
                case 6: bookService.addBook();break;
                case 7: bookService.removeBook(scan.nextInt());break;
                case 8: {System.out.print("id -> "); bookService.removeAuthor(scan.nextInt());break;}
                case 9: bookService.updateAuthor();break;
                case 10:bookService.updateBook();break;
                case 11:System.exit(0);
            }
        }
    }
}
