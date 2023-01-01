/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.student;

import dal.DepartmentDAO;
import dal.StudentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Department;
import model.Student;

/**
 *
 * @author Surface book 2
 */
public class UpdateController extends HttpServlet {

    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DepartmentDAO deptDB = new DepartmentDAO();
        ArrayList<Department> depts = deptDB.getDepts();
        StudentDAO studentDB = new StudentDAO();
        Student student = studentDB.getStudent(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("depts", depts);
        request.setAttribute("student", student);
        request.getRequestDispatcher("../view/student/update.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Date dob = Date.valueOf(request.getParameter("dob"));
        boolean gender = request.getParameter("gender").equals("male");
        Department dept = new Department();
        dept.setId(Integer.parseInt(request.getParameter("did")));
        
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setDob(dob);
        student.setGender(gender);
        student.setDept(dept);
        
        StudentDAO db = new StudentDAO();
        db.update(student);
        response.getWriter().println("update successful!");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
