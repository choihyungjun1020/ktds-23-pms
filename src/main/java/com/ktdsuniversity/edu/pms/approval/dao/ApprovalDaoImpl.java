package com.ktdsuniversity.edu.pms.approval.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktdsuniversity.edu.pms.approval.vo.ApprovalVO;
import com.ktdsuniversity.edu.pms.approval.vo.SearchApprovalVO;

@Repository
public class ApprovalDaoImpl extends SqlSessionDaoSupport implements ApprovalDao {

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}

	@Override
	public int getAllCount() {
		return getSqlSession().selectOne(ApprovalDao.NAME_SPACE + ".getAllCount");
	}

	@Override
	public List<ApprovalVO> getAllApproval() {
		return getSqlSession().selectList(ApprovalDao.NAME_SPACE + ".getAllApproval");
	}

	@Override
	public int getAllCountByEmpId(String empId) {
		return getSqlSession().selectOne(ApprovalDao.NAME_SPACE + ".getAllCountByEmpId", empId);
	}

	@Override
	public List<ApprovalVO> getAllApprovalByEmpId(String empId) {
		return getSqlSession().selectList(ApprovalDao.NAME_SPACE + ".getAllApprovalByEmpId", empId);
	}

	@Override
	public ApprovalVO selectOneApproval(String apprId) {
		return getSqlSession().selectOne(ApprovalDao.NAME_SPACE + ".selectOneApproval", apprId);
	}

	@Override
	public ApprovalVO selectOneApprovalAll(String apprId) {
		return getSqlSession().selectOne(ApprovalDao.NAME_SPACE + ".selectOneApprovalAll", apprId);
	}

	// PSH0422
	@Override
	public String selectOneApprId() {
		return getSqlSession().selectOne(ApprovalDao.NAME_SPACE + ".selectOneApprId");
	}

	@Override
	public int insertApproval(ApprovalVO approvalVO) {
		return getSqlSession().insert(ApprovalDao.NAME_SPACE + ".insertApproval", approvalVO);
	}

	@Override
	public int updateApprovalStatus(ApprovalVO approvalVO) {
		return getSqlSession().update(ApprovalDao.NAME_SPACE + ".updateApprovalStatus", approvalVO);

	}
	
	@Override
	public int updateRentalStatus(ApprovalVO approvalVO) {
		return getSqlSession().update(ApprovalDao.NAME_SPACE + ".updateRentalStatus", approvalVO);
	}

	@Override
	public int deleteApproval(String apprId) {
		return getSqlSession().update(ApprovalDao.NAME_SPACE + ".deleteApproval", apprId);
	}
	
	// PSH - search
	@Override
	public int searchApprAllCount(SearchApprovalVO searchApprovalVO) {
		return getSqlSession().selectOne(ApprovalDao.NAME_SPACE + ".searchApprAllCount", searchApprovalVO);
	}
	
	@Override
	public List<ApprovalVO> searchAllApproval(SearchApprovalVO searchApprovalVO) {
		return getSqlSession().selectList(ApprovalDao.NAME_SPACE + ".searchAllApproval", searchApprovalVO);
	}

	@Override
	public int getAllApproveCount() {
		return getSqlSession().selectOne(ApprovalDao.NAME_SPACE + ".getAllApproveCount");
	}

	@Override
	public int getAllOneWeekApprovalCount() {
		return getSqlSession().selectOne(ApprovalDao.NAME_SPACE + ".getAllOneWeekApprovalCount");
	}

	@Override
	public int getAllMonthApprovalCount() {
		return getSqlSession().selectOne(ApprovalDao.NAME_SPACE + ".getAllMonthApprovalCount");
	}

	@Override
	public int updateApproval(String id) {
		return getSqlSession().update(ApprovalDao.NAME_SPACE + ".updateApproval", id);
	}

	@Override
	public int searchBoardAllCount(ApprovalVO approvaVo) {
		return getSqlSession().selectOne(ApprovalDao.NAME_SPACE + ".searchBoardAllCount", approvaVo);
	}

	@Override
	public List<ApprovalVO> searchAllBoard(ApprovalVO approvaVo) {
		return getSqlSession().selectList(ApprovalDao.NAME_SPACE + ".searchAllBoard", approvaVo);
	}

	@Override
	public int selectAllApprovalCount(String id) {
		return getSqlSession().selectOne(ApprovalDao.NAME_SPACE + ".selectAllApprovalCount", id);
	}

	@Override
	public List<ApprovalVO> searchBoard(SearchApprovalVO searchapprovalvo) {
		return getSqlSession().selectList(ApprovalDao.NAME_SPACE + ".searchBoard", searchapprovalvo);
	}

}
