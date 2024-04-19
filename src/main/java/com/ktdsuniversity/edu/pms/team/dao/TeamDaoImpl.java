package com.ktdsuniversity.edu.pms.team.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktdsuniversity.edu.pms.team.vo.TeamListVO;
import com.ktdsuniversity.edu.pms.team.vo.TeamVO;

@Repository
public class TeamDaoImpl extends SqlSessionDaoSupport implements TeamDao{

	
	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public int createNewTeam(TeamVO teamVO) {
		return getSqlSession().insert(TeamDao.NAME_SPACE + ".createNewTeam", teamVO);
	}

	@Override
	public TeamVO getOneTeam(String teamId) {
		return getSqlSession().selectOne(TeamDao.NAME_SPACE + ".getOneTeam", teamId);
	}

	@Override
	public int updateOneTeam(TeamVO teamVO) {
		return getSqlSession().update(TeamDao.NAME_SPACE + ".updateOneTeam", teamVO);
	}

	@Override
	public List<TeamVO> getOnlyTeam() {
		return getSqlSession().selectList(TeamDao.NAME_SPACE + ".getOnlyTeam");
	}

	@Override
	public List<TeamVO> getAllTeamList(String deptId) {
		return getSqlSession().selectList(TeamDao.NAME_SPACE + ".getAllTeamList", deptId);
	}

	
}
