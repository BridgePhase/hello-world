package com.bridgephase.helloworld.domain;

public class Message {

    private String text;
    private String version;

    public Message(String text, String version) {
        this.text = text;
        this.version = version;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return this.text + "version=" + this.version;
    }
}
