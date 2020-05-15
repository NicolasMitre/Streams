package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

    public static void main( String[] args )
    {
        List<String> listString = new ArrayList();
        listString.add("aaa221");
        listString.add("aaa12");
        listString.add("aaa23");
        listString.add("aaa4");

        System.out.println(removeEvenLength(listString));

        System.out.println(countCharacters("YASDhady8h78ad287ghi21d  1 2 2178  e12 78"));

        System.out.println(caesarCipher("abcdefg"));

        System.out.println(reorderWords("hola como estas"));
    }

    public static List<String> removeEvenLength(List<String> strings){
        return strings.stream()
                .filter(string -> string.length() % 2 != 0)
                .collect(Collectors.toList());
    }

    public static String countCharacters(String string){

        AtomicInteger letters = new AtomicInteger(0);
        AtomicInteger digits = new AtomicInteger(0);
        AtomicInteger spaces = new AtomicInteger(0);

        string.chars()
                .mapToObj(chr -> String.valueOf((char) chr))
                .filter(chr -> chr.matches("[A-Za-zÀ-ÖØ-öø-ÿ]"))
                .forEach(chr -> letters.getAndIncrement());

        string.chars()
                .mapToObj(chr -> String.valueOf((char) chr))
                .filter(chr -> chr.matches("[0-9]"))
                .forEach(chr -> digits.getAndIncrement());

        string.chars()
                .mapToObj(chr -> String.valueOf((char) chr))
                .filter(chr -> chr.matches(("[' ']")))
                .forEach(chr -> spaces.getAndIncrement());

        return "Digits: "+ digits + ", letters: " + letters + ", spaces: " + spaces;
    }

    public static String caesarCipher(String string){
        StringBuilder characters = new StringBuilder("");

        string.chars()
                .forEach(chr ->
                {
                    if(chr == 122)
                        characters.append((char)97);
                    if(chr != 122)
                        characters.append((char)(chr+1));
                });

        return characters.toString();
    }
    public static String reorderWords(String string){
        StringBuilder stringBuilder = new StringBuilder(string);
        string = (stringBuilder.reverse()).toString();

        return Stream.of(string.split(" "))
                .map(word -> new StringBuilder(word).reverse().append(" "))
                .collect(Collectors.joining());
    }
}