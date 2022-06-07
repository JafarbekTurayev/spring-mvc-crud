package uz.pdp.repository;


import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import uz.pdp.entity.Group;

import java.util.List;



@Controller
public class GroupRepository {
    JdbcTemplate jdbcTemplate;
    public Integer findByName(String name) {
        return jdbcTemplate.queryForObject("select * from groups  where groups_name = ?",BeanPropertyRowMapper.newInstance(Group.class),name).getId();
    }
    public  List<Group> readGroup(){
        return jdbcTemplate.query("select * from groups", BeanPropertyRowMapper.newInstance(Group.class));
    }
    public int create(Group group) {
        return jdbcTemplate.update("insert into groups (groups_name) values (?)",group.getGroups_name());
    }
    public List<Group> findById(Integer id) {
        return jdbcTemplate.query("select * from groups where id=?", BeanPropertyRowMapper.newInstance(Group.class), id);
    }
    public int update(Group group) {
        return jdbcTemplate.update("update groups set groups_name=? where id =?",group.getGroups_name(),group.getId());
    }
    public int delete(Integer id) {
        return  jdbcTemplate.update("delete from groups where id=?", id);
    }


}
