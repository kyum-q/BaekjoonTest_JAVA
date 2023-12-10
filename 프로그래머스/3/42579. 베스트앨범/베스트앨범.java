import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

class Solution {
    public static void main(String[] args) {
        new Solution().solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500});
    }
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> counts = new HashMap<>();

        int noOnlyOneCount = 0;
        for (int i = 0; i < genres.length; i++) {
            int count = 0;
            if(counts.containsKey(genres[i])) {
                count = counts.get(genres[i]);
            }
            counts.put(genres[i], count+plays[i]);
        }

        ArrayList<Song> songs = new ArrayList<>();
        for (int i = 0; i < genres.length; i++) {
            songs.add(new Song(i, plays[i], counts.get(genres[i])));
        }

        Collections.sort(songs);

        int[] answer = new int[songs.size()];
        int index = 0;
        int genresCount = 0;
        int songCount = 0;
        for (int i = 0; i < songs.size(); i++) {
            Song song = songs.get(i);
            if(genresCount != song.genresCount) {
                songCount = 0;
                genresCount = song.genresCount;
            }
            if(songCount >= 2) {
                continue;
            }
            answer[index] = song.index;
            songCount++;
            index++;
        }

        
        return Arrays.copyOfRange(answer, 0, index);
    }

    public static class Song implements Comparable<Song> {
        int index;
        int playCount;
        int genresCount;

        public Song(int index, int playCount, int genresCount) {
            this.index = index;
            this.playCount = playCount;
            this.genresCount = genresCount;
        }

        @Override
        public int compareTo(Song s) {
            if (genresCount == s.genresCount) {
                if (playCount == s.playCount)
                    return index - s.index;
                return s.playCount - playCount;
            }
            return s.genresCount - genresCount;
        }
    }
}