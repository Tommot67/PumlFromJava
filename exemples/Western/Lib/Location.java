package Lib;

public class Location {
    private float longitude;
    private float latitude;
    private String type_terrain;
    public Location(float longitude , float latitude){
        this.longitude = longitude;
        this.latitude = latitude;
    }
    public Location(float longitude , float latitude , String type_terrain){
        this.longitude = longitude;
        this.latitude = latitude;
        this.type_terrain = type_terrain;
    }
}
