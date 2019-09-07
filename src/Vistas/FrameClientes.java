/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Clientes.entities.AccionesCliente;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author yosua
 */
public class FrameClientes extends javax.swing.JFrame {

    private AccionesCliente acciones;

    public FrameClientes() {
        initComponents();
        acciones = new AccionesCliente(this);
        acciones.cargarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        diagAddCliente = new javax.swing.JDialog();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblApellidos = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        lblDNI = new javax.swing.JLabel();
        txtDNI = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        lblDescuento = new javax.swing.JLabel();
        spnDescuento = new javax.swing.JSpinner();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        diagEditarCliente = new javax.swing.JDialog();
        lblNombreEditar = new javax.swing.JLabel();
        txtNombreEditar = new javax.swing.JTextField();
        lblApellidosEditar = new javax.swing.JLabel();
        txtApellidosEditar = new javax.swing.JTextField();
        lblDNIEditar = new javax.swing.JLabel();
        txtDNIEditar = new javax.swing.JTextField();
        lblTelefonoEditar = new javax.swing.JLabel();
        txtTelefonoEditar = new javax.swing.JTextField();
        lblDescuentoEditar = new javax.swing.JLabel();
        spnDescuentoEditar = new javax.swing.JSpinner();
        btnAceptarEditar = new javax.swing.JButton();
        btnCancelarEditar = new javax.swing.JButton();
        scpTablaClientes = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        panelBotones = new javax.swing.JPanel();
        btnAddCliente = new javax.swing.JButton();
        btnEditarCliente = new javax.swing.JButton();
        btnEliminarCliente = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        diagAddCliente.setTitle("NUEVO CLIENTE");
        diagAddCliente.setAlwaysOnTop(true);
        diagAddCliente.setMinimumSize(new java.awt.Dimension(330, 370));
        diagAddCliente.setModal(true);
        diagAddCliente.setPreferredSize(new java.awt.Dimension(330, 370));

        lblNombre.setText("Nombre:");

        lblApellidos.setText("Apellidos:");

        lblDNI.setText("DNI:");

        lblTelefono.setText("Teléfono:");

        lblDescuento.setText("Descuento:");

        spnDescuento.setModel(new javax.swing.SpinnerNumberModel(0, 0, 20, 1));

        btnAceptar.setText("Aceptar");
        btnAceptar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout diagAddClienteLayout = new javax.swing.GroupLayout(diagAddCliente.getContentPane());
        diagAddCliente.getContentPane().setLayout(diagAddClienteLayout);
        diagAddClienteLayout.setHorizontalGroup(
            diagAddClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(diagAddClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(diagAddClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblApellidos)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDNI)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, diagAddClienteLayout.createSequentialGroup()
                        .addGroup(diagAddClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(diagAddClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                .addComponent(txtDNI, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(lblTelefono)
                            .addGroup(diagAddClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(spnDescuento, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblDescuento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(diagAddClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        diagAddClienteLayout.setVerticalGroup(
            diagAddClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(diagAddClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblApellidos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDNI)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(diagAddClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(diagAddClienteLayout.createSequentialGroup()
                        .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTelefono)
                        .addGap(14, 14, 14)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(diagAddClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(diagAddClienteLayout.createSequentialGroup()
                        .addComponent(lblDescuento)
                        .addGap(15, 15, 15)
                        .addComponent(spnDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(88, Short.MAX_VALUE))
        );

        diagEditarCliente.setTitle("EDITAR CLIENTE");
        diagEditarCliente.setAlwaysOnTop(true);
        diagEditarCliente.setMinimumSize(new java.awt.Dimension(330, 370));
        diagEditarCliente.setModal(true);
        diagEditarCliente.setPreferredSize(new java.awt.Dimension(330, 370));

        lblNombreEditar.setText("Nombre:");

        lblApellidosEditar.setText("Apellidos:");

        lblDNIEditar.setText("DNI:");

        lblTelefonoEditar.setText("Teléfono:");

        lblDescuentoEditar.setText("Descuento:");

        spnDescuentoEditar.setModel(new javax.swing.SpinnerNumberModel(0, 0, 20, 1));

        btnAceptarEditar.setText("Aceptar");
        btnAceptarEditar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAceptarEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarEditarActionPerformed(evt);
            }
        });

        btnCancelarEditar.setText("Cancelar");
        btnCancelarEditar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCancelarEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout diagEditarClienteLayout = new javax.swing.GroupLayout(diagEditarCliente.getContentPane());
        diagEditarCliente.getContentPane().setLayout(diagEditarClienteLayout);
        diagEditarClienteLayout.setHorizontalGroup(
            diagEditarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(diagEditarClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(diagEditarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblNombreEditar)
                    .addComponent(txtNombreEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblApellidosEditar)
                    .addComponent(txtApellidosEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDNIEditar)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, diagEditarClienteLayout.createSequentialGroup()
                        .addGroup(diagEditarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(diagEditarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtTelefonoEditar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                .addComponent(txtDNIEditar, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(lblTelefonoEditar)
                            .addGroup(diagEditarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(spnDescuentoEditar, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblDescuentoEditar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(diagEditarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAceptarEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCancelarEditar, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        diagEditarClienteLayout.setVerticalGroup(
            diagEditarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(diagEditarClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNombreEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblApellidosEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtApellidosEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDNIEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(diagEditarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(diagEditarClienteLayout.createSequentialGroup()
                        .addComponent(txtDNIEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTelefonoEditar)
                        .addGap(14, 14, 14)
                        .addComponent(txtTelefonoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAceptarEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(diagEditarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(diagEditarClienteLayout.createSequentialGroup()
                        .addComponent(lblDescuentoEditar)
                        .addGap(15, 15, 15)
                        .addComponent(spnDescuentoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCancelarEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(88, Short.MAX_VALUE))
        );

        setTitle("EDITAR CLIENTES");
        setAlwaysOnTop(true);

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "NOMBRE", "APELLIDOS", "DNI", "TELEFONO", "DESCUENTO"
            }
        ));
        scpTablaClientes.setViewportView(tablaClientes);

        panelBotones.setLayout(new java.awt.GridLayout());

        btnAddCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/add.png"))); // NOI18N
        btnAddCliente.setToolTipText("AÑADIR CLIENTE");
        btnAddCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddClienteActionPerformed(evt);
            }
        });
        panelBotones.add(btnAddCliente);

        btnEditarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/edit.png"))); // NOI18N
        btnEditarCliente.setToolTipText("EDITAR CLIENTE");
        btnEditarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarClienteActionPerformed(evt);
            }
        });
        panelBotones.add(btnEditarCliente);

        btnEliminarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/eliminar.png"))); // NOI18N
        btnEliminarCliente.setToolTipText("ELIMINAR CLIENTE");
        btnEliminarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarClienteActionPerformed(evt);
            }
        });
        panelBotones.add(btnEliminarCliente);

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/salir.png"))); // NOI18N
        btnSalir.setToolTipText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        panelBotones.add(btnSalir);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scpTablaClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 793, Short.MAX_VALUE)
            .addComponent(panelBotones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(scpTablaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddClienteActionPerformed
        txtNombre.setText("");
        txtApellidos.setText("");
        txtDNI.setText("");
        txtTelefono.setText("");
        diagAddCliente.setLocationRelativeTo(this);
        diagAddCliente.setVisible(true);
    }//GEN-LAST:event_btnAddClienteActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        acciones.guardarCliente();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        diagAddCliente.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarClienteActionPerformed
        acciones.eliminarCliente();
    }//GEN-LAST:event_btnEliminarClienteActionPerformed

    private void btnAceptarEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarEditarActionPerformed
        acciones.guardarModificacion();
    }//GEN-LAST:event_btnAceptarEditarActionPerformed

    private void btnCancelarEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarEditarActionPerformed
        diagEditarCliente.dispose();
    }//GEN-LAST:event_btnCancelarEditarActionPerformed

    private void btnEditarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarClienteActionPerformed
        acciones.editarCliente();
    }//GEN-LAST:event_btnEditarClienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAceptarEditar;
    private javax.swing.JButton btnAddCliente;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCancelarEditar;
    private javax.swing.JButton btnEditarCliente;
    private javax.swing.JButton btnEliminarCliente;
    private javax.swing.JButton btnSalir;
    private javax.swing.JDialog diagAddCliente;
    private javax.swing.JDialog diagEditarCliente;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblApellidosEditar;
    private javax.swing.JLabel lblDNI;
    private javax.swing.JLabel lblDNIEditar;
    private javax.swing.JLabel lblDescuento;
    private javax.swing.JLabel lblDescuentoEditar;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombreEditar;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTelefonoEditar;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JScrollPane scpTablaClientes;
    private javax.swing.JSpinner spnDescuento;
    private javax.swing.JSpinner spnDescuentoEditar;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtApellidosEditar;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtDNIEditar;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreEditar;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTelefonoEditar;
    // End of variables declaration//GEN-END:variables

    /**
     * Getter del scpTablaClientes
     *
     * @return JScrollPane tablaClientes
     */
    public JScrollPane getScpTablaClientes() {
        return scpTablaClientes;
    }

    /**
     * Getter de la tablaClientes
     *
     * @return JTable tablaClientes
     */
    public JTable getTablaClientes() {
        return tablaClientes;
    }

    /**
     * Getter del spnDescuento
     *
     * @return JSpinner descuento
     */
    public JSpinner getSpnDescuento() {
        return spnDescuento;
    }

    /**
     * Getter del txtApellidos
     *
     * @return JTextField apellidos
     */
    public JTextField getTxtApellidos() {
        return txtApellidos;
    }

    /**
     * Getter del txtDNI
     *
     * @return JTextField DNI
     */
    public JTextField getTxtDNI() {
        return txtDNI;
    }

    /**
     * Getter del txtNombre
     *
     * @return JTextField nombre
     */
    public JTextField getTxtNombre() {
        return txtNombre;
    }

    /**
     * Getter del txtTelefono
     *
     * @return JTextField telefono
     */
    public JTextField getTxtTelefono() {
        return txtTelefono;
    }

    /**
     * Getter del diagAddCliente
     *
     * @return JDialog addCliente
     */
    public JDialog getDiagAddCliente() {
        return diagAddCliente;
    }

    /**
     * Getter del diagEditarCliente
     *
     * @return JDialog editarCliente
     */
    public JDialog getDiagEditarCliente() {
        return diagEditarCliente;
    }

    /**
     * Getter del spnDescuentoEditar
     *
     * @return JSpinner descuentoEditar
     */
    public JSpinner getSpnDescuentoEditar() {
        return spnDescuentoEditar;
    }

    /**
     * Getter del txtApellidosEditar
     *
     * @return JTextField apellidosEditar
     */
    public JTextField getTxtApellidosEditar() {
        return txtApellidosEditar;
    }

    /**
     * Getter del txtDNIEditar
     *
     * @return JTextField DNIEditar
     */
    public JTextField getTxtDNIEditar() {
        return txtDNIEditar;
    }

    /**
     * Getter del txtNombreEditar
     *
     * @return JTextField nombreEditar
     */
    public JTextField getTxtNombreEditar() {
        return txtNombreEditar;
    }

    /**
     * Getter del txtTelefonoEditar
     *
     * @return JTextField telefonoEditar
     */
    public JTextField getTxtTelefonoEditar() {
        return txtTelefonoEditar;
    }
    
    

}
