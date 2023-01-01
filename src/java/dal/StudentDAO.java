/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Department;
import model.Student;

/**
 *
 * @author Surface book 2
 */
public class StudentDAO extends DBContext {
    public void insert(Student student)
    {
        try {
            String sql = "INSERT INTO [Student]\n" +
                    "           ([sid]\n" +
                    "           ,[sname]\n" +
                    "           ,[dob]\n" +
                    "           ,[gender]\n" +
                    "           ,[did])\n" +
                    "     VALUES\n" +
                    "           (?\n" +
                    "           ,?\n" +
                    "           ,?\n" +
                    "           ,?\n" +
                    "           ,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, student.getId());
            stm.setString(2, student.getName());
            stm.setDate(3, student.getDob());
            stm.setBoolean(4, student.isGender());
            stm.setInt(5, student.getDept().getId());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public Student getStudent(int id)
    {
        try {
            String sql = "SELECT [sid]\n" +
                    "      ,[sname]\n" +
                    "      ,[dob]\n" +
                    "      ,[gender]\n" +
                    "      ,[did]\n" +
                    "  FROM [Student] WHERE [sid] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if(rs.next())
            {
                Student s = new Student();
                s.setId(rs.getInt("sid"));
                s.setName(rs.getString("sname"));
                s.setDob(rs.getDate("dob"));
                s.setGender(rs.getBoolean("gender"));
                Department dept = new Department();
                dept.setId(rs.getInt("did"));
                s.setDept(dept);
                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<Student> search(int id, String name, Boolean gender,Date from, Date to,int did)
    {
        ArrayList<Student> students = new ArrayList<>();
        try {
            String sql = "SELECT s.sid,s.sname,s.gender,s.dob,d.did,d.dname FROM \n" +
                    "Student s INNER JOIN Department d\n" +
                    "ON s.did = d.did\n" +
                    "WHERE (1=1)";
            
            HashMap<Integer,Object[]> params = new HashMap<>();
            Integer paramIndex = 0;
            
            if(id != -1)
            {
                sql+= " AND s.sid = ? ";
                paramIndex++;
                Object[] param = new Object[2];
                param[0] = id;
                param[1] = "INT";
                params.put(paramIndex, param);
            }
            if(name.length() !=0)
            {
                sql+= " AND s.sname like '%'+?+'%' ";
                paramIndex++;
                Object[] param = new Object[2];
                param[0] = name;
                param[1] = "STRING";
                params.put(paramIndex, param);
            }
            if(gender!=null)
            {
                sql+= " AND s.gender = ? ";
                paramIndex++;
                Object[] param = new Object[2];
                param[0] = gender;
                param[1] = "BOOLEAN";
                params.put(paramIndex, param);
            }
            if(from!=null)
            {
                sql+= " AND s.dob >= ? ";
                paramIndex++;
                Object[] param = new Object[2];
                param[0] = from;
                param[1] = "DATE";
                params.put(paramIndex, param);
            }
            if(to!=null)
            {
                sql+= " AND s.dob <= ? ";
                paramIndex++;
                Object[] param = new Object[2];
                param[0] = to;
                param[1] = "DATE";
                params.put(paramIndex, param);
            }
            if(did != -1)
            {
                sql+= " AND d.did = ? ";
                paramIndex++;
                Object[] param = new Object[2];
                param[0] = did;
                param[1] = "INT";
                params.put(paramIndex, param);
            }
            
            PreparedStatement stm = connection.prepareStatement(sql);
            for (Map.Entry<Integer, Object[]> entry : params.entrySet()) {
                try {
                    Integer index = entry.getKey();
                    Object[] param = entry.getValue();
                    String datatype = param[1].toString();
                    Object value = param[0];
                    switch(datatype)
                    {
                        case "INT": stm.setInt(index, (Integer)value); break;
                        case "STRING": stm.setString(index, value.toString()); break;
                        case "DATE": stm.setDate(index, (Date)value); break;
                        case "BOOLEAN": stm.setBoolean(index, (Boolean)value);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
               Student s = new Student();
               s.setId(rs.getInt("sid"));
               s.setName(rs.getString("sname"));
               s.setGender(rs.getBoolean("gender"));
               s.setDob(rs.getDate("dob"));
               Department d = new Department();
               d.setId(rs.getInt("did"));
               d.setName(rs.getString("dname"));
               s.setDept(d);
               students.add(s);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }
    
    public void update(Student student)
    {
        try {
            String sql = "UPDATE [Student]\n" +
                            "   SET \n" +
                            "      [sname] = ?\n" +
                            "      ,[dob] = ?\n" +
                            "      ,[gender] = ?\n" +
                            "      ,[did] = ?\n" +
                            " WHERE [sid] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(5, student.getId());
            stm.setString(1, student.getName());
            stm.setDate(2, student.getDob());
            stm.setBoolean(3, student.isGender());
            stm.setInt(4, student.getDept().getId());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
