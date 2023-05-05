package rhythmOrchestra;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Game extends Thread{
	private Image noteRouteLineImage= new ImageIcon(Main.class.getResource("../images/noteRouteLine.png")).getImage();
	private Image judgementLineImage= new ImageIcon(Main.class.getResource("../images/judgementLine.png")).getImage();
	
	private Image gameInfoImage= new ImageIcon(Main.class.getResource("../images/gameInfo.png")).getImage();
	private Image noteRouteSImage= new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteDImage= new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteFImage= new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();	
	private Image noteRouteSpace1Image= new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSpace2Image= new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteJImage= new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteKImage= new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteLImage= new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image blueFlareImage;
	private Image judgeImage;
	
	private Image charecterImage;
	private Image comboImage= new ImageIcon(Main.class.getResource("../images/combo_img0.png")).getImage();
	
	
	private String titleName;
	private String difficulty;
	private String musicTitle;
	private Music gameMusic;
	private String instrumentType;
	
	private int score;
	private int combo;
	
	private long startTime;
    private long endTime;
	
	ArrayList<Note> noteList = new ArrayList<Note>();
	
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
        return endTime - startTime-Main.REACH_TIME;
    }
	
	public void screenDraw(Graphics2D g) {
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
		
		charecterType(instrumentType);
		g.drawImage(charecterImage, 10, 120, null);
		
		
		for(int i=0; i< noteList.size();i++)
		{
			Note note = noteList.get(i);
			if(note.getY()>620) {
				judgeImage = new ImageIcon(Main.class.getResource("../images/judgeMiss.png")).getImage();
				combo = 0;
			}
			if(!note.isProceeded()) {
				noteList.remove(i);
				i--;
			}
			else {
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
		g.setColor(Color.BLACK);
		g.drawString(Integer.toString(combo), 600, 202);
		//콤보 이미지 함수 구현 필요
		//g.drawImage(comboImage,600,202,null);
		g.drawImage(blueFlareImage,250,270,null);
		g.drawImage(judgeImage,550,420,null);
	}
	

    
	
	public void pressS() {
		judge("S");
		noteRouteSImage= new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		System.out.println("new Beat("+getProgressTime()+",\"S\"),");
	}
	
	public void releaseS() {
		noteRouteSImage= new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	public void pressD() {
		judge("D");
		noteRouteDImage= new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		System.out.println("new Beat("+getProgressTime()+",\"D\"),");
	}
	
	public void releaseD() {
		noteRouteDImage= new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	public void pressF() {
		judge("F");
		noteRouteFImage= new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		System.out.println("new Beat("+getProgressTime()+",\"F\"),");
	}
	
	public void releaseF() {
		noteRouteFImage= new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	public void pressSpace() {
		judge("Space");
		noteRouteSpace1Image= new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		noteRouteSpace2Image= new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		System.out.println("new Beat("+getProgressTime()+",\"Space\"),");
	}
	
	public void releaseSpace() {
		noteRouteSpace1Image= new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		noteRouteSpace2Image= new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();

	}
	public void pressJ() {
		judge("J");
		noteRouteJImage= new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		System.out.println("new Beat("+getProgressTime()+",\"J\"),");
	}
	
	public void releaseJ() {
		noteRouteJImage= new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	public void pressK() {
		judge("K");
		noteRouteKImage= new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		System.out.println("new Beat("+getProgressTime()+",\"K\"),");
	}
	
	public void releaseK() {
		noteRouteKImage= new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	public void pressL() {
		judge("L");
		noteRouteLImage= new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		System.out.println("new Beat("+getProgressTime()+",\"L\"),");
	}
	
	public void releaseL() {
		noteRouteLImage= new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	@Override
	public void run() {
		dropNotes(this.titleName);
	}
	public void close() {
		gameMusic.close();
		this.interrupt();
	}
	
	public void dropNotes(String TitleName) {
		Beat[] beats= null;
		//Ditto 피아노 이지모드 노트
		if(titleName.equals("Ditto-NewJeans") &&instrumentType.equals("piano") && difficulty.equals("Easy")) {
			beats = new Beat[] {
					new Beat(481,"S"),
					new Beat(1844,"K"),
					new Beat(2059,"K"),
					new Beat(2451,"D"),
					new Beat(2787,"D"),
					new Beat(3831,"L"),
					new Beat(5555,"S"),
					new Beat(7372,"K"),
					new Beat(9027,"D"),
					new Beat(9260,"F"),
					new Beat(9600,"K"),
					new Beat(9881,"L"),
					new Beat(10917,"Space"),
					new Beat(11847,"Space"),
					new Beat(12822,"S"),
					new Beat(13682,"S"),
					new Beat(14518,"D"),
					new Beat(14916,"K"),
					new Beat(15215,"K"),
					new Beat(15438,"S"),
					new Beat(15550,"K"),
					new Beat(16404,"L"),
					new Beat(16759,"L"),
					new Beat(17020,"L"),
					new Beat(17259,"D"),
					new Beat(17333,"L"),
					new Beat(18168,"S"),
					new Beat(18513,"S"),
					new Beat(18838,"S"),
					new Beat(19038,"J"),
					new Beat(19158,"D"),
					new Beat(20009,"Space"),
					new Beat(20370,"Space"),
					new Beat(20642,"Space"),
					new Beat(20890,"K"),
					new Beat(21232,"S"),
					new Beat(21567,"K"),
					new Beat(21807,"D"),
					new Beat(22152,"D"),
					new Beat(22474,"D"),
					new Beat(22675,"L"),
					new Beat(22817,"K"),
					new Beat(23588,"S"),
					new Beat(23872,"K"),
					new Beat(24197,"D"),
					new Beat(24417,"L"),
					new Beat(24747,"F"),
					new Beat(25078,"K"),
					new Beat(25317,"Space"),
					new Beat(25660,"Space"),
					new Beat(25962,"J"),
					new Beat(26172,"D"),
					new Beat(26318,"J"),
					new Beat(26742,"D"),
					new Beat(26922,"K"),
					new Beat(29209,"J"),
					new Beat(29581,"K"),
					new Beat(29814,"J"),
					new Beat(30022,"J"),
					new Beat(30240,"J"),
					new Beat(30452,"J"),
					new Beat(30883,"D"),
					new Beat(31134,"F"),
					new Beat(31405,"D"),
					new Beat(31632,"J"),
					new Beat(31815,"K"),
					new Beat(32037,"L"),
					new Beat(32695,"K"),
					new Beat(32915,"D"),
					new Beat(33160,"J"),
					new Beat(33381,"S"),
					new Beat(33617,"Space"),
					new Beat(33833,"K"),
					new Beat(34063,"K"),
					new Beat(34561,"D"),
					new Beat(34791,"J"),
					new Beat(35044,"J"),
					new Beat(35266,"F"),
					new Beat(35428,"K"),
					new Beat(35675,"D"),
					new Beat(35884,"L"),
					new Beat(36115,"Space"),
					new Beat(36781,"K"),
					new Beat(37481,"S"),
					new Beat(37687,"S"),
					new Beat(37928,"D"),
					new Beat(38572,"J"),
					new Beat(39246,"F"),
					new Beat(39474,"Space"),
					new Beat(39670,"J"),
					new Beat(40132,"D"),
					new Beat(40367,"K"),
					new Beat(41019,"F"),
					new Beat(41239,"K"),
					new Beat(41478,"D"),
					new Beat(41889,"L"),
					new Beat(42355,"S"),
					new Beat(42793,"K"),
					new Beat(43155,"D"),
					new Beat(43285,"K"),
					new Beat(43567,"F"),
					new Beat(43936,"K"),
					new Beat(44177,"K"),
					new Beat(44376,"K"),
					new Beat(44596,"J"),
					new Beat(44811,"K"),
					new Beat(45300,"D"),
					new Beat(45524,"D"),
					new Beat(45784,"D"),
					new Beat(46000,"K"),
					new Beat(46187,"K"),
					new Beat(46410,"L"),
					new Beat(46618,"L"),
					new Beat(47112,"S"),
					new Beat(47333,"S"),
					new Beat(47536,"S"),
					new Beat(47719,"J"),
					new Beat(47934,"J"),
					new Beat(48181,"D"),
					new Beat(48395,"D"),
					new Beat(48842,"K"),
					new Beat(49082,"K"),
					new Beat(49262,"K"),
					new Beat(49510,"F"),
					new Beat(49725,"F"),
					new Beat(49958,"L"),
					new Beat(50183,"L"),
					new Beat(50787,"Space"),
					new Beat(51067,"Space"),
					new Beat(51733,"S"),
					new Beat(51996,"S"),
					new Beat(52207,"K"),
					new Beat(52885,"K"),
					new Beat(53577,"D"),
					new Beat(53803,"D"),
					new Beat(54024,"L"),
					new Beat(54472,"L"),
					new Beat(54707,"S"),
					new Beat(55419,"L"),
					new Beat(55632,"S"),
					new Beat(55835,"K"),
					new Beat(56261,"D"),
					new Beat(56689,"L"),
					new Beat(57104,"Space"),
					new Beat(57598,"K"),
					new Beat(58269,"K"),
					new Beat(58707,"K"),
					new Beat(58928,"K"),
					new Beat(59175,"K"),
					new Beat(59364,"S"),
					new Beat(59819,"L"),
					new Beat(60268,"D"),
					new Beat(60699,"K"),
					new Beat(61152,"S"),
					new Beat(61683,"S"),
					new Beat(61902,"S"),
					new Beat(62344,"S"),
					new Beat(62588,"S"),
					new Beat(62840,"K"),
					new Beat(63056,"D"),
					new Beat(63459,"L"),
					new Beat(63901,"F"),
					new Beat(64350,"K"),
					new Beat(64767,"Space"),
					new Beat(65150,"Space"),
					new Beat(65409,"K"),
					new Beat(65650,"S"),
					new Beat(66001,"K"),
					new Beat(66341,"D"),
					new Beat(66551,"J"),
					new Beat(66926,"J"),
					new Beat(67451,"F"),
					new Beat(67758,"K"),
					new Beat(68088,"S"),
					new Beat(68335,"L"),
					new Beat(68775,"Space"),
					new Beat(69256,"Space"),
					new Beat(69701,"Space"),
					new Beat(69968,"J"),
					new Beat(70193,"S"),
					new Beat(70567,"K"),
					new Beat(71034,"D"),
					new Beat(71451,"L"),
					new Beat(71921,"Space"),
					new Beat(72298,"S"),
					new Beat(72655,"J"),
					new Beat(72756,"D"),
					new Beat(72875,"J"),
					new Beat(73206,"S"),
					new Beat(73519,"K"),
					new Beat(73752,"Space"),
					new Beat(74214,"Space"),
					new Beat(74650,"S"),
					new Beat(75083,"L"),
					new Beat(75497,"D"),
					new Beat(75947,"K"),
					new Beat(76226,"D"),
					new Beat(76381,"K"),
					new Beat(76867,"F"),
					new Beat(77081,"J"),
					new Beat(77624,"S"),
					new Beat(77766,"L"),
					new Beat(77998,"Space"),
					new Beat(78496,"J"),
					new Beat(78703,"D"),
					new Beat(79092,"K"),
					new Beat(79414,"K"),
					new Beat(79729,"K"),
					new Beat(79964,"K"),
					new Beat(80293,"D"),
					new Beat(80613,"D"),
					new Beat(80866,"Space"),
					new Beat(81221,"Space"),
					new Beat(81828,"J"),
					new Beat(82129,"J"),
					new Beat(82489,"J"),
					new Beat(82717,"S"),
					new Beat(83141,"D"),
					new Beat(83598,"F"),
					new Beat(84042,"J"),
					new Beat(84307,"Space"),
					new Beat(84492,"J"),
					new Beat(84906,"S"),
					new Beat(85366,"D"),
					new Beat(85804,"F"),
					new Beat(86273,"L"),
					new Beat(86660,"J"),
					new Beat(86946,"S"),
					new Beat(87175,"K"),
					new Beat(87285,"D"),
					new Beat(88065,"J"),
					new Beat(88387,"F"),
					new Beat(88672,"K"),
					new Beat(88946,"S"),
					new Beat(89054,"L"),
					new Beat(89848,"Space"),
					new Beat(90207,"Space"),
					new Beat(90499,"Space"),
					new Beat(90724,"K"),
					new Beat(90811,"D"),
					new Beat(91649,"S"),
					new Beat(92003,"S"),
					new Beat(92286,"S"),
					new Beat(92541,"L"),
					new Beat(92848,"D"),
					new Beat(93194,"K"),
					new Beat(93431,"F"),
					new Beat(93772,"F"),
					new Beat(94094,"F"),
					new Beat(94317,"D"),
					new Beat(94420,"F"),
					new Beat(95251,"K"),
					new Beat(95597,"K"),
					new Beat(95885,"S"),
					new Beat(96044,"J"),
					new Beat(96400,"Space"),
					new Beat(96752,"K"),
					new Beat(96974,"S"),
					new Beat(97331,"L"),
					new Beat(97649,"D"),
					new Beat(97887,"K"),
					new Beat(97966,"D"),
					new Beat(98038,"F"),
					new Beat(98408,"D"),
					new Beat(98662,"D"),
					new Beat(99003,"S"),
					new Beat(99242,"K"),
					new Beat(99665,"Space"),
					new Beat(100087,"S"),
					new Beat(100611,"K"),
					new Beat(100977,"K"),
					new Beat(101265,"K"),
					new Beat(101498,"D"),
					new Beat(101601,"K"),
					new Beat(102404,"S"),
					new Beat(102741,"S"),
					new Beat(103076,"S"),
					new Beat(103297,"L"),
					new Beat(103386,"S"),
					new Beat(104049,"D"),
					new Beat(104227,"K"),
					new Beat(104571,"S"),
					new Beat(104864,"S"),
					new Beat(105075,"K"),
					new Beat(105157,"S"),
					new Beat(105988,"Space"),
					new Beat(106318,"K"),
					new Beat(106632,"S"),
					new Beat(106890,"L"),
					new Beat(107219,"D"),
					new Beat(107527,"K"),
					new Beat(107763,"S"),
					new Beat(108097,"S"),
					new Beat(108394,"S"),
					new Beat(108642,"J"),
					new Beat(108728,"S"),
					new Beat(109562,"D"),
					new Beat(109883,"F"),
					new Beat(110199,"K"),
					new Beat(110425,"L"),
					new Beat(110740,"S"),
					new Beat(111115,"S"),
					new Beat(111335,"Space"),
					new Beat(111647,"Space"),
					new Beat(111981,"Space"),
					new Beat(112197,"K"),
					new Beat(112277,"S"),
					new Beat(112726,"L"),
					new Beat(112950,"D"),
					new Beat(115173,"S"),
					new Beat(115555,"S"),
					new Beat(115809,"J"),
					new Beat(116027,"J"),
					new Beat(116242,"J"),
					new Beat(116436,"D"),
					new Beat(116888,"S"),
					new Beat(117133,"S"),
					new Beat(117336,"S"),
					new Beat(117533,"K"),
					new Beat(117782,"K"),
					new Beat(118004,"S"),
					new Beat(118223,"S"),
					new Beat(118698,"Space"),
					new Beat(118903,"K"),
					new Beat(119147,"S"),
					new Beat(119360,"L"),
					new Beat(119589,"D"),
					new Beat(119819,"J"),
					new Beat(120045,"S"),
					new Beat(120500,"K"),
					new Beat(120758,"K"),
					new Beat(120984,"K"),
					new Beat(121187,"D"),
					new Beat(121415,"L"),
					new Beat(121620,"S"),
					new Beat(121828,"J"),
					new Beat(122051,"Space"),
					new Beat(122721,"K"),
					new Beat(123405,"S"),
					new Beat(123650,"S"),
					new Beat(123870,"L"),
					new Beat(124538,"D"),
					new Beat(125222,"K"),
					new Beat(125460,"K"),
					new Beat(125622,"K"),
					new Beat(126132,"S"),
					new Beat(126337,"K"),
					new Beat(126978,"Space"),
					new Beat(127192,"K"),
					new Beat(127406,"S"),
					new Beat(127872,"J"),
					new Beat(128315,"D"),
					new Beat(128734,"K"),
					new Beat(129246,"S"),
					new Beat(129693,"L"),
					new Beat(129953,"L"),
					new Beat(130053,"L"),
					new Beat(130364,"L"),
					new Beat(130590,"L"),
					new Beat(130831,"L"),
					new Beat(131027,"S"),
					new Beat(131463,"K"),
					new Beat(131888,"D"),
					new Beat(132344,"J"),
					new Beat(132788,"K"),
					new Beat(133272,"S"),
					new Beat(133481,"K"),
					new Beat(133710,"S"),
					new Beat(134173,"K"),
					new Beat(134389,"Space"),
					new Beat(134971,"J"),
					new Beat(135211,"S"),
					new Beat(135444,"K"),
					new Beat(135917,"D"),
					new Beat(136409,"L"),
					new Beat(136755,"L"),
					new Beat(137063,"L"),
					new Beat(137285,"S"),
					new Beat(137606,"K"),
					new Beat(137933,"Space"),
					new Beat(138142,"J"),
					new Beat(138491,"J"),
					new Beat(139115,"S"),
					new Beat(139434,"K"),
					new Beat(139757,"D"),
					new Beat(139995,"L"),
					new Beat(140438,"S"),
					new Beat(140899,"S"),
					new Beat(141349,"S"),
					new Beat(141785,"K"),
					new Beat(142248,"D"),
					new Beat(142669,"K"),
					new Beat(143111,"Space"),
					new Beat(143565,"J"),
					new Beat(143925,"J"),
					new Beat(144245,"J"),
					new Beat(144471,"S"),
					new Beat(144572,"J"),
					new Beat(145422,"D"),
					new Beat(145743,"D"),
					new Beat(146046,"D"),
					new Beat(146283,"K"),
					new Beat(146364,"S"),
					new Beat(147168,"L"),
					new Beat(147509,"L"),
					new Beat(147799,"L"),
					new Beat(148032,"Space"),
					new Beat(148161,"L"),
					new Beat(148932,"S"),
					new Beat(149285,"S"),
					new Beat(149625,"S"),
					new Beat(149798,"S"),
					new Beat(150157,"K"),
					new Beat(150478,"D"),
					new Beat(150736,"J"),
					new Beat(151064,"J"),
					new Beat(151379,"J"),
					new Beat(151633,"S"),
					new Beat(151758,"J"),
					new Beat(152526,"K"),
					new Beat(152855,"K"),
					new Beat(153179,"K"),
					new Beat(153386,"K"),
					new Beat(153706,"Space"),
					new Beat(154067,"L"),
					new Beat(154295,"S"),
					new Beat(154645,"K"),
					new Beat(154941,"K"),
					new Beat(155272,"K"),
					new Beat(155358,"D"),
					new Beat(155690,"K"),
					new Beat(155919,"S"),
					new Beat(156145,"K"),
					new Beat(156573,"Space"),
					new Beat(156990,"J"),
					new Beat(157423,"S"),
					new Beat(157830,"K"),
					new Beat(158226,"K"),
					new Beat(158541,"K"),
					new Beat(158773,"D"),
					new Beat(158890,"K"),
					new Beat(159632,"S"),
					new Beat(159999,"S"),
					new Beat(160326,"S"),
					new Beat(160540,"S"),
					new Beat(160837,"L"),
					new Beat(161215,"Space"),
					new Beat(161432,"K"),
					new Beat(161812,"S"),
					new Beat(162122,"J"),
					new Beat(162381,"S"),
					new Beat(162504,"J"),
					new Beat(163283,"K"),
					new Beat(163637,"K"),
					new Beat(163907,"K"),
					new Beat(164166,"K"),
					new Beat(164483,"Space"),
					new Beat(164828,"L"),
					new Beat(165067,"S"),
					new Beat(165446,"S"),
					new Beat(165772,"S"),
					new Beat(165955,"J"),
					new Beat(166069,"D"),
					new Beat(166853,"K"),
					new Beat(167180,"S"),
					new Beat(167503,"K"),
					new Beat(167722,"S"),
					new Beat(168026,"J"),
					new Beat(168445,"F"),
					new Beat(168657,"J"),
					new Beat(169023,"Space"),
					new Beat(169312,"Space"),
					new Beat(169524,"K"),
					new Beat(169610,"D"),
					new Beat(170030,"J"),
					new Beat(170268,"F"),
					new Beat(170550,"S"),
					new Beat(171323,"D"),
					new Beat(172536,"Space"),
					new Beat(173996,"J"),
					new Beat(175780,"S"),
					new Beat(176694,"F"),
					new Beat(177619,"J"),
					new Beat(178506,"Space"),
					new Beat(179379,"L"),
					new Beat(180270,"S"),
					new Beat(180976,"Space"),
					new Beat(181212,"Space"),
					new Beat(181611,"J"),
					new Beat(181876,"S"),
					new Beat(182922,"K"),
					new Beat(183820,"D"),
			};
		}
		//Ditto 피아노 하드모드 노트
		else if(titleName.equals("Ditto-NewJeans") &&instrumentType.equals("piano") && difficulty.equals("Hard")) {
			int startTime = 1000 - Main.REACH_TIME;
			beats = new Beat[] {
				new Beat(startTime,"Space"),	
			};
		}
		//Ditto 바이올린 이지모드 노트
		else if(titleName.equals("Ditto-NewJeans") &&instrumentType.equals("violin") && difficulty.equals("Easy")) {
			beats = new Beat[] {
					new Beat(1074,"Space"),
					new Beat(1360,"Space"),
					new Beat(1724,"Space"),
					new Beat(2098,"Space"),
					new Beat(3128,"Space"),
					new Beat(4858,"Space"),	
			};
		}
		//Ditto 바이올린 하드모드 노트
		else if(titleName.equals("Ditto-NewJeans") &&instrumentType.equals("violin") && difficulty.equals("Hard")) {
			beats = new Beat[] {
					new Beat(1214,"S"),
					new Beat(1453,"S"),
					new Beat(1797,"D"),
					new Beat(2139,"D"),
					new Beat(3225,"Space"),
					new Beat(4784,"Space"),
					new Beat(6708,"K"),
					new Beat(8255,"S"),
					new Beat(8491,"D"),
					new Beat(8858,"K"),
					new Beat(9217,"L"),
					new Beat(10210,"Space"),
					new Beat(11127,"Space"),
					new Beat(12127,"Space"),
					new Beat(12999,"Space"),
					new Beat(13805,"S"),
					new Beat(14136,"S"),
					new Beat(14464,"S"),
					new Beat(14747,"D"),
					new Beat(14930,"S"),
					new Beat(15643,"K"),
					new Beat(15925,"K"),
					new Beat(16245,"K"),
					new Beat(16534,"L"),
					new Beat(16616,"K"),
					new Beat(17448,"D"),
					new Beat(17729,"D"),
					new Beat(18060,"D"),
					new Beat(18333,"K"),
					new Beat(18483,"D"),
					new Beat(19255,"J"),
					new Beat(19546,"J"),
					new Beat(19876,"J"),
					new Beat(20114,"S"),
					new Beat(20417,"J"),
					new Beat(20781,"D"),
					new Beat(21015,"K"),
					new Beat(21328,"K"),
					new Beat(21646,"K"),
					new Beat(21909,"F"),
					new Beat(22025,"L"),
					new Beat(22849,"S"),
					new Beat(23163,"K"),
					new Beat(23457,"D"),
					new Beat(23665,"J"),
					new Beat(24010,"F"),
					new Beat(24365,"F"),
					new Beat(24605,"Space"),
					new Beat(24914,"Space"),
					new Beat(25242,"Space"),
					new Beat(25503,"J"),
					new Beat(25601,"K"),
					new Beat(25983,"J"),
					new Beat(26180,"J"),
					new Beat(28479,"S"),
					new Beat(28843,"D"),
					new Beat(29098,"S"),
					new Beat(29323,"S"),
					new Beat(29544,"S"),
					new Beat(29793,"S"),
					new Beat(30169,"F"),
					new Beat(30377,"F"),
					new Beat(30655,"F"),
					new Beat(30879,"J"),
					new Beat(31074,"J"),
					new Beat(31290,"J"),
					new Beat(31500,"K"),
					new Beat(31984,"Space"),
					new Beat(32202,"Space"),
					new Beat(32475,"Space"),
					new Beat(32682,"J"),
					new Beat(32887,"J"),
					new Beat(33109,"S"),
					new Beat(33336,"J"),
					new Beat(33810,"D"),
					new Beat(34033,"D"),
					new Beat(34271,"D"),
					new Beat(34462,"K"),
					new Beat(34657,"F"),
					new Beat(34883,"J"),
					new Beat(35106,"S"),
					new Beat(35324,"Space"),
					new Beat(35989,"Space"),
					new Beat(36715,"K"),
					new Beat(36914,"K"),
					new Beat(37125,"D"),
					new Beat(37787,"L"),
					new Beat(38455,"S"),
					new Beat(38707,"S"),
					new Beat(38925,"K"),
					new Beat(39386,"D"),
					new Beat(39605,"K"),
					new Beat(40458,"S"),
					new Beat(40798,"J"),
					new Beat(41196,"J"),
					new Beat(41601,"J"),
					new Beat(41956,"J"),
					new Beat(42303,"J"),
					new Beat(42827,"K"),
					new Beat(43153,"K"),
					new Beat(43386,"S"),
					new Beat(43597,"K"),
					new Beat(43848,"K"),
					new Beat(44059,"K"),
					new Beat(44485,"D"),
					new Beat(44699,"K"),
					new Beat(44943,"K"),
					new Beat(45182,"S"),
					new Beat(45423,"L"),
					new Beat(45642,"L"),
					new Beat(45856,"L"),
					new Beat(46298,"K"),
					new Beat(46587,"S"),
					new Beat(46759,"K"),
					new Beat(46987,"D"),
					new Beat(47184,"J"),
					new Beat(47443,"J"),
					new Beat(47659,"J"),
					new Beat(48077,"K"),
					new Beat(48311,"K"),
					new Beat(48530,"K"),
					new Beat(48779,"F"),
					new Beat(49006,"K"),
					new Beat(49246,"K"),
					new Beat(49430,"K"),
					new Beat(49649,"S"),
					new Beat(50311,"K"),
					new Beat(51032,"D"),
					new Beat(51265,"D"),
					new Beat(51486,"L"),
					new Beat(52180,"S"),
					new Beat(52841,"K"),
					new Beat(53037,"K"),
					new Beat(53260,"D"),
					new Beat(53738,"K"),
					new Beat(53961,"F"),
					new Beat(54868,"J"),
					new Beat(55082,"S"),
					new Beat(55491,"K"),
					new Beat(55951,"D"),
					new Beat(56356,"L"),
					new Beat(56829,"F"),
					new Beat(57294,"K"),
					new Beat(57772,"K"),
					new Beat(58222,"K"),
					new Beat(58668,"S"),
					new Beat(59123,"J"),
					new Beat(59539,"D"),
					new Beat(59982,"S"),
					new Beat(60432,"K"),
					new Beat(60875,"K"),
					new Beat(61329,"K"),
					new Beat(61768,"K"),
					new Beat(62026,"S"),
					new Beat(62229,"L"),
					new Beat(62649,"D"),
					new Beat(63095,"K"),
					new Beat(63514,"F"),
					new Beat(63981,"J"),
					new Beat(64330,"J"),
					new Beat(64663,"Space"),
					new Beat(64916,"Space"),
					new Beat(65260,"Space"),
					new Beat(65565,"K"),
					new Beat(65798,"D"),
					new Beat(66149,"J"),
					new Beat(66715,"S"),
					new Beat(67056,"S"),
					new Beat(67363,"L"),
					new Beat(67570,"D"),
					new Beat(68031,"K"),
					new Beat(68497,"D"),
					new Beat(68836,"D"),
					new Beat(69202,"K"),
					new Beat(69426,"D"),
					new Beat(69858,"K"),
					new Beat(70286,"F"),
					new Beat(70710,"J"),
					new Beat(71177,"S"),
					new Beat(71624,"L"),
					new Beat(72061,"D"),
					new Beat(72472,"K"),
					new Beat(72963,"F"),
					new Beat(73392,"J"),
					new Beat(73858,"S"),
					new Beat(74285,"Space"),
					new Beat(74759,"J"),
					new Beat(75453,"K"),
					new Beat(75680,"D"),
					new Beat(76126,"K"),
					new Beat(76313,"D"),
					new Beat(76895,"L"),
					new Beat(77130,"S"),
					new Beat(77870,"K"),
					new Beat(78349,"D"),
					new Beat(78656,"D"),
					new Beat(78994,"D"),
					new Beat(79248,"D"),
					new Beat(79557,"K"),
					new Beat(79865,"D"),
					new Beat(80113,"L"),
					new Beat(80461,"L"),
					new Beat(81034,"S"),
					new Beat(81369,"S"),
					new Beat(81717,"K"),
					new Beat(81906,"S"),
					new Beat(82319,"K"),
					new Beat(82795,"L"),
					new Beat(83199,"L"),
					new Beat(83713,"D"),
					new Beat(84153,"K"),
					new Beat(84607,"S"),
					new Beat(85050,"J"),
					new Beat(85460,"D"),
					new Beat(85887,"K"),
					new Beat(86205,"S"),
					new Beat(86436,"K"),
					new Beat(86553,"K"),
					new Beat(87382,"S"),
					new Beat(87660,"J"),
					new Beat(87974,"D"),
					new Beat(88239,"K"),
					new Beat(88396,"K"),
					new Beat(89129,"S"),
					new Beat(89416,"K"),
					new Beat(89738,"D"),
					new Beat(89973,"J"),
					new Beat(90107,"J"),
					new Beat(90914,"S"),
					new Beat(91213,"K"),
					new Beat(91526,"D"),
					new Beat(91796,"L"),
					new Beat(92109,"S"),
					new Beat(92427,"J"),
					new Beat(92694,"D"),
					new Beat(93007,"K"),
					new Beat(93308,"F"),
					new Beat(93570,"J"),
					new Beat(93725,"J"),
					new Beat(94452,"Space"),
					new Beat(94759,"K"),
					new Beat(95053,"S"),
					new Beat(95278,"J"),
					new Beat(95631,"Space"),
					new Beat(95974,"J"),
					new Beat(96192,"S"),
					new Beat(96577,"D"),
					new Beat(96844,"F"),
					new Beat(97143,"L"),
					new Beat(97231,"K"),
					new Beat(97664,"S"),
					new Beat(97871,"K"),
					new Beat(98171,"D"),
					new Beat(98493,"J"),
					new Beat(98909,"F"),
					new Beat(99322,"K"),
					new Beat(99800,"S"),
					new Beat(100138,"K"),
					new Beat(100463,"K"),
					new Beat(100702,"D"),
					new Beat(100802,"K"),
					new Beat(101611,"F"),
					new Beat(101955,"J"),
					new Beat(102270,"S"),
					new Beat(102536,"L"),
					new Beat(102630,"D"),
					new Beat(102986,"K"),
					new Beat(103199,"F"),
					new Beat(103421,"J"),
					new Beat(103752,"Space"),
					new Beat(104099,"Space"),
					new Beat(104345,"K"),
					new Beat(104443,"S"),
					new Beat(105197,"J"),
					new Beat(105504,"D"),
					new Beat(105827,"K"),
					new Beat(106053,"F"),
					new Beat(106404,"L"),
					new Beat(106727,"S"),
					new Beat(106988,"K"),
					new Beat(107334,"K"),
					new Beat(107624,"K"),
					new Beat(107892,"D"),
					new Beat(107995,"K"),
					new Beat(108766,"S"),
					new Beat(109097,"L"),
					new Beat(109434,"D"),
					new Beat(109668,"K"),
					new Beat(109993,"F"),
					new Beat(110360,"J"),
					new Beat(110578,"K"),
					new Beat(110869,"K"),
					new Beat(111201,"K"),
					new Beat(111478,"S"),
					new Beat(111586,"K"),
					new Beat(111976,"D"),
					new Beat(112202,"J"),
					new Beat(114635,"K"),
					new Beat(114852,"K"),
					new Beat(115094,"D"),
					new Beat(115270,"K"),
					new Beat(115493,"K"),
					new Beat(115697,"K"),
					new Beat(116186,"L"),
					new Beat(116410,"L"),
					new Beat(116653,"L"),
					new Beat(116863,"K"),
					new Beat(117052,"K"),
					new Beat(117271,"J"),
					new Beat(117471,"K"),
					new Beat(117998,"S"),
					new Beat(118444,"K"),
					new Beat(118672,"D"),
					new Beat(118899,"L"),
					new Beat(119095,"L"),
					new Beat(119314,"L"),
					new Beat(119801,"F"),
					new Beat(120216,"J"),
					new Beat(120447,"S"),
					new Beat(120686,"K"),
					new Beat(120915,"D"),
					new Beat(121112,"J"),
					new Beat(121357,"Space"),
					new Beat(122023,"Space"),
					new Beat(122747,"S"),
					new Beat(122979,"S"),
					new Beat(123193,"K"),
					new Beat(123884,"K"),
					new Beat(124485,"D"),
					new Beat(124728,"L"),
					new Beat(124968,"F"),
					new Beat(125418,"K"),
					new Beat(125654,"S"),
					new Beat(125877,"J"),
					new Beat(126566,"D"),
					new Beat(126771,"K"),
					new Beat(127206,"F"),
					new Beat(127586,"J"),
					new Beat(128060,"Space"),
					new Beat(128544,"S"),
					new Beat(128979,"K"),
					new Beat(129389,"K"),
					new Beat(129819,"K"),
					new Beat(130305,"D"),
					new Beat(130750,"S"),
					new Beat(131180,"L"),
					new Beat(131616,"D"),
					new Beat(132040,"K"),
					new Beat(132744,"S"),
					new Beat(132945,"K"),
					new Beat(133492,"D"),
					new Beat(133689,"J"),
					new Beat(134314,"Space"),
					new Beat(134521,"J"),
					new Beat(135123,"F"),
					new Beat(135643,"K"),
					new Beat(135991,"K"),
					new Beat(136306,"J"),
					new Beat(136549,"K"),
					new Beat(136887,"S"),
					new Beat(137234,"S"),
					new Beat(137446,"L"),
					new Beat(137796,"L"),
					new Beat(138196,"D"),
					new Beat(138343,"K"),
					new Beat(138688,"S"),
					new Beat(139041,"S"),
					new Beat(139248,"L"),
					new Beat(139684,"D"),
					new Beat(140121,"K"),
					new Beat(140583,"K"),
					new Beat(140842,"F"),
					new Beat(141053,"J"),
					new Beat(141488,"S"),
					new Beat(141901,"K"),
					new Beat(142325,"D"),
					new Beat(142803,"L"),
					new Beat(143170,"L"),
					new Beat(143464,"L"),
					new Beat(143757,"S"),
					new Beat(143855,"L"),
					new Beat(144621,"D"),
					new Beat(144960,"D"),
					new Beat(145295,"D"),
					new Beat(145525,"K"),
					new Beat(145621,"D"),
					new Beat(146395,"J"),
					new Beat(146676,"J"),
					new Beat(147004,"J"),
					new Beat(147283,"F"),
					new Beat(147372,"J"),
					new Beat(148171,"Space"),
					new Beat(148479,"Space"),
					new Beat(148827,"Space"),
					new Beat(149084,"Space"),
					new Beat(149424,"L"),
					new Beat(149755,"K"),
					new Beat(150003,"S"),
					new Beat(150306,"S"),
					new Beat(150608,"S"),
					new Beat(150869,"K"),
					new Beat(150969,"D"),
					new Beat(151818,"J"),
					new Beat(152122,"F"),
					new Beat(152396,"K"),
					new Beat(152636,"L"),
					new Beat(152990,"S"),
					new Beat(153303,"K"),
					new Beat(153538,"D"),
					new Beat(153873,"J"),
					new Beat(154185,"J"),
					new Beat(154449,"Space"),
					new Beat(154571,"J"),
					new Beat(155272,"F"),
					new Beat(155812,"K"),
					new Beat(156233,"D"),
					new Beat(156664,"L"),
					new Beat(157100,"S"),
					new Beat(157472,"K"),
					new Beat(157779,"K"),
					new Beat(158056,"D"),
					new Beat(158141,"K"),
					new Beat(158835,"F"),
					new Beat(158993,"J"),
					new Beat(159299,"S"),
					new Beat(159575,"K"),
					new Beat(159835,"D"),
					new Beat(160167,"L"),
					new Beat(160508,"L"),
					new Beat(160723,"F"),
					new Beat(161042,"L"),
					new Beat(161392,"L"),
					new Beat(161647,"S"),
					new Beat(161769,"L"),
					new Beat(162529,"D"),
					new Beat(162848,"K"),
					new Beat(163186,"F"),
					new Beat(163419,"L"),
					new Beat(163789,"S"),
					new Beat(164102,"K"),
					new Beat(164347,"Space"),
					new Beat(164655,"Space"),
					new Beat(164967,"Space"),
					new Beat(165217,"J"),
					new Beat(165311,"D"),
					new Beat(166139,"K"),
					new Beat(166419,"S"),
					new Beat(166743,"K"),
					new Beat(166967,"D"),
					new Beat(167308,"L"),
					new Beat(167638,"F"),
					new Beat(167860,"K"),
					new Beat(168218,"K"),
					new Beat(168521,"K"),
					new Beat(168777,"S"),
					new Beat(168881,"K"),
					new Beat(169284,"D"),
					new Beat(169496,"K"),
					new Beat(172976,"K"),
					new Beat(173218,"K"),
					new Beat(173612,"L"),
					new Beat(173861,"K"),
					new Beat(175036,"S"),
					new Beat(176790,"D"),
					new Beat(178552,"S"),
					new Beat(180219,"F"),
					new Beat(180488,"K"),
					new Beat(180847,"S"),
					new Beat(181221,"S"),
					new Beat(182307,"L"),
					new Beat(183135,"S"),
					new Beat(184071,"K"),	
			};
		}
		//Ditto 기타 이지모드 노트
		else if(titleName.equals("Ditto-NewJeans") &&instrumentType.equals("guitar") && difficulty.equals("Easy")) {
			int startTime = 1000 - Main.REACH_TIME;
			beats = new Beat[] {
				new Beat(startTime,"Space"),	
			};
		}
		//Ditto 기타 하드모드 노트
		else if(titleName.equals("Ditto-NewJeans") &&instrumentType.equals("guitar") && difficulty.equals("Hard")) {
			int startTime = 1000 - Main.REACH_TIME;
			beats = new Beat[] {
				new Beat(startTime,"Space"),	
			};
		}
		//사건의 지평선 피아노 이지모드 노트
		else if(titleName.equals("EndTheory-YOUNHA") &&instrumentType.equals("piano") && difficulty.equals("Easy")) {
			int startTime = 1000 - Main.REACH_TIME;
			beats = new Beat[] {
				new Beat(startTime,"Space"),	
			};
		}
		//사건의 지평선 피아노 하드모드 노트
		else if(titleName.equals("EndTheory-YOUNHA") &&instrumentType.equals("piano") && difficulty.equals("Hard")) {
			int startTime = 1000 - Main.REACH_TIME;
			beats = new Beat[] {
				new Beat(startTime,"Space"),	
			};
		}
		//사건의 지평선 바이올린 이지모드 노트
		else if(titleName.equals("EndTheory-YOUNHA") &&instrumentType.equals("violin") && difficulty.equals("Easy")) {
			int startTime = 1000 - Main.REACH_TIME;
			beats = new Beat[] {
				new Beat(startTime,"Space"),	
			};
		}
		//사건의 지평선 바이올린 하드모드 노트
		else if(titleName.equals("EndTheory-YOUNHA") &&instrumentType.equals("violin") && difficulty.equals("Hard")) {
			int startTime = 1000 - Main.REACH_TIME;
			beats = new Beat[] {
				new Beat(startTime,"Space"),	
			};
		}
		//사건의 지평선 기타 이지모드 노트
		else if(titleName.equals("EndTheory-YOUNHA") &&instrumentType.equals("guitar") && difficulty.equals("Easy")) {
			int startTime = 1000 - Main.REACH_TIME;
			beats = new Beat[] {
				new Beat(startTime,"Space"),	
			};
		}
		//사건의 지평선 기타 하드모드 노트
		else if(titleName.equals("EndTheory-YOUNHA") &&instrumentType.equals("guitar") && difficulty.equals("Hard")) {
			int startTime = 1000 - Main.REACH_TIME;
			beats = new Beat[] {
				new Beat(startTime,"Space"),	
			};
		}
		//봄여름가을겨울 피아노 이지모드 노트
		else if(titleName.equals("Still Life-BIGBANG") &&instrumentType.equals("piano") && difficulty.equals("Easy")) {
			int startTime = 1000 - Main.REACH_TIME;
			beats = new Beat[] {
				new Beat(startTime,"Space"),	
			};
		}
		//봄여름가을겨울 피아노 하드모드 노트
		else if(titleName.equals("Still Life-BIGBANG") &&instrumentType.equals("piano") && difficulty.equals("Hard")) {
			int startTime = 1000 - Main.REACH_TIME;
			beats = new Beat[] {
				new Beat(startTime,"Space"),	
			};
		}
		//봄여름가을겨울 바이올린 이지모드 노트
		else if(titleName.equals("Still Life-BIGBANG") &&instrumentType.equals("violin") && difficulty.equals("Easy")) {
			int startTime = 1000 - Main.REACH_TIME;
			beats = new Beat[] {
				new Beat(startTime,"Space"),	
			};
		}
		//봄여름가을겨울 바이올린 하드모드 노트
		else if(titleName.equals("Still Life-BIGBANG") &&instrumentType.equals("violin") && difficulty.equals("Hard")) {
			int startTime = 1000 - Main.REACH_TIME;
			beats = new Beat[] {
				new Beat(startTime,"Space"),	
			};
		}
		//봄여름가을겨울 기타 이지모드 노트
		else if(titleName.equals("Still Life-BIGBANG") &&instrumentType.equals("guitar") && difficulty.equals("Easy")) {
			int startTime = 1000 - Main.REACH_TIME;
			beats = new Beat[] {
				new Beat(startTime,"Space"),	
			};
		}
		//봄여름가을겨울 기타 하드모드 노트
		else if(titleName.equals("Still Life-BIGBANG") &&instrumentType.equals("guitar") && difficulty.equals("Hard")) {
			int startTime = 1000 - Main.REACH_TIME;
			beats = new Beat[] {
				new Beat(startTime,"Space"),	
			};
		}
		
		int i=0;
		gameMusic.start();
		while(i<beats.length && !isInterrupted()) {
			boolean dropped =false;
			if(beats[i].getTime() <= gameMusic.getTime()) {
				Note note = new Note(beats[i].getNoteName());
				note.start();
				noteList.add(note);
				i++;
				dropped = true;
			}
			if(!dropped) {
				try {
					Thread.sleep(5);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	public void judge(String input) {
		for(int i=0; i< noteList.size();i++) {
			Note note = noteList.get(i);
			if(input.equals(note.getNoteType())) {
				judgeEvent(note.judge());
				break;
			}
		}
	}
	
	public void charecterType(String instrumentType) {
		if(instrumentType.equals("piano")) {
			charecterImage = new ImageIcon(Main.class.getResource("../images/piano_charecter.png")).getImage();
		}
		else if(instrumentType.equals("violin")) {
			charecterImage = new ImageIcon(Main.class.getResource("../images/violin_charecter.png")).getImage();
		}
		else if(instrumentType.equals("guitar")) {
			charecterImage = new ImageIcon(Main.class.getResource("../images/guitar_charecter.png")).getImage();
		}
	}
	
	public void judgeEvent(String judge) {
		if(!judge.equals("None")) {
			blueFlareImage = new ImageIcon(Main.class.getResource("../images/blueFlare.png")).getImage();
		}
		if(judge.equals("Late")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgeLate.png")).getImage();
			combo += 1;
		}
		else if(judge.equals("Good")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgeGood.png")).getImage();
			score += 100;
			combo += 1;
			comboEvent();
		}
		else if(judge.equals("Great")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgeGreat.png")).getImage();
			score += 300;
			combo += 1;
			comboEvent();
		}
		else if(judge.equals("Perfect")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgePerfect.png")).getImage();
			score += 500;
			combo += 1;
			comboEvent();
		}
		else if(judge.equals("Early")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgeEarly.png")).getImage();
			combo += 1;
		}
	}
	public void comboEvent() {
		if(combo >= 10 && combo < 30) {
			score += 50;
		}else if (combo >= 30 && combo < 50) {
			score += 100;
		}else if (combo >= 50) {
			score += 200;
		}
	}
}
