package 전영민.dto;

public class UpdateDeleteDTO {
	private String m_id,m_pwd,m_name,m_addr,m_phone;
	
	public UpdateDeleteDTO() {}
	public UpdateDeleteDTO(String m_id, String m_pwd, String m_name, String m_addr, String m_phone) {
		this.m_id = m_id; this.m_pwd = m_pwd; this.m_name = m_name; this.m_addr = m_addr; this.m_phone = m_phone;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getM_pwd() {
		return m_pwd;
	}
	public void setM_pwd(String m_pwd) {
		this.m_pwd = m_pwd;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_addr() {
		return m_addr;
	}
	public void setM_addr(String m_addr) {
		this.m_addr = m_addr;
	}
	public String getM_phone() {
		return m_phone;
	}
	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}
}