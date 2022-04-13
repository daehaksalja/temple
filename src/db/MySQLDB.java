package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.MemberDTO;

public class MySQLDB {
	
	public int login(String loginID, String loginPW) {
		Connection conn= null;
	    PreparedStatement pstmt = null;
	    ResultSet rs= null;
	    
	    String dbURL = "jdbc:mysql://127.0.0.1:3306/swingDB?useSSL=false";
	    String dbID = "root";
	    String dbPW = "rootroot";
	    
	    try {
	       Class.forName("com.mysql.cj.jdbc.Driver");
	       conn = DriverManager.getConnection(dbURL, dbID, dbPW);
	       
	       String sql = "SELECT mID, mPW from templeTBL where mID =?and mPW =?;  "
	            ;
	       pstmt = conn.prepareStatement(sql);
	      pstmt.setString(1,loginID);
	       pstmt.setString(2,loginPW);
	       rs = pstmt.executeQuery();
	       
	     if(rs.next()) {
//	    	 String resultID = rs.getString("mID");
//	    	 String resultPW = rs.getString("mPW");
//	    	 if(resultID.equals(loginID) && resultID.equals(loginPW)) {
	    		 System.out.println("로그인성공");
	    		 return 1000;
	    	 
	    	
	    	 
	     }else {
	    	System.out.println("로그인실패");
	    	return 2000;
	     }
	       
	       
	       
	       
	    } catch (ClassNotFoundException e) {
	       e.printStackTrace();
	    } catch (SQLException e) {
	       e.printStackTrace();
	    } finally {
	       if(pstmt != null) {
	          try {
	             pstmt.close();
	          } catch (SQLException e) {
	             e.printStackTrace();
	          }
	       }
	       
	       if(conn != null) {
	          try {
	             conn.close();
	          } catch (SQLException e) {
	             e.printStackTrace();
	          }
	       }
	    }
		return 0;
	 }
	
	
	public boolean idDuplicate(String onlyEng) {
	
	Connection conn= null;
    PreparedStatement pstmt = null;
    ResultSet rs= null;
    
    String dbURL = "jdbc:mysql://127.0.0.1:3306/swingDB?useSSL=false";
    String dbID = "root";
    String dbPW = "rootroot";
    
    try {
       Class.forName("com.mysql.cj.jdbc.Driver");
       conn = DriverManager.getConnection(dbURL, dbID, dbPW);
       
       String sql = "SELECT mID from templeTBL where mID = ?;   "
            ;
       pstmt = conn.prepareStatement(sql);
      
       pstmt.setString(1, onlyEng);
      
       rs = pstmt.executeQuery();
       
     if(rs.next()) {
    	 return true;
    	 
     }else {
    	 return false;
     }
       
       
       
       
    } catch (ClassNotFoundException e) {
       e.printStackTrace();
    } catch (SQLException e) {
       e.printStackTrace();
    } finally {
       if(pstmt != null) {
          try {
             pstmt.close();
          } catch (SQLException e) {
             e.printStackTrace();
          }
       }
       
       if(conn != null) {
          try {
             conn.close();
          } catch (SQLException e) {
             e.printStackTrace();
          }
       }
    }return false;
 }
	
   public void insert( String mID, String mPW) {
	   
	   
         Connection conn= null;
         PreparedStatement pstmt = null;
         
         String dbURL = "jdbc:mysql://127.0.0.1:3306/swingDB?useSSL=false";
         String dbID = "root";
         String dbPW = "rootroot";
         
         try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, dbID, dbPW);
            
            String sql = "insert into templeTBL(mID, mPW ) "+ " values ( ?, ?)";
            pstmt = conn.prepareStatement(sql);
           
            pstmt.setString(1, mID);
            pstmt.setString(2, mPW);
            pstmt.executeUpdate();
            
