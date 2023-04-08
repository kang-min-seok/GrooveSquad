package rhythmOrchestra;

import javax.swing.JFrame;

public class RhythmOrchestra extends JFrame{
	public RhythmOrchestra() {
		setTitle("RhythmOrchestra");
		setSize(Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
