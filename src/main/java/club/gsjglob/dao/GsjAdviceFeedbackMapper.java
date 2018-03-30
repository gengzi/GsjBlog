package club.gsjglob.dao;

import club.gsjglob.domain.GsjAdviceFeedback;
import club.gsjglob.domain.GsjAdviceFeedbackExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GsjAdviceFeedbackMapper {
    int countByExample(GsjAdviceFeedbackExample example);

    int deleteByExample(GsjAdviceFeedbackExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GsjAdviceFeedback record);

    int insertSelective(GsjAdviceFeedback record);

    List<GsjAdviceFeedback> selectByExample(GsjAdviceFeedbackExample example);

    GsjAdviceFeedback selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GsjAdviceFeedback record, @Param("example") GsjAdviceFeedbackExample example);

    int updateByExample(@Param("record") GsjAdviceFeedback record, @Param("example") GsjAdviceFeedbackExample example);

    int updateByPrimaryKeySelective(GsjAdviceFeedback record);

    int updateByPrimaryKey(GsjAdviceFeedback record);
}