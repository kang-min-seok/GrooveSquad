package rhythmOrchestra_LHK;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class RankingPage extends Thread {
	private Image background;
	private Image rankingPageWindowImage = new ImageIcon(Main.class.getResource("../images/rankingPageWindow.png")).getImage();
	
	private Image rankEasyButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/rankEasyButtonEntered.png")).getImage();
	private Image rankEasyButtonBasicImage = new ImageIcon(Main.class.getResource("../images/rankEasyButtonBasic.png")).getImage();
	private Image rankHardButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/rankHardButtonEntered.png")).getImage();
	private Image rankHardButtonBasicImage = new ImageIcon(Main.class.getResource("../images/rankHardButtonBasic.png")).getImage();
	
	private Image rankPianoButtonEnteredImage = new ImageIcon(
			Main.class.getResource("../images/rankPianoButtonEntered.png")).getImage();
	private Image rankPianoButtonBasicImage = new ImageIcon(Main.class.getResource("../images/rankPianoButtonBasic.png")).getImage();
	private Image rankViolinButtonEnteredImage = new ImageIcon(
			Main.class.getResource("../images/rankViolinButtonEntered.png")).getImage();
	private Image rankViolinButtonBasicImage = new ImageIcon(Main.class.getResource("../images/rankViolinButtonBasic.png")).getImage();
	private Image rankGuitarButtonEnteredImage = new ImageIcon(
			Main.class.getResource("../images/rankGuitarButtonEntered.png")).getImage();
	private Image rankGuitarButtonBasicImage = new ImageIcon(Main.class.getResource("../images/rankGuitarButtonBasic.png")).getImage();

	private Image charecterImage;
	
	private int rankID;
	private String songInfo;
	private String instrumentInfo;
	private int score;
	private String difficulty= "Easy";
	private String userID;
	public static RankingDAO rankingDAO;
	
	public RankingPage(String songInfo, String instrumentInfo, Image background) {
		this.songInfo = songInfo;
		this.instrumentInfo = instrumentInfo;
		this.background = background;
	}
	public void screenDraw(Graphics2D g) {
		g.drawImage(background, 0, 0, null);
		g.drawImage(rankingPageWindowImage,100,80,null);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Elephant", Font.BOLD, 50));
		g.drawString(songInfo+" ("+difficulty+")", 125, 150);
		g.drawImage(rankEasyButtonBasicImage,885,120,null);
		g.drawImage(rankHardButtonBasicImage,885,200,null);
		g.drawImage(rankPianoButtonBasicImage,885,300,null);
		g.drawImage(rankViolinButtonBasicImage,885,380,null);
		g.drawImage(rankGuitarButtonBasicImage,885,460,null);
		if(instrumentInfo == "piano") {
			charecterImage = new ImageIcon(Main.class.getResource("../images/rank_piano_charecter.png")).getImage();
		}else if(instrumentInfo == "violin") {
			charecterImage = new ImageIcon(Main.class.getResource("../images/rank_violin_charecter.png")).getImage();
		}else if(instrumentInfo == "guitar") {
			charecterImage = new ImageIcon(Main.class.getResource("../images/rank_guitar_charecter.png")).getImage();
		}
		g.drawImage(charecterImage,910,530,null);

//		ArrayList<Ranking> list = rankingDAO.getList(songInfo, instrumentInfo, difficulty);
//		for(int i=0; i<list.size();i++) {
//			
//		}
//		g.drawString(String.valueOf(list.get(0).getScore()), 125, 150);
	}
	
	@Override
	public void run() {
	}

	public void close() {
		this.interrupt();
	}
}
