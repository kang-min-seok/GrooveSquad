package rhythmOrchestra;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Game extends Thread {
	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("/images/noteRouteLine.png")).getImage();
	private Image judgementLineImage = new ImageIcon(Main.class.getResource("/images/judgementLine.png")).getImage();

	private Image gameInfoImage = new ImageIcon(Main.class.getResource("/images/gameInfo.png")).getImage();
	private Image noteRouteSImage = new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();
	private Image noteRouteDImage = new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();
	private Image noteRouteFImage = new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();
	private Image noteRouteSpace1Image = new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();
	private Image noteRouteSpace2Image = new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();
	private Image noteRouteJImage = new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();
	private Image noteRouteKImage = new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();
	private Image noteRouteLImage = new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();
	private Image highScoreChkImage = new ImageIcon(Main.class.getResource("/images/highScoreChk.png")).getImage();
	private Image blueFlareImage;
	private Image judgeImage;
	private Image background;

	private Image charecterImage;
	private Image charecterBackgroundImage = new ImageIcon(Main.class.getResource("/images/charecterBackground.png"))
			.getImage();
	private Image comboImage1;
	private Image comboImage2;
	private Image comboImage3;
	private Image rankImage;

	private String titleName;
	private String difficulty;
	private String musicTitle;
	private Music gameMusic;
	private Music resultSound = new Music("resultSound.mp3", false);
	private String instrumentType;
	private String userID;
	private boolean endChk = false;

	private int score;
	private int combo;
	private int maxCombo;
	private boolean comboChk;

	private int perfectChk;
	private int greatChk;
	private int goodChk;
	private int missChk;
	private int noteCount;

	private int highScore;
	private boolean highScoreChk = false;

	private long startTime;
	private long endTime;

	Beat[] beats;
	ArrayList<Note> noteList = new ArrayList<Note>();

	public Game(String titleName, String difficulty, String musicTitle, String instrumentType, String userID) {
		this.titleName = titleName;
		this.difficulty = difficulty;
		this.musicTitle = musicTitle;
		this.instrumentType = instrumentType;
		this.userID = userID;
		gameMusic = new Music(this.musicTitle, false);
		startTime = System.currentTimeMillis();
	}

	public Game(String titleName, String difficulty, String musicTitle, String instrumentType) {
		this.titleName = titleName;
		this.difficulty = difficulty;
		this.musicTitle = musicTitle;
		this.instrumentType = instrumentType;
		gameMusic = new Music(this.musicTitle, false);
		startTime = System.currentTimeMillis();
	}

	public long getProgressTime() {
		endTime = System.currentTimeMillis();
		return endTime - startTime - Main.REACH_TIME;
	}

	public void screenDraw(Graphics2D g) {
		if (!endChk) {
			endChecking();
			g.drawImage(noteRouteSImage, 228, 30, null);
			g.drawImage(noteRouteDImage, 332, 30, null);
			g.drawImage(noteRouteFImage, 436, 30, null);
			g.drawImage(noteRouteSpace1Image, 540, 30, null);
			g.drawImage(noteRouteSpace2Image, 640, 30, null);
			g.drawImage(noteRouteJImage, 744, 30, null);
			g.drawImage(noteRouteKImage, 848, 30, null);
			g.drawImage(noteRouteLImage, 952, 30, null);
			g.drawImage(noteRouteLineImage, 224, 30, null);
			g.drawImage(noteRouteLineImage, 328, 30, null);
			g.drawImage(noteRouteLineImage, 432, 30, null);
			g.drawImage(noteRouteLineImage, 536, 30, null);
			g.drawImage(noteRouteLineImage, 740, 30, null);
			g.drawImage(noteRouteLineImage, 844, 30, null);
			g.drawImage(noteRouteLineImage, 948, 30, null);
			g.drawImage(noteRouteLineImage, 1052, 30, null);
			g.drawImage(gameInfoImage, 0, 660, null);
			g.drawImage(judgementLineImage, 0, 580, null);

			g.drawImage(charecterBackgroundImage, 5, 100, null);
			charecterType(instrumentType);
			g.drawImage(charecterImage, 10, 120, null);

			for (int i = 0; i < noteList.size(); i++) {
				Note note = noteList.get(i);
				if (note.getY() > 630) {
					judgeImage = new ImageIcon(Main.class.getResource("/images/judgeMiss.png")).getImage();
					missChk += 1;
					combo = 0;
					maxComboChk();
				}
				if (!note.isProceeded()) {
					noteList.remove(i);
					i--;
				} else {
					note.screenDraw(g);
				}

			}
			g.setColor(Color.white);
			g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			g.setFont(new Font("Arial", Font.BOLD, 30));
			g.drawString(titleName, 20, 702);
			g.drawString(difficulty, 1110, 702);
			g.setFont(new Font("Arial", Font.PLAIN, 26));
			g.setColor(Color.DARK_GRAY);
			g.drawString("S", 270, 609);
			g.drawString("D", 374, 609);
			g.drawString("F", 478, 609);
			g.drawString("Space Bar", 580, 609);
			g.drawString("J", 784, 609);
			g.drawString("K", 889, 609);
			g.drawString("L", 993, 609);
			g.setColor(Color.LIGHT_GRAY);
			g.setFont(new Font("Elephant", Font.BOLD, 30));
			g.drawString(Integer.toString(score), 565, 702);
			g.drawImage(comboImage1, 540, 152, null);
			g.drawImage(comboImage2, 590, 152, null);
			g.drawImage(comboImage3, 640, 152, null);
			comboDraw();
			g.drawImage(blueFlareImage, 250, 270, null);
			g.drawImage(judgeImage, 550, 420, null);
		} else if (endChk) {
			if (titleName.equals("Ditto-NewJeans") && instrumentType.equals("piano")) {
				background = new ImageIcon(Main.class.getResource("/images/resultBackground_Ditto_piano.png"))
						.getImage();
			}

			// Ditto 바이올린 이지모드 노트
			else if (titleName.equals("Ditto-NewJeans") && instrumentType.equals("violin")) {
				background = new ImageIcon(Main.class.getResource("/images/resultBackground_Ditto_violin.png"))
						.getImage();
			}
			// Ditto 기타 이지모드 노트
			else if (titleName.equals("Ditto-NewJeans") && instrumentType.equals("guitar")) {
				background = new ImageIcon(Main.class.getResource("/images/resultBackground_Ditto_guitar.png"))
						.getImage();
			}

			// 사건의 지평선 피아노 이지모드 노트
			else if (titleName.equals("EndTheory-YOUNHA") && instrumentType.equals("piano")) {
				background = new ImageIcon(Main.class.getResource("/images/resultBackground_Endtheory_piano.png"))
						.getImage();
			}

			// 사건의 지평선 바이올린 이지모드 노트
			else if (titleName.equals("EndTheory-YOUNHA") && instrumentType.equals("violin")) {
				background = new ImageIcon(Main.class.getResource("/images/resultBackground_Endtheory_violin.png"))
						.getImage();
			}

			// 사건의 지평선 기타 이지모드 노트
			else if (titleName.equals("EndTheory-YOUNHA") && instrumentType.equals("guitar")) {
				background = new ImageIcon(Main.class.getResource("/images/resultBackground_Endtheory_guitar.png"))
						.getImage();
			}

			// 봄여름가을겨울 피아노 이지모드 노트
			else if (titleName.equals("Still Life-BIGBANG") && instrumentType.equals("piano")) {
				background = new ImageIcon(Main.class.getResource("/images/resultBackground_StillLife_piano.png"))
						.getImage();
			}

			// 봄여름가을겨울 바이올린 이지모드 노트
			else if (titleName.equals("Still Life-BIGBANG") && instrumentType.equals("violin")) {
				background = new ImageIcon(Main.class.getResource("/images/resultBackground_StillLife_violin.png"))
						.getImage();
			}

			// 봄여름가을겨울 기타 이지모드 노트
			else if (titleName.equals("Still Life-BIGBANG") && instrumentType.equals("guitar")) {
				background = new ImageIcon(Main.class.getResource("/images/resultBackground_StillLife_guitar.png"))
						.getImage();
			}
			g.drawImage(background, 0, 0, null);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Elephant", Font.BOLD, 70));
			g.drawString(Integer.toString(score), 340, 510);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Elephant", Font.BOLD, 25));
			g.drawString(Integer.toString(perfectChk), 285, 310);
			g.drawString(Integer.toString(greatChk), 285, 350);
			g.drawString(Integer.toString(goodChk), 285, 390);
			g.drawString(Integer.toString(missChk), 285, 430);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Elephant", Font.BOLD, 70));
			g.drawString(Integer.toString(maxCombo), 600, 400);
			if (missChk <= noteCount * 0.1) {
				rankImage = new ImageIcon(Main.class.getResource("/images/rankImage_S.png")).getImage();
			} else if (missChk > noteCount * 0.1 && missChk <= noteCount * 0.2) {
				rankImage = new ImageIcon(Main.class.getResource("/images/rankImage_A.png")).getImage();
			} else if (missChk > noteCount * 0.2 && missChk <= noteCount * 0.3) {
				rankImage = new ImageIcon(Main.class.getResource("/images/rankImage_B.png")).getImage();
			} else if (missChk > noteCount * 0.3 && missChk <= noteCount * 0.4) {
				rankImage = new ImageIcon(Main.class.getResource("/images/rankImage_C.png")).getImage();
			} else if (missChk > noteCount * 0.4 && missChk <= noteCount * 0.5) {
				rankImage = new ImageIcon(Main.class.getResource("/images/rankImage_D.png")).getImage();
			} else {
				rankImage = new ImageIcon(Main.class.getResource("/images/rankImage_F.png")).getImage();
			}
			g.drawImage(rankImage, 630, 500, null);
			if (highScoreChk == true) {
				g.drawImage(highScoreChkImage, 420, 40, null);
			}
		}
	}

	public void pressS() {
		judge("S");
		noteRouteSImage = new ImageIcon(Main.class.getResource("/images/noteRoutePressed.png")).getImage();
		System.out.println("new Beat(" + getProgressTime() + ",\"S\"),");
	}

	public void releaseS() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();
	}

	public void pressD() {
		judge("D");
		noteRouteDImage = new ImageIcon(Main.class.getResource("/images/noteRoutePressed.png")).getImage();
		System.out.println("new Beat(" + getProgressTime() + ",\"D\"),");
	}

	public void releaseD() {
		noteRouteDImage = new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();
	}

	public void pressF() {
		judge("F");
		noteRouteFImage = new ImageIcon(Main.class.getResource("/images/noteRoutePressed.png")).getImage();
		System.out.println("new Beat(" + getProgressTime() + ",\"F\"),");
	}

	public void releaseF() {
		noteRouteFImage = new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();
	}

	public void pressSpace() {
		judge("Space");
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("/images/noteRoutePressed.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("/images/noteRoutePressed.png")).getImage();
		System.out.println("new Beat(" + getProgressTime() + ",\"Space\"),");
	}

	public void releaseSpace() {
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();

	}

	public void pressJ() {
		judge("J");
		noteRouteJImage = new ImageIcon(Main.class.getResource("/images/noteRoutePressed.png")).getImage();
		System.out.println("new Beat(" + getProgressTime() + ",\"J\"),");
	}

	public void releaseJ() {
		noteRouteJImage = new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();
	}

	public void pressK() {
		judge("K");
		noteRouteKImage = new ImageIcon(Main.class.getResource("/images/noteRoutePressed.png")).getImage();
		System.out.println("new Beat(" + getProgressTime() + ",\"K\"),");
	}

	public void releaseK() {
		noteRouteKImage = new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();
	}

	public void pressL() {
		judge("L");
		noteRouteLImage = new ImageIcon(Main.class.getResource("/images/noteRoutePressed.png")).getImage();
		System.out.println("new Beat(" + getProgressTime() + ",\"L\"),");
	}

	public void releaseL() {
		noteRouteLImage = new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();
	}

	@Override
	public void run() {
		dropNotes(this.titleName);
	}

	public void close() {
		gameMusic.close();
		this.interrupt();
	}

	// 노트 찍어내는 함수
	public void dropNotes(String TitleName) {
		// Ditto 노트 이지노트
		if (titleName.equals("Ditto-NewJeans") && difficulty.equals("Easy")) {
			beats = new DittoNotes(titleName, instrumentType, difficulty).DittoEasy(titleName, instrumentType,
					difficulty);
		}
		// Ditto 노트 하드 노트
		else if (titleName.equals("Ditto-NewJeans") && difficulty.equals("Hard")) {
			beats = new DittoNotes(titleName, instrumentType, difficulty).DittoHard(titleName, instrumentType,
					difficulty);
		}
		// 사건의 지평선 이지 노트
		else if (titleName.equals("EndTheory-YOUNHA") && difficulty.equals("Easy")) {
			beats = new EndtheoryNotes(titleName, instrumentType, difficulty).EndtheoryEasy(titleName, instrumentType,
					difficulty);
		}
		// 사건의 지평선 하드 노트
		else if (titleName.equals("EndTheory-YOUNHA") && difficulty.equals("Hard")) {
			beats = new EndtheoryNotes(titleName, instrumentType, difficulty).EndtheoryHard(titleName, instrumentType,
					difficulty);
		}
		// 봄여름가을겨울 이지 노트
		else if (titleName.equals("Still Life-BIGBANG") && difficulty.equals("Easy")) {
			beats = new StillLifeNotes(titleName, instrumentType, difficulty).StillLifeEasy(titleName, instrumentType,
					difficulty);
		}
		// 봄여름가을겨울 하드 노트
		else if (titleName.equals("Still Life-BIGBANG") && difficulty.equals("Hard")) {
			beats = new StillLifeNotes(titleName, instrumentType, difficulty).StillLifeHard(titleName, instrumentType,
					difficulty);
		}

		int i = 0;
		gameMusic.start();
		noteCount = beats.length;
		while (i < beats.length && !isInterrupted()) {
			boolean dropped = false;
			if (beats[i].getTime() <= gameMusic.getTime()) {
				Note note = new Note(beats[i].getNoteName());
				note.start();
				noteList.add(note);
				i++;
				dropped = true;
			}
			if (!dropped) {
				try {
					Thread.sleep(5);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	// 노트 타이밍 판정 함수
	public void judge(String input) {
		for (int i = 0; i < noteList.size(); i++) {
			Note note = noteList.get(i);
			if (input.equals(note.getNoteType())) {
				judgeEvent(note.judge());
				break;
			}
		}
	}

	// 악기 정보에 따라 캐릭터 삽입하는 함수
	public void charecterType(String instrumentType) {
		if (instrumentType.equals("piano")) {
			charecterImage = new ImageIcon(Main.class.getResource("/images/piano_charecter.png")).getImage();
			if (comboChk == true) {
				if (combo >= 0 && combo < 5) {
					charecterImage = new ImageIcon(Main.class.getResource("/images/piano_charecter_sad.png"))
							.getImage();
				} else if (combo > 5 && combo < 10) {
					charecterImage = new ImageIcon(Main.class.getResource("/images/piano_charecter.png")).getImage();
				} else if (combo > 10) {
					charecterImage = new ImageIcon(Main.class.getResource("/images/piano_charecter_smile.png"))
							.getImage();
				}
			}
		} else if (instrumentType.equals("violin")) {
			charecterImage = new ImageIcon(Main.class.getResource("/images/violin_charecter.png")).getImage();
			if (comboChk == true) {
				if (combo >= 0 && combo < 5) {
					charecterImage = new ImageIcon(Main.class.getResource("/images/violin_charecter_sad.png"))
							.getImage();
				} else if (combo > 5 && combo < 10) {
					charecterImage = new ImageIcon(Main.class.getResource("/images/violin_charecter.png")).getImage();
				} else if (combo > 10) {
					charecterImage = new ImageIcon(Main.class.getResource("/images/violin_charecter_smile.png"))
							.getImage();
				}
			}

		} else if (instrumentType.equals("guitar")) {
			charecterImage = new ImageIcon(Main.class.getResource("/images/guitar_charecter.png")).getImage();
			if (comboChk == true) {
				if (combo >= 0 && combo < 5) {
					charecterImage = new ImageIcon(Main.class.getResource("/images/guitar_charecter_sad.png"))
							.getImage();
				} else if (combo > 5 && combo < 10) {
					charecterImage = new ImageIcon(Main.class.getResource("/images/guitar_charecter.png")).getImage();
				} else if (combo > 10) {
					charecterImage = new ImageIcon(Main.class.getResource("/images/guitar_charecter_smile.png"))
							.getImage();
				}
			}
		}
	}

	// 판정 타이밍에 따른 콤보 증가, 점수 증가, 판정 이미지 출력
	public void judgeEvent(String judge) {
		if (!judge.equals("None")) {
			blueFlareImage = new ImageIcon(Main.class.getResource("/images/blueFlare.png")).getImage();
		}
		if (judge.equals("Late")) {
			judgeImage = new ImageIcon(Main.class.getResource("/images/judgeLate.png")).getImage();
			combo += 1;
			comboChk = true;
			maxComboChk();
		} else if (judge.equals("Good")) {
			judgeImage = new ImageIcon(Main.class.getResource("/images/judgeGood.png")).getImage();
			score += 100;
			goodChk += 1;
			combo += 1;
			comboChk = true;
			comboEvent();
			maxComboChk();
		} else if (judge.equals("Great")) {
			judgeImage = new ImageIcon(Main.class.getResource("/images/judgeGreat.png")).getImage();
			score += 300;
			greatChk += 1;
			combo += 1;
			comboChk = true;
			comboEvent();
			maxComboChk();
		} else if (judge.equals("Perfect")) {
			judgeImage = new ImageIcon(Main.class.getResource("/images/judgePerfect.png")).getImage();
			score += 500;
			perfectChk += 1;
			combo += 1;
			comboChk = true;
			comboEvent();
			maxComboChk();
		} else if (judge.equals("Early")) {
			judgeImage = new ImageIcon(Main.class.getResource("/images/judgeEarly.png")).getImage();
			combo += 1;
			comboChk = true;
			maxComboChk();
		}
	}

	// 콤보수 높아지면 점수 더 많이 얻을 수 있는 함수
	public void comboEvent() {
		if (combo > 10 && combo < 20) {
			score += 50;
		} else if (combo > 20 && combo < 30) {
			score += 100;
		} else if (combo > 30) {
			score += 200;
		}

	}

	// 최대 콤보수 설정 함수
	public void maxComboChk() {
		if (maxCombo <= combo) {
			maxCombo = combo;
		}
	}

	// 콤보수에 따른 콤보 이미지 그리는 함수
	public void comboDraw() {
		if (!comboChk)
			return;
		int ones, tens, hundreds;

		comboImage1 = new ImageIcon(Main.class.getResource("/images/combo_img0.png")).getImage();
		comboImage2 = new ImageIcon(Main.class.getResource("/images/combo_img0.png")).getImage();
		comboImage3 = new ImageIcon(Main.class.getResource("/images/combo_img0.png")).getImage();

		if (combo < 10) {
			comboImage3 = new ImageIcon(Main.class.getResource("/images/combo_img" + combo + ".png")).getImage();
		} else if (combo >= 10 && combo < 100) {
			tens = combo / 10;
			ones = combo % 10;
			comboImage2 = new ImageIcon(Main.class.getResource("/images/combo_img" + tens + ".png")).getImage();
			comboImage3 = new ImageIcon(Main.class.getResource("/images/combo_img" + ones + ".png")).getImage();
		} else if (combo >= 100 && combo < 1000) {
			hundreds = combo / 100;
			tens = (combo / 10) % 10;
			ones = (combo % 100) % 10;
			comboImage1 = new ImageIcon(Main.class.getResource("/images/combo_img" + hundreds + ".png")).getImage();
			comboImage2 = new ImageIcon(Main.class.getResource("/images/combo_img" + tens + ".png")).getImage();
			comboImage3 = new ImageIcon(Main.class.getResource("/images/combo_img" + ones + ".png")).getImage();
		}
	}

	// 노래 끝나는 시간에 맞춰 결과창 띄울 시간 설정하기
	public void endChecking() {
		if (titleName.equals("Ditto-NewJeans") && instrumentType.equals("piano")) {
			if (getProgressTime() > 186541) {
				if (userID != null) {
					RankingDAO rankingDAO = new RankingDAO();
					int result = rankingDAO.rankingWrite(titleName, instrumentType, score, difficulty, userID);
					System.out.println("ranking success");
					resultSound.start();
					endChk = true;
					ArrayList<Ranking> listChk = rankingDAO.getList(titleName,instrumentType,difficulty);
					for(int i=0; i<listChk.size();i++) {
						if(i>=8) {
							break;
						}
						if(score>=listChk.get(i).getScore()) {
							showTemporaryMessage("랭킹등록에<br>성공하였습니다!");
						}
					}
					ArrayList<Ranking> list = rankingDAO.getHighScore(titleName, instrumentType, difficulty, userID);
					highScore = list.get(0).getScore();
					if (score >= highScore) {
						highScoreChk = true;
					}
					if (result == -1) {
						System.out.println("ranking failed");
					}
				} else if (userID == null) {
					resultSound.start();
					endChk = true;
				}
			}
		}

		// Ditto 바이올린
		else if (titleName.equals("Ditto-NewJeans") && instrumentType.equals("violin")) {
			if (getProgressTime() > 185804) {
				if (userID != null) {
					RankingDAO rankingDAO = new RankingDAO();
					int result = rankingDAO.rankingWrite(titleName, instrumentType, score, difficulty, userID);
					System.out.println("ranking success");

					resultSound.start();
					endChk = true;
					ArrayList<Ranking> listChk = rankingDAO.getList(titleName,instrumentType,difficulty);
					for(int i=0; i<listChk.size();i++) {
						if(i>=8) {
							break;
						}
						if(score>=listChk.get(i).getScore()) {
							showTemporaryMessage("랭킹등록에<br>성공하였습니다!");
						}
					}
					ArrayList<Ranking> list = rankingDAO.getHighScore(titleName, instrumentType, difficulty, userID);

					highScore = list.get(0).getScore();
					if (score >= highScore) {
						highScoreChk = true;
					}
					if (result == -1) {
						System.out.println("ranking failed");
					}
				} else if (userID == null) {
					endChk = true;
					resultSound.start();
				}
			}
		}

		// Ditto 기타
		else if (titleName.equals("Ditto-NewJeans") && instrumentType.equals("guitar")) {
			if (getProgressTime() > 178515) {
				if (userID != null) {
					RankingDAO rankingDAO = new RankingDAO();
					int result = rankingDAO.rankingWrite(titleName, instrumentType, score, difficulty, userID);
					System.out.println("ranking success");

					resultSound.start();
					endChk = true;
					ArrayList<Ranking> listChk = rankingDAO.getList(titleName,instrumentType,difficulty);
					for(int i=0; i<listChk.size();i++) {
						if(i>=8) {
							break;
						}
						if(score>=listChk.get(i).getScore()) {
							showTemporaryMessage("랭킹등록에<br>성공하였습니다!");
						}
					}
					ArrayList<Ranking> list = rankingDAO.getHighScore(titleName, instrumentType, difficulty, userID);

					highScore = list.get(0).getScore();
					if (score >= highScore) {
						highScoreChk = true;
					}
					if (result == -1) {
						System.out.println("ranking failed");
					}
				} else if (userID == null) {
					endChk = true;
					resultSound.start();
				}
			}
		}
		// 사건의 지평선 피아노
		else if (titleName.equals("EndTheory-YOUNHA") && instrumentType.equals("piano")) {
			if (getProgressTime() > 294521) {
				if (userID != null) {
					RankingDAO rankingDAO = new RankingDAO();
					int result = rankingDAO.rankingWrite(titleName, instrumentType, score, difficulty, userID);
					System.out.println("ranking success");

					resultSound.start();
					endChk = true;
					ArrayList<Ranking> listChk = rankingDAO.getList(titleName,instrumentType,difficulty);
					for(int i=0; i<listChk.size();i++) {
						if(i>=8) {
							break;
						}
						if(score>=listChk.get(i).getScore()) {
							showTemporaryMessage("랭킹등록에<br>성공하였습니다!");
						}
					}
					ArrayList<Ranking> list = rankingDAO.getHighScore(titleName, instrumentType, difficulty, userID);

					highScore = list.get(0).getScore();
					if (score >= highScore) {
						highScoreChk = true;
					}
					if (result == -1) {
						System.out.println("ranking failed");
					}
				} else if (userID == null) {
					endChk = true;
					resultSound.start();
				}
			}
		}
		// 사건의 지평선 바이올린
		else if (titleName.equals("EndTheory-YOUNHA") && instrumentType.equals("violin")) {
			if (getProgressTime() > 251954) {
				if (userID != null) {
					RankingDAO rankingDAO = new RankingDAO();
					int result = rankingDAO.rankingWrite(titleName, instrumentType, score, difficulty, userID);
					System.out.println("ranking success");

					resultSound.start();
					endChk = true;
					ArrayList<Ranking> listChk = rankingDAO.getList(titleName,instrumentType,difficulty);
					for(int i=0; i<listChk.size();i++) {
						if(i>=8) {
							break;
						}
						if(score>=listChk.get(i).getScore()) {
							showTemporaryMessage("랭킹등록에<br>성공하였습니다!");
						}
					}
					ArrayList<Ranking> list = rankingDAO.getHighScore(titleName, instrumentType, difficulty, userID);

					highScore = list.get(0).getScore();
					if (score >= highScore) {
						highScoreChk = true;
					}
					if (result == -1) {
						System.out.println("ranking failed");
					}
				} else if (userID == null) {
					endChk = true;
					resultSound.start();
				}
			}
		}
		// 사건의 지평선 기타
		else if (titleName.equals("EndTheory-YOUNHA") && instrumentType.equals("guitar")) {
			if (getProgressTime() > 277640) {
				if (userID != null) {
					RankingDAO rankingDAO = new RankingDAO();
					int result = rankingDAO.rankingWrite(titleName, instrumentType, score, difficulty, userID);
					System.out.println("ranking success");

					resultSound.start();
					endChk = true;
					ArrayList<Ranking> listChk = rankingDAO.getList(titleName,instrumentType,difficulty);
					for(int i=0; i<listChk.size();i++) {
						if(i>=8) {
							break;
						}
						if(score>=listChk.get(i).getScore()) {
							showTemporaryMessage("랭킹등록에<br>성공하였습니다!");
						}
					}
					ArrayList<Ranking> list = rankingDAO.getHighScore(titleName, instrumentType, difficulty, userID);

					highScore = list.get(0).getScore();
					if (score >= highScore) {
						highScoreChk = true;
					}
					if (result == -1) {
						System.out.println("ranking failed");
					}
				} else if (userID == null) {
					endChk = true;
					resultSound.start();
				}
			}
		}
		// 봄여름가을겨울 피아노
		else if (titleName.equals("Still Life-BIGBANG") && instrumentType.equals("piano")) {
			if (getProgressTime() > 190155) {
				if (userID != null) {
					RankingDAO rankingDAO = new RankingDAO();
					int result = rankingDAO.rankingWrite(titleName, instrumentType, score, difficulty, userID);
					System.out.println("ranking success");

					resultSound.start();
					endChk = true;
					ArrayList<Ranking> listChk = rankingDAO.getList(titleName,instrumentType,difficulty);
					for(int i=0; i<listChk.size();i++) {
						if(i>=8) {
							break;
						}
						if(score>=listChk.get(i).getScore()) {
							showTemporaryMessage("랭킹등록에<br>성공하였습니다!");
						}
					}
					ArrayList<Ranking> list = rankingDAO.getHighScore(titleName, instrumentType, difficulty, userID);

					highScore = list.get(0).getScore();
					if (score >= highScore) {
						highScoreChk = true;
					}
					if (result == -1) {
						System.out.println("ranking failed");
					}
				} else if (userID == null) {
					endChk = true;
					resultSound.start();
				}
			}
		}

		// 봄여름가을겨울 바이올린
		else if (titleName.equals("Still Life-BIGBANG") && instrumentType.equals("violin")) {
			if (getProgressTime() > 185393) {
				if (userID != null) {
					RankingDAO rankingDAO = new RankingDAO();
					int result = rankingDAO.rankingWrite(titleName, instrumentType, score, difficulty, userID);
					System.out.println("ranking success");

					resultSound.start();
					endChk = true;
					ArrayList<Ranking> listChk = rankingDAO.getList(titleName,instrumentType,difficulty);
					for(int i=0; i<listChk.size();i++) {
						if(i>=8) {
							break;
						}
						if(score>=listChk.get(i).getScore()) {
							showTemporaryMessage("랭킹등록에<br>성공하였습니다!");
						}
					}
					ArrayList<Ranking> list = rankingDAO.getHighScore(titleName, instrumentType, difficulty, userID);

					highScore = list.get(0).getScore();
					if (score >= highScore) {
						highScoreChk = true;
					}
					if (result == -1) {
						System.out.println("ranking failed");
					}
				} else if (userID == null) {
					endChk = true;
					resultSound.start();
				}
			}
		}

		// 봄여름가을겨울 기타
		else if (titleName.equals("Still Life-BIGBANG") && instrumentType.equals("guitar")) {
			if (getProgressTime() > 171090) {
				if (userID != null) {
					RankingDAO rankingDAO = new RankingDAO();
					int result = rankingDAO.rankingWrite(titleName, instrumentType, score, difficulty, userID);
					System.out.println("ranking success");

					resultSound.start();
					endChk = true;
					ArrayList<Ranking> listChk = rankingDAO.getList(titleName,instrumentType,difficulty);
					for(int i=0; i<listChk.size();i++) {
						if(i>=8) {
							break;
						}
						if(score>=listChk.get(i).getScore()) {
							showTemporaryMessage("랭킹등록에<br>성공하였습니다!");
						}
					}
					ArrayList<Ranking> list = rankingDAO.getHighScore(titleName, instrumentType, difficulty, userID);

					highScore = list.get(0).getScore();
					if (score >= highScore) {
						highScoreChk = true;
					}
					if (result == -1) {
						System.out.println("ranking failed");
					}
				} else if (userID == null) {
					endChk = true;
					resultSound.start();
				}
			}
		}
	}
	public void showTemporaryMessage(String message) {
	    final JDialog dialog = new JDialog();
	    dialog.setUndecorated(true);
	    dialog.setLayout(new BorderLayout());

	    JLabel label = new JLabel("<html><div style='text-align: center;'>" + message + "</div></html>", SwingConstants.CENTER);
	    label.setFont(new Font("Arial", Font.BOLD, 30)); // 글꼴과 크기 설정
	    label.setForeground(Color.WHITE); // 텍스트 색상 설정
	    label.setBackground(Color.decode("#859991")); // 배경색 설정
	    label.setOpaque(true); // 배경색이 보이게 설정
	    label.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // 여백 추가

	    JPanel panel = new JPanel(new GridBagLayout());
	    panel.add(label);
	    panel.setBackground(label.getBackground()); // panel의 배경색을 label의 배경색과 동일하게 설정

	    dialog.getContentPane().add(panel, BorderLayout.CENTER);
	    dialog.getRootPane().setBorder(BorderFactory.createLineBorder(Color.WHITE, 8)); // dialog에 테두리 추가
	    dialog.pack();
	    dialog.setLocationRelativeTo(null); // dialog를 화면 중앙에 위치시킵니다
	    dialog.setVisible(true);
	    dialog.setSize(300, 200);
	    // 메시지를 3초 동안 보여주고 사라지게 합니다
	    new Thread() {
	        public void run() {
	            try {
	                Thread.sleep(2000); // 2초 동안 잠깁니다
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	            dialog.setVisible(false);
	            dialog.dispose();
	        }
	    }.start();
	}
}
