package rhythmOrchestra;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.ImageIcon;

public class RankingPage extends Thread {
	private Image background;
	private Image rankingPageWindowImage = new ImageIcon(Main.class.getResource("../images/rankingPageWindow.png")).getImage();
	
	

	private Image charecterImage;
	
	private String songInfo;
	private String instrumentInfo;
	private String difficulty;


	
	public RankingPage(String songInfo, String instrumentInfo, Image background, String difficulty) {
		this.songInfo = songInfo;
		this.instrumentInfo = instrumentInfo;
		this.background = background;
		this.difficulty = difficulty;
	}
	public void screenDraw(Graphics2D g) {
		g.drawImage(background, 0, 0, null);
		g.drawImage(rankingPageWindowImage,100,80,null);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Elephant", Font.BOLD, 50));
		g.drawString(songInfo+" ("+difficulty+")", 125, 150);
		if(instrumentInfo == "piano") {
			charecterImage = new ImageIcon(Main.class.getResource("../images/rank_piano_charecter.png")).getImage();
		}else if(instrumentInfo == "violin") {
			charecterImage = new ImageIcon(Main.class.getResource("../images/rank_violin_charecter.png")).getImage();
		}else if(instrumentInfo == "guitar") {
			charecterImage = new ImageIcon(Main.class.getResource("../images/rank_guitar_charecter.png")).getImage();
		}
		g.drawImage(charecterImage,910,530,null);
		
		
		RankingDAO rankingDAO = new RankingDAO();
		ArrayList<Ranking> list = rankingDAO.getList(songInfo, instrumentInfo, difficulty);
		
		Collections.sort(list, new Comparator<Ranking>() {
		    @Override
		    public int compare(Ranking r1, Ranking r2) {
		        return Integer.compare(r2.getScore(), r1.getScore()); // 점수를 기준으로 내림차순 정렬
		    }
		});
		
		
		int j=280;
		for(int i=0; i<list.size() ; i++) {
			if(i>=8) {
				break;
			}
			g.setFont(new Font("Elephant", Font.BOLD, 25));
			g.drawString(list.get(i).getUserID(), 250, j);
			g.setFont(new Font("Elephant", Font.BOLD, 40));
			g.drawString(String.valueOf(list.get(i).getScore()), 480, j);
			j+=55;
		}
	}
	
	@Override
	public void run() {
	}

	public void close() {
		this.interrupt();
	}
}
