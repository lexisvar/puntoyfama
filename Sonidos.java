    import javax.swing.*;
	import javax.sound.sampled.*;
	import java.io.*;
	
public class Sonidos extends JFrame {
	 
	private static final long serialVersionUID = 1L;

		public Sonidos(String sonidos2)
	    {
	        File sf = new File(sonidos2);
	        AudioFileFormat aff;
	        AudioInputStream ais;
	   try   	   
	        {
	         aff=AudioSystem.getAudioFileFormat(sf);
	         ais=AudioSystem.getAudioInputStream(sf);
	         AudioFormat af=aff.getFormat();
	         DataLine.Info info = new DataLine.Info(
	                                          Clip.class,
	                                          ais.getFormat(),
	                                          ((int) ais.getFrameLength() *
	                                              af.getFrameSize()));
	       Clip  ol = (Clip) AudioSystem.getLine(info);
	       ol.open(ais);
	       ol.loop(0);
	        
	       }
	        catch(UnsupportedAudioFileException ee){}
	        catch(IOException ea){}
	        catch(LineUnavailableException LUE){};
	        }
}