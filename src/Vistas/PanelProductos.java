/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Principal.TPVFrame;
import Productos.entities.AccionesProducto;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author yosua
 */
public class PanelProductos extends javax.swing.JPanel {

    private TPVFrame frame;
    private AccionesProducto acciones;

    public PanelProductos(TPVFrame frame) {
        this.frame = frame;
        initComponents();
        acciones = new AccionesProducto(this);
        acciones.cargarTabla();
        acciones.cargarFamilias();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        frameAddProducto = new javax.swing.JFrame();
        lblFamilia = new javax.swing.JLabel();
        cmbFamilia = new javax.swing.JComboBox<>();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblPrecio = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        lblIcono = new javax.swing.JLabel();
        txtRutaIcono = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        lblMostrarIcono = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        frameEditarProducto = new javax.swing.JFrame();
        lblFamiliaEditar = new javax.swing.JLabel();
        cmbFamiliaEditar = new javax.swing.JComboBox<>();
        lblNombreEditar = new javax.swing.JLabel();
        txtNombreEditar = new javax.swing.JTextField();
        lblPrecioEditar = new javax.swing.JLabel();
        txtPrecioEditar = new javax.swing.JTextField();
        lblIconoEditar = new javax.swing.JLabel();
        txtRutaIconoEditar = new javax.swing.JTextField();
        btnBuscarEditar = new javax.swing.JButton();
        lblMostrarIconoEditar = new javax.swing.JLabel();
        btnAceptarEditar = new javax.swing.JButton();
        btnCancelarEditar = new javax.swing.JButton();
        scpTablaProductos = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        panelBotones = new javax.swing.JPanel();
        btnAddProducto = new javax.swing.JButton();
        btnEditarProducto = new javax.swing.JButton();
        btnEliminarProducto = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        frameAddProducto.setTitle("Añadir producto");
        frameAddProducto.setMinimumSize(new java.awt.Dimension(480, 440));
        frameAddProducto.setPreferredSize(new java.awt.Dimension(480, 440));

        lblFamilia.setText("Familia:");

        lblNombre.setText("Nombre:");

        lblPrecio.setText("Precio:");

        lblIcono.setText("Ruta Icono:");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        lblMostrarIcono.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout frameAddProductoLayout = new javax.swing.GroupLayout(frameAddProducto.getContentPane());
        frameAddProducto.getContentPane().setLayout(frameAddProductoLayout);
        frameAddProductoLayout.setHorizontalGroup(
            frameAddProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frameAddProductoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(frameAddProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIcono)
                    .addGroup(frameAddProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(frameAddProductoLayout.createSequentialGroup()
                            .addGroup(frameAddProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblPrecio)
                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(frameAddProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblNombre)
                                    .addComponent(lblFamilia)
                                    .addComponent(cmbFamilia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(63, 63, 63)
                            .addComponent(lblMostrarIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(frameAddProductoLayout.createSequentialGroup()
                            .addGroup(frameAddProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(frameAddProductoLayout.createSequentialGroup()
                                    .addComponent(btnAceptar)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnCancelar)
                                    .addGap(18, 18, 18))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, frameAddProductoLayout.createSequentialGroup()
                                    .addComponent(txtRutaIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(btnBuscar))))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        frameAddProductoLayout.setVerticalGroup(
            frameAddProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frameAddProductoLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(lblFamilia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblNombre)
                .addGap(18, 18, 18)
                .addGroup(frameAddProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(frameAddProductoLayout.createSequentialGroup()
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblPrecio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblMostrarIcono, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblIcono)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(frameAddProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(txtRutaIcono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(frameAddProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnAceptar))
                .addContainerGap(103, Short.MAX_VALUE))
        );

        frameEditarProducto.setTitle("Añadir producto");
        frameEditarProducto.setMinimumSize(new java.awt.Dimension(480, 440));
        frameEditarProducto.setPreferredSize(new java.awt.Dimension(480, 440));

        lblFamiliaEditar.setText("Familia:");

        lblNombreEditar.setText("Nombre:");

        lblPrecioEditar.setText("Precio:");

        lblIconoEditar.setText("Ruta Icono:");

        btnBuscarEditar.setText("Buscar");
        btnBuscarEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarEditarActionPerformed(evt);
            }
        });

        lblMostrarIconoEditar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnAceptarEditar.setText("Aceptar");
        btnAceptarEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarEditarActionPerformed(evt);
            }
        });

