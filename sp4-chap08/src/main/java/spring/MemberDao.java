package spring;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MemberDao {
	
	private static long nextId = 0;
	
	private Map<String, Member> map = new HashMap<>();
	
	public Member selectByEmail(String email) {
		// TODO : 구현필요
		return null;
	}
	
	public void insert(Member member) {
		// TODO : 구현필요
	}

	public void update(Member member) {
		// TODO : 구현필요
	}
	
	public Collection<Member> selectAll(){
		// TODO : 구현필요
		return null;
	}
}
