package com.example.hp.htask;

class CourceInfo {

    String imagelink, name, desc, pack;

    public CourceInfo(String imagelink, String name, String desc, String pack) {
        this.imagelink = imagelink;
        this.name = name;
        this.desc = desc;
        this.pack = pack;
    }

    public String getImagelink() {
        return imagelink;
    }

    public void setImagelink(String imagelink) {
        this.imagelink = imagelink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPack() {
        return pack;
    }

    public void setPack(String pack) {
        this.pack = pack;
    }
}
