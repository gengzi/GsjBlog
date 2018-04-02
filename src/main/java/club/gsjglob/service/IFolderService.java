package club.gsjglob.service;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * 目录管理service
 * @author gengzi
 * @time 2018年3月17日15:48:05
 *
 */
public interface IFolderService {
	/**
	 *  加载目录信息
	 * @param type 
	 * @return
	 * @throws JsonProcessingException
	 */
	String getFolderInfo(String type) throws JsonProcessingException;

	/**
	 * 根据id修改目录的名称
	 * @param id 唯一编号
	 * @param name 目录名称
	 * @return
	 */
	String updateFolderById(String id, String name,String parnetid ,String key);

}
