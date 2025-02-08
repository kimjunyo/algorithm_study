package com.ssafy.ws.step3;

import java.util.Arrays;

public class BookManager {

    private final int MAX_SIZE = 100;
    private Book[] books = new Book[MAX_SIZE];
    private int size = 0;

    public void add(Book book) {
        if (size <= MAX_SIZE) {
            books[size++] = book;
        }
    }

    public void remove(String isbn) {
        for (int i = 0; i < size; i++) {
            if (books[i].getIsbn().equals(isbn)) {
                for (int j = i; j < size - 1; j++) {
                    books[j] = books[j + 1];
                }
                size--;
                break;
            }
        }
    }

    public Book[] getList() {

        return Arrays.copyOf(books, size);
    }

    public Book[] getBooks() {
        int cnt = 0;
        for (int i = 0; i < size; i++) {
            if (!(books[i] instanceof Magazine)) {
                cnt++;
            }
        }

        Book[] result = new Book[cnt];

        int idx = 0;

        for (int i = 0; i < size; i++) {
            if (!(books[i] instanceof Magazine)) {
                result[idx++] = books[i];
            }
        }
        return result;
    }

    public Magazine[] getMagazines() {
        int cnt = 0;
        for (int i = 0; i < size; i++) {
            if (books[i] instanceof Magazine) {
                cnt++;
            }
        }

        Magazine[] result = new Magazine[cnt];

        int idx = 0;

        for (int i = 0; i < size; i++) {
            if (books[i] instanceof Magazine) {
                result[idx++] = (Magazine) books[i];
            }
        }
        return result;
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (int i = 0; i < size; i++) {
            totalPrice += books[i].getPrice();
        }
        return totalPrice;
    }

    public double getPriceAvg() {
        return getTotalPrice()*1.0/size;
    }

    public Book searchByIsbn(String isbn) {

        for (int i = 0; i < size; i++) {
            if (books[i].getIsbn().equals(isbn)) {
                return books[i];
            }
        }

        return null;
    }

    public Book[] searchByTitle(String title) {
        int cnt = 0;
        for (int i = 0; i < size; i++) {
            if (books[i].getTitle().contains(title)) {
                cnt++;
            }
        }

        Book[] result = new Book[cnt];

        int idx = 0;

        for (int i = 0; i < size; i++) {
            if (books[i].getTitle().contains(title)) {
                result[idx++] = books[i];
            }
        }
        return result;
    }

}
