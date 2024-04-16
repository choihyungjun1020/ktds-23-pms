package com.ktdsuniversity.edu.pms.requirement.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktdsuniversity.edu.pms.requirement.vo.RequirementVO;
import com.ktdsuniversity.edu.pms.requirement.vo.DelayAcessVO;

@Repository
public class RequirementDaoImpl extends SqlSessionDaoSupport implements RequirementDao{
	@Autowired
	@Override
	public void setSqlSessionTemplate
	(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}

	@Override
	public List<RequirementVO> getAllRequirement() {
		
		return getSqlSession().selectList(NAME_SPACE+".getAllRequirement");
	}

	@Override
	public RequirementVO getOneRequirement(String rqmId) {
		return getSqlSession().selectOne(NAME_SPACE+".getOneRequirement",rqmId);
	}

	@Override
	public int insertOneRequirement(RequirementVO requirementVO) {
		return getSqlSession().insert(NAME_SPACE+".insertOneRequirement",requirementVO);
	}

	@Override
	public int updateOneRequirement(RequirementVO requirementVO) {
		
		return getSqlSession().update(NAME_SPACE+".updateOneRequirement", requirementVO);
	}

	

	@Override
	public int deleteReRequirement(RequirementVO requirementVO) {
		return getSqlSession().update(NAME_SPACE+".deleteReRequirement", requirementVO);
	}
	
	
	@Override
	public int delayRequirement(RequirementVO requirementVO) {
		return getSqlSession().update(NAME_SPACE+".delayRequirement", requirementVO);
		
	}
	@Override
	public int updateDelayOneRequirement(DelayAcessVO delayAcessVO) {
		return getSqlSession().update(NAME_SPACE+".updateDelayOneRequirement", delayAcessVO);
	}

	

}
