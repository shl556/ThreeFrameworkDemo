package com.shl.javabeans.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 表示每个版块的汇总信息，包括版块名，主题总数，最近发表的主题名<br>
 * 及发表该主题的用户昵称和发表时间
 * @author shl
 *
 */
public class IndexTableRow implements Serializable {
    /**
	* @Fields serialVersionUID : 
	*/
	private static final long serialVersionUID = 6127189123830051030L;
	private String kindname;//版块名
    private int kindid;//版块id
    private int sum;//主题总数
    private String title;//最近发表的主题名
    private int postid;//主题id
    private String nickname;//发表主题的用户昵称
    private Date modifytime;//最后修改的时间
    
	
	/**
	 * @param kindname版块名
	 * @param kindid版块id
	 * @param sum主题总数
	 * @param title最近发表的主题名
	 * @param postid主题id
	 * @param nickname发表主题的用户昵称
	 * @param modifytime最后修改的时间
	 */
	public IndexTableRow(String kindname, Integer kindid, int sum,
			String title, int postid, String nickname, Date modifytime) {
		super();
		this.kindname = kindname;
		this.kindid = kindid;
		this.sum = sum;
		this.title = title;
		this.postid = postid;
		this.nickname = nickname;
		this.modifytime = modifytime;
	}
	/**
	 * @return the kindid
	 */
	public Integer getKindid() {
		return kindid;
	}
	/**
	 * @param kindid the kindid to set
	 */
	public void setKindid(Integer kindid) {
		this.kindid = kindid;
	}
	/**
	 * @return the postid
	 */
	public int getPostid() {
		return postid;
	}
	/**
	 * @param postid the postid to set
	 */
	public void setPostid(int postid) {
		this.postid = postid;
	}
	/**
	 * @return the kindname
	 */
	public String getKindname() {
		return kindname;
	}
	/**
	 * @param kindname the kindname to set
	 */
	public void setKindname(String kindname) {
		this.kindname = kindname;
	}
	/**
	 * @return the sum
	 */
	public int getSum() {
		return sum;
	}
	/**
	 * @param sum the sum to set
	 */
	public void setSum(int sum) {
		this.sum = sum;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}
	/**
	 * @param nickname the nickname to set
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	/**
	 * @return the modifytime
	 */
	public Date getModifytime() {
		return modifytime;
	}
	/**
	 * @param modifytime the modifytime to set
	 */
	public void setModifytime(Date modifytime) {
		this.modifytime = modifytime;
	}
    
}
