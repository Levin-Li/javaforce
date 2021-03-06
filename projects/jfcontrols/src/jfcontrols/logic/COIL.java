package jfcontrols.logic;

/** Examine On.
 *
 * @author pquiring
 */

import javaforce.controls.*;

public class COIL extends Logic {

  public boolean isBlock() {
    return false;
  }

  public String getDesc() {
    return "Coil";
  }

  public String getCode(int[] types, boolean[] array, boolean[] unsigned) {
    return "    tags[1].setBoolean(enabled);\r\n";
  }

  public int getTagsCount() {
    return 1;
  }

  public int getTagType(int idx) {
    return TagType.bit;
  }
}
