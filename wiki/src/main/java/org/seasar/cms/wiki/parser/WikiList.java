/* Generated By:JJTree: Do not edit this line. WikiList.java */

package org.seasar.cms.wiki.parser;

public class WikiList extends SimpleNode {
  public WikiList(int id) {
    super(id);
  }

  public WikiList(WikiParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(WikiParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