        btnCancelarEditar.setText("Cancelar");
        btnCancelarEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout frameEditarProductoLayout = new javax.swing.GroupLayout(frameEditarProducto.getContentPane());
        frameEditarProducto.getContentPane().setLayout(frameEditarProductoLayout);
        frameEditarProductoLayout.setHorizontalGroup(
            frameEditarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frameEditarProductoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(frameEditarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIconoEditar)
                    .addGroup(frameEditarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(frameEditarProductoLayout.createSequentialGroup()
                            .addGroup(frameEditarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblPrecioEditar)
                                .addComponent(txtPrecioEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(frameEditarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblNombreEditar)
                                    .addComponent(lblFamiliaEditar)
                                    .addComponent(cmbFamiliaEditar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtNombreEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(63, 63, 63)
                            .addComponent(lblMostrarIconoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(frameEditarProductoLayout.createSequentialGroup()
                            .addGroup(frameEditarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(frameEditarProductoLayout.createSequentialGroup()
                                    .addComponent(btnAceptarEditar)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnCancelarEditar)
                                    .addGap(18, 18, 18))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, frameEditarProductoLayout.createSequentialGroup()
                                    .addComponent(txtRutaIconoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(btnBuscarEditar))))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        frameEditarProductoLayout.setVerticalGroup(
            frameEditarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frameEditarProductoLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(lblFamiliaEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbFamiliaEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblNombreEditar)
                .addGap(18, 18, 18)
                .addGroup(frameEditarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(frameEditarProductoLayout.createSequentialGroup()
                        .addComponent(txtNombreEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblPrecioEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPrecioEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblMostrarIconoEditar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblIconoEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(frameEditarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarEditar)
                    .addComponent(txtRutaIconoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(frameEditarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelarEditar)
                    .addComponent(btnAceptarEditar))
                .addContainerGap(103, Short.MAX_VALUE))
        );

        setPreferredSize(new java.awt.Dimension(800, 800));

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Familia", "Producto", "Precio"
            }
        ));
        scpTablaProductos.setViewportView(tablaProductos);

        panelBotones.setLayout(new java.awt.GridLayout());

        btnAddProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/add.png"))); // NOI18N
        btnAddProducto.setToolTipText("Añadir");
        btnAddProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProductoActionPerformed(evt);
            }
        });
        panelBotones.add(btnAddProducto);

        btnEditarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/edit.png"))); // NOI18N
        btnEditarProducto.setToolTipText("Editar");
        btnEditarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarProductoActionPerformed(evt);
            }
        });
        panelBotones.add(btnEditarProducto);

        btnEliminarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/eliminar.png"))); // NOI18N
        btnEliminarProducto.setToolTipText("Eliminar");
        btnEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProductoActionPerformed(evt);
            }
        });
        panelBotones.add(btnEliminarProducto);

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/salir.png"))); // NOI18N
        btnSalir.setToolTipText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        panelBotones.add(btnSalir);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scpTablaProductos, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
            .addComponent(panelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(scpTablaProductos, javax.swing.GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAddProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProductoActionPerformed
        if (cmbFamilia.getItemCount() > 0) {
            txtNombre.setText("");
            txtPrecio.setText("");
            txtRutaIcono.setText("");
            lblMostrarIcono.setIcon(null);
            frameAddProducto.setLocationRelativeTo(this);
            frameAddProducto.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Debe existir alguna familia"
                    + " para poder añadir productos");
        }
    }//GEN-LAST:event_btnAddProductoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        frameAddProducto.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        acciones.buscarIcono();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        acciones.guardarProducto();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProductoActionPerformed
        acciones.eliminarProducto();
    }//GEN-LAST:event_btnEliminarProductoActionPerformed

    private void btnBuscarEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEditarActionPerformed
        acciones.buscarIcono();
    }//GEN-LAST:event_btnBuscarEditarActionPerformed

    private void btnAceptarEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarEditarActionPerformed
        acciones.guardarModificacion();
    }//GEN-LAST:event_btnAceptarEditarActionPerformed

    private void btnCancelarEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarEditarActionPerformed
        frameEditarProducto.dispose();
    }//GEN-LAST:event_btnCancelarEditarActionPerformed

    private void btnEditarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProductoActionPerformed
        acciones.editarProducto();
    }//GEN-LAST:event_btnEditarProductoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAceptarEditar;
    private javax.swing.JButton btnAddProducto;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarEditar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCancelarEditar;
    private javax.swing.JButton btnEditarProducto;
    private javax.swing.JButton btnEliminarProducto;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cmbFamilia;
    private javax.swing.JComboBox<String> cmbFamiliaEditar;
    private javax.swing.JFrame frameAddProducto;
    private javax.swing.JFrame frameEditarProducto;
    private javax.swing.JLabel lblFamilia;
    private javax.swing.JLabel lblFamiliaEditar;
    private javax.swing.JLabel lblIcono;
    private javax.swing.JLabel lblIconoEditar;
    private javax.swing.JLabel lblMostrarIcono;
    private javax.swing.JLabel lblMostrarIconoEditar;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombreEditar;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblPrecioEditar;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JScrollPane scpTablaProductos;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreEditar;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtPrecioEditar;
    private javax.swing.JTextField txtRutaIcono;
    private javax.swing.JTextField txtRutaIconoEditar;
    // End of variables declaration//GEN-END:variables

    /**
     * Getter del scpTablaProductos
     *
     * @return JScrollPane scpTablaProductos
     */
    public JScrollPane getScpTablaProductos() {
        return scpTablaProductos;
    }

    /**
     * Getter de tablaProductos
     *
     * @return JTable tablaProductos
     */
    public JTable getTablaProductos() {
        return tablaProductos;
    }

    /**
     * Getter del cmbFamilia(frameAddProducto)
     *
     * @return JComboBox getFamilia
     */
    public JComboBox getCmbFamilia() {
        return cmbFamilia;
    }

    /**
     * Getter del frameAddProducto
     *
     * @return JFrame addProducto
     */
    public JFrame getFrameAddProducto() {
        return frameAddProducto;
    }

    /**
     * Getter del lblMostrarIcono(frameAddProducto)
     *
     * @return JLabel mostrarIcono
     */
    public JLabel getLblMostrarIcono() {
        return lblMostrarIcono;
    }

    /**
     * Getter del txtNombre
     *
     * @return JTextField txtNombre
     */
    public JTextField getTxtNombre() {
        return txtNombre;
    }

    /**
     * Getter del txtPrecio
     *
     * @return JTextField txtPrecio
     */
    public JTextField getTxtPrecio() {
        return txtPrecio;
    }

    /**
     * Getter del txtRutaIcono
     *
     * @return JtextField rutaIcono
     */
    public JTextField getTxtRutaIcono() {
        return txtRutaIcono;
    }

    /**
     * Getter del cmbFamiliaEditar(FrameEditarProducto)
     *
     * @return JComboBox cmbFamiliaEditar
     */
    public JComboBox getCmbFamiliaEditar() {
        return cmbFamiliaEditar;
    }

    /**
     * Getter del frameEditarProducto
     *
     * @return JFrame frameEditarProducto
     */
    public JFrame getFrameEditarProducto() {
        return frameEditarProducto;
    }

    /**
     * Getter del lblMostrarIconoEditar(FrameEditarProducto)
     *
     * @return JLabel lblMostrarIconoEditar
     */
    public JLabel getLblMostrarIconoEditar() {
        return lblMostrarIconoEditar;
    }

    /**
     * Getter del txtNombreEditar(FrameEditarProducto)
     *
     * @return JTextField txtNombreEditar
     */
    public JTextField getTxtNombreEditar() {
        return txtNombreEditar;
    }

    /**
     * Getter del txtPrecioEditar(FrameEditarProducto)
     *
     * @return JTextField txtPrecioEditar
     */
    public JTextField getTxtPrecioEditar() {
        return txtPrecioEditar;
    }

    /**
     * Getter del txtRutaIconoEditar(FrameEditarProducto)
     *
     * @return JTextField txtRutaIconoEditar
     */
    public JTextField getTxtRutaIconoEditar() {
        return txtRutaIconoEditar;
    }

}
