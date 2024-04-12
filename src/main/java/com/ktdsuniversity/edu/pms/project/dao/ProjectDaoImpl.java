package com.ktdsuniversity.edu.pms.project.dao;

import com.ktdsuniversity.edu.pms.project.vo.CreateProjectVO;
import com.ktdsuniversity.edu.pms.project.vo.ProjectTeammateVO;
import com.ktdsuniversity.edu.pms.project.vo.ProjectVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectDaoImpl extends SqlSessionDaoSupport implements ProjectDao {

    @Autowired
    @Override
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    @Override
    public List<ProjectVO> selectAllProject() {
        return getSqlSession().selectList(ProjectDao.NAME_SPACE + ".selectAllProject");
    }

    @Override
    public int selectAllProjectCount() {
        return getSqlSession().selectOne(ProjectDao.NAME_SPACE + ".selectAllProjectCount");
    }

    @Override
    public ProjectVO findById(String projectId) {
        return getSqlSession().selectOne(ProjectDao.NAME_SPACE + ".findById", projectId);
    }

    @Override
    public int insertNewProject(CreateProjectVO projectVO) {
        return getSqlSession().insert(ProjectDao.NAME_SPACE + ".insertNewProject", projectVO);
    }

    @Override
    public int insertNewPm(ProjectTeammateVO pm) {
        return getSqlSession().insert(ProjectDao.NAME_SPACE + ".insertNewPm", pm);
    }

    @Override
    public int deleteById(String projectId) {
        return getSqlSession().update(ProjectDao.NAME_SPACE + ".deleteById", projectId);
    }
}