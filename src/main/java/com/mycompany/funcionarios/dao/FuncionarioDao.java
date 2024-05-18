package com.mycompany.funcionarios.dao;

import com.mycompany.funcionarios.domine.Funcionario;
import com.mycompany.funcionarios.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDao {

    public static final String GET_FUNCIONARIOS = "select * from funcionarios";

    public static final String CREATE_FUNCIONARIO = "insert into funcionarios (tipo_identificacion, numero_identificacion, nombres,"
            + " apellidos, estado_civil, sexo, direccion, telefono, fecha_nacimiento)\n " + "values (?, ?, ?, ?, ?, ?, ?, ?, ?);";

    public static final String GET_FUNCIONARIO_BY_ID = "select * from funcionarios where id = ?";

    public static final String UPDATE_FUNCIONARIO = "update funcionarios set tipo_identificacion = ?, numero_identificacion = ?, nombres = ?, apellidos =?,"
            + " estado_civil = ?, sexo =?, direccion =?, telefono =?, fecha_nacimiento =? where id = ?";

    public static final String DELETE_FUNCIONARIO = "delete from funcionarios where id = ?";

    
    
    public List<Funcionario> obtenerFuncionarios() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Funcionario> Funcionarios = new ArrayList<>();

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_FUNCIONARIOS);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
              
                Funcionario funcionario = new Funcionario();
                funcionario.setId(resultSet.getInt("id"));
                funcionario.setTipo_identificacion(resultSet.getString("tipo_identificacion"));
                funcionario.setNumero_identificacion(resultSet.getString("numero_identificacion"));
                funcionario.setNombres(resultSet.getString("nombres"));
                funcionario.setApellidos(resultSet.getString("apellidos"));
                funcionario.setEstado_civil(resultSet.getString("estado_civil"));
                funcionario.setSexo(resultSet.getString("sexo"));
                funcionario.setDireccion(resultSet.getString("direccion"));
                funcionario.setTelefono(resultSet.getString("telefono"));
                funcionario.setFecha_nacimiento(resultSet.getString("fecha_nacimiento"));
                Funcionarios.add(funcionario);
            }
            
               return Funcionarios;

        } finally {

            if (connection != null) {
                connection.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (resultSet != null) {
                resultSet.close();
            }
        }

     

    }

    public void crearFuncionario(Funcionario funcionario) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareCall(CREATE_FUNCIONARIO);

            preparedStatement.setString(1, funcionario.getTipo_identificacion());
            preparedStatement.setString(2, funcionario.getNumero_identificacion());
            preparedStatement.setString(3, funcionario.getNombres());
            preparedStatement.setString(4, funcionario.getApellidos());
            preparedStatement.setString(5, funcionario.getEstado_civil());
            preparedStatement.setString(6, funcionario.getSexo());
            preparedStatement.setString(7, funcionario.getDireccion());
            preparedStatement.setString(8, funcionario.getTelefono());
            preparedStatement.setString(9, funcionario.getFecha_nacimiento());
            preparedStatement.executeUpdate();
        } finally {

            if (connection != null) {
                connection.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    public Funcionario obtenerFuncionario(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Funcionario funcionario = null;

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareCall(GET_FUNCIONARIO_BY_ID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                funcionario = new Funcionario();
                funcionario.setId(resultSet.getInt("id"));
                funcionario.setTipo_identificacion(resultSet.getString("tipo_identificacion"));
                funcionario.setNumero_identificacion(resultSet.getString("numero_identificacion"));
                funcionario.setNombres(resultSet.getString("nombres"));
                funcionario.setApellidos(resultSet.getString("apellidos"));
                funcionario.setEstado_civil(resultSet.getString("estado_civil"));
                funcionario.setSexo(resultSet.getString("sexo"));
                funcionario.setDireccion(resultSet.getString("direccion"));
                funcionario.setTelefono(resultSet.getString("telefono"));
                funcionario.setFecha_nacimiento(resultSet.getString("fecha_nacimiento"));
            }
        } finally {

            if (connection != null) {
                connection.close();
            }

            if (connection != null) {
                connection.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
        return funcionario;
    }
    
    public void actualizarFuncionario(int Id, Funcionario funcionario) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareCall(UPDATE_FUNCIONARIO);
            preparedStatement.setString(1, funcionario.getTipo_identificacion());
            preparedStatement.setString(2, funcionario.getNumero_identificacion());
            preparedStatement.setString(3, funcionario.getNombres());
            preparedStatement.setString(4, funcionario.getApellidos());
            preparedStatement.setString(5, funcionario.getEstado_civil());
            preparedStatement.setString(6, funcionario.getSexo());
            preparedStatement.setString(7, funcionario.getDireccion());
            preparedStatement.setString(8, funcionario.getTelefono());
            preparedStatement.setString(9, funcionario.getFecha_nacimiento());
            preparedStatement.setInt(10, Id);
            preparedStatement.executeUpdate();

        } finally {

            if (connection != null) {
                connection.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }
    
    public void eliminarFuncionario(int Id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareCall(DELETE_FUNCIONARIO);
            preparedStatement.setInt(1, Id);
            preparedStatement.executeUpdate();
        } finally {

            if (connection != null) {
                connection.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

}


