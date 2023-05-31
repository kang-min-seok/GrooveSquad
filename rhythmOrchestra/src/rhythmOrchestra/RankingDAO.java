package rhythmOrchestra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class RankingDAO {
	private Connection conn;
	private ResultSet rs;

	public RankingDAO() {
		try {
			String dbURL = "jdbc:mysql://58.232.79.151:3306/mysql05";
			String dbID = "root";
			String dbPassword = "kbc0924";
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// rankID 매기기
	public int getNext() {
		String SQL = "SELECT rankID FROM RANKING ORDER BY rankID DESC";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1) + 1;
			}
			return 1; // 첫 번째 게시물인 경우
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // 데이터베이스 오류
	}

	// 랭킹 등록 함수
	public int rankingWrite(String songInfo, String instrumentInfo, int score, String difficulty, String userID) {
		String SQL = "INSERT INTO RANKING VALUES (?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, getNext());
			pstmt.setString(2, songInfo);
			pstmt.setString(3, instrumentInfo);
			pstmt.setInt(4, score);
			pstmt.setString(5, difficulty);
			pstmt.setString(6, userID);

			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // 데이터베이스 오류
	}

	// 랭킹정보 가져와서 ArrayList에 저장하는 함수
	public ArrayList<Ranking> getList(String songInfo, String instrumentInfo, String difficulty) {
		String SQL = "SELECT * FROM RANKING WHERE songInfo = ? AND instrumentInfo = ? AND difficulty = ?";
		ArrayList<Ranking> list = new ArrayList<Ranking>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, songInfo);
			pstmt.setString(2, instrumentInfo);
			pstmt.setString(3, difficulty);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Ranking ranking = new Ranking();
				ranking.setRankID(rs.getInt(1));
				ranking.setSongInfo(rs.getString(2));
				ranking.setInstrumentInfo(rs.getString(3));
				ranking.setScore(rs.getInt(4));
				ranking.setDifficulty(rs.getString(5));
				ranking.setUserID(rs.getString(6));
				list.add(ranking);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// 노래 최고기록 가져오는 함수
	public ArrayList<Ranking> getHighScore(String songInfo, String instrumentInfo, String difficulty, String userID) {
		String SQL = "SELECT * FROM RANKING WHERE songInfo = ? AND instrumentInfo = ? AND difficulty = ? AND userID = ?";
		ArrayList<Ranking> list = new ArrayList<Ranking>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, songInfo);
			pstmt.setString(2, instrumentInfo);
			pstmt.setString(3, difficulty);
			pstmt.setString(4, userID);
			rs = pstmt.executeQuery();
			
		
			while (rs.next()) {
				Ranking ranking = new Ranking();
				ranking.setRankID(rs.getInt(1));
				ranking.setSongInfo(rs.getString(2));
				ranking.setInstrumentInfo(rs.getString(3));
				ranking.setScore(rs.getInt(4));
				ranking.setDifficulty(rs.getString(5));
				ranking.setUserID(rs.getString(6));
				list.add(ranking);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(list.size() >= 2) {
			Collections.sort(list, new Comparator<Ranking>() {
				@Override
				public int compare(Ranking r1, Ranking r2) {
					return Integer.compare(r2.getScore(), r1.getScore()); // 점수를 기준으로 내림차순 정렬
				}
			});
		}
		
		return list;
	}
	
	
	
}
