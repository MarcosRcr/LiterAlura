package com.marcos.LiterAlura.View;

import com.marcos.LiterAlura.Model.Author;
import com.marcos.LiterAlura.Model.Book;
import com.marcos.LiterAlura.Model.Data;
import com.marcos.LiterAlura.Model.DataBook;
import com.marcos.LiterAlura.Repository.IAuthorRepository;
import com.marcos.LiterAlura.Service.ApiUsage;
import com.marcos.LiterAlura.Service.DataConverter;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Application {
    private Scanner input = new Scanner(System.in);
    private ApiUsage apiUsage = new ApiUsage();
    private DataConverter converter = new DataConverter();
    private String URL = "https://gutendex.com/books/";
    private IAuthorRepository repository;

    public Application(IAuthorRepository repository) {
        this.repository = repository;
    }
    public void showMenu(){
        int option;
        var menu = """
                1 - Search book by title
                2 - List registered books
                3 - List registered authors
                4 - List living authors for a given year
                5 - List books by language
                6 - Generate statistics
                7 - Top 10 books
                8 - Search author by name
                9 - List authors with other queries
                0 - Exit
                Select an option by the number that appears in the menu:
                """;
        while (option !=0){
            System.out.println(menu);
            try {
                option = input.nextInt();
                switch (option){
                    case 1:
                        searchBookByTitle();
                        break;
                    case 2:
                        listRegisteredBooks();
                        break;
                    case 3:
                        listRegisteredAuthors();
                        break;
                    case 4:
                        listLiveAuthors();
                        break;
                    case 5:
                        listBooksByLanguage();
                        break;
                    case 6:
                        generateStatistics();
                        break;
                    case 7:
                        top10Books();
                        break;
                    case 8:
                        searchAuthorByName();
                        break;
                    case 9:
                        listAuthorsWithOtherQueries();
                        break;
                    case 0:
                        System.out.println("Thank you, see you soon");
                        break;
                    case default:
                        System.out.println("Please, enter a valid option");
                        break;
                }
            }catch (NumberFormatException e){
                System.out.println("Option not valid:"+e.getMessage());
            }
        }
    }
    public void searchBookByTitle(){
        System.out.println("Type in name of the book you wish to search for:");
        var title = input.nextLine();
        var json = apiUsage.getData(URL+"?search="+title+title.replace(" ","%20"));
        var data = converter.getData(json, Data.class);
        Optional<DataBook> bookSearched = data.books()
                                            .stream()
                                            .findFirst();
        if (bookSearched.isPresent()){
            System.out.println(
                    "\n*****Book*****"+
                            "\nTitle:"+bookSearched.get().title()+
                            "\nAuthors:"+bookSearched.get().authors().stream()
                            .map(a -> a.name()).limit(1).collect(Collectors.joining())+
                            "\nLanguage:"+bookSearched.get().languages().stream().collect(Collectors.joining())+
                            "\nDownloads:"+bookSearched.get().download()+
                            "\n---------Nice Book-------"
            );
        }
    }
}
