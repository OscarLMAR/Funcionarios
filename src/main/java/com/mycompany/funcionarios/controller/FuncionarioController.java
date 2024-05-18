
package com.mycompany.funcionarios.controller;

import com.mycompany.funcionarios.dao.FuncionarioDao;
import com.mycompany.funcionarios.domine.Funcionario;
import java.sql.SQLException;
import java.util.List;

public class FuncionarioController {
    private FuncionarioDao funDao;
    
    public FuncionarioController (){
        funDao = new FuncionarioDao();
}
    public List<Funcionario> obtenerFuncionarios () throws SQLException{
        return funDao.obtenerFuncionarios();
    }
    
    public void crearFuncionario(Funcionario funcionario) throws SQLException{
        funDao.crearFuncionario(funcionario);
    }
    
    public Funcionario obteneFuncionario(int Id) throws SQLException{
        return funDao.obtenerFuncionario(Id);
    }
    
    public void actualizarFuncionario(int Id, Funcionario funcionario) throws SQLException{
        funDao.actualizarFuncionario(Id, funcionario);
    }
    
    public void eliminarFuncionario(int Id) throws SQLException{
        funDao.eliminarFuncionario(Id);
    }
}
