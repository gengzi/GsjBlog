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
    
    /**
     * 根据tag获取，该标签下的所有文章id
     * @param labeltype 
     * @return
     */
    List<Integer> getArticleIdByTagname(String labeltype);
    
    /**
     *  获取最多出现的 tagname ，前 8 个
     * @return
     */
    List<String> getTagsOnlyByTagname();
}