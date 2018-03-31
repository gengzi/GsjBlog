package club.gsjglob.dao;

import club.gsjglob.domain.GsjFriendlylink;
import club.gsjglob.domain.GsjFriendlylinkExample;
import club.gsjglob.vo.ShowUrlInfo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GsjFriendlylinkMapper {
    int countByExample(GsjFriendlylinkExample example);

    int deleteByExample(GsjFriendlylinkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GsjFriendlylink record);

    int insertSelective(GsjFriendlylink record);

    List<GsjFriendlylink> selectByExample(GsjFriendlylinkExample example);

    GsjFriendlylink selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GsjFriendlylink record, @Param("example") GsjFriendlylinkExample example);

    int updateByExample(@Param("record") GsjFriendlylink record, @Param("example") GsjFriendlylinkExample example);

    int updateByPrimaryKeySelective(GsjFriendlylink record);

    int updateByPrimaryKey(GsjFriendlylink record);
    
    
    /**
     * 根据父网址进行查询
     * @return ShowUrlInfo
     */
    List<ShowUrlInfo> selectByParentname();
    
}