package io.github.oleiva.entity;

//import io.github.oleiva.entity.Genre;

import java.util.HashSet;
import java.util.Set;
//import com.google.common.base.Objects;
//import edu.com.softserveinc.bawl.models.enums.IssueStatus;
import org.apache.log4j.Logger;

//@Entity
//@Table(name="Genre")
public class Genre implements java.io.Serializable{
    public static final Logger LOG = Logger.getLogger(Genre.class);

//
//    @Id
//    @GeneratedValue
//    @Column(unique=true, name="ID")
    private Long id;

//    @NotNull
    private String name;

//    @NotNull
//    @OneToMany
//    @JoinColumn(name = "books")

    private Set <Book> books = new HashSet(0);

    public Genre() {
    }

    public Genre(String name) {
        this.name = name;
    }

    public Genre(String name, Set books) {
        this.name = name;
        this.books = books;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set getBooks() {
        return this.books;
    }

    public void setBooks(Set books) {
        this.books = books;
    }





}


