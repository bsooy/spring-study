package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import javax.annotation.Resource;

public class MemberInfoPrinter {

	//@Autowired(required=false)
	@Resource(name="memberDao")
	private MemberDao memDao;
	private MemberPrinter printer;
	
	//설정메서드 주입
	public void setMemberDao(MemberDao memberDao) {
		this.memDao = memberDao;
	}
	
	//@Autowired
	//@Qualifier("sysout")
	@Resource(name="memberPrinter")
	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
	}
	
	public void printMemberInfo(String email) {
		Member member = memDao.selectByEmail(email);
		if(member == null) {
			System.out.println("데이터 없음\n");
			return;
		}
		
		printer.print(member);
		System.out.println();
	}

}
