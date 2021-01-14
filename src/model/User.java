package model;
import java.io.Serializable;

/*
 * ユーザーに関する情報を持つJavaBeans
 */
	public class User implements Serializable{

		private String name;
		private String id;

		public User() {}

		public User(String name,String id) {
			this.name=name;
			this.id=id;
		}

		public String getName() {
			return name;
		}
		public String getId() {
			return id;
		}
	}
