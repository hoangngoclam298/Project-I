/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package file_explorer_hoangngoclam20194089;

import java.io.File;
import java.util.Objects;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

/**
 *
 * @author STD_DELL
 */
public class FileTreeModel implements TreeModel {
    
    public DefaultTreeModel tree;
    public DefaultMutableTreeNode rootNode;

    public FileTreeModel() {
        rootNode = buildTree();
        tree = new DefaultTreeModel(rootNode);
    }

    public void buildChild(File root,DefaultMutableTreeNode rootNode){
        if(root.isDirectory()){
            File[] children = root.listFiles();
            if(children == null) return;
            for (File child : children) {
                DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(child);
                buildChild(child, childNode);
                rootNode.add(childNode);
            }
        }        
    }

    private DefaultMutableTreeNode buildTree(){
        DefaultMutableTreeNode thispc = new DefaultMutableTreeNode("This PC");
        File[] roots = File.listRoots();
        for(File root:roots){
            DefaultMutableTreeNode rootTreeNode = new DefaultMutableTreeNode(root);
            buildChild(root, rootTreeNode);
            thispc.add(rootTreeNode);
        }
        return thispc;
    }
    
    @Override
    public Object getRoot() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return this.rootNode;
    }

    @Override
    public Object getChild(Object arg0, int arg1) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return tree.getChild(arg0, arg1);
    }

    @Override
    public int getChildCount(Object arg0) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return tree.getChildCount(arg0);
    }

    @Override
    public boolean isLeaf(Object arg0) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return tree.isLeaf(arg0);
    }

    @Override
    public void valueForPathChanged(TreePath arg0, Object arg1) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        tree.valueForPathChanged(arg0, arg1);
    }

    @Override
    public int getIndexOfChild(Object arg0, Object arg1) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return tree.getIndexOfChild(arg1, arg1);
    }

    @Override
    public void addTreeModelListener(TreeModelListener arg0) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        tree.addTreeModelListener(arg0);
    }

    @Override
    public void removeTreeModelListener(TreeModelListener arg0) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        tree.removeTreeModelListener(arg0);
    }
    
}
