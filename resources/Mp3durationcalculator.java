import java.io.File;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;

public class MP3DurationCalculator {
    public static void main(String[] args) {
        // Example usage
        String[] mp3Files = { "file1.mp3", "file2.mp3", "file3.mp3" };
        calculateDurations(mp3Files);
    }

    public static void calculateDurations(String[] mp3Files) {
        for (String mp3File : mp3Files) {
            File file = new File(mp3File);
            try {
                AudioFileFormat fileFormat = AudioSystem.getAudioFileFormat(file);
                long duration = (long) fileFormat.properties().get("duration");
                long seconds = duration / 1000000; // Convert to seconds
                System.out.println("Duration of " + mp3File + ": " + seconds + " seconds");
            } catch (Exception e) {
                System.out.println("Error calculating duration of " + mp3File + ": " + e.getMessage());
            }
        }
    }
}
