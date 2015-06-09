package io.mindmine.databindingdemo;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import io.mindmine.databindingdemo.BR;

/**
 * Created by Trey Robinson on 6/6/15.
 * Copyright 2015 MindMine LLC.
 */
public class User extends BaseObservable{
    public String firstName;
    public String lastName;
    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Bindable
    public String getFirstName() {
        return firstName;
    }

    @Bindable
    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        notifyPropertyChanged(BR.firstName);
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        notifyPropertyChanged(io.mindmine.databindingdemo.BR.lastName);
    }
}