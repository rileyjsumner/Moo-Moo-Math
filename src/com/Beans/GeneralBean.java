package com.Beans;
public class GeneralBean {
    public String UserName;
    public int Role;
    public GeneralBean(){
        UserName="Guest";
        Role=-1;
    }
    public GeneralBean(String username,int role){
        UserName = username;
        Role=role;
    }
    public String GetCRUD(){
        if(Role==2){
            return "<li><a href = \"crud/crud.jsp\">C.R.U.D.</a></li>";
        }
        return "";
    }
    public String GetUserName(){
        return UserName;
    }
}