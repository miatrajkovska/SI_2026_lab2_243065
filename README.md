# Втора лабораториска вежба по Софтверско инженерство
Миа Трајковска 243065

Control Flow Graph

searchBookByTitle

<img width="411" height="991" alt="searchbookbytitle drawio" src="https://github.com/user-attachments/assets/abb2ce85-f915-44fb-9fcf-312857c7c433" />

borrowBook

<img width="531" height="811" alt="borrowbook drawio" src="https://github.com/user-attachments/assets/f1e7d515-02a5-42c0-af32-782531e90319" />

Цикломатска комплексност

Цикломатска комплексност кај searchBookByTitle е 5. Ја добив со формулата CC = P + 1 каде P = број на предикатни јазли. 1. if title is empty, 2.for book in books, has more?, 3. if title checks && not borrowed, 4. if results is empty, P=4 CC=4+1=5

Цикломатска комплексност кај borrowBook е исто така 5. Ја добив со формулата CC = P + 1 каде P = број на предикатни јазли. 1. if title || author isEmpty, 2.for book in books, has more?, 3. if title and author checks, 4. if book is not borrowed, P=4 CC=4+1=5


Го земаме методот searchBookByTitle по линии
1  if (title.isEmpty()){                                     
2      throw new IllegalArgumentException("Invalid title"); 
   }
3  List<Book> results = new ArrayList<Book>();               
4  for (Book book : books) {                                 
5      if (book.getTitle().equalsIgnoreCase(title) 
           && !book.isBorrowed()) {                         
6           results.add(book);                                
       }
   }
7  if (results.isEmpty()) {                                  
8     return null;                                          
  }
9 return results;

Тест случаи според критериумот Every statement. Мора да имаме барем 3 тест примери за да ги покриеме сите statements.

<img width="677" height="286" alt="image" src="https://github.com/user-attachments/assets/65383802-2317-4db9-ab69-0deaebfee5c7" />


Го земаме методот borrowBook по линии
1  if (title.isEmpty() || author.isEmpty()){
2      throw new IllegalArgumentException("Invalid search query");
   }
3  for (Book book : books) {
4      if (book.getTitle().equalsIgnoreCase(title) && book.getAuthor().equalsIgnoreCase(author)) {
5          if (!book.isBorrowed()) {
6              book.setBorrowed(true);
7              System.out.println("Borrowed successfully");
8          } else {
9              throw new RuntimeException("Book is already borrowed.");
           }
10         return;
       }
   }
11 throw new RuntimeException("Book not found");
}

Тест случаи според критериумот Every branch. Мора да имаме барем 4 тест примери за да ги покриеме сите branches.

<img width="815" height="330" alt="image" src="https://github.com/user-attachments/assets/8ed9a810-9e87-45df-934c-70dadc28a135" />
