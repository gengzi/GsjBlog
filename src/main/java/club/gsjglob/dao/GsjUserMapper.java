package club.gsjglob.dao;

import club.gsjglob.domain.GsjUser;
import club.gsjglob.domain.GsjUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GsjUserMapper {
    int countByExample(GsjUserExample example);

    int deleteByExample(GsjUserExample example);

    int deleteByPrimaryKey(Integer userid);

    int insert(GsjUser record);

    int insertSelective(GsjUser record);

    List<GsjUser> selectByExample(GsjUserExample example);

    GsjUser selectByPrimaryKey(Integer userid);

    int updateByExampleSelective(@Param("record") GsjUser record, @Param("example") GsjUserExample example);

    int updateByExample(@Param("record") GsjUser record, @Param("example") GsjUserExample example);

    int updateByPrimaryKeySelective(GsjUser record);

    int updateByPrimaryKey(GsjUser record);
}