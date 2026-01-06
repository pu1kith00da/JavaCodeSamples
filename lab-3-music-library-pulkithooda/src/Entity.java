//Pulkit Hooda
import java.util.Date;

public class Entity {
    protected String name;
    protected static int entityCounter=0;
    protected int entityID;
    protected Date dateCreated;

    public Entity()
    {
        this.name = "";
        entityCounter++;
        this.entityID=entityCounter;
        dateCreated=new Date();
    }


    public Entity(String name)
    {
        this.name = name;
        entityCounter++;
        this.entityID=entityCounter;
        dateCreated=new Date();
    }

    public int getEntityID()
    {
        return entityID;
    }

    public void setEntityID(int entityID)
    {
        this.entityID = entityID;
    }

    public Date getDateCreated()
    {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated)
    {
        this.dateCreated = dateCreated;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public boolean equals(Entity other)
    {
        return this.entityID==other.entityID;
    }

    public  String toString()
    {
         return "Name: "+this.name+" ID: "+this.entityID;
    }
    public String toHTML()
    {
        return "<b>"+this.name+"</b><i>"+this.entityID+"</i>";
    }
    public String toXML()
    {
        return "<entity><name>"+this.name+"</name><id>"+this.entityID+"</id></entity> ";
    }
}
