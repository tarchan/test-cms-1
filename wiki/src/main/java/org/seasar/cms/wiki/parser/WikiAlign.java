/* Generated By:JJTree: Do not edit this line. WikiAlign.java */

package org.seasar.cms.wiki.parser;

public class WikiAlign extends SimpleNode {
  public WikiAlign(int id) {
    super(id);
  }

  public WikiAlign(WikiParser p, int id) {
    super(p, id);
  }

  public String image;  

  /** Accept the visitor. **/
  public Object jjtAccept(WikiParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
