package rhythmOrchestra_LHK;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {

	@Override
	public void keyPressed(KeyEvent e) {
		if(RhythmOrchestra.game == null) {
			return;
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			RhythmOrchestra.game.pressS();	
		} else if (e.getKeyCode() == KeyEvent.VK_D) {
			RhythmOrchestra.game.pressD();	
		} else if (e.getKeyCode() == KeyEvent.VK_F) {
			RhythmOrchestra.game.pressF();	
		} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			RhythmOrchestra.game.pressSpace();	
		} else if (e.getKeyCode() == KeyEvent.VK_J) {
			RhythmOrchestra.game.pressJ();	
		} else if (e.getKeyCode() == KeyEvent.VK_K) {
			RhythmOrchestra.game.pressK();	
		} else if (e.getKeyCode() == KeyEvent.VK_L) {
			RhythmOrchestra.game.pressL();	
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		if(RhythmOrchestra.game == null) {
			return;
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			RhythmOrchestra.game.releaseS();	
		} else if (e.getKeyCode() == KeyEvent.VK_D) {
			RhythmOrchestra.game.releaseD();
		} else if (e.getKeyCode() == KeyEvent.VK_F) {
			RhythmOrchestra.game.releaseF();
		} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			RhythmOrchestra.game.releaseSpace();
		} else if (e.getKeyCode() == KeyEvent.VK_J) {
			RhythmOrchestra.game.releaseJ();
		} else if (e.getKeyCode() == KeyEvent.VK_K) {
			RhythmOrchestra.game.releaseK();
		} else if (e.getKeyCode() == KeyEvent.VK_L) {
			RhythmOrchestra.game.releaseL();
		}
	}
}
