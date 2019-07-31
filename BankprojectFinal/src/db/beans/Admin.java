package db.beans;

public class Admin {
private String adminid;
private String name ;
public Admin(String adminid, String name) {
	super();
	this.adminid = adminid;
	this.name = name;
}
public String getAdminid() {
	return adminid;
}
public void setAdminid(String adminid) {
	this.adminid = adminid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
@Override
public String toString() {
	return "Admin [adminid=" + adminid + ", name=" + name + "]";
}
}
