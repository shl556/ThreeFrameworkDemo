package com.bar3.domain.annonation;


import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.hibernate.annotations.Formula;

/**
* @ClassName: Kind
* @Description:表示版块信息的实体类 
* @author shl
* @date 2016年2月12日 下午8:16:19
*/
@Entity
public class Kind implements java.io.Serializable {

	/**
	* @Fields serialVersionUID : 
	*/
	private static final long serialVersionUID = -6503334789503179706L;
	/**
	* @Fields Id : 版块id
	*/
	@Id
//	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_kindId")
//	@SequenceGenerator(name="seq_kindId",initialValue=100,allocationSize=2)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long Id;
	/**
	* @Fields version :版本控制 
	*/
	@Version
	private Integer version;
	/**
	* @Fields kindName : 版块名
	*/
	private String kindName;
	/**
	* @Fields parentKindId :父版块id 
	*/
	private long parentKindId;
	/**
	* @Fields postSum : 该版块下主题总数
	*/
	@Formula("select count(*) from posts a where a.kind_id=id")
	private Integer postSum;
	/**
	* @Fields posts : 该版块下的主题集合
	*/
	@OneToMany(mappedBy="kind")
	private Set<Post> posts = new TreeSet<Post>();
//    @Transient
//	private transient int sum;
//    @Enumerated(EnumType.ORDINAL)
//    private Gender gender;
	public Kind() {
	}

	public Kind(String kindName, long parentKindId) {
		this.kindName = kindName;
		this.parentKindId = parentKindId;
	}

	public Kind(String kindName, long parentKindId, Set<Post> posts) {
		this.kindName = kindName;
		this.parentKindId = parentKindId;
		this.posts = posts;
	}

	public long getId() {
		return this.Id;
	}

	private void setId(long Id) {
		this.Id = Id;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getKindName() {
		return this.kindName;
	}

	public void setKindName(String kindName) {
		this.kindName = kindName;
	}

	public long getParentKindId() {
		return this.parentKindId;
	}

	public void setParentKindId(long parentKindId) {
		this.parentKindId = parentKindId;
	}

	public Integer getPostSum() {
		return this.postSum;
	}

	public void setPostSum(Integer postSum) {
		this.postSum = postSum;
	}

	public Set<Post> getPosts() {
		return this.posts;
	}

	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}

	/**
	 * toString
	 * @return String
	 */
	public String toString() {
		StringBuffer buffer = new StringBuffer();

		buffer.append(getClass().getName()).append("@").append(Integer.toHexString(hashCode())).append(" [");
		buffer.append("Id").append("='").append(getId()).append("' ");
		buffer.append("kindName").append("='").append(getKindName()).append("' ");
		buffer.append("parentKindId").append("='").append(getParentKindId()).append("' ");
		buffer.append("]");

		return buffer.toString();
	}

}
