/**
 *  add / edit tag dialog.
 *
 * @author pquiring
 */

import java.awt.Color;
import javaforce.*;
import javax.swing.JColorChooser;

public class TagDialog extends javax.swing.JDialog {

  /**
   * Creates new form AddDialog
   */
  public TagDialog(java.awt.Frame parent, boolean modal) {
    super(parent, modal);
    initComponents();
    JF.centerWindow(this);
    color.setBackground(Color.white);
    clr = 0xffffff;
  }

  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel1 = new javax.swing.JLabel();
    type = new javax.swing.JComboBox<>();
    jLabel2 = new javax.swing.JLabel();
    tag = new javax.swing.JTextField();
    ok = new javax.swing.JButton();
    cancel = new javax.swing.JButton();
    jLabel4 = new javax.swing.JLabel();
    size = new javax.swing.JComboBox<>();
    max = new javax.swing.JTextField();
    min = new javax.swing.JTextField();
    jLabel5 = new javax.swing.JLabel();
    jLabel6 = new javax.swing.JLabel();
    jLabel7 = new javax.swing.JLabel();
    host = new javax.swing.JTextField();
    jLabel8 = new javax.swing.JLabel();
    color = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Tag Properties");

    jLabel1.setText("Type");

    type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Siemens", "AllenBradley", "ModBus" }));

    jLabel2.setText("Tag");

    ok.setText("OK");
    ok.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        okActionPerformed(evt);
      }
    });

    cancel.setText("Cancel");
    cancel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        cancelActionPerformed(evt);
      }
    });

    jLabel4.setText("Size");

    size.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "bit", "int8", "int16", "int32", "float32" }));
    size.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(java.awt.event.ItemEvent evt) {
        sizeItemStateChanged(evt);
      }
    });

    max.setText("1");
    max.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        maxActionPerformed(evt);
      }
    });

    min.setText("0");

    jLabel5.setText("max");

    jLabel6.setText("min");

    jLabel7.setText("Host");

    jLabel8.setText("color");

    color.setText("Change...");
    color.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        colorActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel1)
              .addComponent(jLabel7))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(type, 0, 155, Short.MAX_VALUE)
              .addComponent(host)))
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel2)
            .addGap(16, 16, 16)
            .addComponent(tag))
          .addGroup(layout.createSequentialGroup()
            .addComponent(ok)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
            .addComponent(cancel))
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel4)
              .addComponent(jLabel5)
              .addComponent(jLabel6)
              .addComponent(jLabel8))
            .addGap(11, 11, 11)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(color, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(size, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(max)
              .addComponent(min))))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel1)
          .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel7)
          .addComponent(host, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(tag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel2))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(size, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel4))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(max, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel5))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(min, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel6))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel8)
          .addComponent(color))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(ok)
          .addComponent(cancel))
        .addContainerGap())
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okActionPerformed
    accepted = true;
    dispose();
  }//GEN-LAST:event_okActionPerformed

  private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
    accepted = false;
    dispose();
  }//GEN-LAST:event_cancelActionPerformed

  private void sizeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_sizeItemStateChanged
    int idx = size.getSelectedIndex();
    min.setText("0");
    switch (idx) {
      case 0: max.setText("1"); break;
      case 1: max.setText("255"); break;
      case 2: max.setText("65535"); break;
      case 3: max.setText("16777216"); break;
      case 4: max.setText("1.0"); break;
    }
  }//GEN-LAST:event_sizeItemStateChanged

  private void maxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maxActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_maxActionPerformed

  private void colorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorActionPerformed
    changeColor();
  }//GEN-LAST:event_colorActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton cancel;
  private javax.swing.JButton color;
  private javax.swing.JTextField host;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JTextField max;
  private javax.swing.JTextField min;
  private javax.swing.JButton ok;
  private javax.swing.JComboBox<String> size;
  private javax.swing.JTextField tag;
  private javax.swing.JComboBox<String> type;
  // End of variables declaration//GEN-END:variables

  private boolean accepted;
  private int clr;

  public void load(Tag in) {
    switch (in.type) {
      case S7: type.setSelectedIndex(0); break;
      case AB: type.setSelectedIndex(1); break;
      case MB: type.setSelectedIndex(2); break;
    }
    host.setText(in.host);
    tag.setText(in.tag);
    boolean isFloat = false;
    switch (in.size) {
      case bit: size.setSelectedIndex(0); break;
      case int8: size.setSelectedIndex(1); break;
      case int16: size.setSelectedIndex(2); break;
      case int32: size.setSelectedIndex(3); break;
      case float32: size.setSelectedIndex(4); isFloat = true; break;
    }
    if (!isFloat) {
      max.setText(Integer.toString(in.max));
      min.setText(Integer.toString(in.min));
    } else {
      max.setText(Float.toString(in.fmax));
      min.setText(Float.toString(in.fmin));
    }
    color.setBackground(new Color(in.color));
  }

  public boolean save(Tag out) {
    try {
      switch (type.getSelectedIndex()) {
        case 0: out.type = Tag.types.S7; break;
        case 1: out.type = Tag.types.AB; break;
        case 2: out.type = Tag.types.MB; break;
      }
      out.host = host.getText();
      out.tag = tag.getText();
      boolean isFloat = false;
      switch (size.getSelectedIndex()) {
        case 0: out.size = Tag.sizes.bit; break;
        case 1: out.size = Tag.sizes.int8; break;
        case 2: out.size = Tag.sizes.int16; break;
        case 3: out.size = Tag.sizes.int32; break;
        case 4: out.size = Tag.sizes.float32; isFloat = true; break;
      }
      if (!isFloat) {
        out.min = Integer.valueOf(min.getText());
        out.max = Integer.valueOf(max.getText());
      } else {
        out.fmin = Float.valueOf(min.getText());
        out.fmax = Float.valueOf(max.getText());
      }
      out.color = clr;
    } catch (Exception e) {
      JFLog.log(e);
      return false;
    }
    return true;
  }

  public boolean accepted() {
    return accepted;
  }

  public void changeColor() {
    Color newClr = JColorChooser.showDialog(this, "Tag Color", new Color(clr));
    if (newClr == null) return;
    clr = newClr.getRGB();
    color.setBackground(newClr);
  }
}
