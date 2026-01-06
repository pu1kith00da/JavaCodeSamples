//Pulkit Hooda
public class SongTester
{
    public static void main(String[] args)
    {
        Song s1=new Song("Yesterday");
        Song s2=new Song("Love me do");
        System.out.printf("%d %d\n",s1.getEntityID(),s2.getEntityID());
        System.out.println(s1.getDateCreated());
        s1.setLength(533);
        System.out.println(s1.getInterval());
        Artist a1=new Artist("The Beatles");
        Artist a2=new Artist("The Beatles");
        Artist a3=new Artist("Lil Baby");
        if(a1.equals(a2))
        {
            System.out.println("equals works");
        }
        else
        {
            System.out.println("equals doesnt work");
        }
        if(a1.equals(a3))
        {
            System.out.println("equals doesnt work");
        }
        else
        {
            System.out.println("equals works");
        }

        Album album1=new Album("Rubber Soul");
        album1.setArtist(a1);
        Album album2=new Album("Rubber Soul");
        album2.setArtist(a1);
        if(album1.equals(album2))
        {
            System.out.println("equals works");
        }
        else
        {
            System.out.println("equals doesnt work");
        }
        album2.setArtist(a2);
        if(album1.equals(album2))
        {
            System.out.println("equals doesnt work");
        }
        else
        {
            System.out.println("equals works");
        }
        album2.setArtist(a1);
        album2.setName("White Album");
        if(album1.equals(album2))
        {
            System.out.println("equals not working");
        }
        else
        {
            System.out.println("equals works");
        }

        Song s3=new Song("Michelle");
        Song s4=new Song("Michelle");
        s3.setArtist(a1);
        s4.setArtist(a1);
        s3.setAlbum(album1);
        s4.setAlbum(album1);
        if(s3.equals(s4))
        {
            System.out.println("equals works");
        }
        else
        {
            System.out.println("equals doesnt");
        }
        s3.setArtist(a2);
        if(!s3.equals(s4))
        {
            System.out.println("equals works");
        }
        else
        {
            System.out.println("equals doesnt");
        }
        s3.setArtist(a1);
        s3.setAlbum(album2);
        if(!s3.equals(s4))
        {
            System.out.println("equals works");
        }
        else
        {
            System.out.println("equals doesnt");
        }
        Album album3=new Album("Harder than ever");
        album3.setArtist(a3);
        System.out.println(a3.toString());
        System.out.println(a3.toHTML());
        System.out.println(a3.toXML());
        System.out.println(album3.toString());
        System.out.println(album3.toHTML());
        System.out.println(album3.toXML());
        System.out.println(s3.toString());
        System.out.println(s3.toHTML());
        System.out.println(s3.toXML());
    }
}
