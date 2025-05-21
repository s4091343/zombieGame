package gameobjects;

public class ThingHolder extends Thing implements java.io.Serializable{

private ThingList things = new ThingList();

public ThingHolder(String aName, String aDescription, ThingList tl){
super(aName, aDescription)
things = tl
}
}
