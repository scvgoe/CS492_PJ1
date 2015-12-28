package com.example.daesungkim.cs492_pj1;

/**
 * Created by daeseongkim on 2015. 12. 28..
 */
public class ImageObject {
    private Integer id;
    private String title;

    public ImageObject (Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
