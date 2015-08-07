/**
 *
 * @author pquiring
 *
 * Created : Sept 7, 2013
 *
 */

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javaforce.*;
import javaforce.gl.*;

public class GLProps extends javax.swing.JPanel implements KeyListener {

  /**
   * Creates new form GLProps
   */
  public GLProps(Element e, float _fov) {
    initComponents();
    use3d.setSelected(e.use3d);
    tx.setText(String.format("%.4f", e.tx));
    ty.setText(String.format("%.4f", e.ty));
    tz.setText(String.format("%.4f", e.tz));
    rx.setText(String.format("%.4f", e.rx));
    ry.setText(String.format("%.4f", e.ry));
    rz.setText(String.format("%.4f", e.rz));
    image = new JFImage();
    image.load(getClass().getResourceAsStream("img200.png"));
    previewImage.addKeyListener(this);
    previewImage.setFocusable(true);
    if (e.type == Element.TYPE_CAMERA) {
      use3d.setVisible(false);
      fov.setText(String.format("%.4f", _fov));
    } else {
      fov.setText("60.0");
      fov.setVisible(false);
      fovLabel.setVisible(false);
    }
    width = 288; //previewImage.getWidth();
    height = 177;  //previewImage.getHeight();
    off = new GLOffscreen();
    off.createOffscreen(width, height);
    offimage = new JFImage();
    offimage.setSize(width, height);
    initGL();
    timer = new Timer();
    timer.schedule(new TimerTask() {
      public void run() {
        updateImage();
      }
    },100,100);
  }

  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
   * content of this method is always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel12 = new javax.swing.JLabel();
    use3d = new javax.swing.JCheckBox();
    preview = new javax.swing.JPanel();
    previewImage = new java.awt.Canvas();
    jPanel2 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    tx = new javax.swing.JTextField();
    ty = new javax.swing.JTextField();
    tz = new javax.swing.JTextField();
    jPanel3 = new javax.swing.JPanel();
    rz = new javax.swing.JTextField();
    jLabel4 = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();
    ry = new javax.swing.JTextField();
    rx = new javax.swing.JTextField();
    jLabel6 = new javax.swing.JLabel();
    jLabel7 = new javax.swing.JLabel();
    jLabel8 = new javax.swing.JLabel();
    jLabel9 = new javax.swing.JLabel();
    jLabel10 = new javax.swing.JLabel();
    jLabel11 = new javax.swing.JLabel();
    fovLabel = new javax.swing.JLabel();
    fov = new javax.swing.JTextField();
    reset = new javax.swing.JButton();

    jLabel12.setText("jLabel12");

    use3d.setText("Enable 3D position");

    preview.setBorder(javax.swing.BorderFactory.createTitledBorder("Preview"));
    preview.setPreferredSize(new java.awt.Dimension(300, 200));

    javax.swing.GroupLayout previewLayout = new javax.swing.GroupLayout(preview);
    preview.setLayout(previewLayout);
    previewLayout.setHorizontalGroup(
      previewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(previewImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    previewLayout.setVerticalGroup(
      previewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(previewImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Position"));

    jLabel1.setText("X");

    jLabel2.setText("Y");

    jLabel3.setText("Z");

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addComponent(jLabel3)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(tz))
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addComponent(jLabel1)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(tx))
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addComponent(jLabel2)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(ty))
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel1)
          .addComponent(tx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel2)
          .addComponent(ty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel3)
          .addComponent(tz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
    );

    jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Rotation"));

    jLabel4.setText("Z");

    jLabel5.setText("Y");

