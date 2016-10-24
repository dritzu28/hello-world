package model;

/**
 * Created by itzu.villarce on 23/10/16.
 */

public class Perro {

    String name;
    int id;

    public Perro(String name, int id ){
        this.name = name;
        this.id = id;

    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId(){
        return id;
    }


}
