

package com.mycompany.funcionarios;

import com.mycompany.funcionarios.controller.FuncionarioController;
import com.mycompany.funcionarios.domine.Funcionario;
import java.sql.SQLException;
import java.util.List;

public class Funcionarios {

    /*public static void obtenerFuncionarios(FuncionarioController funcionarioController){
        try {
            
            List<Funcionario> funcionarios = funcionarioController.obtenerFuncionarios();
            if (funcionarios.isEmpty()) {
                System.out.println("no hay funcionarios");
            } else {
                funcionarios.forEach(funcionario -> {
                    System.out.println("Id:" + funcionario.getId());
                    System.out.println("Tipo de identificacion:" + funcionario.getTipo_identificacion());
                    System.out.println("Numero de identificacion:" + funcionario.getNumero_identificacion());
                    System.out.println("Nombres:" + funcionario.getNombres());
                    System.out.println("Apellidos" + funcionario.getApellidos());
                    System.out.println("Estadi civil" + funcionario.getEstado_civil());
                    System.out.println("Sexo" + funcionario.getSexo());
                    System.out.println("Direccion" + funcionario.getDireccion());
                    System.out.println("Telefono" + funcionario.getTelefono());
                    System.out.println("Fecha de nacimiento" + funcionario.getFecha_nacimiento());
                    System.out.println("----------------------------------");
                });

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }*/

    public static void main(String[] args) {
        
        Main objetoFormulario = new Main();
        objetoFormulario.setVisible(true);
        /*FuncionarioController funcionarioController = new FuncionarioController();
        obtenerFuncionarios(funcionarioController);*/
    }
}
