package com.verity.datlashiv.adminpanel;

public class Model {
    String id;
    String cat;
    String sub_cat;
    String topic;

    public Model(String id,String cat, String sub_cat, String topic) {
        this.id = id;
        this.cat = cat;
        this.sub_cat = sub_cat;
        this.topic = topic;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getSub_cat() {
        return sub_cat;
    }

    public void setSub_cat(String sub_cat) {
        this.sub_cat = sub_cat;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
