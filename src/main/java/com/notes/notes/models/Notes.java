package com.notes.notes.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Notes {
    @Id
    public ObjectId _id;
    public String title;
    public String note;

    public Notes(){}

    public Notes(ObjectId _id, String title, String note) {
        this._id = _id;
        this.title = title;
        this.note = note;
    }
    public String get_id(){
        return _id.toHexString();
    }
    public void set_id(ObjectId _id){
        this._id = _id;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getNote(){
        return note;
    }
    public void setNote(String note){
        this.note= note;
    }
}