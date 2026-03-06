package com.example.menuapp;

import java.util.ArrayList;

public class Language {
    private static ArrayList<Language> languageArrayList;

    private int id;
    private String name;

    public Language(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void initLanguages(){
        languageArrayList = new ArrayList<>();

        Language english = new Language(0, "English");
        languageArrayList.add(english);

        Language french = new Language(0, "French");
        languageArrayList.add(french);

        Language japanese = new Language(0, "Japanese");
        languageArrayList.add(japanese);

        Language russian = new Language(0, "Russian");
        languageArrayList.add(russian);

        Language belarusan = new Language(0, "Belarusan");
        languageArrayList.add(belarusan);

        Language german = new Language(0, "German");
        languageArrayList.add(german);
    }

    public static ArrayList<Language> getLanguageArrayList(){
        return languageArrayList;
    }

    public static String[] languageNames(){
        String[] names = new String[languageArrayList.size()];
        for (int i = 0; i < languageArrayList.size(); i++) {
            names[i] = languageArrayList.get(i).name;
        }

        return names;
    }
}
