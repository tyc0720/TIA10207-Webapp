package com.productInfo.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ProductInfoDAOImpl implements ProductInfoDAO {
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/g1?serverTimezone=Asia/Taipei";
	public static final String USER = "root";
	public static final String PASSWORD = "123456";

	// 宣告SQL指令
	private static final String INSERT_PRODUCTINFO = "INSERT INTO productinfo (productTypeId, proName, proPrice, proSafetyStock, totalCount, commentUsers, commentStars, proPic, proStatus, proDesc, createdBy, dateCreated, lastUpdatedBy, lastUpdated) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	private static final String UPDATE_PRODUCTINFO = "UPDATE productinfo SET productTypeId=?, proName=?, proPrice=?, proSafetyStock=?, totalCount=?, commentUsers=?, commentStars=?, proPic=?, proStatus=?, proDesc=?, createdBy=?, dateCreated=?, lastUpdatedBy=?, lastUpdated=? where productId=?";

	private static final String UPDATEPSTSTUS_PRODUCTINFO = "UPDATE productinfo SET proStatus=? where productId=?";

	private static final String UPDATE_PROPIC = "UPDATE productinfo SET proPIC=? where productId=?";

	private static final String FIND_ONE_PRODUCTINFO = "SELECT productId, productTypeId, proName, proPrice, proSafetyStock, totalCount, commentUsers, commentStars, proPic, proStatus, proDesc, createdBy, dateCreated, lastUpdatedBy, lastUpdated FROM productinfo where productId=?";

	private static final String FIND_ALL = "SELECT productId, productTypeId, proName, proPrice, proSafetyStock, totalCount, commentUsers, commentStars, proPic, proStatus, proDesc, createdBy, dateCreated, lastUpdatedBy, lastUpdated FROM productinfo order by productId";

	private static final String FIND_TYPE_ALL = "SELECT productId, productTypeId, proName, proPrice, proSafetyStock, totalCount, commentUsers, commentStars, proPic, proStatus, proDesc, createdBy, dateCreated, lastUpdatedBy, lastUpdated FROM productinfo where productTypeId=? order by productId";

	private static final String FIND_STATUS_ALL = "SELECT productId, productTypeId, proName, proPrice, proSafetyStock, totalCount, commentUsers, commentStars, proPic, proStatus, proDesc, createdBy, dateCreated, lastUpdatedBy, lastUpdated FROM productinfo where proStatus=? order by productId";

	// 建立連線
	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

	public void insert(ProductInfo productInfo) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(INSERT_PRODUCTINFO);

			pstmt.setInt(1, productInfo.getProductTypeId());
			pstmt.setString(2, productInfo.getProName());
			pstmt.setInt(3, productInfo.getProPrice());
			pstmt.setInt(4, productInfo.getProSafetyStock());
			pstmt.setInt(5, productInfo.getTotalCount());
			pstmt.setInt(6, productInfo.getCommentUsers());
			pstmt.setInt(7, productInfo.getCommentStars());
			pstmt.setBytes(8, productInfo.getProPic());
			pstmt.setInt(9, productInfo.getProStatus());
			pstmt.setString(10, productInfo.getProDesc());
			pstmt.setString(11, productInfo.getCreatedBy());
			pstmt.setTimestamp(12, productInfo.getDateCreated());
			pstmt.setString(13, productInfo.getLastUpdatedBy());
			pstmt.setTimestamp(14, productInfo.getLastUpdated());

			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	public void update(ProductInfo productInfo) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(UPDATE_PRODUCTINFO);

			pstmt.setInt(1, productInfo.getProductTypeId());
			pstmt.setString(2, productInfo.getProName());
			pstmt.setInt(3, productInfo.getProPrice());
			pstmt.setInt(4, productInfo.getProSafetyStock());
			pstmt.setInt(5, productInfo.getTotalCount());
			pstmt.setInt(6, productInfo.getCommentUsers());
			pstmt.setInt(7, productInfo.getCommentStars());
			pstmt.setBytes(8, productInfo.getProPic());
			pstmt.setInt(9, productInfo.getProStatus());
			pstmt.setString(10, productInfo.getProDesc());
			pstmt.setString(11, productInfo.getCreatedBy());
			pstmt.setTimestamp(12, productInfo.getDateCreated());
			pstmt.setString(13, productInfo.getLastUpdatedBy());
			pstmt.setTimestamp(14, productInfo.getLastUpdated());
			pstmt.setInt(15, productInfo.getProductId());

			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

	public void updateProStatus(Integer productId, Integer proStatus) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(UPDATEPSTSTUS_PRODUCTINFO);

			pstmt.setInt(1, proStatus);
			pstmt.setInt(2, productId);
			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	public void updateProPic(Integer productId, String proPic) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(UPDATE_PROPIC);

			byte[] pic = getPictureByteArray(proPic);
			pstmt.setBytes(1, pic);
			pstmt.setInt(2, productId);

			pstmt.executeUpdate();

		} catch (ClassNotFoundException ce) {
			System.out.println(ce);
		} catch (SQLException se) {
			System.out.println(se);
		} catch (IOException ie) {
			System.out.println(ie);
		} finally {
			// 依建立順序關閉資源 (越晚建立越早關閉)
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					System.out.println(se);
				}
			}

			if (con != null) {
				try {
					con.close();
				} catch (SQLException se) {
					System.out.println(se);
				}
			}
		}

	}

	public ProductInfo findByProductId(Integer productId) {
		ProductInfo productInfo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(FIND_ONE_PRODUCTINFO);

			pstmt.setInt(1, productId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				productInfo = new ProductInfo();

				productInfo.setProductId(rs.getInt("productId"));
				productInfo.setProductTypeId(rs.getInt("productTypeId"));
				productInfo.setProName(rs.getString("proName"));
				productInfo.setProPrice(rs.getInt("proPrice"));
				productInfo.setProSafetyStock(rs.getInt("proSafetyStock"));
				productInfo.setTotalCount(rs.getInt("totalCount"));
				productInfo.setCommentUsers(rs.getInt("commentUsers"));
				productInfo.setCommentStars(rs.getInt("commentStars"));
				productInfo.setProPic(rs.getBytes("proPic"));
				productInfo.setProStatus(rs.getInt("proStatus"));
				productInfo.setProDesc(rs.getString("proDesc"));
				productInfo.setCreatedBy(rs.getString("createdBy"));
				productInfo.setDateCreated(rs.getTimestamp("dateCreated"));
				productInfo.setLastUpdatedBy(rs.getString("lastUpdatedBy"));
				productInfo.setLastUpdated(rs.getTimestamp("lastUpdated"));

			}

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return productInfo;
	}

	public List<ProductInfo> getAll() {
		List<ProductInfo> list = new ArrayList<ProductInfo>();
		ProductInfo productInfo = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(FIND_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				productInfo = new ProductInfo();

				productInfo.setProductId(rs.getInt("productId"));
				productInfo.setProductTypeId(rs.getInt("productTypeId"));
				productInfo.setProName(rs.getString("proName"));
				productInfo.setProPrice(rs.getInt("proPrice"));
				productInfo.setProSafetyStock(rs.getInt("proSafetyStock"));
				productInfo.setTotalCount(rs.getInt("totalCount"));
				productInfo.setCommentUsers(rs.getInt("commentUsers"));
				productInfo.setCommentStars(rs.getInt("commentStars"));
				productInfo.setProPic(rs.getBytes("proPic"));
				productInfo.setProStatus(rs.getInt("proStatus"));
				productInfo.setProDesc(rs.getString("proDesc"));
				productInfo.setCreatedBy(rs.getString("createdBy"));
				productInfo.setDateCreated(rs.getTimestamp("dateCreated"));
				productInfo.setLastUpdatedBy(rs.getString("lastUpdatedBy"));
				productInfo.setLastUpdated(rs.getTimestamp("lastUpdated"));

				list.add(productInfo);

			}
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}

	public List<ProductInfo> findByProductTypeId(Integer productTypeId) {
		List<ProductInfo> list = new ArrayList<ProductInfo>();
		ProductInfo productInfo = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(FIND_TYPE_ALL);
			pstmt.setInt(1, productTypeId); // 注意順序
			rs = pstmt.executeQuery(); // 注意順序

			while (rs.next()) {
				productInfo = new ProductInfo();

				productInfo.setProductId(rs.getInt("productId"));
				productInfo.setProductTypeId(rs.getInt("productTypeId"));
				productInfo.setProName(rs.getString("proName"));
				productInfo.setProPrice(rs.getInt("proPrice"));
				productInfo.setProSafetyStock(rs.getInt("proSafetyStock"));
				productInfo.setTotalCount(rs.getInt("totalCount"));
				productInfo.setCommentUsers(rs.getInt("commentUsers"));
				productInfo.setCommentStars(rs.getInt("commentStars"));
				productInfo.setProPic(rs.getBytes("proPic"));
				productInfo.setProStatus(rs.getInt("proStatus"));
				productInfo.setProDesc(rs.getString("proDesc"));
				productInfo.setCreatedBy(rs.getString("createdBy"));
				productInfo.setDateCreated(rs.getTimestamp("dateCreated"));
				productInfo.setLastUpdatedBy(rs.getString("lastUpdatedBy"));
				productInfo.setLastUpdated(rs.getTimestamp("lastUpdated"));

				list.add(productInfo);

			}
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}

	public List<ProductInfo> findByProStatus(Integer proStatus) {
		List<ProductInfo> list = new ArrayList<ProductInfo>();
		ProductInfo productInfo = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(FIND_STATUS_ALL);
			pstmt.setInt(1, proStatus);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				productInfo = new ProductInfo();

				productInfo.setProductId(rs.getInt("productId"));
				productInfo.setProductTypeId(rs.getInt("productTypeId"));
				productInfo.setProName(rs.getString("proName"));
				productInfo.setProPrice(rs.getInt("proPrice"));
				productInfo.setProSafetyStock(rs.getInt("proSafetyStock"));
				productInfo.setTotalCount(rs.getInt("totalCount"));
				productInfo.setCommentUsers(rs.getInt("commentUsers"));
				productInfo.setCommentStars(rs.getInt("commentStars"));
				productInfo.setProPic(rs.getBytes("proPic"));
				productInfo.setProStatus(rs.getInt("proStatus"));
				productInfo.setProDesc(rs.getString("proDesc"));
				productInfo.setCreatedBy(rs.getString("createdBy"));
				productInfo.setDateCreated(rs.getTimestamp("dateCreated"));
				productInfo.setLastUpdatedBy(rs.getString("lastUpdatedBy"));
				productInfo.setLastUpdated(rs.getTimestamp("lastUpdated"));

				list.add(productInfo);

			}
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}

	// 使用byte[]方式
	
	public static byte[] getPictureByteArray(String path) 
			throws IOException {
		FileInputStream fis = new FileInputStream(path);
		byte[] buffer = fis.readAllBytes();

		fis.close();
		return buffer;
	}

	
	
	public static void main(String[] args) {
		ProductInfo productInfo = new ProductInfo();
		ProductInfoDAO dao = new ProductInfoDAOImpl();
		// insert
		productInfo.setProductTypeId(1);
		productInfo.setProName("杏仁瓦片");
		productInfo.setProPrice(650);
		productInfo.setProSafetyStock(35);
		productInfo.setTotalCount(80);
		productInfo.setCommentUsers(5);
		productInfo.setCommentStars(25);
		productInfo.setProPic(null);
		productInfo.setProStatus(2);
		productInfo.setProDesc("好吃");
		productInfo.setCreatedBy("Jane");
		productInfo.setDateCreated(new Timestamp (System.currentTimeMillis()));
		productInfo.setLastUpdatedBy("Amy");
		productInfo.setLastUpdated(new Timestamp (System.currentTimeMillis()));
			
		dao.insert(productInfo);

		 //update
//		productInfo.setProductTypeId(2);
//		productInfo.setProName("原味杏仁瓦片");
//		productInfo.setProPrice(600);
//		productInfo.setProSafetyStock(25);
//		productInfo.setTotalCount(32);
//		productInfo.setCommentUsers(5);
//		productInfo.setCommentStars(20);
//		productInfo.setProPic(null);
//		productInfo.setProStatus(2);
//		productInfo.setProDesc("讚很棒好棒好好吃");
//		productInfo.setCreatedBy("Amy");
//		productInfo.setDateCreated(new Timestamp (System.currentTimeMillis()));
//		productInfo.setLastUpdatedBy("Andy");
//		productInfo.setLastUpdated(new Timestamp (System.currentTimeMillis()));
//		productInfo.setProductId(1003);
//		
//		dao.update(productInfo);

		// updateProStatus
//		dao.updateProStatus(1002, 1);
		
		
		// updateProPic
//		dao.updateProPic(1002, "items/FC_Barcelona.png");
		

		// findByProductId
//		productInfo = dao.findByProductId(1002);
//		System.out.println(productInfo);
//		//System.out.println(productInfo.toString()); (也可以但脫褲子放屁)

		// getAll
//		List<ProductInfo> list = dao.getAll();
//		for (ProductInfo aProductInfo : list) {
//			System.out.print(aProductInfo + ",");
//			System.out.println();
//		}

		// findByProductTypeId
//		List<ProductInfo> list = dao.findByProductTypeId(1);
//		for (ProductInfo aProductInfo : list) {
//			System.out.print(aProductInfo + ",");
//			System.out.println();
//		}

		// findByProStatus
//		List<ProductInfo> list = dao.findByProStatus(2);
//		for (ProductInfo aProductInfo : list) {
//			System.out.print(aProductInfo + ",");
//			System.out.println();
//		}

	}


	
}
