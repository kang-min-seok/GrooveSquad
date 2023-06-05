package rhythmOrchestra;

import java.io.BufferedInputStream;
import java.io.InputStream;

import javazoom.jl.player.Player;

public class Music extends Thread{
	
	private Player player;
	private boolean isLoop;
	private InputStream fis;
	private BufferedInputStream bis;
	private String fileName;   // Changed 'name' to 'fileName'
	
	public Music(String name, boolean isLoop) {
	    try {
	        this.isLoop = isLoop;
	        this.fileName = name; // Use fileName instead of name
	        InputStream is = Main.class.getResourceAsStream("/music/" + fileName);
	        bis = new BufferedInputStream(is);
	        player = new Player(bis);
	    }catch (Exception e) {
	        System.out.println(e.getMessage());
	    }
	}

	public int getTime() {
	    if (player == null)
	        return 0;
	    return player.getPosition();
	}

	public void close() {
	    isLoop = false;
	    player.close();
	    this.interrupt();
	}

	@Override
	public void run() {
	    try {
	        do {
	            player.play();
	            if(isLoop) {
	                InputStream is = Main.class.getResourceAsStream("/music/" + fileName);
	                bis = new BufferedInputStream(is);
	                player = new Player(bis);
	            }
	        } while (isLoop);
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    }
	}
}
