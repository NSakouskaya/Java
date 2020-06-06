import java.util.Arrays;

 class ClassesBook {

    public static void main(String[] args) {

        Book[] books = new Book[6];
        books[0] = new Book(1, "The Odyssey", "Homer", "HarperCollins Publishers", 2001, 345, "case");
        books[1] = new Book(2, "Hamlet", "William Shakespeare", "Holiday House", 2015, 332, "case");
        books[2] = new Book(3, "Pride and Prejudice", "Jane Austen", "Holiday House", 2013, 456, "case");
        books[3] = new Book(4, "The Iliad", "Homer", "Hyperion Publishing", 2000, 336, "case");
        books[4] = new Book(5, "Great Expectations", "Charles Dickens", "Crown Publishing Group", 1999, 234, "soft cover");
        books[5] = new Book(6, "David Copperfield", "Charles Dickens", "Holiday House", 2001, 120, "soft cover");

        for (Book book : books)  {
            System.out.println(book);
        }
        System.out.println(Arrays.toString(books));
        System.out.println();


        //List of books by Homer - поиск книг по автору
        System.out.println("List of books by Homer: ");
        for (int i = 0; i < books.length; i++)
            if (books[i].getAuthor() == "Homer")
                System.out.println(books[i].getTitle());
        System.out.println();

        //List of books that were published by "Holiday House" Publishing office - поиск книг по издательству
        System.out.println("List of books where Publishing office is Holiday House: ");
        for (int i = 0; i < books.length; i++)
            if (books[i].getPublishingOffice() == "Holiday House")
                System.out.println(books[i].getTitle());
        System.out.println();

        //List of books that were published after 2000 year
        System.out.println("List of books that were published after 2000 year: ");
        for (int i = 0; i < books.length; i++)
            if (books[i].getYear() > 2000)
                System.out.println(books[i].getTitle());


    }
}

