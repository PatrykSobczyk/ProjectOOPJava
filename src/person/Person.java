package person;

import javafx.scene.image.ImageView;

import java.io.Serializable;

/**
 * Created by Patryk Sobczyk on 17/11/2016.\
 * Implementacja klasy osoba
 */
public abstract class Person implements Serializable {
    private String mNames[] = {"Anna", "Zofia", "Dariusz", "Zygmunt", "Jan", "Anna", "Maria", "Dominika", "Mariusz", "Krzysztof", "Krystian"};
    private String mSurnames[] = {"Bak", "Brzez", "Sobkowiak", "Lewansdowski", "Gryzon", "Lech", "Czech", "Rus", "Chlebozjadacz", "Podolski"};
    private String mName;
    private String mSurname;
    private ImageView mPicture;

    /**
     * Konstruktor osoby
     *
     * @param name
     * @param surname
     */
    public Person(String name, String surname) {
        mName = name;
        mSurname = surname;
    }

    /**
     * Konstruktor losowy osoby
     */
    public Person() {
        this.mName = mNames[(int) (Math.random() * (mNames.length - 1))];
        this.mSurname = mSurnames[(int) (Math.random() * (mSurnames.length - 1))];
    }

    /**
     * Zwraca imie
     * @return imie
     */
    public String getName() {
        return mName;
    }

    /**
     * Ustawia imie
     * @param name
     */
    public void setName(String name) {
        mName = name;
    }

    /**
     * Zwraca nazwisko
     * @return nazwisko
     */
    public String getSurname() {
        return mSurname;
    }

    /**
     * Ustawia nazwisko
     * @param surname
     */
    public void setSurname(String surname) {
        mSurname = surname;
    }

    /**
     * Zwraca obrazek osoby
     * @return obrazek osoby
     */
    public ImageView getPicture() {
        return mPicture;
    }

    /**
     * Ustawia obrazek osoby
     * @param picture
     */
    public void setPicture(ImageView picture) {
        mPicture = picture;
    }

    @Override
    public String toString() {
        return "My name - " + getName() +
                ", my surname - " + getSurname();
    }
}
