package jfcontrols.tags;

/** Monitored Tag
 *
 * @author pquiring
 */

import java.util.*;

import javaforce.*;

public abstract class MonitoredTag extends TagBase {

  private ArrayList<TagBaseListener> listeners = new ArrayList<>();
  private Object lock = new Object();

  public MonitoredTag(int type, boolean unsigned, boolean array) {
    super(type, unsigned, array);
  }

  public abstract void updateRead(SQL sql);
  public abstract void updateWrite(SQL sql);

  public void addListener(TagBaseListener listener) {
    synchronized(lock) {
      listeners.add(listener);
    }
  }

  public void removeListener(TagBaseListener listener) {
    synchronized(lock) {
      listeners.remove(listener);
    }
  }

  public void tagChanged(TagID id, String oldValue, String newValue) {
    synchronized(lock) {
      int cnt = listeners.size();
      for(int a=0;a<cnt;a++) {
        listeners.get(a).tagChanged(this, id, oldValue, newValue);
      }
    }
  }
}
