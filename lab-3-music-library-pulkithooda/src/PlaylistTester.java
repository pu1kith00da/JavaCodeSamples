//Pulkit Hooda
public class PlaylistTester
{
    public static void main(String[] args)
    {
        Playlist p=new Playlist();
        Song s1=new Song("Yellow Submarine");
        Song s2=new Song("Yesterday");
        p.addSong(s1);
        p.addSong(s2);
        p.deleteSong(s1);
        p.deleteSong(s1);

        int n=(97^37);
        int m=221;
        int answer=n%m;
        System.out.println(answer);
    }
}
