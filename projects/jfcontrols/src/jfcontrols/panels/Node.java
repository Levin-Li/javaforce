package jfcontrols.panels;

/** Node */

import java.util.ArrayList;
import javaforce.JFLog;
import jfcontrols.logic.Logic;

/*
Ladder Logic Notation
---------------------
hth#hth
 v   v
 ah#hb
 v   v
 ch#hd
block(t#,c#t#,i#,d#,a#,...) - call block
c# = controller id # (optional, default = 0)
t# = tag id #
i# = immediate id #
d# = digital port
a# = analog port
f# = function id #
Example blocks:
func(c#f#,args...) - call another function
xon(t) - examine bit on
xoff(t) - example bit off
coil(t) - coil output
set(t) - set bit
reset(t) - reset bit
Example Logic:
xon(c1t1)|f(t2,t3)|t|xon(t4)|t|c,xon(t5)|d|coil(t6)
*/

import javaforce.webui.*;
import jfcontrols.images.Images;

public class Node {

  public char type;
  public String args; //if "#"
  public int x;
  public int y;
  public boolean closed;
  public Node prev;
  public Node next;
  public Node upper; //b,d only
  public Node lower; //a,c only
  public Node parent;
  public Logic blk;
  public String tags[];
  public Component comp;
  public NodeRoot root;
  public boolean highlight;  //possible fork dest
  public ArrayList<Node> childs = new ArrayList<Node>();
  public boolean moved;

  public Node addChild(char type, int x, int y) {
    JFLog.log("addChild:" + type);
    Node node = new Node();
    node.root = root;

    node.type = type;
    node.x = x;
    node.y = y;
    node.parent = this;

    childs.add(node);
    return node;
  }

  public Node addChildLower(char type, int x, int y) {
    JFLog.log("addChild:" + type);
    Node node = new Node();
    node.root = root;

    node.type = type;
    node.x = x;
    node.y = y;
    node.parent = this;

    node.lower = this;

    childs.add(node);
    return node;
  }

  public Node addChildUpper(char type, int x, int y) {
    JFLog.log("addChild:" + type);
    Node node = new Node();
    node.root = root;

    node.type = type;
    node.x = x;
    node.y = y;
    node.parent = this;

    node.upper = this;

    childs.add(node);
    return node;
  }

  public Node insertPreNode(char type, int x, int y) {
    JFLog.log("insertPreNode:" + type);
    Node node = new Node();
    node.root = root;
    //insert BEFORE this node
    node.prev = prev;
    node.next = this;
    if (prev != null) prev.next = node;
    prev = node;

    node.type = type;
    node.x = x;
    node.y = y;
    return node;
  }

  public Node insertNode(char type, int x, int y) {
    JFLog.log("insertNode:" + type);
    Node node = new Node();
    node.root = root;
    //insert AFTER this node
    node.prev = this;
    node.next = next;
    if (next != null) next.prev = node;
    next = node;

    node.type = type;
    node.x = x;
    node.y = y;
    return node;
  }

  public Node insertLogic(char type, int x, int y, Logic blk, String tags[]) {
    JFLog.log("insertLogic:" + type);
    Node node = new Node();
    node.root = root;
    //insert AFTER this node
    node.prev = this;
    node.next = next;
    if (next != null) next.prev = node;
    next = node;

    node.type = type;
    node.x = x;
    node.y = y;
    node.blk = blk;
    node.tags = tags;
    for(int a=0;a<tags.length;a++) {
      if (tags[a] == null) tags[a] = "";
    }
    return node;
  }

