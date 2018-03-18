package club.gsjglob.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.support.json.JSONUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import club.gsjglob.dao.GsjFolderMapper;
import club.gsjglob.domain.GsjFolder;
import club.gsjglob.domain.GsjFolderExample;
import club.gsjglob.domain.GsjFolderExample.Criteria;
import club.gsjglob.service.IFolderService;


@Service
public class FolderServiceImpl implements IFolderService {

	@Autowired
	private GsjFolderMapper folderdao;
	private String folderjson;
	
	
	/**
	 * 根据类型返回目录信息
	 * @throws JsonProcessingException 
	 */
	@Override
	public String getFolderInfo(String type) throws JsonProcessingException {
		
		switch (type) {
		case "index": //主页
			// 查询key是 index的目录信息
			GsjFolderExample example = new GsjFolderExample();
			Criteria criteria = example.createCriteria();
			criteria.andKeyEqualTo("index");
			criteria.andParentIdEqualTo(0);
			List<GsjFolder> indexFolders = folderdao.selectByExample(example);
			GsjFolderExample indexexample = null;
			List<GsjFolder> jsonList = new ArrayList<GsjFolder>();
			for (GsjFolder gsjFolder : indexFolders) {
				Integer id = gsjFolder.getId();
				indexexample = new GsjFolderExample(); 
				indexexample.createCriteria().andParentIdEqualTo(id);
				List<GsjFolder> subList = folderdao.selectByExample(indexexample);
				gsjFolder.setSubsetlist(subList);
				jsonList.add(gsjFolder);
			}
			ObjectMapper mapper = new ObjectMapper();
			folderjson = mapper.writeValueAsString(jsonList);
			System.out.println(folderjson);
			break;

		default:
			break;
		}
		return folderjson;
	}

}
