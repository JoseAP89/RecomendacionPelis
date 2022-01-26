package com.back.Models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Box {

    private Long id;
    private String name;
    private String title;

    public Box() {
    }

    public String getTitle() {
        return title;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Dupla [id=" + id + ", name=" + name + ", title=" + title + "]";
    }

    @Override
    public int hashCode() {
        return 17*id.hashCode() + 31;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Box) {
            Box box = (Box) obj;
            return (id == box.id && name == box.name ) || (id == box.id && title == box.title );
        } else {
            return false;    
        }
    }

}
