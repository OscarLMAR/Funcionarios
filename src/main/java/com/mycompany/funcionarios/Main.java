package com.mycompany.funcionarios;

import com.mycompany.funcionarios.controller.FuncionarioController;
import com.mycompany.funcionarios.domine.Funcionario;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Main extends javax.swing.JFrame {

    private final FuncionarioController funcionarioController;
    private static final String[] COLUMNS = {"ID", "TIPO IDENTIFICACION", "IDENTIFICACION", "NOMBRE", "APELLIDOS",
        "ESTADO CIVIL", "SEXO", "DIRECCION", "TELEFONO", "FECHA NACIMIENTO"};
    private static final String SELECCIONE = "--SELECCIONE--";

    public Main() {

        initComponents();
        txtID.setEditable(false);
        this.setLocationRelativeTo(null);
        addListener();
        funcionarioController = new FuncionarioController();
        listFuncionarios();

    }

    private void listFuncionarios() {
        cbxFuncionario.removeAllItems();
        Funcionario funcionariocb = new Funcionario();
        funcionariocb.setNombres(SELECCIONE);
        funcionariocb.setApellidos("");
        cbxFuncionario.addItem(funcionariocb);

        DefaultTableModel defaultTableModel = new DefaultTableModel();
        for (String COLUMN : COLUMNS) {
            defaultTableModel.addColumn(COLUMN);
        }
        tblFunction.setModel(defaultTableModel);
        try {
            List<Funcionario> funcionarios = funcionarioController.obtenerFuncionarios();
            if (funcionarios.isEmpty()) {
                return;
            }
            defaultTableModel.setRowCount(funcionarios.size());
            int row = 0;
            for (Funcionario fun : funcionarios) {

                defaultTableModel.setValueAt(fun.getId(), row, 0);
                defaultTableModel.setValueAt(fun.getTipo_identificacion(), row, 1);
                defaultTableModel.setValueAt(fun.getNumero_identificacion(), row, 2);
                defaultTableModel.setValueAt(fun.getNombres(), row, 3);
                defaultTableModel.setValueAt(fun.getApellidos(), row, 4);
                defaultTableModel.setValueAt(fun.getEstado_civil(), row, 5);
                defaultTableModel.setValueAt(fun.getSexo(), row, 6);
                defaultTableModel.setValueAt(fun.getDireccion(), row, 7);
                defaultTableModel.setValueAt(fun.getTelefono(), row, 8);
                defaultTableModel.setValueAt(fun.getFecha_nacimiento(), row, 9);

                row++;

                cbxFuncionario.addItem(fun);
            }
        } catch (SQLException ex) {

        }

    }

    private void addListener() {
        cbxFuncionario.addItemListener(event -> {
            Funcionario selectedFun = (Funcionario) event.getItem();
            if (selectedFun.getNombres().equals(SELECCIONE)) {
                txtID.setText("");
                txtTipoDocumentoEdit.setText("");
                txtNumDocumentEdit.setText("");
                txtNameEdit.setText("");
                txtApellidosEdit.setText("");
                txtEstadoCivilEdit.setText("");
                txtSexoEdit.setText("");
                txtDireccionEdit.setText("");
                txtTelefonoEdit.setText("");
                txtFechaNacimientoEdit.setText("");
            } else {

                txtID.setText(String.valueOf(selectedFun.getId()));
                txtTipoDocumentoEdit.setText(selectedFun.getTipo_identificacion());
                txtNumDocumentEdit.setText(selectedFun.getNumero_identificacion());
                txtNameEdit.setText(selectedFun.getNombres());
                txtApellidosEdit.setText(selectedFun.getApellidos());
                txtEstadoCivilEdit.setText(selectedFun.getEstado_civil());
                txtSexoEdit.setText(selectedFun.getSexo());
                txtDireccionEdit.setText(selectedFun.getDireccion());
                txtTelefonoEdit.setText(selectedFun.getTelefono());
                txtFechaNacimientoEdit.setText(selectedFun.getFecha_nacimiento());

            }

        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        jLabel1 = new javax.swing.JLabel();
        jPanesls = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPFuncionario = new javax.swing.JPanel();
        lblTipoDocument = new javax.swing.JLabel();
        lblNumDocument = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblApellidos = new javax.swing.JLabel();
        lblEstadoCivil = new javax.swing.JLabel();
        txtNumDocument = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtEstadoCivil = new javax.swing.JTextField();
        lblSexo = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        btnCreate = new javax.swing.JButton();
        txtTipoDocument = new javax.swing.JTextField();
        txtSexo = new javax.swing.JTextField();
        txtFechaNacimiento = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanelUpdate = new javax.swing.JPanel();
        lblFuncionrioEdit = new javax.swing.JLabel();
        cbxFuncionario = new javax.swing.JComboBox<>();
        lblID = new javax.swing.JLabel();
        lblTipoDocumentEdit = new javax.swing.JLabel();
        lblNumDocumentEdit = new javax.swing.JLabel();
        lblNameEdit = new javax.swing.JLabel();
        lblAppelidosEdit = new javax.swing.JLabel();
        lblEstadoCivilEdit = new javax.swing.JLabel();
        lblSexEdit = new javax.swing.JLabel();
        lblDireccionEdit = new javax.swing.JLabel();
        lblTelefonoEdit = new javax.swing.JLabel();
        lblFechaNacimientoEdit = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtNumDocumentEdit = new javax.swing.JTextField();
        txtNameEdit = new javax.swing.JTextField();
        txtApellidosEdit = new javax.swing.JTextField();
        txtEstadoCivilEdit = new javax.swing.JTextField();
        txtDireccionEdit = new javax.swing.JTextField();
        txtTelefonoEdit = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        txtFechaNacimientoEdit = new javax.swing.JTextField();
        txtTipoDocumentoEdit = new javax.swing.JTextField();
        txtSexoEdit = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFunction = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 153));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("FUNCIONARIOS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, -1, -1));

        jPanesls.setBackground(new java.awt.Color(204, 204, 204));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("INGRESE LOS SIGUIENTES DATOS"));
        jPanel1.setForeground(new java.awt.Color(255, 204, 153));

        jPFuncionario.setBackground(new java.awt.Color(204, 204, 204));
        jPFuncionario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblTipoDocument.setText("TIPO DE DOCUMENTO");

        lblNumDocument.setText("NUMERO DE DOCUMENTO");

        lblName.setText("NOMBRES");

        lblApellidos.setText("APELLIDOS");

        lblEstadoCivil.setText("ESTADO CIVIL");

        txtNumDocument.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumDocumentActionPerformed(evt);
            }
        });

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        lblSexo.setText("SEXO");

        lblDireccion.setText("DIRECCION");

        lblTelefono.setText("TELEFONO");

        jLabel10.setText("FECHA DE NACIMIENTO");

        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });

        btnCreate.setText("AGREGAR");
        btnCreate.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPFuncionarioLayout = new javax.swing.GroupLayout(jPFuncionario);
        jPFuncionario.setLayout(jPFuncionarioLayout);
        jPFuncionarioLayout.setHorizontalGroup(
            jPFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPFuncionarioLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTipoDocument)
                    .addComponent(lblNumDocument)
                    .addComponent(lblName)
                    .addComponent(lblApellidos)
                    .addComponent(lblEstadoCivil))
                .addGap(27, 27, 27)
                .addGroup(jPFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPFuncionarioLayout.createSequentialGroup()
                        .addGroup(jPFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPFuncionarioLayout.createSequentialGroup()
                                .addGroup(jPFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNumDocument)
                                    .addComponent(txtName)
                                    .addComponent(txtApellidos, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                                    .addComponent(txtTipoDocument))
                                .addGap(167, 167, 167)
                                .addGroup(jPFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSexo)
                                    .addComponent(lblDireccion)
                                    .addComponent(lblTelefono)
                                    .addComponent(jLabel10)))
                            .addGroup(jPFuncionarioLayout.createSequentialGroup()
                                .addGap(132, 132, 132)
                                .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30)
                        .addGroup(jPFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addComponent(txtSexo)
                            .addComponent(txtFechaNacimiento)))
                    .addComponent(txtEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPFuncionarioLayout.setVerticalGroup(
            jPFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPFuncionarioLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipoDocument)
                    .addComponent(lblSexo)
                    .addComponent(txtTipoDocument, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumDocument)
                    .addComponent(txtNumDocument, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDireccion)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTelefono)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellidos)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEstadoCivil)
                    .addComponent(txtEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnCreate)
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(259, Short.MAX_VALUE)
                .addComponent(jPFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(255, 255, 255))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(191, Short.MAX_VALUE))
        );

        jPanesls.addTab("AGREGAR", jPanel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("MODIFIQUE LOS SIGUIENTES DATOS"));

        jPanelUpdate.setBackground(new java.awt.Color(204, 204, 204));
        jPanelUpdate.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblFuncionrioEdit.setText("FUNCIONARIO");

        cbxFuncionario.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        cbxFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxFuncionarioActionPerformed(evt);
            }
        });

        lblID.setText("ID");

        lblTipoDocumentEdit.setText("TIPO DE DOCUMENTO");

        lblNumDocumentEdit.setText("NUMERO DE DOCUMENTO");

        lblNameEdit.setText("NOMBRES");

        lblAppelidosEdit.setText("APELLIDOS");

        lblEstadoCivilEdit.setText("ESTADO CIVIL");

        lblSexEdit.setText("SEXO");

        lblDireccionEdit.setText("DIRECCION");

        lblTelefonoEdit.setText("TELEFONO");

        lblFechaNacimientoEdit.setText("FECHA DE NACIMIENTO");

        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        btnUpdate.setText("ACTUALIZAR");
        btnUpdate.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("ELIMINAR");
        btnDelete.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelUpdateLayout = new javax.swing.GroupLayout(jPanelUpdate);
        jPanelUpdate.setLayout(jPanelUpdateLayout);
        jPanelUpdateLayout.setHorizontalGroup(
            jPanelUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUpdateLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanelUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFuncionrioEdit)
                    .addGroup(jPanelUpdateLayout.createSequentialGroup()
                        .addComponent(lblNameEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNameEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelUpdateLayout.createSequentialGroup()
                        .addComponent(lblAppelidosEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtApellidosEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbxFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelUpdateLayout.createSequentialGroup()
                        .addGroup(jPanelUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNumDocumentEdit)
                            .addGroup(jPanelUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelUpdateLayout.createSequentialGroup()
                                    .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtID))
                                .addComponent(lblTipoDocumentEdit, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNumDocumentEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(txtTipoDocumentoEdit)))
                    .addGroup(jPanelUpdateLayout.createSequentialGroup()
                        .addComponent(lblEstadoCivilEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEstadoCivilEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(btnUpdate)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanelUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanelUpdateLayout.createSequentialGroup()
                            .addComponent(lblTelefonoEdit)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtTelefonoEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
                        .addGroup(jPanelUpdateLayout.createSequentialGroup()
                            .addGroup(jPanelUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblDireccionEdit)
                                .addComponent(lblSexEdit))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanelUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtDireccionEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                .addComponent(txtSexoEdit))))
                    .addGroup(jPanelUpdateLayout.createSequentialGroup()
                        .addGroup(jPanelUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFechaNacimientoEdit)
                            .addGroup(jPanelUpdateLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(txtFechaNacimientoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(141, Short.MAX_VALUE))
        );
        jPanelUpdateLayout.setVerticalGroup(
            jPanelUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUpdateLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblFuncionrioEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanelUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID)
                    .addComponent(lblSexEdit)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSexoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanelUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipoDocumentEdit)
                    .addComponent(lblDireccionEdit)
                    .addComponent(txtDireccionEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTipoDocumentoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanelUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumDocumentEdit)
                    .addComponent(lblTelefonoEdit)
                    .addComponent(txtNumDocumentEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefonoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanelUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNameEdit)
                    .addComponent(lblFechaNacimientoEdit)
                    .addComponent(txtNameEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaNacimientoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanelUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAppelidosEdit)
                    .addComponent(txtApellidosEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanelUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEstadoCivilEdit)
                    .addComponent(txtEstadoCivilEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(275, Short.MAX_VALUE)
                .addComponent(jPanelUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(239, 239, 239))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(139, Short.MAX_VALUE))
        );

        jPanesls.addTab("ACTUALIZAR", jPanel2);

        jScrollPane1.setBackground(new java.awt.Color(204, 204, 204));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("FUNCIONARIOS GUARDADOS"));

        tblFunction.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tblFunction.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblFunction.setCellSelectionEnabled(true);
        tblFunction.setSelectionForeground(new java.awt.Color(255, 51, 51));
        jScrollPane1.setViewportView(tblFunction);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1262, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addGap(361, 361, 361))
        );

        jPanesls.addTab("LISTA DE FUNCIONARIOS", jPanel3);

        getContentPane().add(jPanesls, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 1300, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed

        if (txtTipoDocument.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese el campo Tipo de documento");
            txtTipoDocument.requestFocus();
            return;
        }

        if (txtNumDocument.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese el campo Numero de documento");
            txtNumDocument.requestFocus();
            return;
        }

        if (txtName.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese el campo de Nombres");
            txtName.requestFocus();
            return;
        }
        if (txtApellidos.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese el campo de Apellidos");
            txtApellidos.requestFocus();
            return;
        }

        if (txtEstadoCivil.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese el campo Estado civil");
            txtEstadoCivil.requestFocus();
            return;
        }

        if (txtSexo.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese el campo Sexo");
            txtSexo.requestFocus();
            return;
        }

        if (txtDireccion.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese el campo Direccion");
            txtDireccion.requestFocus();
            return;
        }

        if (txtTelefono.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese el campo Telefono");
            txtTelefono.requestFocus();
            return;
        }

        if (txtFechaNacimiento.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese el campo Fecha de nacimiento");
            txtFechaNacimiento.requestFocus();
            return;
        }

        try {
            Funcionario fun = new Funcionario();
            fun.setTipo_identificacion(txtTipoDocument.getText().trim());
            fun.setNumero_identificacion(txtNumDocument.getText().trim());
            fun.setNombres(txtName.getText().trim());
            fun.setApellidos(txtApellidos.getText().trim());
            fun.setEstado_civil(txtEstadoCivil.getText().trim());
            fun.setSexo(txtSexo.getText().trim());
            fun.setDireccion(txtDireccion.getText().trim());
            fun.setTelefono(txtTelefono.getText().trim());
            fun.setFecha_nacimiento(txtFechaNacimiento.getText().trim());

            funcionarioController.crearFuncionario(fun);

            txtTipoDocument.setText("");
            txtNumDocument.setText("");
            txtName.setText("");
            txtApellidos.setText("");
            txtEstadoCivil.setText("");
            txtSexo.setText("");
            txtDireccion.setText("");
            txtTelefono.setText("");
            txtFechaNacimiento.setText("");

            listFuncionarios();

            JOptionPane.showInternalMessageDialog(null, "Funcionario creado satisfactoriamente");

        } catch (Exception ex) {
            ex.printStackTrace();

            JOptionPane.showConfirmDialog(null, "No se pudo crear el Funcionario");
        }

    }//GEN-LAST:event_btnCreateActionPerformed

    private void txtNumDocumentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumDocumentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumDocumentActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void cbxFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxFuncionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxFuncionarioActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

        if (txtID.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione un funcionario de la lista");
            txtID.requestFocus();
            return;
        }
        if (txtTipoDocumentoEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese el campo Tipo de documento");
            txtTipoDocumentoEdit.requestFocus();
            return;
        }

        if (txtNumDocumentEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese el campo Numero de documento");
            txtNumDocumentEdit.requestFocus();
            return;
        }

        if (txtNameEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese el campo de Nombres");
            txtNameEdit.requestFocus();
            return;
        }
        if (txtApellidosEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese el campo de Apellidos");
            txtApellidosEdit.requestFocus();
            return;
        }

        if (txtEstadoCivilEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese el campo Estado civil");
            txtEstadoCivilEdit.requestFocus();
            return;
        }

        if (txtSexoEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese el campo Sexo");
            txtSexoEdit.requestFocus();
            return;
        }

        if (txtDireccionEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese el campo Direccion");
            txtDireccionEdit.requestFocus();
            return;
        }

        if (txtTelefonoEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese el campo Telefono");
            txtTelefono.requestFocus();
            return;
        }

        if (txtFechaNacimientoEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese el campo Fecha de nacimiento");
            txtFechaNacimientoEdit.requestFocus();
            return;
        }

        Funcionario fun = new Funcionario();
        fun.setTipo_identificacion(txtTipoDocumentoEdit.getText().trim());
        fun.setNumero_identificacion(txtNumDocumentEdit.getText().trim());
        fun.setNombres(txtNameEdit.getText().trim());
        fun.setApellidos(txtApellidosEdit.getText().trim());
        fun.setEstado_civil(txtEstadoCivilEdit.getText().trim());
        fun.setSexo(txtSexoEdit.getText().trim());
        fun.setDireccion(txtDireccionEdit.getText().trim());
        fun.setTelefono(txtTelefonoEdit.getText().trim());
        fun.setFecha_nacimiento(txtFechaNacimientoEdit.getText().trim());

        int opt = JOptionPane.showConfirmDialog(null, "¿Desea actualizar el Funcionario?", "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (opt == 0) {
            try {
                funcionarioController.actualizarFuncionario(Integer.parseInt(txtID.getText()), fun);

                txtTipoDocumentoEdit.setText("");
                txtNumDocumentEdit.setText("");
                txtNameEdit.setText("");
                txtApellidosEdit.setText("");
                txtEstadoCivilEdit.setText("");
                txtSexoEdit.setText("");
                txtDireccionEdit.setText("");
                txtTelefonoEdit.setText("");
                txtFechaNacimientoEdit.setText("");

                listFuncionarios();

                JOptionPane.showInternalMessageDialog(null, "Funcionario actualizado correctamente");

            } catch (Exception ex) {
                ex.printStackTrace();

                JOptionPane.showInternalMessageDialog(null, "No se ha actualizado el funcionario");
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (txtID.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione un Funcionario de la lista");
            txtID.requestFocus();
            return;
        }
        int opt = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el Funcionario?", "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (opt == 0) {
            try {
                funcionarioController.eliminarFuncionario(Integer.parseInt(txtID.getText()));

                txtTipoDocumentoEdit.setText("");
                txtNumDocumentEdit.setText("");
                txtNameEdit.setText("");
                txtApellidosEdit.setText("");
                txtEstadoCivilEdit.setText("");
                txtSexoEdit.setText("");
                txtDireccionEdit.setText("");
                txtTelefonoEdit.setText("");
                txtFechaNacimientoEdit.setText("");

                listFuncionarios();

                JOptionPane.showInternalMessageDialog(null, "Funcionario eliminado correctamente");

            } catch (Exception ex) {
                ex.printStackTrace();

                JOptionPane.showInternalMessageDialog(null, "No se ha eliminado el funcionario");
            }
        }

    }//GEN-LAST:event_btnDeleteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<Funcionario> cbxFuncionario;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JPanel jPFuncionario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelUpdate;
    private javax.swing.JTabbedPane jPanesls;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblAppelidosEdit;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblDireccionEdit;
    private javax.swing.JLabel lblEstadoCivil;
    private javax.swing.JLabel lblEstadoCivilEdit;
    private javax.swing.JLabel lblFechaNacimientoEdit;
    private javax.swing.JLabel lblFuncionrioEdit;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNameEdit;
    private javax.swing.JLabel lblNumDocument;
    private javax.swing.JLabel lblNumDocumentEdit;
    private javax.swing.JLabel lblSexEdit;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTelefonoEdit;
    private javax.swing.JLabel lblTipoDocument;
    private javax.swing.JLabel lblTipoDocumentEdit;
    private javax.swing.JTable tblFunction;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtApellidosEdit;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDireccionEdit;
    private javax.swing.JTextField txtEstadoCivil;
    private javax.swing.JTextField txtEstadoCivilEdit;
    private javax.swing.JTextField txtFechaNacimiento;
    private javax.swing.JTextField txtFechaNacimientoEdit;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNameEdit;
    private javax.swing.JTextField txtNumDocument;
    private javax.swing.JTextField txtNumDocumentEdit;
    private javax.swing.JTextField txtSexo;
    private javax.swing.JTextField txtSexoEdit;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTelefonoEdit;
    private javax.swing.JTextField txtTipoDocument;
    private javax.swing.JTextField txtTipoDocumentoEdit;
    // End of variables declaration//GEN-END:variables
}
