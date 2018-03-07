package club.gsjglob.dao.mapper;

import club.gsjglob.domain.User;
import club.gsjglob.domain.UserExample;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends Mapper<User>{
	
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}