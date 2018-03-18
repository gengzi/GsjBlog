package club.gsjglob.dao;

import club.gsjglob.domain.GsjFolder;
import club.gsjglob.domain.GsjFolderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GsjFolderMapper {
    int countByExample(GsjFolderExample example);

    int deleteByExample(GsjFolderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GsjFolder record);

    int insertSelective(GsjFolder record);

    List<GsjFolder> selectByExampleWithBLOBs(GsjFolderExample example);

    List<GsjFolder> selectByExample(GsjFolderExample example);

    GsjFolder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GsjFolder record, @Param("example") GsjFolderExample example);

    int updateByExampleWithBLOBs(@Param("record") GsjFolder record, @Param("example") GsjFolderExample example);

    int updateByExample(@Param("record") GsjFolder record, @Param("example") GsjFolderExample example);

    int updateByPrimaryKeySelective(GsjFolder record);

    int updateByPrimaryKeyWithBLOBs(GsjFolder record);

    int updateByPrimaryKey(GsjFolder record);
}