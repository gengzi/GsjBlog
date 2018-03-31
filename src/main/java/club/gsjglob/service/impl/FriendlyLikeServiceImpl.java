package club.gsjglob.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import club.gsjglob.dao.GsjFriendlylinkMapper;
import club.gsjglob.domain.GsjFriendlylink;
import club.gsjglob.domain.GsjFriendlylinkExample;
import club.gsjglob.service.IFriendlyLikeService;
import club.gsjglob.vo.ShowUrlInfo;

/**
 * 友情链接serviceimpl
 * @author gengzi
 * @time 2018年3月31日12:48:54
 *
 */
@Service
public class FriendlyLikeServiceImpl implements IFriendlyLikeService {

	@Autowired
	private GsjFriendlylinkMapper friendlylinkdao;
	
	@Override
	public List<ShowUrlInfo> selectParentInfo() {
		return  friendlylinkdao.selectByParentname();

	}

	@Override
	public List<GsjFriendlylink> selectziUrlInfo(String id) {
		if (!"".equals(id)) {
			GsjFriendlylinkExample example = new GsjFriendlylinkExample();
			example.createCriteria().andParentnameEqualTo(id);
			return friendlylinkdao.selectByExample(example);
		}
		return null;
	}

}
