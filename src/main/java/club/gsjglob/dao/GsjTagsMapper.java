package club.gsjglob.dao;

import club.gsjglob.domain.GsjTags;
import club.gsjglob.domain.GsjTagsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GsjTagsMapper {
    int countByExample(GsjTagsExample example);

    int deleteByExample(GsjTagsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GsjTags record);

    int insertSelective(GsjTags record);

    List<GsjTags> selectByExample(GsjTagsExample example);

    GsjTags selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GsjTags record, @Param("example") GsjTagsExample example);

    int updateByExample(@Param("record") GsjTags record, @Param("example") GsjTagsExample example);

    int updateByPrimaryKeySelective(GsjTags record);

    int updateByPrimaryKey(GsjTags record);
    
    List<Integer> getArticleIdByTagname(String labeltype);
}