            System.out.println("MemberDTO insert() 메서드 실행 완료");
            
         } catch (ClassNotFoundException e) {
            e.printStackTrace();
         } catch (SQLException e) {
            e.printStackTrace();
         } finally {
            if(pstmt != null) {
               try {
                  pstmt.close();
               } catch (SQLException e) {
                  e.printStackTrace();
               }
            }
            
            if(conn != null) {
               try {
                  conn.close();
               } catch (SQLException e) {
                  e.printStackTrace();
               }
            }
         }
      }
   public void delete(int mNum) {
       Connection conn= null;
       PreparedStatement pstmt = null;
       
       String dbURL = "jdbc:mysql://127.0.0.1:3306/shoppingMall?useSSL=false";
       String dbID = "root";
       String dbPW = "rootroot";
       
       try {
          Class.forName("com.mysql.cj.jdbc.Driver");
          conn = DriverManager.getConnection(dbURL, dbID, dbPW);
          
          String sql = "delete from templeTBL where mNum = ?";
          pstmt = conn.prepareStatement(sql);
          pstmt.setInt(1, mNum);
          pstmt.executeUpdate();
          
          System.out.println("MemberDTO delete() 메서드 실행 완료");
          
       } catch (ClassNotFoundException e) {
          e.printStackTrace();
       } catch (SQLException e) {

          e.printStackTrace();
       } finally {
          if(pstmt != null) {
             try {
                pstmt.close();
             } catch (SQLException e) {
                e.printStackTrace();
             }
          }
          
          if(conn != null) {
             try {
                conn.close();
             } catch (SQLException e) {
                e.printStackTrace();
             }
          }
       }
    }
    
    
    public void update(int mNum, String mAddress) {
       Connection conn= null;
       PreparedStatement pstmt = null;
       
       String dbURL = "jdbc:mysql://127.0.0.1:3306/shoppingMall?useSSL=false";
       String dbID = "root";
       String dbPW = "rootroot";
       
       try {
          Class.forName("com.mysql.cj.jdbc.Driver");
          conn = DriverManager.getConnection(dbURL, dbID, dbPW);
          
          String sql = "update templeTBL set mAddress = ? where mNum = ?";
          pstmt = conn.prepareStatement(sql);
          pstmt.setString(1, mAddress);
          pstmt.setInt(2, mNum);
          pstmt.executeUpdate();
          
          System.out.println("MemberDTO update() 메서드 실행 완료");
          
       } catch (ClassNotFoundException e) {
          e.printStackTrace();
       } catch (SQLException e) {
          e.printStackTrace();
       } finally {
          if(pstmt != null) {
             try {
                pstmt.close();
             } catch (SQLException e) {
                e.printStackTrace();
             }
          }
          
          if(conn != null) {
             try {
                conn.close();
             } catch (SQLException e) {
                e.printStackTrace();
             }
          }
       }
    }
    
    
    public void selectOne(int mNum) {
       Connection conn= null;
       PreparedStatement pstmt = null;
       ResultSet rs = null;
       
       String dbURL = "jdbc:mysql://127.0.0.1:3306/swingDB?useSSL=false";
       String dbID = "root";
       String dbPW = "rootroot";
       
       try {
          Class.forName("com.mysql.cj.jdbc.Driver");
          conn = DriverManager.getConnection(dbURL, dbID, dbPW);
          
          String sql = "select * from templeTBL where mNum = ?";
          pstmt = conn.prepareStatement(sql);
          pstmt.setInt(1, mNum);
          rs = pstmt.executeQuery();
          
          if(rs.next()) {
             MemberDTO dto = new MemberDTO();
             dto.setmNum(rs.getInt("mNum"));
             dto.setmID(rs.getString("mUserID"));
             dto.setmPW(rs.getString("mUserPW"));
      
             
             System.out.println(dto.toString());
          }
          
          System.out.println("MemberDTO selectOne() 메서드 실행 완료");
          
       } catch (ClassNotFoundException e) {
          e.printStackTrace();
       } catch (SQLException e) {
          e.printStackTrace();
       } finally {
          if(pstmt != null) {
             try {
                pstmt.close();
             } catch (SQLException e) {
                e.printStackTrace();
             }
          }
          
          if(rs != null) {
             try {
                rs.close();
             } catch (SQLException e) {
                e.printStackTrace();
             }
          }
          
          if(conn != null) {
             try {
                conn.close();
             } catch (SQLException e) {
                e.printStackTrace();
             }
          }
       }
    }
    
    public void selectAll() {
       Connection conn= null;
       PreparedStatement pstmt = null;
       ResultSet rs = null;
       
       String dbURL = "jdbc:mysql://127.0.0.1:3306/shoppingMall?useSSL=false";
       String dbID = "root";
       String dbPW = "rootroot";
       
       try {
          Class.forName("com.mysql.cj.jdbc.Driver");
          conn = DriverManager.getConnection(dbURL, dbID, dbPW);
          
          String sql = "select * from memberTBL";
          pstmt = conn.prepareStatement(sql);
          rs = pstmt.executeQuery();
          
          ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
          
          while(rs.next()) {
             MemberDTO dto = new MemberDTO();
             dto.setmNum(rs.getInt("mNum"));
             dto.setmID(rs.getString("mUserID"));
             dto.setmPW(rs.getString("mUserPW"));
           
             
             list.add(dto);
          }
          
          for(MemberDTO m : list) {
             System.out.println(m.toString());
          }
          
          System.out.println("MemberDTO selectAll() 메서드 실행 완료");
          
       } catch (ClassNotFoundException e) {
          e.printStackTrace();
       } catch (SQLException e) {
          e.printStackTrace();
       } finally {
          if(pstmt != null) {
             try {
                pstmt.close();
             } catch (SQLException e) {
                e.printStackTrace();
             }
          }
          
          if(rs != null) {
             try {
                rs.close();
             } catch (SQLException e) {
                e.printStackTrace();
             }
          }
          
          if(conn != null) {
             try {
                conn.close();
             } catch (SQLException e) {
                e.printStackTrace();
             }
          }
       }
    }
}
      
      
