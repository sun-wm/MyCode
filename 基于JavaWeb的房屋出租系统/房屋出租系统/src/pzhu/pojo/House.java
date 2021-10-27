package pzhu.pojo;

public class House {
	 private int Sno;
	 private String Sex;
	 private String Dept;
	 private int Classno;
	public int getSno() {
		return Sno;
	}
	public void setSno(int sno) {
		Sno = sno;
	}
	public String getSex() {
		return Sex;
	}
	public void setSex(String sex) {
		Sex = sex;
	}
	public String getDept() {
		return Dept;
	}
	public void setDept(String dept) {
		Dept = dept;
	}
	public int getClassno() {
		return Classno;
	}
	public void setClassno(int classno) {
		Classno = classno;
	}
	public House(int sno, String sex, String dept, int classno) {
		super();
		Sno = sno;
		Sex = sex;
		Dept = dept;
		Classno = classno;
	}
	public House() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Classno;
		result = prime * result + ((Dept == null) ? 0 : Dept.hashCode());
		result = prime * result + ((Sex == null) ? 0 : Sex.hashCode());
		result = prime * result + Sno;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		House other = (House) obj;
		if (Classno != other.Classno)
			return false;
		if (Dept == null) {
			if (other.Dept != null)
				return false;
		} else if (!Dept.equals(other.Dept))
			return false;
		if (Sex == null) {
			if (other.Sex != null)
				return false;
		} else if (!Sex.equals(other.Sex))
			return false;
		if (Sno != other.Sno)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "House [Sno=" + Sno + ", Sex=" + Sex + ", Dept=" + Dept
				+ ", Classno=" + Classno + "]";
	}
	
	 
}
