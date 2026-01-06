//Pulkit Hooda
public class EntityTest
{
    public static void main(String[] args)
    {
        Entity e1=new Entity();
        Entity e2=new Entity();
        System.out.printf("%d %d",e1.getEntityID(),e2.getEntityID());
        Entity e3=new Entity("The Beatles");
        System.out.printf("\n%d\n",e3.getEntityID());
        System.out.printf("Date created %s\n",e3.getDateCreated());
        if(e1.equals(e1))
        {
            System.out.println("equals works");
        }
        if(e1.equals(e2))
        {
            System.out.println("equals doesn't work");
        }
        System.out.println(e3.toString());
        System.out.println(e3.toHTML());
        System.out.println(e3.toXML());
    }
}