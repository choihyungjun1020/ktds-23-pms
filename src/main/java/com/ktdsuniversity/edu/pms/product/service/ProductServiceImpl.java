package com.ktdsuniversity.edu.pms.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ktdsuniversity.edu.pms.exceptions.PageNotFoundException;
import com.ktdsuniversity.edu.pms.product.dao.ProductDao;
import com.ktdsuniversity.edu.pms.product.dao.ProductManagementDao;
import com.ktdsuniversity.edu.pms.product.vo.ProductListVO;
import com.ktdsuniversity.edu.pms.product.vo.ProductManagementVO;
import com.ktdsuniversity.edu.pms.product.vo.ProductVO;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private ProductManagementDao productManagementDao;

	@Override
	public ProductListVO getAllProduct(ProductVO productVO) {
		int productCount = this.productDao.getProductAllCount(productVO);
		
		productVO.setPageCount(productCount);
		
		List<ProductVO> productList = this.productDao.getAllProduct(productVO);
		
		ProductListVO productListVO = new ProductListVO();
		productListVO.setProductCnt(productCount);
		productListVO.setProductList(productList);
		
		return productListVO;
	}

	@Transactional
	@Override
	public int createNewProduct(ProductListVO productList) {
		int insertCount = 0;
		
		for( ProductVO productVO : productList.getProductList()) {
			insertCount += this.productDao.insertNewProduct(productVO);			
		}
		
		return insertCount;
	}

	@Override
	public ProductVO getOneProduct(String id) {
		ProductVO productVO = this.productDao.selectOneProduct(id);
		
		if (productVO == null) {
			throw new PageNotFoundException();
		}
		return productVO;
	}

	@Transactional
	@Override
	public boolean updateOneProduct(String prdtId) {
		
		return productDao.updateOneProduct(prdtId) > 0;
	}

	@Transactional
	@Override
	public boolean addProductCount(ProductManagementVO productManagementVO) {
		int count = productManagementVO.getProductVO().getCurStr();
		int successCount = 0;
		for(var i=0; i < count; i++) {
			successCount += productManagementDao.addProductManagement(productManagementVO);
		}
		boolean isSuccessPrdtCntUp = productDao.updateOneProductCount(productManagementVO.getProductVO()) > 0;
		
		return isSuccessPrdtCntUp && successCount == count;
	}

	@Transactional
	@Override
	public boolean deleteOneProduct(String prdtId) {
		return productDao.deleteOneProduct(prdtId) > 0;
	}

	@Transactional
	@Override
	public boolean modifyProduct(ProductVO productVO) {
		return productDao.modifyProduct(productVO) > 0;
	}
	
	@Override
	public ProductListVO getAllProductCategory() {
		List<ProductVO> productList = this.productDao.getAllProductCategory();
		ProductListVO productListVO = new ProductListVO();
		productListVO.setProductList(productList);
		
		return productListVO;
	}

	@Override
	public ProductVO getOneSelectedProduct(String prdtName) {
		return this.productDao.selectOneProductByPrdtName(prdtName);
	}

	@Override
	public boolean createManyProduct(List<Integer> addItems) {
		return this.productDao.insertManyProduct(addItems) > 0;
	}

	

}
