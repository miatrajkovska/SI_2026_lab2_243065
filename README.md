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


