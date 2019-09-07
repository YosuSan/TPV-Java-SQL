
package Vistas;

import Facturas.entities.AccionesFactura;
import Principal.TPVFrame;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author yosua
 */
public class PanelFacturas extends javax.swing.JPanel {

    private TPVFrame frame;
    private AccionesFactura acciones;

    public PanelFacturas(TPVFrame frame) {
        this.frame = frame;
        initComponents();
        acciones = new AccionesFactura(this);
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

        frameFactura = new javax.swing.JFrame();
        scpTxtAreaFactura = new javax.swing.JScrollPane();
        txtAreaFactura = new javax.swing.JTextArea();
        frameBuscar = new javax.swing.JFrame();
        lblNombre = new javax.swing.JLabel();
        txtNombreBuscar = new javax.swing.JTextField();
        lblApellidos = new javax.swing.JLabel();
        txtApellidosBuscar = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        btnBuscarNombre = new javax.swing.JButton();
        lblTituloNombre = new javax.swing.JLabel();
        lblTituloFecha = new javax.swing.JLabel();
        spnDia = new javax.swing.JSpinner();
        lblBarra = new javax.swing.JLabel();
        spnMes = new javax.swing.JSpinner();
        lblBarra2 = new javax.swing.JLabel();
        spnAnio = new javax.swing.JSpinner();
        lblDia = new javax.swing.JLabel();
        lblMes = new javax.swing.JLabel();
        lblAnio = new javax.swing.JLabel();
        btnBuscarFecha = new javax.swing.JButton();
        scpTablaFacturas = new javax.swing.JScrollPane();
        tablaFacturas = new javax.swing.JTable();
        pnlBotones = new javax.swing.JPanel();
        btnEliminar = new javax.swing.JButton();
        btnAbrir = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnRefresco = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        frameFactura.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        frameFactura.setMinimumSize(new java.awt.Dimension(700, 700));

        scpTxtAreaFactura.setEnabled(false);

        txtAreaFactura.setColumns(20);
        txtAreaFactura.setRows(5);
        scpTxtAreaFactura.setViewportView(txtAreaFactura);

        javax.swing.GroupLayout frameFacturaLayout = new javax.swing.GroupLayout(frameFactura.getContentPane());
        frameFactura.getContentPane().setLayout(frameFacturaLayout);
        frameFacturaLayout.setHorizontalGroup(
            frameFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scpTxtAreaFactura, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );
        frameFacturaLayout.setVerticalGroup(
            frameFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scpTxtAreaFactura, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );

        frameBuscar.setMinimumSize(new java.awt.Dimension(400, 280));
        frameBuscar.setResizable(false);

        lblNombre.setText("Nombre:");

        lblApellidos.setText("Apellidos:");

        btnBuscarNombre.setText("Buscar");
        btnBuscarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarNombreActionPerformed(evt);
            }
        });

        lblTituloNombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTituloNombre.setText("BUSCAR POR CLIENTE");

        lblTituloFecha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTituloFecha.setText("BUSCAR POR FECHA");

        spnDia.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));

        lblBarra.setText("/");

        spnMes.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));

        lblBarra2.setText("/");

        spnAnio.setModel(new javax.swing.SpinnerNumberModel(2019, 2019, null, 1));

        lblDia.setLabelFor(spnDia);
        lblDia.setText("Dia");

        lblMes.setLabelFor(spnMes);
        lblMes.setText("Mes");

        lblAnio.setLabelFor(spnAnio);
        lblAnio.setText("Año");

        btnBuscarFecha.setText("Buscar");
        btnBuscarFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarFechaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout frameBuscarLayout = new javax.swing.GroupLayout(frameBuscar.getContentPane());
        frameBuscar.getContentPane().setLayout(frameBuscarLayout);
        frameBuscarLayout.setHorizontalGroup(
            frameBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(frameBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(frameBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(frameBuscarLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(frameBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spnDia, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDia))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblBarra)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(frameBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(frameBuscarLayout.createSequentialGroup()
                                .addComponent(spnMes, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblBarra2))
                            .addComponent(lblMes))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(frameBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(frameBuscarLayout.createSequentialGroup()
                                .addComponent(spnAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscarFecha))
                            .addComponent(lblAnio)))
                    .addComponent(lblTituloFecha)
                    .addGroup(frameBuscarLayout.createSequentialGroup()
                        .addGroup(frameBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombre)
                            .addComponent(lblApellidos))
                        .addGap(22, 22, 22)
                        .addGroup(frameBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(frameBuscarLayout.createSequentialGroup()
                                .addComponent(txtApellidosBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscarNombre))))
                    .addComponent(lblTituloNombre))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        frameBuscarLayout.setVerticalGroup(
            frameBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frameBuscarLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(lblTituloNombre)
                .addGap(18, 18, 18)
                .addGroup(frameBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombreBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(frameBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellidos)
                    .addComponent(txtApellidosBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarNombre))
                .addGap(28, 28, 28)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTituloFecha)
                .addGap(14, 14, 14)
                .addGroup(frameBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDia)
                    .addComponent(lblMes)
                    .addComponent(lblAnio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(frameBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spnDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBarra)
                    .addComponent(spnMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBarra2)
                    .addComponent(spnAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarFecha))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        setPreferredSize(new java.awt.Dimension(800, 800));

        tablaFacturas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nº Factura", "Cliente", "Fecha"
            }
        ));
        scpTablaFacturas.setViewportView(tablaFacturas);

        pnlBotones.setLayout(new java.awt.GridLayout(1, 0));

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/eliminar.png"))); // NOI18N
        btnEliminar.setToolTipText("ELIMINAR FACTURA");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        pnlBotones.add(btnEliminar);

        btnAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/open.png"))); // NOI18N
        btnAbrir.setToolTipText("ABRIR FACTURA");
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });
        pnlBotones.add(btnAbrir);

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/search.png"))); // NOI18N
        btnBuscar.setToolTipText("BUSCAR FACTURA");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        pnlBotones.add(btnBuscar);

        btnRefresco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Actualizar.png"))); // NOI18N
        btnRefresco.setToolTipText("REFRESCAR TABLA");
        btnRefresco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescoActionPerformed(evt);
            }
        });
        pnlBotones.add(btnRefresco);

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/salir.png"))); // NOI18N
        btnSalir.setToolTipText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        pnlBotones.add(btnSalir);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scpTablaFacturas)
            .addComponent(pnlBotones, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(scpTablaFacturas, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlBotones, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        acciones.eliminarFactura();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        acciones.mostrarFactura();
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        acciones.resetearValoresBusqueda();
        frameBuscar.setLocationRelativeTo(this);
        frameBuscar.setVisible(true);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnBuscarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarNombreActionPerformed
        acciones.buscarNombre();
        frameBuscar.dispose();
    }//GEN-LAST:event_btnBuscarNombreActionPerformed

    private void btnBuscarFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarFechaActionPerformed
        acciones.buscarFecha();
        frameBuscar.dispose();
    }//GEN-LAST:event_btnBuscarFechaActionPerformed

    private void btnRefrescoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescoActionPerformed
        acciones.cargarTabla();
    }//GEN-LAST:event_btnRefrescoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarFecha;
    private javax.swing.JButton btnBuscarNombre;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRefresco;
    private javax.swing.JButton btnSalir;
    private javax.swing.JFrame frameBuscar;
    private javax.swing.JFrame frameFactura;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAnio;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblBarra;
    private javax.swing.JLabel lblBarra2;
    private javax.swing.JLabel lblDia;
    private javax.swing.JLabel lblMes;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTituloFecha;
    private javax.swing.JLabel lblTituloNombre;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JScrollPane scpTablaFacturas;
    private javax.swing.JScrollPane scpTxtAreaFactura;
    private javax.swing.JSpinner spnAnio;
    private javax.swing.JSpinner spnDia;
    private javax.swing.JSpinner spnMes;
    private javax.swing.JTable tablaFacturas;
    private javax.swing.JTextField txtApellidosBuscar;
    private javax.swing.JTextArea txtAreaFactura;
    private javax.swing.JTextField txtNombreBuscar;
    // End of variables declaration//GEN-END:variables

    /**
     * Getter del scpTablaFacturas
     * 
     * @return JScrollPane tablaFacturas
     */
    public JScrollPane getScpTablaFacturas() {
        return scpTablaFacturas;
    }

    /**
     * Getter de la tablaFacturas
     * 
     * @return JTable facturas
     */
    public JTable getTablaFacturas() {
        return tablaFacturas;
    }

    /**
     * Getter del frameFactura
     * 
     * @return JFrame factura
     */
    public JFrame getFrameFactura() {
        return frameFactura;
    }

    /**
     * Getter del scpTxtAreaFactura
     * 
     * @return JScrollPane TxtAreaFactura
     */
    public JScrollPane getScpTxtAreaFactura() {
        return scpTxtAreaFactura;
    }

    /**
     * Getter del txtAreaFactura
     * 
     * @return JTextArea factura
     */
    public JTextArea getTxtAreaFactura() {
        return txtAreaFactura;
    }

    /**
     * Getter del frameBuscar
     * 
     * @return JFrame buscar
     */
    public JFrame getFrameBuscar() {
        return frameBuscar;
    }

    /**
     * Getter del spnAnio
     * 
     * @return JSpinner anio
     */
    public JSpinner getSpnAnio() {
        return spnAnio;
    }

    /**
     * Getter del spnDia
     * 
     * @return JSpinner dia
     */
    public JSpinner getSpnDia() {
        return spnDia;
    }

    /**
     * Getter del spnMes
     * 
     * @return JSpinner mes
     */
    public JSpinner getSpnMes() {
        return spnMes;
    }

    /**
     * Getter del txtApellidosBuscar
     * 
     * @return JTextField apellidosBuscar
     */
    public JTextField getTxtApellidosBuscar() {
        return txtApellidosBuscar;
    }

    /**
     * Getter del txtNombreBuscar
     * 
     * @return JTextField nombre Buscar
     */
    public JTextField getTxtNombreBuscar() {
        return txtNombreBuscar;
    }
}