package spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class MemberDao {
    
    private JdbcTemplate jdbcTemplate;
    private static long nextId = 0;
    
    private Map<String, Member> map = new HashMap<>();
    
    public MemberDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    public Member selectByEmail(String email) {
        List<Member> results = jdbcTemplate.query("select * from MEMBER where EMAIL = ?", 
                                                    new RowMapper<Member>() {
                                                        @Override
                                                        public Member mapRow(ResultSet rs, int worNum) throws SQLException {
                                                            Member member = new Member(rs.getString("EMAIL"), 
                                                                                       rs.getString("PASSWORD"),
                                                                                       rs.getString("NAME"),
                                                                                       rs.getTimestamp("REGDATE"));
                                                            member.setId(rs.getLong("ID"));
                                                            return member;
                                                        }
        }, email);
        
        return results.isEmpty() ? null : results.get(0);
    }
    
    public void insert(Member member) {
        // TODO : 구현필요
    }

    public void update(Member member) {
        // TODO : 구현필요
    }
    
    public List<Member> selectAll(){
        List<Member> result = jdbcTemplate.query("select * from MEMBER", 
        										new RowMapper <Member>() {
        	
        										}
        )
    }
}
