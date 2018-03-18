package club.gsjglob.dao;

import club.gsjglob.domain.GsjArticle;
import club.gsjglob.domain.GsjArticleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GsjArticleMapper {
    int countByExample(GsjArticleExample example);

    int deleteByExample(GsjArticleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GsjArticle record);

    int insertSelective(GsjArticle record);

    List<GsjArticle> selectByExample(GsjArticleExample example);

    GsjArticle selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GsjArticle record, @Param("example") GsjArticleExample example);

    int updateByExample(@Param("record") GsjArticle record, @Param("example") GsjArticleExample example);

    int updateByPrimaryKeySelective(GsjArticle record);

    int updateByPrimaryKey(GsjArticle record);
}