package ICAI.designPatterns.patternCreational.Prototype2;

import ICAI.entity.Songs;

import java.util.HashSet;
import java.util.Set;

public class MainCreational2 {
    public static void main( String[] args ) {
        Set<Songs> songsSet = new HashSet<>();
        songsSet.add(new Songs(20L,"On BS", 3.12));
        songsSet.add(new Songs(21L,"Need to Know", 3.13));
        songsSet.add(new Songs(22L,"Feels", 4.13));

        PlaylistDAO2 p2 = new PlaylistDAO2(6, "GRWM", songsSet);
        PlaylistDAO2 p3 =  p2.clone();
        System.out.println("Original: " + p2);
        System.out.println("Cloned: " +p3 );
    }

}
