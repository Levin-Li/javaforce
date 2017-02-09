/** EditTagPopup
 *
 * @author pquiring
 */

import javaforce.webui.*;

public class EditTagPopup extends PopupPanel {
  public static int delays[] = new int[] {
    25, 50, 100, 500, 1000, 3000, 5000, 10000, 30000, 60000, 300000
  };
  public static String delays_txt[] = new String[] {
    "25ms", "50ms", "100ms", "500ms", "1s", "3s", "5s", "10s", "30s", "60s", "300s"
  };
  public EditTagPopup(ColorChooserPopup ccp) {
    super("Edit Tag");
    this.ccp = ccp;
    setModal(true);

    Row row;
    Label label;

    row = new Row();
    add(row);
    label = new Label("Type");
    row.add(label);
    type = new ComboBox();
    row.add(type);
    type.add("S7", "Siemens S7 PLC");
    type.add("AB", "Allen Bradley PLC");
    type.add("MB", "Modbus TCP");
    type.add("NI", "National Instruments");

    row = new Row();
    add(row);
    label = new Label("Host");
    row.add(label);
    host = new TextField("");
    row.add(host);

    row = new Row();
    add(row);
    label = new Label("Tag");
    row.add(label);
    tag = new TextField("");
    row.add(tag);

    row = new Row();
    add(row);
    label = new Label("Size");
    row.add(label);
    size = new ComboBox();
    row.add(size);
    size.add("0", "bit");
    size.add("1", "int8");
    size.add("2", "int16");
    size.add("3", "int32");
    size.add("4", "float32");
    size.add("5", "float64");

    row = new Row();
    add(row);
    label = new Label("Speed");
    row.add(label);
    delay = new ComboBox();
    row.add(delay);
    for(int a=0;a<delays.length;a++) {
      delay.add(Integer.toString(delays[a]), delays_txt[a]);
    }

    row = new Row();
    add(row);
    label = new Label("Max");
    row.add(label);
    max = new TextField("");
    row.add(max);

    row = new Row();
    add(row);
    label = new Label("Min");
    row.add(label);
    min = new TextField("");
    row.add(min);

    row = new Row();
    add(row);
    label = new Label("Color");
    row.add(label);
    color = new Button("Select...");
    color.setColor("#ffffff");
    row.add(color);

    row = new Row();
    add(row);
    ok = new Button("OK");
    row.add(ok);
    cancel = new Button("Cancel");
    row.add(cancel);

    color.addClickListener((me, c) -> {
      ccp.setValue(rgb);
      ccp.setVisible(true);
    });

    ok.addClickListener((me, c) -> {
      if (!validate()) return;
      setVisible(false);
      action();
    });
    cancel.addClickListener((me, c) -> {
      setVisible(false);
    });
    ccp.addActionListener((c) -> {
      rgb = ccp.getValue();
      System.out.println("rgb=" + rgb);
      color.setBackColor(String.format("#%06x" , rgb, 16));
    });
  }
  public ComboBox type;
  public TextField host;
  public TextField tag;
  public ComboBox size;
  public ComboBox delay;
  public TextField max, min;
  public Button color;
  public Button ok, cancel;
  public int rgb;

  public ColorChooserPopup ccp;

  public void editTag(Tag intag) {
    switch (intag.type) {
      case S7: type.setSelectedIndex(0); break;
      case AB: type.setSelectedIndex(1); break;
      case MB: type.setSelectedIndex(2); break;
      case NI: type.setSelectedIndex(3); break;
    }
    host.setText(intag.host);
    tag.setText(intag.tag);
    size.setSelectedIndex(intag.size.ordinal());
    for(int a=0;a<delays.length;a++) {
      if (delays[a] == intag.delay) {delay.setSelectedIndex(a); break;}
    }
    max.setText(Integer.toString(intag.max));
    min.setText(Integer.toString(intag.min));
    rgb = intag.color;
    color.setBackColor(String.format("#%06x" , intag.color, 16));
    setVisible(true);
  }
  public void newTag() {
    type.setSelectedIndex(0);
    host.setText("");
    tag.setText("");
    size.setSelectedIndex(0);
    delay.setSelectedIndex(4);  //1s default
    max.setText("1");
    min.setText("0");
    rgb = 0;
    color.setBackColor("#000000");
    setVisible(true);
  }
  public int str2int(String in) {
    try {
      return Integer.valueOf(in);
    } catch (Exception e) {
      return 0;
    }
  }
  public float str2float(String in) {
    try {
      return Float.valueOf(in);
    } catch (Exception e) {
      return 0;
    }
  }
  public void saveTag(Tag outtag) {
    outtag.type = Tag.types.values()[type.getSelectedIndex()];
    outtag.host = host.getText();
    outtag.tag = tag.getText();
    outtag.size = Tag.sizes.values()[size.getSelectedIndex()];
    outtag.delay = delays[delay.getSelectedIndex()];
    if (outtag.size == Tag.sizes.float32 || outtag.size == Tag.sizes.float64) {
      outtag.fmax = Float.valueOf(max.getText());
      outtag.fmin = Float.valueOf(min.getText());
    } else {
      outtag.max = Integer.valueOf(max.getText());
      outtag.min = Integer.valueOf(min.getText());
    }
    outtag.color = rgb;
  }
}
