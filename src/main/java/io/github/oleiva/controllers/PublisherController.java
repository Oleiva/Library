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

import io.github.oleiva.beans.Pager;
import io.github.oleiva.comparators.ListComparator;
import io.github.oleiva.configs.DataHelper;
import io.github.oleiva.entity.Publisher;

@ManagedBean
@SessionScoped
public class PublisherController implements Serializable, Converter {

    private List<SelectItem> selectItems = new ArrayList<SelectItem>();
    private Map<Long, Publisher> map;
    private List<Publisher> list;
    private Pager pager;
    private DataHelper dataHelper;
    @ManagedProperty(value = "#{bookListController}")
    private BookListController bookListController;

    @PostConstruct
    public void init() {
        pager = bookListController.getPager();
        dataHelper = bookListController.getDataHelper();

        map = new HashMap<Long, Publisher>();
        list = dataHelper.getAllPublishers();

        Collections.sort(list, ListComparator.getInstance());
        
        list.add(0,createEmptyPublisher());

        for (Publisher publisher : list) {
            map.put(publisher.getId(), publisher);
            selectItems.add(new SelectItem(publisher, publisher.getName()));
        }

    }

    public List<SelectItem> getSelectItems() {
        return selectItems;
    }

    public List<Publisher> getPublisherList() {
        return list;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return map.get(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return ((Publisher) value).getId().toString();
    }

    public BookListController getBookListController() {
        return bookListController;
    }

    public void setBookListController(BookListController bookListController) {
        this.bookListController = bookListController;
    }
    
     private Publisher createEmptyPublisher() {
        Publisher publisher = new Publisher();
        publisher.setId(-1L);
        publisher.setName("");
        return publisher;
    }
}