  public Node insertLinkUpper(Node upper, char type, int x, int y) {
    JFLog.log("insertLinkUpper:" + type);
    Node node = new Node();
    node.root = root;
    //insert AFTER this node
    node.prev = this;
    node.next = next;
    if (next != null) next.prev = node;
    next = node;

    node.type = type;
    node.x = x;
    node.y = y;
    node.upper = upper;
//    if (node.validFork()) {
      upper.lower = node;
//    }
    return node;
  }

/*/
  public Node insertLinkLower(Node lower, char type, int x, int y) {
    JFLog.log("insertLinkLower:" + type);
    Node node = new Node();
    node.root = root;
    //insert AFTER this node
    node.prev = this;
    node.next = next;
    if (next != null) next.prev = node;
    next = node;

    node.type = type;
    node.x = x;
    node.y = y;
    node.lower = lower;
//    lower.upper = node;
    return node;
  }
  public Node insertPreLinkUpper(Node upper, char type, int x, int y) {
    JFLog.log("insertPreLinkUpper:" + type);
    Node node = new Node();
    node.root = root;
    //insert BEFORE this node
    node.prev = prev;
    node.next = this;
    if (prev != null) prev.next = node;
    prev = node;

    node.type = type;
    node.x = x;
    node.y = y;
    node.upper = upper;
//    upper.lower = node;
    return node;
  }

  public Node insertPreLinkLower(Node lower, char type, int x, int y) {
    JFLog.log("insertPreLinkLower:" + type);
    Node node = new Node();
    node.root = root;
    //insert BEFORE this node
    node.prev = prev;
    node.next = this;
    if (prev != null) prev.next = node;
    prev = node;

    node.type = type;
    node.x = x;
    node.y = y;
    node.lower = lower;
//    lower.upper = node;
    return node;
  }
/*/

  public static Node findFirstOpenNode(ArrayList<Node> stack, String types) {
    int cnt = stack.size();
    char[] ca = types.toCharArray();
    for (int p = 0; p < cnt; p++) {
      Node node = stack.get(p);
      if (node.closed) {
        continue;
      }
      for (int c = 0; c < ca.length; c++) {
        if (node.type == ca[c]) {
          node.closed = true;
          return node;
        }
      }
    }
    return null;
  }

  public static Node findLastOpenNode(ArrayList<Node> stack, String types) {
    int cnt = stack.size();
    char[] ca = types.toCharArray();
    for (int p = cnt - 1; p >= 0; p--) {
      Node node = stack.get(p);
      if (node.closed) {
        continue;
      }
      for (int c = 0; c < ca.length; c++) {
        if (node.type == ca[c]) {
          node.closed = true;
          return node;
        }
      }
    }
    return null;
  }

  /** Returns delta x to next node.
   * This may not be the actual width.
   * Only valid for major nodes (not ref nodes)
   */
  public int getDelta() {
    if (blk != null) {
      if (blk.isBlock()) {
        return 1;
      } else {
        return 2;
      }
    }
    return 1;
  }

  /** Returns actual width of node.
   * Only valid for major nodes (not ref nodes)
   */
  public int getWidth() {
    if (blk != null) {
      return 3;
    }
    return 1;
  }

  /** Returns actual height of node.
   * Only valid for major nodes (not ref nodes)
   */
  public int getHeight() {
    if (blk != null) {
      if (blk.isBlock()) {
        return 3 + blk.getTagsCount();
      } else {
        if (blk.getTagsCount() == 1) return 2;
      }
    }
    return 1;
  }

  public boolean validFork() {
    if (parent != null) return false;
    switch (type) {
      case 'h':
      case 't':
      case 'a':
      case 'b':
      case 'c':
      case 'd':
        return true;
    }
    return false;
  }

  public boolean validForkSrc() {
    if (parent != null) return false;
    switch (type) {
      case 'c':
        return true;
    }
    return false;
  }

  public boolean validForkDest() {
    if (parent != null) return false;
    switch (type) {
      case 'd':
        return true;
    }
    return false;
  }

  public boolean endFork() {
    switch (type) {
      case 't':
      case 'a':
      case 'b':
      case 'c':
      case 'd':
        return true;
    }
    return false;
  }

  public void setHighlight(boolean state) {
    if (state) comp.setBorderColor("#0f0");
    comp.setBorder(state);
    highlight = state;
  }

  public void forkSource(WebUIClient client) {
    Node node = this;
    boolean valid = false;
    while (!node.validFork()) {
      if (node.type == 'v') {
        node = node.upper;
      } else {
        node = node.prev;
      }
      while (node != null && node.parent != null) {
        node = node.prev;
      }
    }
    if (node == null) return;
    //highlight possible destinations
    Node src = node;
    node = node.next;
    if (node != null && node.parent != null) node = node.parent;
    int cnt = 0;
    boolean last = false;
    while (node != null) {
      if (node.validFork()) {
        node.setHighlight(true);
        cnt++;
        if (node.endFork()) break;
      }
      node = node.next;
      if (node != null && node.parent != null) {
        node = node.parent;
      }
    }
    if (cnt == 0) {
      JFLog.log("Fork:no possible destinations");
      return;
    }
    JFLog.log("Fork:select destination");
    //TODO : update "fork" button to indicate a cancel function
    client.setProperty("fork", src);
  }

