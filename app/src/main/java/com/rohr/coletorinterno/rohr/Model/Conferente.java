package com.rohr.coletorinterno.rohr.Model;

import android.app.Activity;
import android.widget.EditText;

import java.io.Serializable;

/**
 * Created by rafael.marques on 25/07/2016.
 */
public class Conferente implements Serializable {

    private Integer id;
    private String firstName;
    private String lastName;
    private String notes;
    private String title;
    private Integer cargo;


    private EditText EdtTitle;


    private Activity activity;

    public Conferente(int id, String firstname, String lastname, String notes, String title, int cargo) {
        this.id = id;
        this.firstName = firstname;
        this.lastName = lastname;
        this.notes = notes;
        this.title = title;
        this.cargo = cargo;
    }

    public Conferente(){

    }


    public Activity getActivity() {
        return activity;
    }

    public EditText getEdtTitle() {
        return EdtTitle;
    }

    public void setEdtTitle(EditText edtTitle) {
        EdtTitle = edtTitle;
    }

    public void setActivity(Activity activity) {

        this.activity = activity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String setFirstName(String firstName) {
        this.firstName = firstName;
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCargo() {
        return cargo;
    }

    public void setCargo(Integer cargo) {
        this.cargo = cargo;
    }
}
