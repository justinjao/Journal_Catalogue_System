package ui;

import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;
import java.io.File;

// based the sound implementation on this site:
// // http://suavesnippets.blogspot.com/2011/06/add-sound-on-jbutton-click-in-java.html
// a simple class to play a sound
public class SoundPlayer {

    public SoundPlayer() {
    }

    public void playSound() {
        File sound = new File("./src/main/ui/tada.wav");

        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(sound));
            clip.start();
        } catch (Exception e) {
            System.out.println("sound didn't play");
        }
    }
}