  public void forkDest(WebUIClient client, Table table, Node src) {
    //src = fork source
    //dest = fork destination
    Node dest = this, node;
    if (dest.parent != null) dest = dest.parent;
    if (!dest.highlight) return;
    //fork it!

    while (src.type == 'b' || src.type == 'd') {
      src = src.upper;
    }
    while (src.type == 'a') {
      src = src.lower;
    }
    if (!src.validForkSrc()) {
      src = src.insertNode('t', src.x + 1, src.y);
    }
//    src.insertNode('h', src.x + 1, src.y);

    while (dest.type == 'b' || dest.type == 't') {
      dest = dest.lower;
    }
    while (dest.type == 'a') {
      dest = dest.upper;
    }
    if (!dest.validForkDest()) {
      dest = dest.insertNode('t', src.x + 1, src.y);
    }
//    dest.insertNode('h', src.x + 1, src.y);

    dest.insertLinkUpper(dest, 'd', dest.x, dest.y + 1);
    if (dest.type == 'd') {
      dest.type = 'b';
      Image img = (Image)dest.comp;
      img.setImage(Images.getImage("w_b"));
    }
    dest.insertLinkUpper(src, 'c', src.x, src.y + 1);
    if (src.type == 'c') {
      src.type = 'a';
      Image img = (Image)src.comp;
      img.setImage(Images.getImage("w_a"));
    }
    client.setProperty("fork", null);
    node = dest.root;
    //clear all highlighted destinations
    while (node != null) {
      if (node.highlight) node.setHighlight(false);
      node = node.next;
    }
    try {
      Panels.layoutNodes(dest.root, table);
    } catch (Exception e) {
      JFLog.log(e);
    }
  }

  public void forkCancel(WebUIClient client) {
    JFLog.log("Fork:cancel");
    client.setProperty("fork", null);
    Node node = root;
    JFLog.log("root=" + node);
    //clear all highlighted destinations
    while (node != null) {
      if (node.highlight) node.setHighlight(false);
      node = node.next;
    }
  }

  public int adjustX(int x) {
    //TODO : may need to move over to right for branches below this node
    //NOTE : this is already fixed by looping over layoutNodes() until no change is detected
    return x;
  }

  public String getTags() {
    StringBuilder sb = new StringBuilder();
    int cnt = childs.size();
    for(int a=0;a<cnt;a++) {
      Node child = childs.get(a);
      if (child.type == 'T') {
        TextField tf = (TextField)child.comp;
        sb.append(",");
        sb.append(tf.getText());
      }
    }
    if (sb.length() > 0) sb.append(",");
    return sb.toString();
  }

  private void remove(Table logic) {
    logic.remove(x, y);
    if (prev != null) {
      prev.next = next;
    }
    if (next != null) {
      next.prev = prev;
    }
    int cnt = childs.size();
    for(int a=0;a<cnt;a++) {
      childs.get(a).remove(logic);
    }
  }

  public void delete(Table logic) {
    switch (type) {
      case 'a':
        //delete segment forward to 'b'
        remove(logic);
        while (next != null) {
          next.remove(logic);
          if (next.type == 'b') break;
          next = next.next;
        }
        break;
      case 'b':
        //delete segment backwards to 'a'
        remove(logic);
        while (prev != null) {
          prev.remove(logic);
          if (prev.type == 'a') break;
          prev = prev.next;
        }
        break;
      case 'c':
        //delete segment forward to 'd'
        remove(logic);
        while (next != null) {
          next.remove(logic);
          if (next.type == 'd') break;
          next = next.next;
        }
        break;
      case 'd':
        //delete segment backwards to 'c'
        remove(logic);
        while (prev != null) {
          prev.remove(logic);
          if (prev.type == 'c') break;
          prev = prev.next;
        }
        break;
      default:
        remove(logic);
        break;
    }
  }
}