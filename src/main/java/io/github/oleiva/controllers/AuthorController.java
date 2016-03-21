package io.github.oleiva.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.model.SelectItem;

import io.github.oleiva.configs.DataHelper;
import io.github.oleiva.beans.Pager;
import io.github.oleiva.comparators.ListComparator;
import io.github.oleiva.entity.Author;

@ManagedBean
@SessionScoped
public class AuthorController implements Serializable, Converter {

    private List<SelectItem> selectItems = new ArrayList<SelectItem>();
    private Map<Long, Author> map;
    private List<Author> list;
//    private final BookListController bookListController;
    private Pager pager;
    private DataHelper dataHelper;
    @ManagedProperty(value = "#{bookListController}")
    private BookListController bookListController;

    @PostConstruct
    public void init() {
        pager = bookListController.getPager();
        dataHelper = bookListController.getDataHelper();

        map = new HashMap<Long, Author>();
        list = dataHelper.getAllAuthors();
        Collections.sort(list, ListComparator.getInstance());        
        
        list.add(0, createEmptyAuthor());

        for (Author author : list) {
            map.put(author.getId(), author);
            selectItems.add(new SelectItem(author, author.getFio()));
        }
    }

  
    public List<Author> getAuthorList() {
        return list;
    }

    public List<SelectItem> getSelectItems() {
        return selectItems;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return map.get(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return ((Author) value).getId().toString();
    }

    public BookListController getBookListController() {
        return bookListController;
    }

    public void setBookListController(BookListController bookListController) {
        this.bookListController = bookListController;
    }

    private Author createEmptyAuthor() {
        Author author = new Author();
        author.setId(-1L);
        author.setFio("");
        return author;
    }
}
