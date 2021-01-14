package model;

import java.io.Serializable;

/**
 * 「Sake」テーブルの1レコードを表すJavaBeans
 */
public class SakeRecord implements Serializable {

	private String sakeId;
	private String sakeMei;
	private String sakeBunrui;
	private int sakeDosu;
	private String sakeAjiwai;
	private String imgLocation;

	public SakeRecord() {}

	public SakeRecord(String sakeId, String sakeMei, String sakeBunrui, int sakeDosu, String sakeAjiwai, String imgLocation) {
		this.sakeId = sakeId;
		this.sakeMei = sakeMei;
		this.sakeBunrui = sakeBunrui;
		this.sakeDosu = sakeDosu;
		this.sakeAjiwai = sakeAjiwai;
		this.imgLocation = imgLocation;
	}

	public String getSakeId() {
		return sakeId;
	}

	public void setSakeId(String sakeId) {
		this.sakeId = sakeId;
	}

	public String getSakeMei() {
		return sakeMei;
	}

	public void setSakeMei(String sakeMei) {
		this.sakeMei = sakeMei;
	}

	public String getSakeBunrui() {
		return sakeBunrui;
	}

	public void setSakeBunrui(String sakeBunrui) {
		this.sakeBunrui = sakeBunrui;
	}

	public int getSakeDosu() {
		return sakeDosu;
	}

	public void setSakeDosu(int sakeDosu) {
		this.sakeDosu = sakeDosu;
	}

	public String getSakeAjiwai() {
		return sakeAjiwai;
	}

	public void setSakeAjiwai(String sakeAjiwai) {
		this.sakeAjiwai = sakeAjiwai;
	}

	public String getImglocation() {
		return imgLocation;
	}

	public void setImglocation(String imgLocation) {
		this.imgLocation = imgLocation;
	}

}
