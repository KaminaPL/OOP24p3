package music;

import java.util.ArrayList;

public class Playlist extends ArrayList<Song> {

    public Song atSecond(int seconds) {
            int tmp = seconds;
            int i = 0;
            int max =0;

            for(int k=0;k< size();k++) {
                max += get(k).seconds();
            }

            try{
                if(tmp < 0){
                throw new IndexOutOfBoundsException("Provided time is negative");
                }else if(tmp > max){
                throw new IndexOutOfBoundsException("Provided time is greater than playlist time");
                }
                while (get(i).seconds() < tmp) {
                    tmp -= get(i).seconds();
                    i++;
                }
            }catch (IndexOutOfBoundsException e){
                System.err.println(e.getMessage());
                System.exit(1);
            }


      return get(i);
    }


}
