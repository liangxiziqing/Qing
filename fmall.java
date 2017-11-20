package cn.sdeit.beans; 
import java.sql.Connection; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement; 
import java.util.ArrayList; 
import cn.sdeit.mysql.ConnectMySql; 
public class Normal 
{ 
 private int id; 
 private String title; 
 private String buildDate; 
   
 public Normal(int id, String title, String buildDate) 
 { 
 super(); 
 this.id = id; 
 this.title = title; 
 this.buildDate = buildDate; 
 } 
   
 public Normal() 
 { 
 super(); 
 /* 
  * 空的构造方法用作 获取 array 
  */ 
 } 
 public int getId() 
 { 
 return id; 
 } 
 public void setId(int id) 
 { 
 this.id = id; 
 } 
 public String getTitle() 
 { 
 return title; 
 } 
 public void setTitle(String title) 
 { 
 this.title = title; 
 } 
 public String getBuildDate() 
 { 
 return buildDate; 
 } 
 public void setBuildDate(String buildDate) 
 { 
 this.buildDate = buildDate; 
 } 
   
 @Override 
 public String toString() 
 { 
 return "ObjectBean [id=" + id + ", title=" + title + ", buildDate=" 
 + buildDate + "]"; 
 } 
   
 public ArrayList<Normal> getNormalBeanArray(String tableName) 
 { 
 ArrayList<Normal> array = new ArrayList<Normal>(); 
 Connection connection = ConnectMySql.createConnection(); 
 Statement statement = ConnectMySql.createStatement(connection); 
 String sql = "select * from "+tableName+";"; 
 ResultSet set = ConnectMySql.getResultSet(statement, sql); 
   
 try 
 { 
 while (set.next()) 
 { 
 Normal ObjectBean = new Normal(set.getInt("id"),set.getString("title"),set.getString("build_date")); 
 array.add(ObjectBean); 
 } 
 } catch (SQLException e) 
 { 
 e.printStackTrace(); 
 } 
 return array; 
 } 
}  