    jLabel6.setText("X");

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createSequentialGroup()
        .addComponent(jLabel4)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(rz, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
      .addGroup(jPanel3Layout.createSequentialGroup()
        .addComponent(jLabel6)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(rx))
      .addGroup(jPanel3Layout.createSequentialGroup()
        .addComponent(jLabel5)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(ry))
    );
    jPanel3Layout.setVerticalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createSequentialGroup()
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel6)
          .addComponent(rx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel5)
          .addComponent(ry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel4)
          .addComponent(rz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
    );

    jLabel7.setText("Click on Preview to adjust position/rotation with these keys:");

    jLabel8.setText("A,D,W,S = adjust position left/right/up/down");

    jLabel9.setText("Arrow Keys = adjust rotation");

    jLabel10.setText("R,F = adjust position in/out");

    jLabel11.setText("Z,X = spin image");

    fovLabel.setText("FOV");

    reset.setText("Reset");
    reset.setMargin(new java.awt.Insets(2, 4, 2, 4));
    reset.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        resetActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
              .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(preview, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(jLabel7)
          .addGroup(layout.createSequentialGroup()
            .addGap(10, 10, 10)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel9)
              .addComponent(jLabel8)
              .addComponent(jLabel10)
              .addComponent(jLabel11)))
          .addGroup(layout.createSequentialGroup()
            .addComponent(use3d)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(fovLabel)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(fov, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(reset)))
        .addContainerGap(27, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(use3d)
          .addComponent(fovLabel)
          .addComponent(fov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(reset))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(preview, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jLabel7)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jLabel8)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jLabel9)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jLabel10)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jLabel11)
        .addContainerGap(14, Short.MAX_VALUE))
    );
  }// </editor-fold>//GEN-END:initComponents

  private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
    tx.setText("0.0");
    ty.setText("0.0");
    tz.setText("0.0");
    rx.setText("0.0");
    ry.setText("0.0");
    rz.setText("0.0");
    fov.setText("60.0");
  }//GEN-LAST:event_resetActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JTextField fov;
  private javax.swing.JLabel fovLabel;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel10;
  private javax.swing.JLabel jLabel11;
  private javax.swing.JLabel jLabel12;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JLabel jLabel9;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JPanel jPanel3;
  private javax.swing.JPanel preview;
  private java.awt.Canvas previewImage;
  private javax.swing.JButton reset;
  private javax.swing.JTextField rx;
  private javax.swing.JTextField ry;
  private javax.swing.JTextField rz;
  private javax.swing.JTextField tx;
  private javax.swing.JTextField ty;
  private javax.swing.JTextField tz;
  private javax.swing.JCheckBox use3d;
  // End of variables declaration//GEN-END:variables

  GLScene scene;
  GLModel model;
  GLObject object;
  GLRender render;
  JFImage image;
  java.util.Timer timer;
  GLOffscreen off;
  JFImage offimage;
  int width,height;

  public void save(Element e) {
    if (tx.getText().length() == 0) tx.setText("0");
    if (ty.getText().length() == 0) ty.setText("0");
    if (tz.getText().length() == 0) tz.setText("0");
    if (rx.getText().length() == 0) rx.setText("0");
    if (ry.getText().length() == 0) ry.setText("0");
    if (rz.getText().length() == 0) rz.setText("0");
    if (fov.getText().length() == 0) fov.setText("0");
    e.use3d = use3d.isSelected();
    e.tx = Float.valueOf(tx.getText());
    e.ty = Float.valueOf(ty.getText());
    e.tz = Float.valueOf(tz.getText());
    e.rx = Float.valueOf(rx.getText());
    e.ry = Float.valueOf(ry.getText());
    e.rz = Float.valueOf(rz.getText());
  }

  public float getFOV() {
    return Float.valueOf(fov.getText());
  }

  private void initGL() {
    JFLog.log("GLProps.init()");
    MainPanel.gl.pool();
    scene = new GLScene();
    scene.init(GLVertexShader.source, GLFragmentShader.source);
    render = new GLRender();
    render.init(scene, 512, 512);
    model = new GLModel();
    scene.addModel(model);
    object = new GLObject();
    model.addObject(object);
    model.addTexture("0");
    //need to calc based on w,h,fov
    float z = 5.0f;
    float x = 2.0f;
    float y = 2.0f;
    GLUVMap map = object.createUVMap();
    map.textureIndex = 0;
    map.texloaded = true;  //direct loaded
    object.addVertex(new float[] {-x,-y,-z}, new float[] {0,1});
    object.addVertex(new float[] {+x,-y,-z}, new float[] {1,1});
    object.addVertex(new float[] {-x,+y,-z}, new float[] {0,0});
    object.addVertex(new float[] {+x,+y,-z}, new float[] {1,0});
    object.addPoly(new int[] {0,3,2});
    object.addPoly(new int[] {0,1,3});
    object.copyBuffers();
    scene.setTexture("0", image.getPixels(), image.getWidth(), image.getHeight(), 0);
    x = Float.valueOf(tx.getText());
    y = Float.valueOf(ty.getText());
    z = Float.valueOf(tz.getText());
    model.translate(x, y, z);
    x = Float.valueOf(rx.getText());
    y = Float.valueOf(ry.getText());
    z = Float.valueOf(rz.getText());
    model.rotate(x, 1.0f, 0, 0);
    model.rotate(y, 0, 1.0f, 0);
    model.rotate(z, 0, 0, 1.0f);
  }

  public void render() {
    try {
      java.awt.EventQueue.invokeAndWait(new Runnable() {
        public void run() {
          MainPanel.gl.pool();
          float x,y,z;
          model.setIdentity();
          x = Float.valueOf(rx.getText());
          y = Float.valueOf(ry.getText());
          z = Float.valueOf(rz.getText());
          model.rotate(x, 1.0f, 0.0f, 0.0f);
          model.rotate(y, 0.0f, 1.0f, 0.0f);
          model.rotate(z, 0.0f, 0.0f, 1.0f);
          x = Float.valueOf(tx.getText());
          y = Float.valueOf(ty.getText());
          z = Float.valueOf(tz.getText());
          model.translate(x,y,z);
          x = Float.valueOf(fov.getText());
          render.fovy = x;
          render.render();
          offimage.putPixels(off.getOffscreenPixels(), 0,0,width,height,0);
          previewImage.getGraphics().drawImage(offimage.getImage(), 0, 0, null);
        }
      });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void uninit() {
    timer.cancel();
  }

  public void resize(GL gl, int width, int height) {
    render.resize(width, height);
  }

  private static float delta = 0.1f;
  private static float angle = 1.0f;

  public void keyTyped(KeyEvent e) {
  }

  public void keyPressed(KeyEvent e) {
    char ch = e.getKeyChar();
    int cc = e.getKeyCode();
    float f;
    switch (ch) {
      case 'a':
        f = Float.valueOf(tx.getText());
        f -= delta;
        tx.setText(String.format("%.4f", f));
        break;
      case 's':
        f = Float.valueOf(ty.getText());
        f -= delta;
        ty.setText(String.format("%.4f", f));
        break;
      case 'd':
        f = Float.valueOf(tx.getText());
        f += delta;
        tx.setText(String.format("%.4f", f));
        break;
      case 'w':
        f = Float.valueOf(ty.getText());
        f += delta;
        ty.setText(String.format("%.4f", f));
        break;
      case 'r':
        f = Float.valueOf(tz.getText());
        f += delta;
        tz.setText(String.format("%.4f", f));
        break;
      case 'f':
        f = Float.valueOf(tz.getText());
        f -= delta;
        tz.setText(String.format("%.4f", f));
        break;
      case 'z':
        f = Float.valueOf(rz.getText());
        f += angle;
        rz.setText(String.format("%.4f", f));
        break;
      case 'x':
        f = Float.valueOf(rz.getText());
        f -= angle;
        rz.setText(String.format("%.4f", f));
        break;
    }
    switch (cc) {
      case KeyEvent.VK_UP:
        f = Float.valueOf(rx.getText());
        f += angle;
        rx.setText(String.format("%.4f", f));
        break;
      case KeyEvent.VK_DOWN:
        f = Float.valueOf(rx.getText());
        f -= angle;
        rx.setText(String.format("%.4f", f));
        break;
      case KeyEvent.VK_LEFT:
        f = Float.valueOf(ry.getText());
        f += angle;
        ry.setText(String.format("%.4f", f));
        break;
      case KeyEvent.VK_RIGHT:
        f = Float.valueOf(ry.getText());
        f -= angle;
        ry.setText(String.format("%.4f", f));
        break;
    }
  }

  public void keyReleased(KeyEvent e) {
  }

  public void updateImage() {
    render();
  }
}
