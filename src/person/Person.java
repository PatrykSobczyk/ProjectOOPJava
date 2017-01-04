package person;

import javafx.scene.image.ImageView;

import java.io.Serializable;

/**
 * Created by Patryk Sobczyk on 17/11/2016.
 */
public abstract class Person implements Serializable {
    private String mNames[] = {"Anna", "Zofia", "Dariusz", "Zygmunt", "Jan", "Anna", "Maria", "Dominika", "Mariusz", "Krzysztof", "Krystian"};
    private String mSurnames[] = {"Bak", "Brzez", "Sobkowiak", "Lewansdowski", "Gryzon", "Lech", "Czech", "Rus", "Chlebozjadacz", "Podolski"};
    private String mName;
    private String mSurname;
    private ImageView mPicture;

    public Person(String name, String surname) {
        mName = name;
        mSurname = surname;
    }

    public Person() {
        this.mName = mNames[(int) (Math.random() * (mNames.length - 1))];
        this.mSurname = mSurnames[(int) (Math.random() * (mSurnames.length - 1))];
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getSurname() {
        return mSurname;
    }

    public void setSurname(String surname) {
        mSurname = surname;
    }

    public ImageView getPicture() {
        return mPicture;
    }

    public void setPicture(ImageView picture) {
        mPicture = picture;
    }

    @Override
    public String toString() {
        return "My name - " + getName() +
                ", my surname - " + getSurname();
    }
}
