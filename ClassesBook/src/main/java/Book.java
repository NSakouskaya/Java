//Создать классы, спецификации которых приведены ниже. Определить конструкторы и методы setТип(), getТип(), toString().
// Определить дополнительно методы в классе, создающем массив объектов. Задать критерий выбора данных и вывести эти данные
//  на консоль. В каждом классе, обладающем информацией, должно быть объявлено несколько конструкторов.
//
//  5.Book: id, Название, Автор (ы), Издательство, Год издания, Количество страниц, Цена, Тип переплета.
//
//Создать массив объектов. Вывести:
//
//a) список книг заданного автора;
//
//b)   список книг, выпущенных заданным издательством;
//
//c)   список книг, выпущенных после заданного года.
//

class Book {

    private int id;
    private String title;
    private String author;
    private String publishingOffice;
    private int year;
    private int numberOfPages;
    private String bindingType;


    public Book(){
    }

    public Book(int id, String title, String author, String publishingOffice, int year, int numberOfPages, String bindingType){
        this.id = id;
        this.title = title;
        this.author = author;
        this.publishingOffice = publishingOffice;
        this.year = year;
        this.numberOfPages = numberOfPages;
        this.bindingType = bindingType;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishingOffice() {
        return publishingOffice;
    }

    public void setPublishingOffice(String publishingOffice) {
        this.publishingOffice = publishingOffice;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getBindingType() {
        return bindingType;
    }

    public void setBindingType(String bindingType) {
        this.bindingType = bindingType;
    }


    @Override
    public String toString() {
        return this.id + " " + this.title + " " + this.author + " " + this.publishingOffice + " " + this.year + " " + this.numberOfPages + " " + this.bindingType;

    }

}