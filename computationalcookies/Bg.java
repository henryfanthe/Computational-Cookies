package computationalcookies;


import java.io.File;
import java.io.IOException;
 
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
 
/**
 * Jawad and Henry
 * 2020-01-13
 * Des: this code is used to play the back groudn music and is a modified version of varioius code snippits found online
 *
 */
public class Bg {
 
    // size of the byte buffer used to read/write the audio stream
    private static final int BUFFER_SIZE = 4096;
     
    /**
     * Play a given audio file.
     * pre: noting
     * post: the background music will begin to play adn no other music will be able to override it 
     */
    void play(String audioFilePath) {
        File audioFile = new File(audioFilePath);
        try {
        	//Declaring the inputStream to be from the file with the audio content adn other various settup nesscessaties
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
            SourceDataLine audioLine = (SourceDataLine) AudioSystem.getLine(info);
 
            //making the audio playable by pulling it into menory
            audioLine.open(format);
            
            // sharting backgroudn music
            audioLine.start();
             

             // The while statement that will keep the audio going
            byte[] bytesBuffer = new byte[BUFFER_SIZE];
            int bytesRead = -1;
 
            while ((bytesRead = audioStream.read(bytesBuffer)) != -1) {
                audioLine.write(bytesBuffer, 0, bytesRead);
            }
            
            //Gettign rid of the auido when the musci is done
            audioLine.drain();
            audioLine.close();
            audioStream.close();
   
            //Catching all the various errors that could show up, but hopefully wont
        } catch (UnsupportedAudioFileException ex) {
            System.out.println("The specified audio file is not supported.");
            ex.printStackTrace();
        } catch (LineUnavailableException ex) {
            System.out.println("Audio line for playing back is unavailable.");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("Error playing the audio file.");
            ex.printStackTrace();
        }      
    }
}