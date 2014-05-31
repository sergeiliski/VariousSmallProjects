package com.vannevelj.designpatterns;

public class Proxy {

}

interface Image {
    void display();
}

class RealImage implements Image {
    private String filename;
    
    public RealImage(String filename){
        this.filename = filename;
        loadImage();
    }
    
    private void loadImage(){
        System.out.println("Loading..." + filename);
    }

    @Override
    public void display() {
        System.out.println("Displaying..." + filename);
    }    
}

class ProxyImage implements Image {
    private Image image;
    private String filename;
    
    public ProxyImage(String filename){
        this.filename = filename;
    }

    @Override
    public void display() {
        if(image == null){
            image = new RealImage(filename);
        }
        image.display();
    }    
}
