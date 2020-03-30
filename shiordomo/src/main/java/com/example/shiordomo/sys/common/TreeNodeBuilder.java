package com.example.shiordomo.sys.common;

import java.util.ArrayList;
import java.util.List;

public class TreeNodeBuilder {


	/**
	 * 把没有层级关系的线性表，变成有层级关系的
	 * @param treeNodes
	 * @param topPid
	 * @return
	 */
	//toppid = 1，从第一行开始遍历
	public static List<TreeNode> build(List<TreeNode> treeNodes,Integer topPid){
		List<TreeNode> nodes=new ArrayList<>();
		for (TreeNode n1 : treeNodes) {
			if(n1.getPid()==topPid) {
				nodes.add(n1);
			}
			for (TreeNode n2 : treeNodes) {
				if(n1.getId()==n2.getPid()) {
					n1.getChildren().add(n2);
				}
			}
		}
		return nodes;
	}
}
