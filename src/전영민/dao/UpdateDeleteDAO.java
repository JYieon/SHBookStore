package 전영민.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.DBConnect;
import 전영민.dto.UpdateDeleteDTO;

public class UpdateDeleteDAO {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	public UpdateDeleteDAO() {
		con = DBConnect.getConnect();
	}

	public int update(UpdateDeleteDTO ud) {
		String sql = "UPDATE member SET m_pwd = ?, m_name = ?, m_addr = ?, m_phone = ? WHERE m_id = ?";
		int result = 0;

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, ud.getM_pwd());
			ps.setString(2, ud.getM_name());
			ps.setString(3, ud.getM_addr());
			ps.setString(4, ud.getM_phone());
			ps.setString(5, ud.getM_id());
			result = ps.executeUpdate();

			if (result > 0) {
				System.out.println("회원정보 수정 완료");
			}

		} catch (Exception e) {
			System.out.println("회원정보 수정 중 오류가 발생했습니다.");
			e.printStackTrace();
		}
		return result;
	}
	public int delete(String id) {
        String sql = "DELETE FROM member WHERE m_id = ?";
        int result = 0;

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            result = ps.executeUpdate();

            if (result > 0) {
                System.out.println("탈퇴 완료");
            }

        } catch (Exception e) {
            System.out.println("회원 탈퇴 중 오류가 발생했습니다.");
            e.printStackTrace();
        }
        return result;
    }
}