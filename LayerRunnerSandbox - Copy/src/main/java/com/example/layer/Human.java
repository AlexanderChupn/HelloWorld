package com.example.layer;
import java.util.List;

//import com.codegraph.sdk.*;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Required;
import org.neo4j.ogm.annotation.Property;

@NodeEntity(label="HumanClass")
public class Human {

    public Human (String fn){
        this.fullName = fn;//

    }

    public Human (String fn, int i, int j) throws IllegalArgumentException{
        this.fullName = fn;//
        this._id=i;//new Long(i);//new Long(i);
        //this._idExtra=new Long(j);//new Long(i);
        //this._idExtra=_id+1000;
    }

    public Human (String fn, int i) throws IllegalArgumentException{
        this.fullName = fn;//
        this._id=i;//new Long(i);//new Long(i);
        this._idExtra=new Long(i+1000);
    }


    public Human (){
        //Long myId=this._id;
        System.out.println( "Human standard constructor");
    }

    
    //@Id //@GeneratedValue
    private Long _idExtra;

   @Id //@GeneratedValue
   private int _id;


   //private int _idExtra;

   @Required
   @Property(name="fullName") 
   private String fullName;

   public String toString(){
    return getClass().getName() + " _id:"+_id +"; fullName:"+fullName;
   }
}
