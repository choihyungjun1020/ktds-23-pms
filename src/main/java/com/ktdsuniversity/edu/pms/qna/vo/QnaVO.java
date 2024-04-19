package com.ktdsuniversity.edu.pms.qna.vo;

import com.ktdsuniversity.edu.pms.employee.vo.EmployeeVO;
import com.ktdsuniversity.edu.pms.project.vo.ProjectVO;
import com.ktdsuniversity.edu.pms.requirement.vo.RequirementVO;

public class QnaVO {
	
	private String qaId;
	private String rqmId;
	private String qaTtl;
	private String qaCntnt;
	private String qaCnt;
	private String qaRecCnt;
	private String crtDt;
	private String mdfDt;
	private String delYn;
	private String crtrId;
	private String mdfrId;
	
	// file - 난독화
	private String fileName;
	// file - 난독화X
	private String originFileName;
	
	private RequirementVO requirementVO;
	
	private ProjectVO  projectVO;
	
	private EmployeeVO employeeVO;
	
	
	public String getQaId() {
		return qaId;
	}
	public void setQaId(String qaId) {
		this.qaId = qaId;
	}
	public String getRqmId() {
		return rqmId;
	}
	public void setRqmId(String rqmId) {
		this.rqmId = rqmId;
	}
	public String getQaTtl() {
		return qaTtl;
	}
	public void setQaTtl(String qaTtl) {
		this.qaTtl = qaTtl;
	}
	public String getQaCntnt() {
		return qaCntnt;
	}
	public void setQaCntnt(String qaCntnt) {
		this.qaCntnt = qaCntnt;
	}
	public String getQaCnt() {
		return qaCnt;
	}
	public void setQaCnt(String qaCnt) {
		this.qaCnt = qaCnt;
	}
	public String getQaRecCnt() {
		return qaRecCnt;
	}
	public void setQaRecCnt(String qaRecCnt) {
		this.qaRecCnt = qaRecCnt;
	}
	public String getCrtDt() {
		return crtDt;
	}
	public void setCrtDt(String crtDt) {
		this.crtDt = crtDt;
	}
	public String getMdfDt() {
		return mdfDt;
	}
	public void setMdfDt(String mdfDt) {
		this.mdfDt = mdfDt;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	public String getCrtrId() {
		return crtrId;
	}
	public void setCrtrId(String crtrId) {
		this.crtrId = crtrId;
	}
	public String getMdfrId() {
		return mdfrId;
	}
	public void setMdfrId(String mdfrId) {
		this.mdfrId = mdfrId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getOriginFileName() {
		return originFileName;
	}
	public void setOriginFileName(String originFileName) {
		this.originFileName = originFileName;
	}
	public RequirementVO getRequirementVO() {
		return requirementVO;
	}
	public void setRequirementVO(RequirementVO requirementVO) {
		this.requirementVO = requirementVO;
	}
	public ProjectVO getProjectVO() {
		return projectVO;
	}
	public void setProjectVO(ProjectVO projectVO) {
		this.projectVO = projectVO;
	}
	public EmployeeVO getEmployeeVO() {
		return employeeVO;
	}
	public void setEmployeeVO(EmployeeVO employeeVO) {
		this.employeeVO = employeeVO;
	}
	
	

}
